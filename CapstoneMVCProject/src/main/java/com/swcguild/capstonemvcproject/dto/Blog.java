package com.swcguild.capstonemvcproject.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Blog {

    private int blogId;
    private String blogTitle;
    private LocalDate blogDate;
    private List<Integer> hashTagIds;
    private List<Integer> categoryIds;
    private List<Integer> commentIds;
    private List<Integer> imageIds;
    private int userId;
    private String blog;
    private boolean posted = false;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public LocalDate getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(LocalDate blogDate) {
        this.blogDate = blogDate;
    }

    public List<Integer> getHashTagIds() {
        return hashTagIds;
    }

    public void setHashTagIds(List<Integer> hashTagIds) {
        this.hashTagIds = hashTagIds;
    }

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public boolean isPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }

    public List<Integer> getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(List<Integer> commentIds) {
        this.commentIds = commentIds;
    }

    public List<Integer> getImageIds() {
        return imageIds;
    }

    public void setImageIds(List<Integer> imageIds) {
        this.imageIds = imageIds;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.blogId;
        hash = 23 * hash + Objects.hashCode(this.blogTitle);
        hash = 23 * hash + Objects.hashCode(this.blogDate);
        hash = 23 * hash + Objects.hashCode(this.hashTagIds);
        hash = 23 * hash + Objects.hashCode(this.categoryIds);
        hash = 23 * hash + Objects.hashCode(this.commentIds);
        hash = 23 * hash + Objects.hashCode(this.imageIds);
        hash = 23 * hash + this.userId;
        hash = 23 * hash + Objects.hashCode(this.blog);
        hash = 23 * hash + (this.posted ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Blog other = (Blog) obj;
        if (this.blogId != other.blogId) {
            return false;
        }
        if (!Objects.equals(this.blogTitle, other.blogTitle)) {
            return false;
        }
        if (!Objects.equals(this.blogDate, other.blogDate)) {
            return false;
        }
        if (!Objects.equals(this.hashTagIds, other.hashTagIds)) {
            return false;
        }
        if (!Objects.equals(this.categoryIds, other.categoryIds)) {
            return false;
        }
        if (!Objects.equals(this.commentIds, other.commentIds)) {
            return false;
        }
        if (!Objects.equals(this.imageIds, other.imageIds)) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.blog, other.blog)) {
            return false;
        }
        if (this.posted != other.posted) {
            return false;
        }
        return true;
    }

}
