/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Blog;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class BlogDaoTest {

    BlogDao blogDao;

    public BlogDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        blogDao = (BlogDao) ctx.getBean("blogDao");

        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");

        cleaner.execute("delete from comments");
        cleaner.execute("delete from categories_blogs");
        cleaner.execute("delete from categories");
        cleaner.execute("delete from authorities");
        cleaner.execute("delete from hash_tags");
        cleaner.execute("delete from images");
        cleaner.execute("delete from pages");
        cleaner.execute("delete from blogs");
        cleaner.execute("delete from users");
        cleaner.execute("alter table comments auto_increment = 1");
        cleaner.execute("alter table categories auto_increment = 1");
        cleaner.execute("alter table authorities auto_increment = 1");
        cleaner.execute("alter table hash_tags auto_increment = 1");
        cleaner.execute("alter table images auto_increment = 1");
        cleaner.execute("alter table pages auto_increment = 1");
        cleaner.execute("alter table users auto_increment = 1");
        cleaner.execute("alter table blogs auto_increment = 1");
        cleaner.execute("alter table categories auto_increment = 1");
        cleaner.execute("insert into users (first_name, last_name, email, username, password, enabled)"
                + " values ('Jim', 'Jones', 'JJones', 'JonesJ', '1', '1')");
        cleaner.execute("insert into users (first_name, last_name, email, username, password, enabled)"
                + " values ('Tim', 'Smith', 'TSmith', 'SmithT', '1', '1')");
        cleaner.execute("insert into blogs (blog_title, date, user_id, blog, posted)"
                + " values ('Blog 1', '2015-01-13 12:23:23', '1', 'Blog body 1', '1')");
        cleaner.execute("insert into blogs (blog_title, date, user_id, blog, posted)"
                + " values ('Blog 2', '2015-01-13 12:23:23', '1', 'Blog body 2', '1')");
        cleaner.execute("insert into comments (comment, blog_id, user_id) values "
                + "('Great point', '1', '2')");
        cleaner.execute("insert into comments (comment, blog_id, user_id) values "
                + "('OBAMA!!!!', '1', '1')");
        cleaner.execute("insert into comments (comment, blog_id, user_id) values "
                + "('Murica', '1', '2')");
        cleaner.execute("insert into comments (comment, blog_id, user_id) values "
                + "('Liberals controlling the media!', '1', '2')");
        cleaner.execute("insert into categories (category_name) values ('Java')");
        cleaner.execute("insert into categories (category_name) values ('.Net')");
        cleaner.execute("insert into categories (category_name) values ('Tech')");

    }

    @After
    public void tearDown() {
    }

//    @Test
    public void addGetUpdateRemoveCommentTest() {
//        User user = new User();

        Blog blog = new Blog();
        blog.setBlogTitle("Blog Title");
        blog.setBlogDate(LocalDate.of(2015, 03, 1));
        blog.setUserId(1);
        blog.setBlog("New Blog");
        blogDao.addBlog(blog);

        Blog fromDb = blogDao.getBlogById(blog.getBlogId());
        assertEquals(blog.getBlogId(), fromDb.getBlogId());
        List<Blog> fromDbList = blogDao.getAllBlogs();
        assertEquals(fromDbList.size(), 2);

//        blogDao.insertCategoriesBlogs(blog);
        Blog blog2 = new Blog();
        blog2.setBlogTitle("HELLO");
        blog2.setBlogDate(LocalDate.of(2015, 03, 1));
        blog2.setUserId(2);
        blog2.setBlog("Howdy");
        blogDao.addBlog(blog2);
//
        fromDbList = blogDao.getAllBlogs();
        assertEquals(fromDbList.size(), 2);

        blog.setBlog("Howdy");
        blogDao.editBlog(blog);
        fromDb = blogDao.getBlogById(blog.getBlogId());
        assertEquals(fromDb.getBlog(), blog.getBlog());
        assertEquals(fromDb.getBlogDate(), blog.getBlogDate());
        assertEquals(fromDb.getBlogId(), blog.getBlogId());
        assertEquals(fromDb.getBlogTitle(), blog.getBlogTitle());
        assertEquals(fromDb.getUserId(), blog.getUserId());
        assertEquals(fromDb.isPosted(), blog.isPosted());

        fromDb = blogDao.getBlogById(blog2.getBlogId());
        assertEquals(fromDb.getBlog(), blog2.getBlog());
        assertEquals(fromDb.getBlogDate(), blog2.getBlogDate());
        assertEquals(fromDb.getBlogId(), blog2.getBlogId());
        assertEquals(fromDb.getBlogTitle(), blog2.getBlogTitle());
        assertEquals(fromDb.getUserId(), blog2.getUserId());
        assertEquals(fromDb.isPosted(), blog2.isPosted());

        assertFalse(blog.isPosted());
        blogDao.postBlog(blog.getBlogId());
        fromDb = blogDao.getBlogById(blog.getBlogId());
        assertTrue(fromDb.isPosted());
        blogDao.unPostBlog(blog.getBlogId());
        fromDb = blogDao.getBlogById(blog.getBlogId());
        assertFalse(fromDb.isPosted());

        fromDbList = blogDao.getAllBlogs();
        assertEquals(fromDbList.size(), 2);

        Map<BlogSearchTerm, String> fromDbMap = new HashMap<>();
        fromDbMap.put(BlogSearchTerm.BLOG_TITLE, blog.getBlogTitle());
        fromDbList = blogDao.searchForBlogs(fromDbMap);
        assertEquals(fromDbList.size(), 1);
        assertEquals(fromDbList.get(0).getBlogTitle(), blog.getBlogTitle());

        blogDao.deleteBlog(blog.getBlogId());
        fromDbList = blogDao.getAllBlogs();
        assertEquals(fromDbList.size(), 2);

        blogDao.deleteBlog(blog2.getBlogId());
        fromDbList = blogDao.getAllBlogs();
        assertEquals(fromDbList.size(), 2);

        fromDb = blogDao.getBlogById(blog.getBlogId());
        assertNull(fromDb);
    }
}
