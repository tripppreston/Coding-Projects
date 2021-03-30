package com.tsguild.dolphinblog.dto;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Fin To Win (FTW)
 */
public class Page {

    private int pageID;
    @NotEmpty(message= "A page must have a title. Please be sure that it is added.")
    @Length(min= 2, max= 15, message = "Title must be between 2 and 15 characters in length. ")
    private String title;
    @NotEmpty(message= "A page must have content. Please be sure that it is added.")
    @Length(max= 10000, message = "Content must be no more than 10000 characters in length. ")
    private String content;
    private int tabId;
    private int statusId;
//        private String parentTab;?????

    public Page() {
    }

    public Page(int pageID, String title, String content, int tabId, int statusId) {
        this.pageID = pageID;
        this.title = title;
        this.content = content;
        this.tabId = tabId;
        this.statusId = statusId;
    }

    public int getPageID() {
        return pageID;
    }

    public void setPageID(int pageID) {
        this.pageID = pageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTabId() {
        return tabId;
    }

    public void setTabId(int tabId) {
        this.tabId = tabId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.pageID;
        hash = 17 * hash + Objects.hashCode(this.title);
        hash = 17 * hash + Objects.hashCode(this.content);
        hash = 17 * hash + this.tabId;
        hash = 17 * hash + this.statusId;
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
        final Page other = (Page) obj;
        if (this.pageID != other.pageID) {
            return false;
        }
        if (this.tabId != other.tabId) {
            return false;
        }
        if (this.statusId != other.statusId) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        return true;
    }

}

// 1. The DTO for Pages may need to have a boolean like isTab, or something like that.
//    Upon further thought,  Tab may need to be its own Object that has an arraylist of Pages
//    as a property, or something like that, and possibly a position as in 1, 2, 3, 4, 5 to
//    represent the order that they will appear left-to-right on the navbar.  Then the Page DTO
//    would have as a property the page that it belonged to.
// 2. I don't think we need the mappingUrl as a property.  It should be a
//    Path Variable made from the page's title like /static/{pageTitle}, or whatever
//    - I mention this because it needs to be removed as a column from the Pages tabIdle in the DB
