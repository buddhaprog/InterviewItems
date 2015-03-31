package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Authority;
import com.swcguild.capstonemvcproject.dto.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UserDaoInDbImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    Prepared SQL Statements
    private static final String SQL_INSERT_USER
            = "insert into users (first_name, last_name, email, username, password, "
            + "enabled"
            + ")"
            + " values (?, ?, ?, ?, ?, 0"
            //            + "?"
            + ")";

    private static final String SQL_DELETE_USER
            = "delete from users where user_id = ?";

    private static final String SQL_UPDATE_USER
            = "update users set first_name = ?, last_name = ?, email = ?, username = ?,"
            + " enabled = ?"
            + " where user_id = ?";

    private static final String SQL_SELECT_USER
            = "select * from users where user_id=?";

    private static final String SQL_SELECT_ALL_USERS
            = "select * from users";

    private static final String SQL_SELECT_USER_BY_EMAIL
            = "select * from users where email = ?";

//    private static final String SQL_SELECT_AUTHORITY_BY_USERNAME
//            = "select authority from authorities where username = ";
    // Prepared SQL statements for Authorities table
    private static final String SQL_INSERT_AUTHORITY
            = "insert into authorities (username, authority) values (?, 'ROLE_USER')";

    private static final String SQL_SELECT_AUTHORITY_BY_USERNAME
            = "select * from authorities where username = ?";

    private static final String SQL_SELECT_ALL_AUTHORITIES
            = "select * from authorities";

    private static final String SQL_SELECT_ALL_BY_AUTHORITIES
            = "select * from authorities where authority = ?";

    private static final String SQL_UPDATE_AUTHORITY
            = "update authorities set authority = ? where username = ?";

    private static final String SQL_DELETE_AUTHORITY
            = "delete from authorities where username = ?";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User addUser(User user) {
        jdbcTemplate.update(SQL_INSERT_USER,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUserName(),
                user.getPassword());
        user.setUserId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return user;
    }

    public String getAuthorityByUserName(String userName) {
        StringBuilder authority = new StringBuilder(SQL_SELECT_AUTHORITY_BY_USERNAME);
        authority.append(userName);
        return authority.toString();
    }

    @Override
    public void editUser(User user) {
        jdbcTemplate.update(SQL_UPDATE_USER,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUserName(),
                user.isEnabled(),
                user.getUserId());
    }

    @Override
    public void deleteUser(int userId) {
        jdbcTemplate.update(SQL_DELETE_USER, userId);
    }

    @Override
    public User getUserById(int userId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_USER, new UserMapper(), userId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<User> getUserByEmail(String email) {
        try{
            return jdbcTemplate.query(SQL_SELECT_USER_BY_EMAIL, new UserMapper(), email);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, new UserMapper());
    }

    @Override
    public List<User> searchUsers(Map<UserSearchTerm, String> userCriteria) {
        if (userCriteria.size() == 0) {
            return getAllUsers();
        } else {
            StringBuilder sQuery = new StringBuilder("select * from users where ");

            int numParams = userCriteria.size();
            int paramPosition = 0;

            String[] paramVals = new String[numParams];

            Set<UserSearchTerm> keySet = userCriteria.keySet();

            Iterator<UserSearchTerm> iter = keySet.iterator();

            while (iter.hasNext()) {
                UserSearchTerm currentKey = iter.next();
                if (paramPosition > 0) {
                    sQuery.append(" and ");
                }
                sQuery.append(currentKey);
                sQuery.append(" LIKE ? ");

                paramVals[paramPosition] = userCriteria.get(currentKey);
                paramPosition++;
            }
            return jdbcTemplate.query(sQuery.toString(), new UserMapper(), paramVals);
        }
    }

    //    Methods for Authorities
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Authority addAuthority(Authority authority) {
        jdbcTemplate.update(SQL_INSERT_AUTHORITY,
                authority.getUserName(),
                authority.getAuthority());
        return authority;
    }

    @Override
    public Authority getAuthorityByUsername(String username) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_AUTHORITY_BY_USERNAME, new AuthorityMapper(), username);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Authority> getAllAuthorities() {
        return jdbcTemplate.query(SQL_SELECT_ALL_AUTHORITIES, new AuthorityMapper());
    }

    @Override
    public List<Authority> getAllByAuthority(String authority) {
        return jdbcTemplate.query(SQL_SELECT_ALL_BY_AUTHORITIES, new AuthorityMapper(), authority);
    }

    @Override
    public void editAuthority(Authority authority) {
        jdbcTemplate.update(SQL_UPDATE_AUTHORITY,
                authority.getAuthority(),
                authority.getUserName());
    }

    @Override
    public void deleteAuthority(String username) {
        jdbcTemplate.update(SQL_DELETE_AUTHORITY, username);
    }

    private static final class UserMapper implements ParameterizedRowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEnabled(rs.getBoolean("enabled"));
            user.setUserId(rs.getInt("user_id"));
            return user;
        }
    }

    private static final class AuthorityMapper implements ParameterizedRowMapper<Authority> {

        @Override
        public Authority mapRow(ResultSet rs, int i) throws SQLException {
            Authority authority = new Authority();
            authority.setAuthority(rs.getString("authority"));
            authority.setUserName(rs.getString("username"));
            return authority;
        }
    }
}
