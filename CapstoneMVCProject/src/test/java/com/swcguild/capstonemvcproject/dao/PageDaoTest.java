/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Page;
import java.util.List;
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
public class PageDaoTest {

    PageDao pageDao;
    Page page;
    Page pageTest;
    ApplicationContext context;

    public PageDaoTest() {
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
        pageDao = (PageDao) ctx.getBean("pageDao");

        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
//        cleaner.execute("delete from pages");
//        cleaner.execute("delete from commments");
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
//        cleaner.execute("alter table comments auto_increment = 1");

//        page = new Page();
//        pageTest = new Page();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetUpdateRemovePageTest() {
        Page page = new Page();

        page.setPageBody("PageBody");
        page.setPageTitle("Page Title");
        pageDao.addPage(page);

        Page page2 = new Page();
        page2.setPageBody("Hello");
        page2.setPageTitle("Second Page");
        pageDao.addPage(page2);

        Page fromDb = pageDao.getPageById(page.getPageId());
        assertEquals(page.getPageId(), fromDb.getPageId());
        assertEquals(page.getPageBody(), fromDb.getPageBody());
        assertEquals(page.getPageTitle(), fromDb.getPageTitle());

        fromDb = pageDao.getPageById(page2.getPageId());
        assertEquals(page2.getPageId(), fromDb.getPageId());
        assertEquals(page2.getPageBody(), fromDb.getPageBody());
        assertEquals(page2.getPageTitle(), fromDb.getPageTitle());

        List<Page> fromDbList = pageDao.getAllPages();
        assertEquals(fromDbList.size(), 2);

        page.setPageBody("Howdy wody dody");
        pageDao.editPage(page);;
        fromDb = pageDao.getPageById(page.getPageId());

        assertEquals(page.getPageBody(), fromDb.getPageBody());

        assertFalse(page.isPosted());
        pageDao.postPage(page.getPageId());
        fromDb = pageDao.getPageById(page.getPageId());
        assertTrue(fromDb.isPosted());
        pageDao.unPostPage(page.getPageId());
        fromDb = pageDao.getPageById(page.getPageId());
        assertFalse(fromDb.isPosted());

        fromDbList = pageDao.getAllPages();
        assertEquals(fromDbList.size(), 2);

        pageDao.deletePage(page.getPageId());
        fromDbList = pageDao.getAllPages();
        assertEquals(fromDbList.size(), 1);

        assertEquals(fromDbList.get(0).getPageBody(), page2.getPageBody());
        assertEquals(fromDbList.get(0).getPageId(), page2.getPageId());
        assertEquals(fromDbList.get(0).getPageTitle(), page2.getPageTitle());

        pageDao.deletePage(page2.getPageId());
        fromDbList = pageDao.getAllPages();
        assertEquals(fromDbList.size(), 0);

        fromDb = pageDao.getPageById(page2.getPageId());
        assertNull(fromDb);

//        page.setPosted(true);
//        pageTest.setPageBody("PageTest");
//        pageTest.setPageTitle("PageTest Title");
//        pageTest.setPosted(false);
//
//        assertEquals(0, pageDao.getAllPages().size());
//        pageDao.addPage(page);
//        pageDao.addPage(pageTest);
//
//        assertEquals(2, pageDao.getAllPages().size());
//        assertEquals(pageTest, pageDao.getPageById(pageTest.getPageId()));
//        assertEquals(pageTest.getPageId(), page.getPageId() + 1);
//
//        List<Page> pageList = new ArrayList<>();
//        pageList = pageDao.getAllPages();
//        for (Page p : pageList) {
//            assertTrue(page.getPageBody().equals(p.getPageBody()) || pageTest.getPageBody().equals(p.getPageBody()));
//        }
//
//        page.setPageTitle("NEW TITLE");
//        page.setPageBody("NEW BODY");
//        pageDao.editPage(page);
//        pageTest = pageDao.getPageById(page.getPageId());
//        assertEquals(page, pageTest);
//
//        pageDao.deletePage(page.getPageId());
//        assertNull(pageDao.getPageById(page.getPageId()));
    }
}
