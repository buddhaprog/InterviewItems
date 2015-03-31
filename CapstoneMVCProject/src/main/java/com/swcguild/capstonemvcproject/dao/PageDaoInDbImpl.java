package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Page;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class PageDaoInDbImpl implements PageDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_PAGE
            = "insert into pages (page, page_title, posted) values (?, ?, 0)";

    private static final String SQL_DELETE_PAGE
            = "delete from pages where page_id = ?";

    private static final String SQL_UPDATE_PAGE
            = "update pages set page = ?, page_title = ? where page_id = ?";

    private static final String SQL_SELECT_PAGE_BY_ID
            = "select * from pages where page_id = ?";

    private static final String SQL_SELECT_ALL_PAGES
            = "select * from pages";
    
    private static final String SQL_SELECT_ALL_POSTED_PAGES
            = "select * from pages where posted = 1";

    private static final String SQL_POST_PAGE
            = "update pages set posted = 1 where page_id = ?";

    private static final String SQL_UNPOST_PAGE
            = "update pages set posted = 0 where page_id = ?";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Page addPage(Page page) {
        jdbcTemplate.update(SQL_INSERT_PAGE,
                page.getPageBody(),
                page.getPageTitle());
        page.setPageId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return page;
    }

    @Override
    public void editPage(Page page) {
        jdbcTemplate.update(SQL_UPDATE_PAGE,
                page.getPageBody(),
                page.getPageTitle(),
//                page.isPosted(),
                page.getPageId());
    }

    @Override
    public void deletePage(int pageId) {
        jdbcTemplate.update(SQL_DELETE_PAGE, pageId);
    }

    @Override
    public Page getPageById(int pageId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PAGE_BY_ID, new PageMapper(), pageId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Page> getAllPages() {
        return jdbcTemplate.query(SQL_SELECT_ALL_PAGES, new PageMapper());
    }
    
    @Override
    public List<Page> getAllPostedPages() {
        return jdbcTemplate.query(SQL_SELECT_ALL_POSTED_PAGES, new PageMapper());
    }

    @Override
    public void postPage(int pageId) {
        jdbcTemplate.update(SQL_POST_PAGE, pageId);
    }

    @Override
    public void unPostPage(int pageId) {
        jdbcTemplate.update(SQL_UNPOST_PAGE, pageId);
    }

    private static final class PageMapper implements ParameterizedRowMapper<Page> {

        @Override
        public Page mapRow(ResultSet rs, int i) throws SQLException {
            Page page = new Page();
            page.setPageBody(rs.getString("page"));
            page.setPageTitle(rs.getString("page_title"));
            page.setPosted(rs.getBoolean("posted"));
            page.setPageId(rs.getInt("page_id"));
            return page;
        }
    }
}
