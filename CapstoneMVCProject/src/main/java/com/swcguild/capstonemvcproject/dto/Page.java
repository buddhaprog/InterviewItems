package com.swcguild.capstonemvcproject.dto;


public class Page {
    
    private int pageId;
    private String pageTitle;
    private String pageBody;
    private boolean posted = false;

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageBody() {
        return pageBody;
    }

    public void setPageBody(String pageBody) {
        this.pageBody = pageBody;
    }

    public boolean isPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }

}
