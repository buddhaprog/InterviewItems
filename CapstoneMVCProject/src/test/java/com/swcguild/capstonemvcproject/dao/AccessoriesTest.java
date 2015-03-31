/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Blog;
import com.swcguild.capstonemvcproject.dto.Category;
import com.swcguild.capstonemvcproject.dto.HashTag;
import com.swcguild.capstonemvcproject.dto.Image;
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
public class AccessoriesTest {

    AccessoriesDao accessoriesDao;
    BlogDao blogDao;

    public AccessoriesTest() {
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

        accessoriesDao = (AccessoriesDao) ctx.getBean("accessoriesDao");
        blogDao = (BlogDao) ctx.getBean("blogDao");

        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from comments");
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
//        cleaner.execute("insert into categories (category) values ('technology')");

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
//    @Test 
//    public void addGetUpdateRemoveAuthorities() {
//        Authority authority = new Authority();
//        authority.setAuthority("Editor");
//        
//        
//    }
    @Test
    public void addGetUpdateRemoveCategories() {
        Category category = new Category();
        category.setCategoryName("Technology");
        accessoriesDao.addCategory(category);

        Category category2 = new Category();
        category2.setCategoryName("Java");
        accessoriesDao.addCategory(category2);

        Category category3 = new Category();
        category3.setCategoryName(".Net");
        accessoriesDao.addCategory(category3);

        Category fromDb = accessoriesDao.getCategoryByCategoryId(category.getCategoryId());
        assertEquals(fromDb.getCategoryName(), category.getCategoryName());
        assertEquals(fromDb.getCategoryId(), category.getCategoryId());
        assertEquals(fromDb.getCategoryName(), "Technology");

        List<Category> fromDbList = accessoriesDao.getAllCategories();
        assertEquals(fromDbList.size(), 3);

        category.setCategoryName("Entertainment");
        accessoriesDao.editCategory(category);
        fromDb = accessoriesDao.getCategoryByCategoryId(category.getCategoryId());
        fromDb.getCategoryName();
        assertEquals(fromDb.getCategoryName(), category.getCategoryName());
        assertEquals(fromDb.getCategoryName(), "Entertainment");

        accessoriesDao.deleteCategory(category.getCategoryId());
        fromDbList = accessoriesDao.getAllCategories();
        assertEquals(fromDbList.size(), 2);

        fromDb = accessoriesDao.getCategoryByCategoryId(category.getCategoryId());
        assertNull(fromDb);

        accessoriesDao.deleteCategory(category2.getCategoryId());
        fromDbList = accessoriesDao.getAllCategories();
        assertEquals(fromDbList.size(), 1);

        fromDb = accessoriesDao.getCategoryByCategoryId(category2.getCategoryId());
        assertNull(fromDb);

        accessoriesDao.deleteCategory(category3.getCategoryId());
        fromDbList = accessoriesDao.getAllCategories();
        assertEquals(fromDbList.size(), 0);
    }

    @Test
    public void addGetUpdateRemoveHashTags() {
        HashTag hashTag = new HashTag();
        hashTag.setHashTag("#tech");
        accessoriesDao.addHashTag(hashTag);

        HashTag hashTag2 = new HashTag();
        hashTag2.setHashTag("#oracle");
        accessoriesDao.addHashTag(hashTag2);

        HashTag hashTag3 = new HashTag();
        hashTag3.setHashTag("#spring");
        accessoriesDao.addHashTag(hashTag3);

        HashTag hashTag4 = new HashTag();
        hashTag4.setHashTag("#agile");
        accessoriesDao.addHashTag(hashTag4);

        HashTag fromDb = accessoriesDao.getHashTagById(hashTag.getHashTagId());
        assertEquals(fromDb.getHashTag(), hashTag.getHashTag());
        assertEquals(fromDb.getHashTagId(), hashTag.getHashTagId());
        assertEquals(fromDb.getHashTag(), "#tech");

        List<HashTag> fromDbList = accessoriesDao.getAllHashTags();
        assertEquals(fromDbList.size(), 4);

        accessoriesDao.deleteHashTag(hashTag.getHashTagId());
        fromDbList = accessoriesDao.getAllHashTags();
        assertEquals(fromDbList.size(), 3);

        fromDb = accessoriesDao.getHashTagById(hashTag.getHashTagId());
        assertNull(fromDb);

        hashTag2.setHashTag("#jUnit");
        accessoriesDao.editHashTag(hashTag2);
        fromDb = accessoriesDao.getHashTagById(hashTag2.getHashTagId());
        assertEquals(fromDb.getHashTag(), hashTag2.getHashTag());
        assertEquals(fromDb.getHashTag(), "#jUnit");

        accessoriesDao.deleteHashTag(hashTag2.getHashTagId());
        fromDbList = accessoriesDao.getAllHashTags();
        assertEquals(fromDbList.size(), 2);

        accessoriesDao.deleteHashTag(hashTag3.getHashTagId());
        fromDbList = accessoriesDao.getAllHashTags();
        assertEquals(fromDbList.size(), 1);

        accessoriesDao.deleteHashTag(hashTag4.getHashTagId());
        fromDbList = accessoriesDao.getAllHashTags();
        assertEquals(fromDbList.size(), 0);
    }

    @Test
    public void addGetUpdateImage() {
        Image image = new Image();
        image.setImage("one");
        accessoriesDao.addImage(image);

        Image image2 = new Image();
        image2.setImage("two");
        accessoriesDao.addImage(image2);

        Image image3 = new Image();
        image3.setImage("three");
        accessoriesDao.addImage(image3);

        Image image4 = new Image();
        image4.setImage("four");
        accessoriesDao.addImage(image4);

        Image fromDb = accessoriesDao.getImageById(image.getImageId());
        assertEquals(fromDb.getImage(), image.getImage());
        assertEquals(fromDb.getImageId(), image.getImageId());
        assertEquals(fromDb.getImage(), "one");

        List<Image> fromDbList = accessoriesDao.getAllImages();
        assertEquals(fromDbList.size(), 4);

        image.setImage("uno");
        accessoriesDao.editImage(image);
        fromDb = accessoriesDao.getImageById(image.getImageId());
        assertEquals(fromDb.getImage(), image.getImage());
        assertEquals(fromDb.getImageId(), image.getImageId());
        assertEquals(fromDb.getImage(), "uno");

        accessoriesDao.deleteImage(image.getImageId());
        fromDb = accessoriesDao.getImageById(image.getImageId());
        assertNull(fromDb);

        fromDbList = accessoriesDao.getAllImages();
        assertEquals(fromDbList.size(), 3);

        accessoriesDao.deleteImage(image2.getImageId());
        fromDbList = accessoriesDao.getAllImages();
        assertEquals(fromDbList.size(), 2);

        accessoriesDao.deleteImage(image3.getImageId());
        fromDbList = accessoriesDao.getAllImages();
        assertEquals(fromDbList.size(), 1);

        accessoriesDao.deleteImage(image4.getImageId());
        fromDbList = accessoriesDao.getAllImages();
        assertEquals(fromDbList.size(), 0);
    }

//    @Test
    public void addCategoriesBlogs() {

        Blog blogFromDb = blogDao.getBlogById(1);
        Category categoryFromDb = accessoriesDao.getCategoryByCategoryId(1);

//        blogDao.insertCategoriesBlogs(blogFromDb, categoryFromDb);
    }
}
