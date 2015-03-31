package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Authority;
import com.swcguild.capstonemvcproject.dto.Category;
import com.swcguild.capstonemvcproject.dto.HashTag;
import com.swcguild.capstonemvcproject.dto.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AccessoriesDaoInDbImpl implements AccessoriesDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    Prepared SQL statements for Categories table
    private static final String SQL_INSERT_CATEGORY
            = "insert into categories (category_name) values (?)";

    private static final String SQL_SELECT_ALL_CATEGORIES
            = "select * from categories";

    private static final String SQL_SELECT_CATEGORY_NAME_BY_ID
            = "select category_name from categories where category_id = ?";

    private static final String SQL_UPDATE_CATEGORY
            = "update categories set category_name = ? where category_id = ?";

    private static final String SQL_DELETE_CATEGORY
            = "delete from categories where category_id = ?";

//    Prepared SQL statements for HashTags table
    private static final String SQL_INSERT_HASH_TAG
            = "insert into hash_tags (hash_tag) values (?)";

    private static final String SQL_SELECT_HASH_TAG_BY_ID
            = "select * from hash_tags where hash_tag_id = ?";

    private static final String SQL_SELECT_ALL_HASH_TAGS
            = "select * from hash_tags";

    private static final String SQL_UPDATE_HASH_TAG
            = "update hash_tags set hash_tag = ? where hash_tag_id = ?";

    private static final String SQL_DELETE_HASH_TAG
            = "delete from hash_tags where hash_tag_id = ?";

//    Prepared SQL statements for Images table
    private static final String SQL_INSERT_IMAGE
            = "insert into images (image) values (?)";

    private static final String SQL_SELECT_IMAGE_BY_ID
            = "select * from images where image_id = ?";

    private static final String SQL_SELECT_ALL_IMAGES
            = "select * from images";

    private static final String SQL_UPDATE_IMAGE
            = "update images set image = ? where image_id = ?";

    private static final String SQL_DELETE_IMAGE
            = "delete from images where image_id = ?";

//    Prepared SQL statements for bridge and reference tables
    private static final String SQL_SELECT_CATEGORY_BY_BLOG_ID
            = "select from categories_blogs where blog_id = ?";

    private static final String SQL_SELECT_CATEGORY_BY_CATEGORY_ID
            = "select * from categories where category_id = ?";

    private static final String SQL_SELECT_IMAGE_BY_BLOG_ID
            = "select from blogs_images where blog_id = ?";

    private static final String SQL_SELECT_HASH_TAG_BY_BLOG_ID
            = "select from hash_tags_blogs where blog_id = ?";

    private static final String SQL_SELECT_ALL_BY_CATEGORY_ID
            = "select * from categories where category_id = ?";

//    Methods for Categories
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Category addCategory(Category category) {
        jdbcTemplate.update(SQL_INSERT_CATEGORY,
                category.getCategoryName());
        category.setCategoryId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        return jdbcTemplate.query(SQL_SELECT_ALL_CATEGORIES, new CategoryMapper());
    }

    @Override
    public Category getCategoryByCategoryId(int categoryId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CATEGORY_BY_CATEGORY_ID, new CategoryMapper(), categoryId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void editCategory(Category category) {
        jdbcTemplate.update(SQL_UPDATE_CATEGORY,
                category.getCategoryName(),
                category.getCategoryId());
    }

    @Override
    public void deleteCategory(int categoryId) {
        jdbcTemplate.update(SQL_DELETE_CATEGORY, categoryId);
    }

//    Methods for HashTags
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public HashTag addHashTag(HashTag hashTag) {
        jdbcTemplate.update(SQL_INSERT_HASH_TAG,
                hashTag.getHashTag());
        hashTag.setHashTagId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return hashTag;
    }

    @Override
    public HashTag getHashTagById(int hashTagId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_HASH_TAG_BY_ID, new HashTagMapper(), hashTagId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<HashTag> getAllHashTags() {
        return jdbcTemplate.query(SQL_SELECT_ALL_HASH_TAGS, new HashTagMapper());
    }

    @Override
    public void editHashTag(HashTag hashTag) {
        jdbcTemplate.update(SQL_UPDATE_HASH_TAG,
                hashTag.getHashTag(),
                hashTag.getHashTagId());
    }

    @Override
    public void deleteHashTag(int hashTagId) {
        jdbcTemplate.update(SQL_DELETE_HASH_TAG, hashTagId);
    }

//  Methods for Images    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Image addImage(Image image) {
        jdbcTemplate.update(SQL_INSERT_IMAGE,
                image.getImage());
        image.setImageId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return image;
    }

    @Override
    public Image getImageById(int imageId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_IMAGE_BY_ID, new ImageMapper(), imageId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Image> getAllImages() {
        return jdbcTemplate.query(SQL_SELECT_ALL_IMAGES, new ImageMapper());
    }

    @Override
    public void editImage(Image image) {
        jdbcTemplate.update(SQL_UPDATE_IMAGE,
                image.getImage(),
                image.getImageId());
    }

    @Override
    public void deleteImage(int imageId) {
        jdbcTemplate.update(SQL_DELETE_IMAGE, imageId);
    }

    private static final class CategoryMapper implements ParameterizedRowMapper<Category> {

        @Override
        public Category mapRow(ResultSet rs, int i) throws SQLException {
            Category category = new Category();
            category.setCategoryName(rs.getString("category_name"));
            category.setCategoryId(rs.getInt("category_id"));
            return category;
        }
    }

    private static final class HashTagMapper implements ParameterizedRowMapper<HashTag> {

        @Override
        public HashTag mapRow(ResultSet rs, int i) throws SQLException {
            HashTag hashTag = new HashTag();
            hashTag.setHashTag(rs.getString("hash_tag"));
            hashTag.setHashTagId(rs.getInt("hash_tag_id"));
            return hashTag;
        }
    }

    private static final class ImageMapper implements ParameterizedRowMapper<Image> {

        @Override
        public Image mapRow(ResultSet rs, int i) throws SQLException {
            Image image = new Image();
            image.setImage(rs.getString("image"));
            image.setImageId(rs.getInt("image_id"));
            return image;
        }
    }
}
