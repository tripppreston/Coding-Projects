package com.tsguild.dolphinblog.controller;

import com.tsguild.dolphinblog.dao.DolphinPostDao;
import com.tsguild.dolphinblog.dto.Page;
import com.tsguild.dolphinblog.dto.Post;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Fin To Win (FTW)
 */
@Controller
public class HomeController {
    
    private DolphinPostDao dao;
    
    @Inject
    public HomeController(DolphinPostDao dao) {
        this.dao = dao;
    }
    
    public HomeController() {
    }
    
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "index";
    }
    
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String displaylogin() {
        return "login";
    }
    
    @RequestMapping(value = {"/blogpost"}, method = RequestMethod.GET)
    public String displayBlogPostExample() {
        return "blogpost";
    }

//    @ResponseBody
//    @RequestMapping(value = {"/blogpost/{postId}"}, method = RequestMethod.GET)
//    public Post displayBlogPageWithPost(@PathVariable("postId") int postID) {
//        return dao.getPostById(postID);
//
//    }
//    @RequestMapping(value = "/testPage/{postId}", method = RequestMethod.GET)
//    public String testthing(HttpServletRequest req, Model model, @PathVariable("postId") int postID) {
//
//        Post dummyPost = dao.getPostById(postID);
//        String title = dummyPost.getTitle();
//        String content = dummyPost.getContent();
//        String pub_date = dummyPost.getPubDate();
//        int likes = dummyPost.getLikes();
//        List<String> comments = dummyPost.getComments();
//        List<String> hashtags = dummyPost.getHashtags();
//        int postIdentifier = dummyPost.getPostID();
//
//        model.addAttribute("hashtags", hashtags);
//        model.addAttribute("postIdentifier", postIdentifier);
//        model.addAttribute("comments", comments);
//        model.addAttribute("content", content);
//        model.addAttribute("pub_date", pub_date);
//        model.addAttribute("title", title);
//        model.addAttribute("postID", postID);
//        model.addAttribute("likes", likes);
//        model.addAttribute("post", "itworked");
//        return "testPage";
//    }
    @ResponseBody
    @RequestMapping(value = "/admin/loadEditModal/{postID}", method = RequestMethod.GET)
    public Post getPostById(@PathVariable("postID") int postID) {
        return dao.getPostById(postID);
    }
    
    @RequestMapping(value = "/blogpost/{postId}", method = RequestMethod.GET)
    public String displayBlogPage(HttpServletRequest req, Model model, @PathVariable("postId") int postID) {
        
        Post dummyPost = dao.getPostById(postID);
        String title = dummyPost.getTitle();
        String content = dummyPost.getContent();
        String pub_date = dummyPost.getPubDate();
        int likes = dummyPost.getLikes();
        List<String> comments = dummyPost.getComments();
        List<String> hashtags = dummyPost.getHashtags();
        int postIdentifier = dummyPost.getPostID();
        
        int commentNum = dummyPost.getComments().size();
        
        HashMap<String, Integer> commentMap = new HashMap<>();
        for (String s : comments) {
            commentMap.put(s, dao.getCommentIdByComment(s));
            
        }
        
        model.addAttribute("hashtags", hashtags);
        model.addAttribute("postIdentifier", postIdentifier);
        model.addAttribute("comments", comments);
        model.addAttribute("content", content);
        model.addAttribute("pub_date", pub_date);
        model.addAttribute("title", title);
        model.addAttribute("postID", postID);
        model.addAttribute("likes", likes);
        model.addAttribute("commentNum", commentNum);
        model.addAttribute("post", "itworked");
        model.addAttribute("commentMap", commentMap);
        return "blogpost";
    }
    
    @RequestMapping(value = "/Dolphin/{pageId}", method = RequestMethod.GET)
    public String displayDolphinPage(HttpServletRequest req, Model model, @PathVariable("pageId") int pageId) {

        // 'href': "/DolphinBlog/Dolphin/" + page.title,
        model.addAttribute("post", "itworked");
        ArrayList<Page> dummyPageList = new ArrayList<>();
        Page dummyPage = new Page();
        //dummyPageList= dao.getAllPages();
        for (Page p : dao.getAllPages()) {
            dummyPageList.add(p);
        }
        for (Page p : dummyPageList) {
            if (p.getPageID() == pageId) {
                dummyPage.setContent(p.getContent());
                dummyPage.setPageID(p.getPageID());
                dummyPage.setStatusId(p.getStatusId());
                dummyPage.setTitle(p.getTitle());
                dummyPage.setTabId(p.getTabId());
            }
        }
        String title = dummyPage.getTitle();

//        Post dummyPost = dao.getPostById(postID);
//        String title = dummyPost.getTitle();
        String content = dummyPage.getContent();
//        String pub_date = dummyPost.getPubDate();
//        int likes = dummyPost.getLikes();
//        List<String> comments = dummyPost.getComments();
//        List<String> hashtags = dummyPost.getHashtags();
//        int postIdentifier = dummyPost.getPostID();
//
//        int commentNum=dummyPost.getComments().size();
//        
//        HashMap<String, Integer> commentMap=new HashMap<>();
//        for(String s:comments){
//            commentMap.put(s, dao.getCommentIdByComment(s));
//           
//        }
//        
//           
//
//        model.addAttribute("hashtags", hashtags);
//        model.addAttribute("postIdentifier", postIdentifier);
//        model.addAttribute("comments", comments);
        model.addAttribute("content", content);
//        model.addAttribute("pub_date", pub_date);
        model.addAttribute("title", title);
//        model.addAttribute("postID", postID);
//        model.addAttribute("likes", likes);
//        model.addAttribute("commentNum", commentNum);
//        model.addAttribute("post", "itworked");
//        model.addAttribute("commentMap", commentMap);
        return "Dolphin";
    }
    
    @RequestMapping(value = "/search/{words}", method = RequestMethod.GET)
    public String displaySearchPage(HttpServletRequest req, Model model, @PathVariable("words") String words) {
        List<Post> searchList = new ArrayList<>();
        List<Post> returnList = new ArrayList<>();
        for (Post p : dao.getAllPosts()) {
            searchList.add(p);
        }
        for (Post p : searchList) {
            if (p.getTitle().toLowerCase().contains(words.toLowerCase())) {
                returnList.add(p);
            }
        }
        
        model.addAttribute("returnList", returnList);
        model.addAttribute("testWorked", "testWorked");
        
        return "search";
    }
    
    @RequestMapping(value = {"/pages/Popinov"}, method = RequestMethod.GET)
    public String displayPopinov() {
        return "staticPopinov";
    }
    
    @RequestMapping(value = {"/pages/Vladimir"}, method = RequestMethod.GET)
    public String displayVladimir() {
        return "staticVlad";
    }
    
    @RequestMapping(value = "blogposts/popular", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> getPopularPosts() {
        List<Post> searchList = new ArrayList<>();
        List<Post> returnList = new ArrayList<>();
        dao.getPopularPosts().stream().map((p) -> {
            Post dummyPost = new Post();
            dummyPost = dao.getPostById(p.getPostID());
            return dummyPost;
        }).forEach((dummyPost) -> {
            returnList.add(dummyPost);
        });
        
        return returnList;
    }
    
    @RequestMapping(value = {"/blogposts"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Post> getAllPosts() {
        
        List<Post> searchList = new ArrayList<>();
        List<Post> returnList = new ArrayList<>();
        dao.getAllPosts().stream().map((p) -> {
            Post dummyPost = new Post();
            dummyPost = dao.getPostById(p.getPostID());
            return dummyPost;
        }).forEach((dummyPost) -> {
            returnList.add(dummyPost);
        });
        
        return returnList;
        
    }
    
    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public String displaySearch() {
        return "search";
    }
    
    @RequestMapping(value = {"/admin/posts"}, method = RequestMethod.GET)
    public String displayAdminPostPage() {
        return "adminPosts";
    }
    
    @RequestMapping(value = {"/admin/pages"}, method = RequestMethod.GET)
    public String displayAdminPagesPage() {
        return "adminPages";
    }
    
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = {"admin/post/add"}, method = RequestMethod.POST)
    public Post createPost(@Valid @RequestBody Post createdPost) {
        dao.addPost(createdPost);
        return createdPost;
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = {"/post/delete/{id}"}, method = RequestMethod.DELETE)
    public void removePost(@PathVariable("id") int postId) {
        dao.removePost(postId);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = {"/DeletePage/{id}"}, method = RequestMethod.DELETE)
    public void removePage(@PathVariable("id") int pageId) {
        dao.removePage(pageId);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = {"/RemoveComment/{id}"}, method = RequestMethod.DELETE)
    public void removeComment(@PathVariable("id") int commentID) {
        dao.removeComment(commentID);
    }
    //AJAX APPROACH TO ADDING COMMENTS

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = {"/blogpost/addComment/{id}"}, method = RequestMethod.POST)
    public void addComment(@PathVariable("id") int postID, @RequestBody String newComment) {
        dao.addComment(postID, newComment);
    }
//
//  SERVLET FORM APPROACH TO LEAVING A COMMENT (not fully functional)    
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @RequestMapping(value = {"/blogpost/addComment"}, method = RequestMethod.POST)
//    public void addComment(HttpServletRequest request, Model model) {
//         String newComment = request.getParameter("newCommentBox");
//         int postID = Integer.parseInt(request.getParameter("secret-post-id-input"));
//         
//        dao.addComment(postID, newComment);
//    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = {"admin/post/update/{id}"}, method = RequestMethod.PUT)
    public void updatePost(@Valid @PathVariable("id") int postId, @RequestBody Post post) {
        post.setPostID(postId);
        dao.updatePost(post);
    }
    
    @RequestMapping(value = {"/category/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Post> category(@PathVariable("id") int catId) {
        
        List<Post> searchList = new ArrayList<>();
        List<Post> returnList = new ArrayList<>();
        for (Post p : dao.getAllPosts()) {
            Post dummyPost = new Post();
            dummyPost = dao.getPostById(p.getPostID());
            searchList.add(dummyPost);
        }
        
        for (Post p : searchList) {
            if (p.getCategoryId() == catId) {
                returnList.add(p);
            }
        }
        
        return returnList;
        //return dao.getPostsByCategory(catId);
    }

//    @RequestMapping(value = "/unit/{trackingNumber}", method = RequestMethod.GET)
//    @ResponseBody
//    public Unit getUnit(@PathVariable("trackingNumber") int id) {
//
//        return dao.getUnitsById(id);
//    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = {"/testPage/like/{id}"}, method = RequestMethod.POST)
    public void addLike(@PathVariable("id") int postId) {
        Post post = dao.getPostById(postId);
        int currentLikes = post.getLikes();
        currentLikes += 1;
        post.setLikes(currentLikes);
        dao.addLike(currentLikes, postId);
    }
    
    @RequestMapping(value = {"/searchfor/{words}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Post> search(@PathVariable("words") String words) {
        List<Post> searchList = new ArrayList<>();
        List<Post> returnList = new ArrayList<>();
        for (Post p : dao.getAllPosts()) {
            Post dummyPost = new Post();
            dummyPost = dao.getPostById(p.getPostID());
            searchList.add(dummyPost);
        }

//      
        for (Post p : searchList) {
            if (p.getTitle().toLowerCase().contains(words.toLowerCase())) {
                returnList.add(p);
            }
        }
        
        return returnList;
    }

    //below is added
    @RequestMapping(value = {"/admin/posts/approvedposts"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Post> getAllApprovedPosts() {
        return dao.getAllPosts();
    }
    
    @RequestMapping(value = {"/admin/posts/waitposts"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Post> getAllWaitPosts() {
        return dao.getAllUnapprovedPosts();
    }
    
    @RequestMapping(value = {"/admin/posts/editposts"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Post> getAllEditPosts() {
        return dao.getAllEditPosts();
    }
    // end of shade controller methods

    @ResponseBody
    @RequestMapping(value = {"/admin/posts/hashtags"}, method = RequestMethod.GET)
    public List<String> getAllHashtags() {
        return dao.getAllHashtags();
    }
    
    @ResponseBody
    @RequestMapping(value = {"/HashtagsMain"}, method = RequestMethod.GET)
    public List<String> getAllHashtagsMainPage() {
        List<String> searchList = new ArrayList<>();
        List<String> returnList = new ArrayList<>();
        for (String s : dao.getAllHashtags()) {
            searchList.add(s);
        }
        for (int i = 0; i < 10; i++) {
            returnList.add(searchList.get(i));
        }
        return returnList;
    }
    
    @ResponseBody
    @RequestMapping(value = {"/HashtagsMainX/{hashtag}"}, method = RequestMethod.GET)
    public List<Post> getAllHashtagsMainPageForClick(@PathVariable("hashtag") String hashtag) {
        
        List<Post> searchList = new ArrayList<>();
        List<Post> returnList = new ArrayList<>();
        for (Post p : dao.getAllPosts()) {
            Post dummyPost = new Post();
            dummyPost = dao.getPostById(p.getPostID());
            searchList.add(dummyPost);
        }
        
        for (Post p : searchList) {
            
            for (String h : p.getHashtags()) {
                if (h.equalsIgnoreCase(hashtag)) {
                    returnList.add(p);
                }
            }
            
        }
        return returnList;
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = {"admin/posts/addhashtag"}, method = RequestMethod.POST)
    public void createHashtag(@RequestBody String hashtag) {
        hashtag = hashtag.substring(0, hashtag.length() - 1);
        dao.addHashtag(hashtag);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = {"/like/{id}"}, method = RequestMethod.PUT)
    public void addLike2(@PathVariable("id") int postId) {
        Post post = dao.getPostById(postId);
        int currentLikes = post.getLikes();
        currentLikes += 1;
        post.setLikes(currentLikes);
        dao.addLike(currentLikes, postId);
    }

//    
//    @ResponseBody
//    @RequestMapping(value = {"/admin/posts/categories"}, method = RequestMethod.GET)
//    public List<String> getAllCategories() {
//        return dao.getAllCategories();
//    }
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @RequestMapping(value = {"/testPage/like/{id}"}, method = RequestMethod.POST)
//    public void addLike(@PathVariable("id") int postId) {
//        Post post = dao.getPostById(postId);
//        int currentLikes = post.getLikes();
//        currentLikes += 1;
//        post.setLikes(currentLikes);
//        dao.addLike(currentLikes, postId);
//    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = {"/Unpost/{id}"}, method = RequestMethod.PUT)
    public void unpostBlog(@PathVariable("id") int postID) {
        dao.unpostBlog(postID);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = {"/reject/{id}"}, method = RequestMethod.PUT)
    public void rejectBlog(@PathVariable("id") int postID) {
        dao.unpostBlog(postID);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = {"/postit/{id}"}, method = RequestMethod.PUT)
    public void postBlog(@PathVariable("id") int postID) {
        dao.postBlog(postID);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = {"/submit/{id}"}, method = RequestMethod.PUT)
    public void submitBlog(@PathVariable("id") int postID) {
        dao.submitBlog(postID);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = {"/UnpostPage/{id}"}, method = RequestMethod.PUT)
    public void unpostPage(@PathVariable("id") int postID) {
        dao.unpostPage(postID);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = {"/PostPage/{id}"}, method = RequestMethod.PUT)
    public void postPage(@PathVariable("id") int postID) {
        dao.postPage(postID);
    }
    
    @RequestMapping(value = {"/admin/pages/active"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Page> getAllActivePages() {
        return dao.getAllActivePages();
    }
    
    @RequestMapping(value = {"DolphinBlog/Active"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Page> NavBarAllActivePages() {
        return dao.getAllActivePages();
    }
    
    @RequestMapping(value = {"blogpost/Active"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Page> NavBarAllActivePagesBlogPost() {
        return dao.getAllActivePages();
    }
    
    @RequestMapping(value = {"admin/pages/Active"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Page> NavBarAllActivePagesAdminPages() {
        return dao.getAllActivePages();
    }
    
    @RequestMapping(value = {"admin/posts/Active"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Page> NavBarAllActivePostsAdminPages() {
        return dao.getAllActivePages();
    }
    
    @RequestMapping(value = {"Dolphin/Active"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Page> NavBarAllActivePostsDolphin() {
        return dao.getAllActivePages();
    }
    
    @RequestMapping(value = {"/admin/pages/editmode"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Page> getAllEditModePages() {
        return dao.getAllEditModePages();
    }
    
    @RequestMapping(value = {"/admin/pages/unpostedmode"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Page> getAllUnpostedModePages() {
        return dao.getAllUnpostedModePages();
    }
    
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = {"admin/page/add"}, method = RequestMethod.POST)
    public Page createPage(@Valid @RequestBody Page createdPage) {
        dao.addPage(createdPage);
        return createdPage;
    }
    
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = {"admin/page/update/{id}"}, method = RequestMethod.PUT)
    public void updatePage(@Valid @PathVariable("id") int pageId, @RequestBody Page updatedPage) {
        updatedPage.setPageID(pageId);
        dao.updatePage(updatedPage);
        
    }

    @ResponseBody
    @RequestMapping(value = "/admin/loadEditPageModal/{pageID}", method = RequestMethod.GET)
    public Page getPageById(@PathVariable("pageID") int pageID) {
        return dao.getPageById(pageID);

    }

}
