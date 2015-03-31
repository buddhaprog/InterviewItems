package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Blog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BlogDaoInMemImpl implements BlogDao {

    private Map<Integer, Blog> blogMap = new HashMap<>();
    private static int blogIdCounter = 0;

    @Override
    public Blog addBlog(Blog blog) {
        blog.setBlogId(blogIdCounter++);
        blogMap.put(blog.getBlogId(), blog);
        return blog;
    }

    @Override
    public Blog getBlogById(int blogId) {
        return blogMap.get(blogId);
    }

    @Override
    public List<Blog> getAllBlogs() {
        Collection<Blog> b = blogMap.values();
        return new ArrayList(b);
    }

    @Override
    public void editBlog(Blog blog) {
        blogMap.put(blog.getBlogId(), blog);
    }

    @Override
    public void deleteBlog(int blogId) {
        blogMap.remove(blogId);
    }

    @Override
    public void postBlog(int blogId) {
        Blog blog = blogMap.get(blogId);
        blog.setPosted(true);
    }

    @Override
    public void unPostBlog(int blogId) {
        Blog blog = blogMap.get(blogId);
        blog.setPosted(false);
    }

    @Override
    public List<Blog> searchForBlogs(Map<BlogSearchTerm, String> criteria) {
        String categoryCriteria = criteria.get(BlogSearchTerm.CATEGORY);
        String hashTagCriteria = criteria.get(BlogSearchTerm.HASH_TAG);
        String blogTitleCriteria = criteria.get(BlogSearchTerm.BLOG_TITLE);

        Predicate<Blog> categoryMatches;
        Predicate<Blog> hashTagMatches;
        Predicate<Blog> blogTitleMatches;

        Predicate<Blog> truePredicate = (b) -> {
            return true;
        };

        categoryMatches = (categoryCriteria == null || categoryCriteria.isEmpty())
                ? truePredicate
                : (b) -> b.getCategoryIds().contains(categoryCriteria);

        hashTagMatches = (hashTagCriteria == null || hashTagCriteria.isEmpty())
                ? truePredicate
                : (b) -> b.getHashTagIds().contains(hashTagCriteria);

        blogTitleMatches = (blogTitleCriteria == null || blogTitleCriteria.isEmpty())
                ? truePredicate
                : (b) -> b.getBlogTitle().equalsIgnoreCase(blogTitleCriteria);

        List<Blog> blogList = blogMap.values().stream()
                .filter(categoryMatches
                        .and(hashTagMatches)
                        .and(blogTitleMatches))
                .collect(Collectors.toList());

        return blogList;
    }

//    @Override
//    public void insertCategoriesBlogs(Blog blog) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public List<Integer> getCategoryIdsForBlog(Blog blog) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertCategoriesBlogs(Blog blog) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Blog> getAllPostedBlogs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Blog> getAllUnPostedBlogs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
