package com.swcguild.capstonemvcproject.controller;

import com.swcguild.capstonemvcproject.dao.BlogDao;
import com.swcguild.capstonemvcproject.dto.Blog;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class BlogController {

    private BlogDao blogDao;

    @Inject
    public BlogController(BlogDao dao) {
        this.blogDao = dao;
    }

    @RequestMapping(value = "/blog/{blogId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlog(@PathVariable("blogId") int blogId) {
        blogDao.deleteBlog(blogId);
    }

    @RequestMapping(value = "/blog/{blogId}", method = RequestMethod.GET)
    @ResponseBody
    public Blog getBlogById(@PathVariable("blogId") int blogId) {
        return blogDao.getBlogById(blogId);
    }

    @RequestMapping(value = "/blog/{blogId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editBlog(@PathVariable("blogId") int blogId, @RequestBody Blog blog) {
        blog.setBlogId(blogId);
//        blog.setUserId(1);
        blog.setBlogDate(blogDao.getBlogById(blogId).getBlogDate());
//        blogDao.postBlog(blogId);
        blogDao.editBlog(blog);
    }

    @RequestMapping(value = {"/blogdetailpage"}, method = RequestMethod.GET)
    public String displayBlogDetailPage(HttpServletRequest req, Model model) {
        int blogId = Integer.parseInt(req.getParameter("blogId"));
        Blog blog = blogDao.getBlogById(blogId);
        model.addAttribute("blogContent", blog.getBlog());
        model.addAttribute("blogTitle", blog.getBlogTitle());
        return "blogdetailpage";
    }

    @RequestMapping(value = {"/blogsummarypage"}, method = RequestMethod.GET)
    public String displayBlogSummaryPage() {
        return "blogsummarypage";
    }

    @RequestMapping(value = {"/addNewBlog"}, method = RequestMethod.GET)
    public String displayAddNewBlogPage() {
        return "addNewBlog";
    }

    @RequestMapping(value = "/blog", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Blog addBlog(@RequestBody Blog blog) {
//        Blog addedBlog = new Blog();
//        Blog blog = blog;
//        addedBlog.setBlog(blog.getBlog());
//        addedBlog.setBlogTitle(blog.getBlogTitle());
//        addedBlog.setBlogDate(LocalDate.of(2012, 1, 1));
//        addedBlog.setUserId(1);
//        blogDao.addBlog(addedBlog);
        blog.setBlogDate(LocalDate.now());
        blog.setUserId(1);
        blogDao.addBlog(blog);
        return blog;
//        return addedBlog;
    }

    @RequestMapping(value = "/postblog/{blogId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void postBlog(@PathVariable("blogId") int blogId) {
        blogDao.postBlog(blogId);
    }

//    @RequestMapping(value = "/blog/{blogId}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteBlog(@PathVariable("blogId") int blogId) {
//        blogDao.deleteBlog(blogId);
//    }
    @RequestMapping(value = "/unpostblog/{blogId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unpostBlog(@PathVariable("blogId") int blogId) {
        blogDao.unPostBlog(blogId);
    }

    @RequestMapping(value = "/blogs", method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> getAllBlogs() {
        return blogDao.getAllBlogs();
    }

    @RequestMapping(value = "/postedBlogs", method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> getAllPostedBlogs() {
        return blogDao.getAllPostedBlogs();
    }

    @RequestMapping(value = "/unpostedBlogs", method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> getAllUnPostedBlogs() {
        return blogDao.getAllUnPostedBlogs();
    }
}
