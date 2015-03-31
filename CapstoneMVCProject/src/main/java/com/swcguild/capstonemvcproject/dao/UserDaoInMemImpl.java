package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Authority;
import com.swcguild.capstonemvcproject.dto.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserDaoInMemImpl implements UserDao {

    private static int counter = 0;
    Map<Integer, User> userMap = new HashMap<>();

    @Override
    public User addUser(User user) {
        user.setUserId(counter++);
        userMap.put(user.getUserId(), user);
        return user;
    }

    @Override
    public void editUser(User user) {
        userMap.put(user.getUserId(), user);
    }

    @Override
    public void deleteUser(int userId) {
        userMap.remove(userId);
    }

    @Override
    public User getUserById(int userId) {
        return userMap.get(userId);
    }

    @Override
    public List<User> getUserByEmail(String email) {
        return userMap.values().stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList(userMap.values());
    }

    @Override
    public List<User> searchUsers(Map<UserSearchTerm, String> userCriteria) {

//        String roleTitleCriteria = userCriteria.get(UserSearchTerm.ROLE_TITLE);
        String firstNameCriteria = userCriteria.get(UserSearchTerm.FIRST_NAME);
        String lastNameCriteria = userCriteria.get(UserSearchTerm.LAST_NAME);
        String userNameCriteria = userCriteria.get(UserSearchTerm.USER_NAME);

//        Predicate<User> roleTitleMatches;
        Predicate<User> firstNameMatches;
        Predicate<User> lastNameMatches;
        Predicate<User> userNameMatches;

        Predicate<User> truePredicate = (u) -> {
            return true;
        };

//        roleTitleMatches = (roleTitleCriteria == null || roleTitleCriteria.isEmpty())
//                ? truePredicate
//                : (u) -> u.getRoleTitle().equalsIgnoreCase(roleTitleCriteria);
        firstNameMatches = (firstNameCriteria == null || firstNameCriteria.isEmpty())
                ? truePredicate
                : (u) -> u.getFirstName().equalsIgnoreCase(firstNameCriteria);

        lastNameMatches = (lastNameCriteria == null || lastNameCriteria.isEmpty())
                ? truePredicate
                : (u) -> u.getLastName().equalsIgnoreCase(lastNameCriteria);

        userNameMatches = (userNameCriteria == null || userNameCriteria.isEmpty())
                ? truePredicate
                : (u) -> u.getUserName().equalsIgnoreCase(userNameCriteria);

        return userMap.values().stream()
                .filter(
                        //                        roleTitleMatches
                        //                        .and
                        (firstNameMatches)
                        .and(lastNameMatches)
                        .and(userNameMatches))
                .collect(Collectors.toList());

    }

    @Override
    public Authority addAuthority(Authority authority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Authority getAuthorityByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Authority> getAllAuthorities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Authority> getAllByAuthority(String authority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editAuthority(Authority authority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAuthority(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
