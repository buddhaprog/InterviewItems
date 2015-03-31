package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Blog;
import com.swcguild.capstonemvcproject.dto.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BlogDaoInDbImpl implements BlogDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    Prepared SQL Statements
    private static final String SQL_INSERT_BLOG
            = "insert into blogs (blog_title, date, user_id, blog, posted) "
            + "values (?, ?, ?, ?, 0)";

    private static final String SQL_DELETE_BLOG
            = "delete from blogs where blog_id = ?";

    private static final String SQL_UPDATE_BLOG
            = "update blogs set blog_title = ?, date = ?, user_id = ?, blog = ? "
            + "where blog_id = ?";

    private static final String SQL_SELECT_BLOG_BY_ID
            = "select * from blogs where blog_id = ?";

    private static final String SQL_SELECT_BLOGS_BY_USER_ID
            = "select * from blogs where user_id = ?";

    private static final String SQL_SELECT_ALL_BLOGS
            = "select * from blogs order by blog_id desc";

    private static final String SQL_SELECT_ALL_POSTED_BLOGS
            = "select * from blogs where posted = 1 order by blog_id desc";

    private static final String SQL_SELECT_ALL_UNPOSTED_BLOGS
            = "select * from blogs where posted = 0 order by blog_id desc";

    private static final String SQL_POST_BLOG
            = "update blogs set posted = 1 where blog_id = ?";

    private static final String SQL_UNPOST_BLOG
            = "update blogs set posted = 0 where blog_id = ?";

