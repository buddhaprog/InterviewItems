package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Page;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageDaoInMemImpl implements PageDao {

    private Map<Integer, Page> pageMap = new HashMap<>();
    private static int pageIdCounter = 0;

    @Override
    public Page addPage(Page page) {
        page.setPageId(pageIdCounter++);
        pageMap.put(page.getPageId(), page);
        return page;
    }

    @Override
    public void editPage(Page page) {
        pageMap.put(page.getPageId(), page);
    }

    @Override
    public void deletePage(int pageId) {
        pageMap.remove(pageId);
    }

    @Override
    public Page getPageById(int pageId) {
        return pageMap.get(pageId);
    }

    @Override
    public List<Page> getAllPages() {
        Collection<Page> p = pageMap.values();
        return new ArrayList(p);
    }

    @Override
    public void postPage(int pageId) {
        Page page = pageMap.get(pageId);
        page.setPosted(true);
    }

    @Override
    public void unPostPage(int pageId) {
        Page page = pageMap.get(pageId);
        page.setPosted(false);
    }

    @Override
    public List<Page> getAllPostedPages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
