/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Comment;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
public class CommentsDaoTest {

    CommentDao commentDao;
    BlogDao blogDao;
    Comment comment;
    Comment commentTest;
    ApplicationContext context;

    public CommentsDaoTest() {
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
        commentDao = (CommentDao) ctx.getBean("commentDao");

        ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        blogDao = (BlogDao) ctx.getBean("blogDao");

        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from comments");
        cleaner.execute("delete from blogs");
        cleaner.execute("delete from users");
        cleaner.execute("alter table users auto_increment = 1");
        cleaner.execute("alter table blogs auto_increment = 1");
        cleaner.execute("alter table comments auto_increment = 1");
        cleaner.execute("insert into users (first_name, last_name, email, username, password, enabled)"
                + "values ('Jim', 'Jones', 'jjones', 'jones1', 'jonesss', '1')");
        cleaner.execute("insert into blogs (blog_title, date, user_id, blog, posted) values "
                + "('hello', '2015-01-13 12:23:23', '1', 'hello blog', '0')");
        cleaner.execute("insert into users (first_name, last_name, email, username, password, enabled)"
                + "values ('Tim', 'Smith', 'TSmith', 'SmithT', 'password', '1')");
        cleaner.execute("insert into blogs (blog_title, date, user_id, blog, posted) values "
                + "('hi', '2015-01-13 12:23:23', '1', 'hi blog', '0')");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetUpdateRemoveCommentTest() {
        Comment comment = new Comment();
        comment.setComment("Hello");
        comment.setBlogId(1);
        comment.setUserId(1);
        commentDao.addComment(comment);

        Comment comment2 = new Comment();
        comment2.setComment("Hi");
        comment2.setBlogId(1);
        comment2.setUserId(1);
        commentDao.addComment(comment2);

        List<Comment> fromDbList = commentDao.getCommentByUser(1);
        assertEquals(fromDbList.size(), 2);

        fromDbList = commentDao.getCommentsByBlog(1);
        assertEquals(fromDbList.size(), 2);

        Comment comment3 = new Comment();
        comment3.setComment("Hello");
        comment3.setBlogId(1);
        comment3.setUserId(2);
        commentDao.addComment(comment3);
        Comment fromDb = commentDao.getCommentByCommentId(comment3.getCommentId());
        assertEquals(fromDb.getComment(), "Hello");
        assertEquals(fromDb.getBlogId(), 1);
        assertEquals(fromDb.getUserId(), 2);

        Comment comment4 = new Comment();
        comment4.setComment("Hi");
        comment4.setBlogId(2);
        comment4.setUserId(1);
        commentDao.addComment(comment4);
        fromDb = commentDao.getCommentByCommentId(comment4.getCommentId());
        assertEquals(fromDb.getComment(), "Hi");
        assertEquals(fromDb.getBlogId(), 2);
        assertEquals(fromDb.getUserId(), 1);

        Comment comment5 = new Comment();
        comment5.setComment("Hello");
        comment5.setBlogId(2);
        comment5.setUserId(2);
        commentDao.addComment(comment5);

        Comment comment6 = new Comment();
        comment6.setComment("Hi");
        comment6.setBlogId(2);
        comment6.setUserId(2);
        commentDao.addComment(comment6);
        fromDb = commentDao.getCommentByCommentId(comment6.getCommentId());
        assertEquals(fromDb.getComment(), "Hi");
        assertEquals(fromDb.getBlogId(), 2);
        assertEquals(fromDb.getUserId(), 2);

        fromDbList = commentDao.getCommentByUser(2);
        assertEquals(fromDbList.size(), 3);

        fromDbList = commentDao.getCommentsByBlog(2);
        assertEquals(fromDbList.size(), 3);

        fromDbList = commentDao.getAllComments();
        assertEquals(fromDbList.size(), 6);

        commentDao.deleteComment(comment.getCommentId());

        fromDbList = commentDao.getAllComments();
        assertEquals(fromDbList.size(), 5);

        comment6.setComment("Hello There Edit");
        commentDao.editComment(comment6);
        fromDb = commentDao.getCommentByCommentId(comment6.getCommentId());
        assertEquals(fromDb.getComment(), comment6.getComment());
        assertEquals(fromDb.getBlogId(), comment6.getBlogId());
        assertEquals(fromDb.getCommentId(), comment6.getCommentId());
        assertEquals(fromDb.getUserId(), comment6.getUserId());

        fromDb = commentDao.getCommentByCommentId(comment.getCommentId());
        assertNull(fromDb);

        commentDao.deleteCommentsByBlogId(2);
        fromDbList = commentDao.getAllComments();
        assertEquals(fromDbList.size(), 2);

        comment4 = new Comment();
        comment4.setComment("Hi");
        comment4.setBlogId(2);
        comment4.setUserId(1);
        commentDao.addComment(comment4);

        comment5 = new Comment();
        comment5.setComment("Hello");
        comment5.setBlogId(2);
        comment5.setUserId(2);
        commentDao.addComment(comment5);

        comment6 = new Comment();
        comment6.setComment("Hi");
        comment6.setBlogId(2);
        comment6.setUserId(2);
        commentDao.addComment(comment6);

        fromDbList = commentDao.getAllComments();
        assertEquals(fromDbList.size(), 5);
        
        commentDao.deleteCommentsByUserId(2);
        fromDbList = commentDao.getAllComments();
        assertEquals(fromDbList.size(), 2);
        
        fromDbList= commentDao.getCommentByUser(2);
        assertEquals(fromDbList.size(), 0);
        commentDao.deleteCommentsByUserId(1);

    }
}
