/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dolphinblog.dto;

import java.util.List;
import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Fin To Win (FTW)
 */
public class Post {

    private int postID;
    @NotEmpty(message = "A post must have a title!")
    @Length(min= 2, max = 100, message = "The title must be no more than 100 characters in length.")
    private String title;
    @NotEmpty(message = "A post must have an author!")
    @Length(max = 100, message = "The author must be no more than 100 characters in length.")
    private String author;
    private String pubDate;
    private int categoryId;
    private int likes;
    private List<String> hashtags;
    private List<String> comments;
    @NotEmpty(message= "A post must have content!")
    @Length(max= 10000, message = "Content must be no more than 10000 characters in length. ")
    private String content;
    private int statusId;
    private String photoUrl;
    @NotEmpty(message= "A post must have a synopsis!")
    @Length(max = 100, message = "The synopsis must be no more than 100 characters in length.")
    private String synopsis;

    public Post() {
    }

    public Post(int postID, String title, String author, String pubDate, int categoryId, int likes, List<String> hashtags, List<String> comments, String content, int statusId, String photoUrl, String synopsis) {
        this.postID = postID;
        this.title = title;
        this.author = author;
        this.pubDate = pubDate;
        this.categoryId = categoryId;
        this.likes = likes;
        this.hashtags = hashtags;
        this.comments = comments;
        this.content = content;
        this.statusId = statusId;
        this.photoUrl = photoUrl;
        this.synopsis = synopsis;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.postID;
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + Objects.hashCode(this.author);
        hash = 53 * hash + Objects.hashCode(this.pubDate);
        hash = 53 * hash + this.categoryId;
        hash = 53 * hash + this.likes;
        hash = 53 * hash + Objects.hashCode(this.hashtags);
        hash = 53 * hash + Objects.hashCode(this.comments);
        hash = 53 * hash + Objects.hashCode(this.content);
        hash = 53 * hash + this.statusId;
        hash = 53 * hash + Objects.hashCode(this.photoUrl);
        hash = 53 * hash + Objects.hashCode(this.synopsis);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Post other = (Post) obj;
        if (this.postID != other.postID) {
            return false;
        }
        if (this.categoryId != other.categoryId) {
            return false;
        }
        if (this.likes != other.likes) {
            return false;
        }
        if (this.statusId != other.statusId) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.pubDate, other.pubDate)) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        if (!Objects.equals(this.photoUrl, other.photoUrl)) {
            return false;
        }
        if (!Objects.equals(this.synopsis, other.synopsis)) {
            return false;
        }
        if (!Objects.equals(this.hashtags, other.hashtags)) {
            return false;
        }
        if (!Objects.equals(this.comments, other.comments)) {
            return false;
        }
        return true;
    }

}

// 1. So, for now, the idea with the date is that it will be a String in Java,
//    and it will be a Timestamp in MySQL that is automatically assigned when the 
//    Post is created.  When we make a MySQL request, we'll order the results by the time stamp
//    - the string display of the date with a post will be some sort of formatted version of the 
///   timestamp...
// 2. the photoURLs should be included as part of the exported tinyMCE content, but
//    if we want to stick with the layout as we currently have it, we will need 
//    to get that URL for the miniature version of the picture for a given blogpost.
//    In that case, I THINK it will need to be a property, too.  See the properties above.
// 3. in the DB, I don't think we need to have the 
//   hashtag_post_id as part of the HashtagsPosts table.  Seems unnecessary.

