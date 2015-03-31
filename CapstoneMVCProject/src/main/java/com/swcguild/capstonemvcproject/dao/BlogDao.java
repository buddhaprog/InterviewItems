package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Blog;
import java.util.List;
import java.util.Map;

public interface BlogDao {

    public Blog addBlog(Blog blog);

    public Blog getBlogById(int blogId);

    public List<Blog> getAllBlogs();

    public List<Blog> getAllPostedBlogs();

    public List<Blog> getAllUnPostedBlogs();

    public void editBlog(Blog blog);

    public void deleteBlog(int blogId);

    public void postBlog(int blogId);

    public void unPostBlog(int blogId);
//    public List<Blog> getBlogByCategory(String category);

    public List<Blog> searchForBlogs(Map<BlogSearchTerm, String> criteria);

    public List<Integer> getCategoryIdsForBlog(Blog blog);
//

    public void insertCategoriesBlogs(Blog blog);
//
//    public Blog postBlog(Blog blog);
//    public Blog getPostedBlogById(int blogId);
//    public List<Blog> getAllPostedBlogs();
//    public void editPostedBlog(Blog blog);
//    public void deletePostedBlog(int blogId);
}
