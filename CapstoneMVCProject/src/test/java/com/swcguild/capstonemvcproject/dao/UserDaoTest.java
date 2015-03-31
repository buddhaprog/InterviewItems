/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.User;
import java.util.ArrayList;
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
public class UserDaoTest {

    UserDao userDao;

    public UserDaoTest() {
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
        userDao = (UserDao) ctx.getBean("userDao");

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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetUpdateRemoveUserTest() {
        User user = new User();
        user.setFirstName("Jim");
        user.setLastName("Jones");
        user.setEmail("JJones@Yahoo.com");
        user.setUserName("JonesJ");
        user.setPassword("password");
        userDao.addUser(user);

        User user2 = new User();
        user2.setFirstName("Tom");
        user2.setLastName("Smith");
        user2.setEmail("TSmith@Yahoo.com");
        user2.setUserName("SmithT");
        user2.setPassword("drowssap");
        userDao.addUser(user2);

        User fromDb = userDao.getUserById(user.getUserId());
        assertEquals(fromDb.getFirstName(), user.getFirstName());
        assertEquals(fromDb.getLastName(), user.getLastName());
        assertEquals(fromDb.getEmail(), user.getEmail());
        assertEquals(fromDb.getUserName(), user.getUserName());
        assertEquals(fromDb.getPassword(), user.getPassword());
        assertEquals(fromDb.isEnabled(), user.isEnabled());

        List<User> fromDbList = userDao.getAllUsers();
        assertEquals(fromDbList.size(), 2);

        user.setFirstName("John");
        userDao.editUser(user);
        fromDb = userDao.getUserById(user.getUserId());
        assertEquals(fromDb.getFirstName(), user.getFirstName());

        userDao.deleteUser(user.getUserId());
        fromDbList = userDao.getAllUsers();

        assertEquals(fromDbList.size(), 1);
        fromDb = userDao.getUserById(user.getUserId());
        assertNull(fromDb);
        assertEquals(fromDbList.get(0).getFirstName(), user2.getFirstName());
        assertEquals(fromDbList.get(0).getLastName(), user2.getLastName());
        assertEquals(fromDbList.get(0).getEmail(), user2.getEmail());
        assertEquals(fromDbList.get(0).getUserName(), user2.getUserName());
        assertEquals(fromDbList.get(0).getUserId(), user2.getUserId());
        assertEquals(fromDbList.get(0).getPassword(), user2.getPassword());
        assertEquals(fromDbList.get(0).isEnabled(), user2.isEnabled());

        fromDb = userDao.getUserById(user2.getUserId());
        assertFalse(fromDb.isEnabled());
        user2.setEnabled(true);
        userDao.editUser(user2);
        fromDb = userDao.getUserById(user2.getUserId());
        assertTrue(fromDb.isEnabled());
        user2.setEnabled(false);
        userDao.editUser(user2);
        fromDb = userDao.getUserById(user2.getUserId());
        assertFalse(fromDb.isEnabled());

        userDao.deleteUser(user2.getUserId());
        fromDbList = userDao.getAllUsers();
        assertEquals(fromDbList.size(), 0);
        fromDb = userDao.getUserById(user2.getUserId());
        assertNull(fromDb);
    }
//

    @Test
    public void searchUserTest() {
        User user = new User();
        user.setFirstName("Jim");
        user.setLastName("Jones");
        user.setEmail("JJones@Yahoo.com");
        user.setUserName("JonesJ");
        user.setPassword("password");
        userDao.addUser(user);

        User user2 = new User();
        user2.setFirstName("Tom");
        user2.setLastName("Smith");
        user2.setEmail("TSmith@Yahoo.com");
        user2.setUserName("SmithT");
        user2.setPassword("drowssap");
        userDao.addUser(user2);

        User user3 = new User();
        user3.setFirstName("Tom");
        user3.setLastName("Sullivan");
        user3.setEmail("TSullivan@Yahoo.com");
        user3.setUserName("SullivanT");
        user3.setPassword("meKinda");
        userDao.addUser(user3);

        User user4 = new User();
        user4.setFirstName("John");
        user4.setLastName("Sullivan");
        user4.setEmail("JExpo@Yahoo.com");
        user4.setUserName("ExpoJ");
        user4.setPassword("bottle");
        userDao.addUser(user4);

        Map<UserSearchTerm, String> fromDbMap = new HashMap<>();
        fromDbMap.put(UserSearchTerm.FIRST_NAME, "jim");
        List<User> fromDbList = userDao.searchUsers(fromDbMap);
        assertEquals(fromDbList.size(), 1);

        fromDbMap.put(UserSearchTerm.FIRST_NAME, "Jasaon");
        fromDbList = userDao.searchUsers(fromDbMap);
        assertEquals(fromDbList.size(), 0);
        fromDbMap.clear();

//        fromDbMap.put(UserSearchTerm.FIRST_NAME, );
        fromDbList = userDao.searchUsers(fromDbMap);
        assertEquals(fromDbList.size(), 4);

        fromDbMap.put(UserSearchTerm.FIRST_NAME, "tom");
        fromDbList = userDao.searchUsers(fromDbMap);
        assertEquals(fromDbList.get(0).getFirstName(), user2.getFirstName());
        assertEquals(fromDbList.get(1).getFirstName(), user3.getFirstName());
        assertEquals(fromDbList.size(), 2);

        fromDbMap.put(UserSearchTerm.LAST_NAME, "Sullivan");
        fromDbList = userDao.searchUsers(fromDbMap);
        assertEquals(fromDbList.size(), 1);
        assertEquals(fromDbList.get(0).getLastName(), user3.getLastName());
        assertEquals(fromDbList.get(0).getFirstName(), user3.getFirstName());
        assertEquals(fromDbList.get(0).getEmail(), user3.getEmail());
        assertEquals(fromDbList.get(0).getUserId(), user3.getUserId());
        assertEquals(fromDbList.get(0).getUserName(), user3.getUserName());

        fromDbMap.clear();

        fromDbMap.put(UserSearchTerm.LAST_NAME, "Sullivan");
        fromDbList = userDao.searchUsers(fromDbMap);
        assertEquals(fromDbList.size(), 2);
        fromDbMap.clear();

//        fromDbMap.put(UserSearchTerm.LAST_NAME, "S");
//        fromDbList = userDao.searchUsers(fromDbMap);
//        assertEquals(fromDbList.size(), 3);
    }
}
