/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Authority;
import com.swcguild.capstonemvcproject.dto.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface UserDao {
    public User addUser(User user);
    public void editUser(User user);
    public void deleteUser(int userId);
    public User getUserById(int userId);
    public List<User> getAllUsers();
    public List<User> getUserByEmail(String email);
//    public String getRoleByUserId(int userId);
    public List<User> searchUsers(Map<UserSearchTerm, String> userCriteria);
    
    //    Authority Methods
    public Authority addAuthority(Authority authority);
    public Authority getAuthorityByUsername(String username);
    public List<Authority> getAllAuthorities();
    public List<Authority> getAllByAuthority(String authority);
    public void editAuthority(Authority authority);
    public void deleteAuthority(String username);
}
