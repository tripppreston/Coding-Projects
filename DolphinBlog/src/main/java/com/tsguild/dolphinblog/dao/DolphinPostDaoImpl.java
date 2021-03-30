/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dolphinblog.dao;

import com.tsguild.dolphinblog.dto.Page;
import com.tsguild.dolphinblog.dto.Post;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class DolphinPostDaoImpl implements DolphinPostDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    String SQL_SELECT_ALL_POSTS
            = "SELECT Posts.post_id, Posts.title, Posts.author, Posts.pub_date, Categories.category_id, "
            + " Statuses.status_id, Posts.likes, Posts.photo_url, Posts.content, Posts.synopsis "
            + " FROM Posts "
            + " JOIN Categories ON Posts.category_id = Categories.category_id "
            + " JOIN Statuses ON Posts.status_id = Statuses.status_id "
            + " WHERE Posts.status_id = 3";

    String SQL_INSERT_POST
            = "INSERT INTO Posts (title, author, category_id, photo_url, content, synopsis)"
            + "VALUES ( ?, ?, ?, ?, ?, ?)";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Post addPost(Post post) {
        jdbcTemplate.update(SQL_INSERT_POST,
                post.getTitle(),
                post.getAuthor(),
                post.getCategoryId(),
                post.getPhotoUrl(),
                post.getContent(),
                post.getSynopsis());
        int postID = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        post.setPostID(postID);

        post.getPostID();

        for (int i = 0; i < post.getHashtags().size(); i++) {
            int hashtagID = jdbcTemplate.queryForObject(CONVERT_HASHTAGNAME_TO_HASHTAGID, Integer.class, post.getHashtags().get(i));
            jdbcTemplate.update(INSERT_A_POSTS_HASHTAGS, postID, hashtagID);

        }

        return post;
    }

    String SQL_SELECT_ALL_EDIT_MODE_POSTS
            = "SELECT Posts.post_id, Posts.title, Posts.author, Posts.pub_date, Categories.category_id, "
            + " Statuses.status_id, Posts.likes, Posts.photo_url, Posts.content, Posts.synopsis "
            + " FROM Posts "
            + " JOIN Categories ON Posts.category_id = Categories.category_id "
            + " JOIN Statuses ON Posts.status_id = Statuses.status_id"
            + " WHERE Posts.status_id = 1";

    @Override
    public List<Post> getAllEditPosts() {
        return jdbcTemplate.query(SQL_SELECT_ALL_EDIT_MODE_POSTS, new PostMapper());
    }

    @Override
    public List<Post> getAllPosts() {
        return jdbcTemplate.query(SQL_SELECT_ALL_POSTS, new PostMapper());
    }

    String SQL_SELECT_POST_BY_ID
            = "SELECT Posts.post_id, Posts.title, Posts.author, Posts.pub_date, Categories.category_id, "
            + " Statuses.status_id, Posts.likes, Posts.photo_url, Posts.content, Posts.synopsis FROM Posts "
            + " JOIN Categories ON Posts.category_id = Categories.category_id "
            + " JOIN Statuses ON Posts.status_id = Statuses.status_id "
            + " WHERE Posts.post_id = ?";
    String SQL_SELECT_COMMENTS_BY_ID = "SELECT Comments.comment_text FROM Comments WHERE Comments.post_id = ?";
    String SQL_SELECT_HASHTAGS_BY_POST_ID
            = "SELECT Hashtags.hashtag_name, HashtagsPosts.* FROM HashtagsPosts\n"
            + "JOIN Hashtags ON HashtagsPosts.hashtag_id = Hashtags.hashtag_id\n"
            + "JOIN Posts ON HashtagsPosts.post_id = Posts.post_id\n"
            + "WHERE HashtagsPosts.post_id = ?";

    @Override
    public Post getPostById(int postId) {
        Post foundPost = new Post();
        foundPost = jdbcTemplate.queryForObject(SQL_SELECT_POST_BY_ID,
                new PostMapper(), postId);

        List<String> comments;
        comments = jdbcTemplate.query(SQL_SELECT_COMMENTS_BY_ID, new CommentMapper(), postId);
        foundPost.setComments(comments);

        List<String> hashtags;
        hashtags = jdbcTemplate.query(SQL_SELECT_HASHTAGS_BY_POST_ID, new HashtagMapper(), postId);

        foundPost.setHashtags(hashtags);

        return foundPost;

    }

    String SQL_REMOVE_POST
            = "DELETE FROM Posts WHERE post_id = ?";

    String SQL_FORIGN_KEY_PRE
            = "SET foreign_key_checks = 0";

    String SQL_FORIGN_KEY_POST
            = "SET foreign_key_checks = 1";

    @Override
    public void removePost(int postId) {//make transactional
        jdbcTemplate.update(SQL_FORIGN_KEY_PRE);
        jdbcTemplate.update(SQL_REMOVE_POST, postId);
        jdbcTemplate.update(SQL_FORIGN_KEY_POST);
    }

    String SQL_UPDATE_POST
            = "UPDATE Posts SET title= ?, author= ?, category_id= ?, "
            + " photo_url= ?, content= ?, synopsis= ? WHERE post_id= ?";

    private static final String REMOVE_AN_EXISTING_POSTS_HASHTAGS = " DELETE FROM HashtagsPosts WHERE post_id = ?";

    @Override
    public void updatePost(Post post) {
        jdbcTemplate.update(SQL_UPDATE_POST,
                post.getTitle(),
                post.getAuthor(),
                post.getCategoryId(),
                post.getPhotoUrl(),
                post.getContent(),
                post.getSynopsis(),
                post.getPostID());

        int postID = post.getPostID();
        jdbcTemplate.update(REMOVE_AN_EXISTING_POSTS_HASHTAGS, postID);
        for (int i = 0; i < post.getHashtags().size(); i++) {
            int tagId = jdbcTemplate.queryForObject(CONVERT_HASHTAGNAME_TO_HASHTAGID, Integer.class, post.getHashtags().get(i));
            jdbcTemplate.update(INSERT_A_POSTS_HASHTAGS, postID, tagId);
        }

    }

    String SQL_SELECT_POPULAR_POSTS
            = " SELECT Posts.*, "
            + " COUNT(Comments.post_id) AS c "
            + " FROM Posts "
            + " JOIN Comments ON Posts.post_id = Comments.post_id "
             + " WHERE Posts.status_id = 3 "
            + " GROUP BY Posts.post_id "
            + " ORDER BY c DESC "
           // + " WHERE Posts.status_id = 3 "
            + " LIMIT 5;";

    @Override
    public List<Post> getPopularPosts() {
        return jdbcTemplate.query(SQL_SELECT_POPULAR_POSTS, new PostMapper());
    }

    String SQL_SELECT_ALL_UNAPPROVED_POSTS
            = "SELECT Posts.post_id, Posts.title, Posts.author, Posts.pub_date, Categories.category_id, "
            + " Statuses.status_id, Posts.likes, Posts.photo_url, Posts.content, Posts.synopsis "
            + " FROM Posts "
            + " JOIN Categories ON Posts.category_id = Categories.category_id "
            + " JOIN Statuses ON Posts.status_id = Statuses.status_id"
            + " WHERE Posts.status_id = 2";

    @Override
    public List<Post> getAllUnapprovedPosts() {
        return jdbcTemplate.query(SQL_SELECT_ALL_UNAPPROVED_POSTS, new PostMapper());
    }

    String SQL_SELECT_POSTS_BY_CATEGORY //This is for clicking on, not searching
            = "SELECT Posts.post_id, Posts.author, Posts.content, Posts.likes, Posts.pub_date, Posts.title, \n"
            + "Categories.category_id,\n"
            + "Statuses.status_id\n"
            + "FROM Posts\n"
            + "JOIN Categories ON Posts.category_id = Categories.category_id\n"
            + "JOIN Statuses ON Posts.status_id = Statuses.status_id\n"
            + "WHERE Categories.category_id = ? AND Posts.status_id = 3";

    @Override
    public List<Post> getPostsByCategory(int categoryId) {
        return jdbcTemplate.query(SQL_SELECT_POSTS_BY_CATEGORY, new PostMapper());
    }

    String SQL_SELECT_POSTS_BY_HASHTAG
            = "SELECT Posts.post_id, Posts.title, Posts.author, Posts.pub_date,\n"
            + "Posts.likes, Posts.status_id, Posts.photo_url, Posts.content, Posts.synopsis\n"
            + "FROM HashtagsPosts\n"
            + "JOIN Posts ON HashtagsPosts.post_id = Posts.post_id\n"
            + "JOIN Hashtags ON HashtagsPosts.hashtag_id = Hashtags.hashtag_id\n"
            + "WHERE HashtagsPosts.hashtag_id = 3 AND Posts.status_id = 3;";

    @Override
    public List<Post> getPostsByHashtag(String hashtag) {
        return jdbcTemplate.query(SQL_SELECT_POSTS_BY_HASHTAG, new PostMapper());
    }

    String SQL_INSERT_PAGE 
            = "INSERT INTO Pages (title, content, tab_id) VALUES (?, ?, ?)";
            

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Page addPage(Page page) {
        jdbcTemplate.update(SQL_INSERT_PAGE,
                page.getTitle(),
                page.getContent(),
                page.getTabId()
        );
        page.setPageID(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        return page;
    }

    String SQL_SELECT_ALL_PAGES = "SELECT * FROM Pages";

    @Override
    public List<Page> getAllPages() {
        return jdbcTemplate.query(SQL_SELECT_ALL_PAGES, new PageMapper());
    }

    String SQL_SELECT_PAGE_BY_ID = "SELECT * FROM Pages WHERE page_id = ?";

    @Override
    public Page getPageById(int pageId) {
        Page page = jdbcTemplate.queryForObject(SQL_SELECT_PAGE_BY_ID, new PageMapper(), pageId);

        return page;

    }

    private static final String GET_ALL_ACTIVE_PAGES
            = "SELECT * FROM Pages WHERE status_id = 3";

    @Override
    public List<Page> getAllActivePages() {
        return jdbcTemplate.query(GET_ALL_ACTIVE_PAGES, new PageMapper());
    }

    private static final String GET_ALL_EDIT_MODE_PAGES
            = "SELECT * FROM Pages WHERE status_id = 1";

    @Override
    public List<Page> getAllEditModePages() {
        return jdbcTemplate.query(GET_ALL_EDIT_MODE_PAGES, new PageMapper());
    }
    private static final String GET_ALL_UNPOSTED_MODE_PAGES
            = "SELECT * FROM Pages WHERE status_id = 2";

    @Override
    public List<Page> getAllUnpostedModePages() {
        return jdbcTemplate.query(GET_ALL_UNPOSTED_MODE_PAGES, new PageMapper());
    }

    String SQL_REMOVE_PAGE_BY_ID = "DELETE FROM Pages WHERE page_id = ?";

    @Override
    public void removePage(int pageId) {
        jdbcTemplate.update(SQL_REMOVE_PAGE_BY_ID, pageId);
    }
    

    String SQL_UPDATE_PAGE = "UPDATE Pages SET title= ?, content= ?, tab_id= ? WHERE page_id= ?";




//     String SQL_UPDATE_POST
//            = "UPDATE Posts SET title= ?, author= ?, category_id= ?, "
//            + " photo_url= ?, content= ?, synopsis= ? WHERE post_id= ?";

    
    @Override
    public void updatePage(Page page) {
        jdbcTemplate.update(SQL_UPDATE_PAGE,
                page.getTitle(),
                page.getContent(),
                page.getTabId(),
                page.getPageID()
                );
    }

//=========================
// LIKES LIKES LIKES LIKES
//=========================    
    String SQL_ADD_LIKE
            = "UPDATE Posts SET likes = ? "
            + " WHERE post_id = ?";
    String SQL_SEARCH
            = "SELECT Posts.post_id, Posts.title, Posts.author, Posts.pub_date, Categories.category_id, "
            + " Statuses.status_id, Posts.likes, Posts.photo_url, Posts.content, Posts.synopsis "
            + " FROM Posts "
            + " JOIN Categories ON Posts.category_id = Categories.category_id "
            + " JOIN Statuses ON Posts.status_id = Statuses.status_id"
            + " WHERE Posts.status_id = 3 AND Posts.title LIKE '%?%' ";

    @Override
    public void addLike(int likes, int postId) {
        jdbcTemplate.update(SQL_ADD_LIKE, likes, postId);
    }

//==========================
//   HASHTAGS  HASHTAGS
//==========================  
//    String SQL_SELECT_HASHTAG_BY_ID = "SELECT hashtag_id FROM Hashtags "
//                                    + " WHERE hashtag_name = ?";
    String SQL_SELECT_ALL_HASHTAGS = "SELECT * FROM Hashtags";

    @Override
    public List<String> getAllHashtags() {
        return jdbcTemplate.query(SQL_SELECT_ALL_HASHTAGS, new HashtagMapper());
    }

    private static final String ADD_NEW_HASHTAG = "INSERT IGNORE INTO Hashtags "
            + " (hashtag_name) VALUES (?)";

    @Override
    public void addHashtag(String hashtag) {
        jdbcTemplate.update(ADD_NEW_HASHTAG, hashtag);
    }

    private static final String CONVERT_HASHTAGNAME_TO_HASHTAGID
            = "SELECT hashtag_id FROM Hashtags "
            + " WHERE hashtag_name = ?";

    @Override
    public int getHashtagIdByName(String hashtagName) {
        return jdbcTemplate.queryForObject(CONVERT_HASHTAGNAME_TO_HASHTAGID, new HashtagIdMapper(), hashtagName);
    }

    private static final String INSERT_A_POSTS_HASHTAGS
            = "INSERT INTO HashtagsPosts (post_id, hashtag_id) "
            + " VALUES ( ?, ?)";

///////////////////////////////////
//      CATEGORIES CATEGORIES
///////////////////////////////////            
    @Override
    public List<String> getAllCategories() {
        //see below.  This is here just to fulfill the interface.  Below works if we need it, we just need to uncomment the mapper, the statements below
        throw new UnsupportedOperationException("Not supported yet."); //and the function from the JS file (and the function call in JS at the top)
    }
//    String GET_ALL_CATEGORIES
//            = "SELECT * FROM Categories ";
//    @Override
//    public List<String> getAllCategories() {
//         return jdbcTemplate.query(GET_ALL_CATEGORIES, new CategoryMapper());
//    }

    @Override
    public List<String> getAllTabs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

///////////////////////////////////////////
//     MAPPERS MAPPERS MAPPERS MAPPERS    
///////////////////////////////////////////    
    private static final class PostMapper implements RowMapper<Post> {

        @Override
        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post post = new Post();
            post.setPostID(rs.getInt("post_id"));
            post.setTitle(rs.getString("title"));
            post.setAuthor(rs.getString("author"));
            post.setPubDate(rs.getString("pub_date"));
            post.setCategoryId(rs.getInt("category_id"));
            post.setStatusId(rs.getInt("status_id"));
            post.setLikes(rs.getInt("likes"));
            post.setPhotoUrl(rs.getString("photo_url"));
            post.setContent(rs.getString("content"));
            post.setSynopsis(rs.getString("synopsis"));

            return post;
        }
    }
    private static final class PostMapper2 implements RowMapper<Post> {

        @Override
        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post post = new Post();
            post.setPostID(rs.getInt("p"));
            post.setTitle(rs.getString("title"));
            post.setAuthor(rs.getString("author"));
            post.setPubDate(rs.getString("pub_date"));
            post.setCategoryId(rs.getInt("category_id"));
            post.setStatusId(rs.getInt("status_id"));
            post.setLikes(rs.getInt("likes"));
            post.setPhotoUrl(rs.getString("photo_url"));
            post.setContent(rs.getString("content"));
            post.setSynopsis(rs.getString("synopsis"));
            

            return post;
        }
    }

    private static final String SQL_SEARCH_USER
            = " SELECT Posts.post_id, Posts.title, Posts.author, Posts.pub_date, Categories.category_id, "
            + " Statuses.status_id, Posts.likes, Posts.photo_url, Posts.content, Posts.synopsis "
            + " FROM Posts "
            + " JOIN Categories ON Posts.category_id = Categories.category_id "
            + " JOIN Statuses ON Posts.status_id = Statuses.status_id "
            + " WHERE Posts.status_id = 3 AND Posts.title LIKE %?% ";

    @Override
    public List<Post> getBySearch(String words) {
        //List<Post>dummy;
        //dummy= jdbcTemplate.query(SQL_SEARCH, new PostMapper(), words);

        return jdbcTemplate.query(SQL_SEARCH_USER,
                new PostMapper(), words);
        //return dummy;
        //return jdbcTemplate.query(SQL_SELECT_ALL_POSTS, new PostMapper());
        //List<String> comments;
        //comments = jdbcTemplate.query(SQL_SELECT_COMMENTS_BY_ID, new CommentMapper(), postId);
    }

    private static final String SQL_GET_COMMENTID_BY_COMMENT
            = "SELECT * FROM Comments WHERE comment_text = ?";

    @Override
    public int getCommentIdByComment(String words) {

        return jdbcTemplate.queryForObject(SQL_GET_COMMENTID_BY_COMMENT, new CommentMapper2(), words);
    }

    private static final String ADD_NEW_COMMENT
            = "INSERT IGNORE INTO Comments (comment_text, post_id) "
            + " VALUES ( ?, ? )";

    @Override
    public void addComment(int postID, String newComment) {
        jdbcTemplate.update(ADD_NEW_COMMENT, newComment, postID);
    }

