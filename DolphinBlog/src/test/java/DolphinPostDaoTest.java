//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//import com.tsguild.dolphinblog.dao.DolphinPostDao;
//import com.tsguild.dolphinblog.dto.Page;
//import com.tsguild.dolphinblog.dto.Post;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;
//
///**
// *
// * @author apprentice
// */
//public class DolphinPostDaoTest {
//
//    private DolphinPostDao dao;
//
//    public DolphinPostDaoTest() {
//    }
//
//    @Before
//    public void setUp() {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//        dao = ctx.getBean("jdbcDao", DolphinPostDao.class);
//        JdbcTemplate cleaner = ctx.getBean("jdbcTemplateBean", JdbcTemplate.class);
//        cleaner.execute("DELETE FROM Comments ");
//        cleaner.execute("DELETE FROM HashtagsPosts WHERE 1=1");
//        cleaner.execute("DELETE FROM Hashtags WHERE 1=1");
//        cleaner.execute("DELETE FROM Posts WHERE 1=1");
//        cleaner.execute("DELETE FROM Pages");
//
////        
//    }
//
//    List<String> hashtagsOne = new ArrayList<>(Arrays.asList("Funny", "Cool"));
//    List<String> hashtagsTwo = new ArrayList<>(Arrays.asList("ComradesForLife", "FuckSharks", "Cute"));
//    List<String> hashtagsThree = new ArrayList<>(Arrays.asList("FuckSharks", "Training"));
//    List<String> hashtagsFour = new ArrayList<>(Arrays.asList("ComradesForLife", "FuckSharks", "Rescue"));
//    List<String> hashtagsFive = new ArrayList<>(Arrays.asList("FuckSharks", "Finning"));
//    List<String> hashtagsSix = new ArrayList<>(Arrays.asList("ComradesForLife", "FuckSharks", "Training"));
//    List<String> hashtagsSeven = new ArrayList<>(Arrays.asList("ComradesForLife", "FuckSharks", "Training", "Finning"));
//
//    List<String> commentsForPostOne = new ArrayList<>(Arrays.asList("Comment 1", "Comment 2", "Comment 3", "Comment 4", "Comment 5"));
//    List<String> commentsForPostTwo = new ArrayList<>(Arrays.asList("Comment 1", "Comment 2", "Comment 3"));
//    List<String> commentsForPostThree = new ArrayList<>(Arrays.asList("Comment 1"));
//    List<String> commentsForPostFour = new ArrayList<>(Arrays.asList("Comment 1", "Comment 2"));
//    List<String> commentsForPostFive = new ArrayList<>(Arrays.asList("Comment 1", "Comment 2", "Comment 3", "Comment 4"));
//    List<String> commentsForPostSix = new ArrayList<>(Arrays.asList("Comment 1", "Comment 2", "Comment 3", "Comment 4", "Comment 5", "Comment 6"));
//    List<String> commentsForPostSeven = new ArrayList<>(Arrays.asList("Comment 1", "Comment 2", "Comment 3"));
//
//    Post[] postsForTesting = {
//        new Post(-1, "Test Post One", "Tripp Preston", "11-12-13", 2, 16, hashtagsOne, commentsForPostOne, "Test Content", 3, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post Two", "John Smith", "1-16-12", 3, 16, hashtagsTwo, commentsForPostTwo, "Test Content", 2, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post Three", "Jimmy Cook", "5-6-08", 2, 16, hashtagsThree, commentsForPostThree, "Test Content", 3, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post Four", "Craig Sawyer", "3-5-20", 4, 16, hashtagsFour, commentsForPostFour, "Test Content", 1, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post Five", "Austyn Hill", "4-12-11", 4, 16, hashtagsFive, commentsForPostFive, "Test Content", 3, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post Six", "Billy Bob", "7-27-14", 5, 16, hashtagsSix, commentsForPostSix, "Test Content", 2, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post Seven", "James Bond", "12-12-12", 6, 16, hashtagsSeven, commentsForPostSeven, "Test Content", 1, "Test Photo Url", "Test Synopsis")
//    };
//    Post[] duplicatePostsForTesting = {
//        new Post(-1, "Test Post One", "Tripp Preston", "11-12-13", 2, 16, hashtagsOne, commentsForPostOne, "Test Content", 3, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post Two", "John Smith", "1-16-12", 3, 23, hashtagsTwo, commentsForPostTwo, "Test Content", 2, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post Three", "Jimmy Cook", "5-6-08", 2, 5, hashtagsThree, commentsForPostThree, "Test Content", 3, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post Four", "Craig Sawyer", "3-5-20", 4, 8, hashtagsFour, commentsForPostFour, "Test Content", 1, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post Five", "Austyn Hill", "4-12-11", 4, 9, hashtagsFive, commentsForPostFive, "Test Content", 3, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post Six", "Billy Bob", "7-27-14", 5, 10, hashtagsSix, commentsForPostSix, "Test Content", 2, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post Seven", "James Bond", "12-12-12", 6, 1, hashtagsSeven, commentsForPostSeven, "Test Content", 1, "Test Photo Url", "Test Synopsis")
//    };
//    Post[] similarPostsForTesting = {
//        new Post(-1, "Test Post 1", "Tripp Preston", "11-12-13", 2, 16, hashtagsOne, commentsForPostOne, "Test Content", 3, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post 2", "Jimmy Cook", "1-16-12", 3, 23, hashtagsTwo, commentsForPostTwo, "Test Content", 2, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post 3", "John Smith", "5-6-08", 2, 5, hashtagsThree, commentsForPostThree, "Test Content", 3, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post 4", "Craig Sawyer", "3-5-20", 4, 8, hashtagsFour, commentsForPostFour, "Test Content", 1, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post 5", "Billy Bob", "4-12-11", 4, 9, hashtagsFive, commentsForPostFive, "Test Content", 3, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post 6", "Austyn Hill", "7-27-14", 5, 10, hashtagsSix, commentsForPostSix, "Test Content", 2, "Test Photo Url", "Test Synopsis"),
//        new Post(-1, "Test Post 7", "James Bond", "12-12-12", 6, 1, hashtagsSeven, commentsForPostSeven, "Test Content", 1, "Test Photo Url", "Test Synopsis")
//    };
//
//    @Test
//    public void addOneToEmptyDaoTest() {
//        dao.addHashtag("Funny");
//        dao.addHashtag("Cool");
//
//        Post testPost = new Post();
//        testPost.setTitle("Test Title");
//        testPost.setAuthor("Tripp Preston");
//        testPost.setCategoryId(3);
//        testPost.setPhotoUrl("Test Photo Url");
//        testPost.setContent("Test Content");
//        testPost.setSynopsis("Test");
//        testPost.setHashtags(hashtagsOne);
//        dao.addPost(testPost);
//
////        Post shouldBeTestPost = dao.getPostById(testPost.getPostID());
////        Assert.assertEquals("Post does not match stored post", testPost, shouldBeTestPost);
//    }
//
//    @Test
//    public void testAgainstEmptyDao() {
////        Assert.assertNull("Asking for a non existant post should return null", dao.getPostById(160));
//        Assert.assertNotNull("Asking for all posts should not be null", dao.getAllPosts());
//        Assert.assertEquals("Expected post count is nonzero with an empty dao", 0, dao.getAllPosts().size());
//    }
//
//    @Test
//    public void testAddOnePost() {
//        dao.addHashtag("ComradesForLife");
//        dao.addHashtag("Cute");
//        dao.addHashtag("FuckSharks");
//        Post testPost = new Post();
//        testPost.setTitle("More Test Title");
//        testPost.setAuthor("Jimmy Cook");
//        testPost.setCategoryId(2);
//        testPost.setPhotoUrl("Stupid Url");
//        testPost.setContent("Bad Content");
//        testPost.setSynopsis("Jimmy is stupid");
//        testPost.setHashtags(hashtagsTwo);
//        dao.addPost(testPost);
//
//        Assert.assertEquals(testPost.getTitle(), dao.getPostById(testPost.getPostID()).getTitle());
//        Assert.assertEquals(testPost.getAuthor(), dao.getPostById(testPost.getPostID()).getAuthor());
//        Assert.assertEquals(testPost.getContent(), dao.getPostById(testPost.getPostID()).getContent());
//        Assert.assertEquals(testPost.getPhotoUrl(), dao.getPostById(testPost.getPostID()).getPhotoUrl());
//        Assert.assertEquals(testPost.getSynopsis(), dao.getPostById(testPost.getPostID()).getSynopsis());
//        Assert.assertEquals(testPost.getHashtags(), dao.getPostById(testPost.getPostID()).getHashtags());
//        Assert.assertEquals(testPost.getCategoryId(), dao.getPostById(testPost.getPostID()).getCategoryId());
//
//    }
//
//    @Test
//    public void testUpdatePost() {
//        dao.addHashtag("ComradesForLife");
//        dao.addHashtag("Cute");
//        dao.addHashtag("FuckSharks");
//        Post testPost2 = new Post();
//        testPost2.setTitle("More Test Title");
//        testPost2.setAuthor("Jimmy Cook");
//        testPost2.setCategoryId(2);
//        testPost2.setPhotoUrl("Stupid Url");
//        testPost2.setContent("Bad Content");
//        testPost2.setSynopsis("Jimmy is stupid");
//        testPost2.setHashtags(hashtagsTwo);
//
//        dao.addHashtag("Funny");
//        dao.addHashtag("Cool");
//        Post testPost = new Post();
//        testPost.setTitle("Test Title");
//        testPost.setAuthor("Tripp Preston");
//        testPost.setCategoryId(3);
//        testPost.setPhotoUrl("Test Photo Url");
//        testPost.setContent("Test Content");
//        testPost.setSynopsis("Test");
//        testPost.setHashtags(hashtagsOne);
//        dao.addPost(testPost);
//
//        testPost.setTitle("New Title");
//        dao.updatePost(testPost);
//
//        Post samePost = dao.getPostById(testPost.getPostID());
//
//        Assert.assertEquals(testPost.getPostID(), samePost.getPostID());
//        Assert.assertEquals(testPost.getTitle(), samePost.getTitle());
//        Assert.assertEquals(testPost.getAuthor(), samePost.getAuthor());
//        Assert.assertEquals(testPost.getContent(), samePost.getContent());
//        Assert.assertEquals(testPost.getPhotoUrl(), samePost.getPhotoUrl());
//        Assert.assertEquals(testPost.getSynopsis(), samePost.getSynopsis());
//
//    }
//
//    @Test
//    public void testAddAndRemoveOnePost() {
//        dao.addHashtag("ComradesForLife");
//        dao.addHashtag("Cute");
//        dao.addHashtag("FuckSharks");
//        Post testPost2 = new Post();
//        testPost2.setTitle("More Test Title");
//        testPost2.setAuthor("Jimmy Cook");
//        testPost2.setCategoryId(2);
//        testPost2.setPhotoUrl("Stupid Url");
//        testPost2.setContent("Bad Content");
//        testPost2.setSynopsis("Jimmy is stupid");
//        testPost2.setHashtags(hashtagsTwo);
//
//        dao.addPost(testPost2);
//        dao.removePost(testPost2.getPostID());
//
////        assertNull("Post should return null after removal", dao.getPostById(testPost2.getPostID()));
//    }
//
//    @Test
//    public void testPostCountOnAdditionAndRemoval() {
//        dao.addHashtag("ComradesForLife");
//        dao.addHashtag("Cute");
//        dao.addHashtag("FuckSharks");
//        Post testPost2 = new Post();
//        testPost2.setTitle("More Test Title");
//        testPost2.setAuthor("Jimmy Cook");
//        testPost2.setCategoryId(2);
//        testPost2.setPhotoUrl("Stupid Url");
//        testPost2.setContent("Bad Content");
//        testPost2.setSynopsis("Jimmy is stupid");
//        testPost2.setHashtags(hashtagsTwo);
//
//        dao.addPost(testPost2);
//
//        dao.rejectBlog(testPost2.getPostID());
//        List<Post> editPostList = dao.getAllEditPosts();
//        Assert.assertEquals("Edit", 1, editPostList.size());
//
//        dao.postBlog(testPost2.getPostID());
//        List<Post> approvedPostList = dao.getAllPosts();
//        Assert.assertEquals("Approved", 1, approvedPostList.size());
//
//        dao.submitBlog(testPost2.getPostID());
//        List<Post> unapprovedPostList = dao.getAllUnapprovedPosts();
//        Assert.assertEquals("Unapproved", 1, unapprovedPostList.size());
//
//    }
//
//    @Test
//    public void testAddRemoveGetComment() {
//
//        dao.addHashtag("ComradesForLife");
//        dao.addHashtag("Cute");
//        dao.addHashtag("FuckSharks");
//        Post testPost2 = new Post();
//        testPost2.setTitle("More Test Title");
//        testPost2.setAuthor("Jimmy Cook");
//        testPost2.setCategoryId(2);
//        testPost2.setPhotoUrl("Stupid Url");
//        testPost2.setContent("Bad Content");
//        testPost2.setSynopsis("Jimmy is stupid");
//        testPost2.setHashtags(hashtagsTwo);
//
//        dao.addPost(testPost2);
//
//        dao.addComment(testPost2.getPostID(), "Jimmy is lame");
//        int commentId = dao.getCommentIdByComment("Jimmy is lame");
//        Assert.assertEquals(1, commentId);
//
//        Post postWithComments = dao.getPostById(testPost2.getPostID());
//        List<String> commentList = postWithComments.getComments();
//        Assert.assertEquals(1, commentList.size());
//        dao.removeComment(dao.getCommentIdByComment("Jimmy is lame"));
//        Assert.assertEquals(0, commentList.size());
//    }
//    @Test
//    public void testAddUpdateDeletePage() {
//        Page page = new Page();
//        page.setTitle("Page Title");
//        page.setContent("Test Content");
//        page.setTabId(2);
//        dao.addPage(page);
//        Page samePage = dao.getPageById(page.getPageID());
//        Assert.assertEquals(page.getPageID(), samePage.getPageID());
//
//        page.setTitle("Updated Title");
//        dao.updatePage(page);
//
//        Page updatedPage = dao.getPageById(page.getPageID());
//
//        Assert.assertEquals(page.getContent(), updatedPage.getContent());
//        Assert.assertEquals(page.getTabId(), updatedPage.getTabId());
//        Assert.assertEquals(page.getTitle(), updatedPage.getTitle());
//     
//    }
//
//    @Test
//    public void testPageCountOnAdditionAndRemoval() {
//        Page page = new Page();
//        page.setTitle("Page Title");
//        page.setContent("Test Content");
//        page.setTabId(2);
//        dao.addPage(page);
//        
//        List<Page> editPageList = dao.getAllEditModePages();
//        Assert.assertEquals(1, editPageList.size());
//        
//        
//        dao.postPage(page.getPageID());
//        List<Page> approvedPageList = dao.getAllActivePages();
//        Assert.assertEquals(1, approvedPageList.size());
//        
//                
//                
//    }
//
//}