//    BridgeTable Statements
    private static final String SQL_INSERT_CATEGORIES_BLOGS
            = "insert into categories_blogs (blog_id, category_id) values (?, ?)";

    private static final String SQL_INSERT_HASH_TAG_BLOGS
            = "insert into hash_tag_blogs (hash_tag_id, blog_id) values (?, ?)";

    private static final String SQL_INSERT_BLOGS_IMAGES
            = "insert into blogs_images (blog_id, image_id) values (?, ?)";

    private static final String SQL_SELECT_BLOGS_CATEGORIES_CATEGORY_ID_BY_BLOG_ID
            = "select category_id from blogs_categories where blog_id = ?";

    private static final String SQL_SELECT_HASH_TAGS_BLOGS_HASH_TAG_ID_BY_BLOG_ID
            = "select hash_tag_id from blogs_categories where blog_id = ?";

    private static final String SQL_SELECT_BLOGS_IMAGES_IMAGE_ID_BY_BLOG_ID
            = "select image_id from blogs_categories where blog_id = ?";

    private static final String SQL_SELECT_BLOGS_BY_CATEGORIES_ID
            = "select b.blog_id, b.blog_title, b.date, b.user_id, b.blog, b.posted"
            + " from blogs b join categories_blogs cb on cb.blog_id "
            + "where b.blog_id = cb.blog_id and cb.category_id = ?";

    private static final String SQL_DELETE_CATEGORIES_BLOGS
            = "delete from categories_blogs where blog_id = ?";

    private static final String SQL_DELETE_HASH_TAGS_BLOGS
            = "delete from hash_tags_blogs where blog_id = ?";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Blog addBlog(Blog blog) {
        jdbcTemplate.update(SQL_INSERT_BLOG,
                blog.getBlogTitle(),
                blog.getBlogDate().toString(),
                blog.getUserId(),
                blog.getBlog());
        blog.setBlogId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
//        insertCategoriesBlogs(blog);
        return blog;
    }

    @Override
    public Blog getBlogById(int blogId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BLOG_BY_ID, new BlogMapper(), blogId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public List<Blog> getBlogsByUserId(int userId) {
        try {
            return jdbcTemplate.query(SQL_SELECT_BLOGS_BY_USER_ID, new BlogMapper(), userId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Blog> getAllBlogs() {
        return jdbcTemplate.query(SQL_SELECT_ALL_BLOGS, new BlogMapper());
    }

    @Override
    public List<Blog> getAllPostedBlogs() {
        return jdbcTemplate.query(SQL_SELECT_ALL_POSTED_BLOGS, new BlogMapper());
    }

    @Override
    public List<Blog> getAllUnPostedBlogs() {
        return jdbcTemplate.query(SQL_SELECT_ALL_UNPOSTED_BLOGS, new BlogMapper());
    }

//    @Override
//    public void editBlog(Blog blog) {
//        jdbcTemplate.update(SQL_UPDATE_BLOG,
//                blog.getBlogTitle(),
//                blog.getBlogDate().toString(),
//                blog.getUserId(),
//                blog.getBlog(),
//                blog.getBlogId());
//    }
//    @Override
//    public void deleteBlog(int blogId) {
//        jdbcTemplate.update(SQL_DELETE_BLOG, blogId);
//    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteBlog(int blogId) {
//        jdbcTemplate.update(SQL_DELETE_CATEGORIES_BLOGS, blogId);

        jdbcTemplate.update(SQL_DELETE_BLOG, blogId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void editBlog(Blog blog) {
        jdbcTemplate.update(SQL_UPDATE_BLOG,
                blog.getBlogTitle(),
                blog.getBlogDate().toString(),
                blog.getUserId(),
                blog.getBlog(),
                blog.getBlogId());
        jdbcTemplate.update(SQL_DELETE_CATEGORIES_BLOGS, blog.getBlogId());
//        insertCategoriesBlogs(blog);
    }

    @Override
    public void postBlog(int blogId) {
        jdbcTemplate.update(SQL_POST_BLOG, blogId);

    }

    @Override
    public void unPostBlog(int blogId) {
        jdbcTemplate.update(SQL_UNPOST_BLOG, blogId);
    }

//    Bridge Table Methods
//    @Override
    @Override
    public void insertCategoriesBlogs(Blog blog) {
        final int blogId = blog.getBlogId();
        final List<Integer> categoryIds = blog.getCategoryIds();
        jdbcTemplate.batchUpdate(SQL_INSERT_CATEGORIES_BLOGS, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, blogId);
                ps.setInt(2, categoryIds.get(i));
            }

            @Override
            public int getBatchSize() {
                return categoryIds.size();
            }
        });
    }

    @Override
    public List<Integer> getCategoryIdsForBlog(Blog blog) {
        return jdbcTemplate.queryForList(SQL_SELECT_BLOGS_CATEGORIES_CATEGORY_ID_BY_BLOG_ID, new Integer[]{blog.getBlogId()}, Integer.class);
    }

    public void insertBlogsImages(Blog blog) {
        final int blogId = blog.getBlogId();
        final List<Integer> imageIds = blog.getImageIds();

        jdbcTemplate.batchUpdate(SQL_INSERT_BLOGS_IMAGES, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, blogId);
                ps.setInt(2, imageIds.get(i));
            }

            @Override
            public int getBatchSize() {
                return imageIds.size();
            }
        });
    }

    public List<Integer> getImageIdsForBlog(Blog blog) {
        return jdbcTemplate.queryForList(SQL_SELECT_BLOGS_IMAGES_IMAGE_ID_BY_BLOG_ID, new Integer[]{blog.getBlogId()}, Integer.class);
    }

    public void insertHashTagBlogs(Blog blog) {
        final int blogId = blog.getBlogId();
        final List<Integer> hashTagIds = blog.getHashTagIds();

        jdbcTemplate.batchUpdate(SQL_INSERT_HASH_TAG_BLOGS, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, hashTagIds.get(i));
                ps.setInt(2, blogId);
            }

            @Override
            public int getBatchSize() {
                return hashTagIds.size();
            }
        });
    }

    public List<Integer> getHashTagIdsForBlog(Blog blog) {
        return jdbcTemplate.queryForList(SQL_SELECT_HASH_TAGS_BLOGS_HASH_TAG_ID_BY_BLOG_ID, new Integer[]{blog.getBlogId()}, Integer.class);
    }

    public List<Blog> getBlogsByCategoryId(int categoryId) {
        List<Blog> bList = jdbcTemplate.query(SQL_SELECT_BLOGS_BY_CATEGORIES_ID, new BlogMapper(), categoryId);
        for (Blog currentBlog : bList) {
            currentBlog.setCategoryIds(getCategoryIdsForBlog(currentBlog));
        }
        return bList;
    }

    @Override
    public List<Blog> searchForBlogs(Map<BlogSearchTerm, String> criteria) {
        if (criteria.size() == 0) {
            return getAllBlogs();
        } else {
            StringBuilder sQuery = new StringBuilder("select * from blogs where ");

            int numParams = criteria.size();
            int paramPosition = 0;

            String[] paramVals = new String[numParams];

            Set<BlogSearchTerm> keySet = criteria.keySet();

            Iterator<BlogSearchTerm> iter = keySet.iterator();

            while (iter.hasNext()) {
                BlogSearchTerm currentKey = iter.next();
                if (paramPosition > 0) {
                    sQuery.append(" and ");
                }
                sQuery.append(currentKey);
                sQuery.append(" = ? ");

                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;
            }
            return jdbcTemplate.query(sQuery.toString(), new BlogMapper(), paramVals);
        }
    }

    private static final class BlogMapper implements ParameterizedRowMapper<Blog> {

        @Override
        public Blog mapRow(ResultSet rs, int i) throws SQLException {
            Blog blog = new Blog();
            blog.setBlogId(rs.getInt("blog_id"));
            blog.setBlogTitle(rs.getString("blog_title"));
            blog.setBlogDate(rs.getTimestamp("date").toLocalDateTime().toLocalDate());
            blog.setUserId(rs.getInt("user_id"));
            blog.setBlog(rs.getString("blog"));
            blog.setPosted(rs.getBoolean("posted"));
            return blog;
        }

    }
}
