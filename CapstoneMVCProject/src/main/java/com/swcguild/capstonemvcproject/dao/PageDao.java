/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Page;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface PageDao {
    public Page addPage(Page page);
    public void editPage(Page page);
    public void deletePage(int pageId);
    public Page getPageById(int pageId);
    public List<Page> getAllPages();
    public List<Page> getAllPostedPages();
    public void postPage(int pageId);
    public void unPostPage(int pageId);
}