//     private static final String SQL_GET_POST_IDS_ON_COMMENTS
//            = "SELECT post_id FROM Comments WHERE post_id > 0 ";
//           
//    
//    @Override
//    public List<Integer> getAllPostCommentIDs(){
//        
//        
//         //return jdbcTemplate.queryForObject(SQL_GET_POST_IDS_ON_COMMENTS);
//                   
//      
//    }
    private static final String SQL_DELETE_COMMENT
            = "delete from Comments where comment_id = ?";

    @Override
    public void removeComment(int commentId) {
        jdbcTemplate.update(SQL_DELETE_COMMENT, commentId);
    }

    private static final String SQL_UNPOST_BLOG
            = "UPDATE Posts set status_id = '1' where post_id = ?";

    @Override
    public void unpostBlog(int postID) {
        jdbcTemplate.update(SQL_UNPOST_BLOG, postID);
    }

    private static final String SQL_REJECT_BLOG
            = "UPDATE Posts set status_id = '1' where post_id = ?";

    @Override
    public void rejectBlog(int postID) {
        jdbcTemplate.update(SQL_REJECT_BLOG, postID);
    }
    private static final String SQL_POST_BLOG
            = "UPDATE Posts set status_id = '3' where post_id = ?";

    @Override
    public void postBlog(int postID) {
        jdbcTemplate.update(SQL_POST_BLOG, postID);
    }
    private static final String SQL_SUBMIT_BLOG
            = "UPDATE Posts set status_id = '2' where post_id = ?";

    @Override
    public void submitBlog(int postID) {
        jdbcTemplate.update(SQL_SUBMIT_BLOG, postID);
    }

    private static final String SQL_UNPOST_PAGE
            = "UPDATE Pages set status_id = '1' where page_id = ?";

    @Override
    public void unpostPage(int postID) {
        jdbcTemplate.update(SQL_UNPOST_PAGE, postID);
    }

    private static final String SQL_POST_PAGE
            = "UPDATE Pages set status_id = '3' where page_id = ?";

    @Override
    public void postPage(int postID) {
        jdbcTemplate.update(SQL_POST_PAGE, postID);
    }

    private static final class CommentMapper implements RowMapper<String> {

        @Override
        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
            String comment = rs.getString("comment_text");

            return comment;
        }
    }

    private static final class CommentMapper2 implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
            int commentID = rs.getInt("comment_id");

            return commentID;
        }
    }

//    private static final class CommentMapper3 implements RowMapper<Integer> {
//
//        @Override
//        public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
//            int commentID = rs.getInt("comment_id");
//
//            return commentID;
//        }
//    }
    private static final class HashtagMapper implements RowMapper<String> {

        @Override
        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
            String hashtag = rs.getString("hashtag_name");

            return hashtag;
        }
    }

    private static final class HashtagIdMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
            int hashtagID = rs.getInt("hashtag_id");

            return hashtagID;
        }
    }

    private static final class PageMapper implements RowMapper<Page> {

        @Override
        public Page mapRow(ResultSet rs, int rowNum) throws SQLException {
            Page page = new Page();
            page.setPageID(rs.getInt("page_id"));
            page.setTitle(rs.getString("title"));
            page.setContent(rs.getString("content"));
            page.setStatusId(rs.getInt("status_id"));
            page.setTabId(rs.getInt("tab_id"));

            return page;
        }
    }

//    private static final class CategoryMapper implements RowMapper<String> {
//
//        @Override
//        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//            String category = rs.getString("category_name");
//
//            return category;
//        }
//    }
}
