/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dolphinblog.dao;

import com.tsguild.dolphinblog.dto.Page;
import com.tsguild.dolphinblog.dto.Post;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface DolphinPostDao {
    
    //POST STUFF##################################################################################
    public Post addPost(Post post);
    
    public List<Post> getAllPosts();
    public List<Post> getAllUnapprovedPosts();
    public List<Post> getAllEditPosts();
    public List<String> getAllCategories();
    public List<String> getAllHashtags();
    public List<Post> getPopularPosts();
    public Post getPostById(int postId);
   
    public List<Post> getPostsByCategory(int categoryId); //Get categories from a drop down menu, but let the admin add more categories to that menu. Each category there will have an id associated with it.
    public List<Post> getPostsByHashtag(String hasttag); //Each hashtag will be clickable and will contain an id that is sent to the controller as a path variable
    
    
    public void removePost(int postId);
    
    public void updatePost(Post post);
    
    public void addLike(int likes, int postId);
    
    public void addHashtag(String hashtag);
    
    
    //PAGE STUFF#################################################################################
    public Page addPage(Page page);
    
    public List<Page> getAllPages();
    
    public Page getPageById(int pageId);
    
    public void removePage(int pageId);
    
    public void updatePage(Page page);
    
    public List<Post> getBySearch(String words);

    public int getHashtagIdByName(String hashtagName);
    
    public int getCommentIdByComment(String words);
    
    public void removeComment(int commentId);
    
    public void addComment(int postID, String newComment);
    
    public void unpostBlog(int postID);
//    public List<Integer> getAllPostCommentIDs();

    
    
    public List<String> getAllTabs();

    public List<Page> getAllActivePages();

    public List<Page> getAllEditModePages();
    public void unpostPage(int postID);
    public void postPage(int postID);
     public List<Page> getAllUnpostedModePages();
     public void rejectBlog(int postID);
     public void postBlog(int postID);
     public void submitBlog(int postID);
    
}
