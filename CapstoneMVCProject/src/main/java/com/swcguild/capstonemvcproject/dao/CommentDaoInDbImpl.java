package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Comment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CommentDaoInDbImpl implements CommentDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_COMMENT
            = "insert into comments (comment, blog_id, user_id) "
            + "values (?, ?, ?)";

    private static final String SQL_DELETE_COMMENT
            = "delete from comments where comment_id = ?";

    private static final String SQL_UPDATE_COMMENT
            = "update comments set comment = ? where comment_id = ?";

    private static final String SQL_SELECT_COMMENT_BY_COMMENT_ID
            = "select * from comments where comment_id = ?";

    private static final String SQL_SELECT_ALL_COMMENTS
            = "select * from comments";

    private static final String SQL_SELECT_COMMENTS_BY_BLOG_ID
            = "select * from comments where blog_id = ?";

    private static final String SQL_SELECT_COMMENTS_BY_USER_ID
            = "select * from comments where user_id = ?";

    private static final String SQL_DELETE_COMMENT_BY_BLOG_ID
            = "delete from comments where blog_id = ?";

    private static final String SQL_DELETE_COMMENT_BY_USER_ID
            = "delete from comments where user_id = ?";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Comment addComment(Comment comment) {
        jdbcTemplate.update(SQL_INSERT_COMMENT,
                comment.getComment(),
                comment.getBlogId(),
                comment.getUserId());
        comment.setCommentId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return comment;
    }

    @Override
    public void editComment(Comment comment) {
        jdbcTemplate.update(SQL_UPDATE_COMMENT,
                comment.getComment(),
                comment.getCommentId());
    }

    @Override
    public void deleteComment(int commentId) {
        jdbcTemplate.update(SQL_DELETE_COMMENT, commentId);
    }

    @Override
    public Comment getCommentByCommentId(int commentId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_COMMENT_BY_COMMENT_ID, new CommentMapper(), commentId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Comment> getAllComments() {
        return jdbcTemplate.query(SQL_SELECT_ALL_COMMENTS, new CommentMapper());
    }

    @Override
    public List<Comment> getCommentsByBlog(int blogId) {
        try {
            return jdbcTemplate.query(SQL_SELECT_COMMENTS_BY_BLOG_ID, new CommentMapper(), blogId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Comment> getCommentByUser(int userId) {
        try {
            return jdbcTemplate.query(SQL_SELECT_COMMENTS_BY_USER_ID, new CommentMapper(), userId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void deleteCommentsByBlogId(int blogId) {
        jdbcTemplate.update(SQL_DELETE_COMMENT_BY_BLOG_ID, blogId);
    }
    
    @Override
    public void deleteCommentsByUserId(int userId) {
        jdbcTemplate.update(SQL_DELETE_COMMENT_BY_USER_ID, userId);
    }

    private static final class CommentMapper implements ParameterizedRowMapper<Comment> {

        @Override
        public Comment mapRow(ResultSet rs, int i) throws SQLException {
            Comment comment = new Comment();
            comment.setCommentId(rs.getInt("comment_id"));
            comment.setComment(rs.getString("comment"));
            comment.setUserId(rs.getInt("user_id"));
            comment.setBlogId(rs.getInt("blog_id"));
            return comment;
        }

    }

}
