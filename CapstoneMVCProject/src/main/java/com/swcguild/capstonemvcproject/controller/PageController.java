package com.swcguild.capstonemvcproject.controller;

import com.swcguild.capstonemvcproject.dao.PageDao;
import com.swcguild.capstonemvcproject.dto.Page;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PageController {

    private PageDao pageDao;

    @Inject
    public PageController(PageDao dao) {
        this.pageDao = dao;
    }

    @RequestMapping(value = {"/page", "/pagepage"}, method = RequestMethod.GET)
    public String displayPagePage() {
        return "pagepage";
    }
    
     @RequestMapping(value = {"/pagedetailpage"}, method = RequestMethod.GET)
    public String displayPageDetailPage(HttpServletRequest req, Model model) {
        int pageId = Integer.parseInt(req.getParameter("pageId"));
        Page page = pageDao.getPageById(pageId);
        model.addAttribute("pageContent", page.getPageBody());
        model.addAttribute("pageTitle", page.getPageTitle());
        return "pagedetailpage";
    }

    @RequestMapping(value = "/addNewPage", method = RequestMethod.GET)
    public String addNewPage() {
        return "addNewPage";
    }

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Page addPage(@RequestBody Page page) {
        Page addedPage = new Page();
        addedPage.setPageTitle(page.getPageTitle());
        addedPage.setPageBody(page.getPageBody());
        pageDao.addPage(addedPage);
        return page;
    }

    @RequestMapping(value = {"/adminpage"}, method = RequestMethod.GET)
    public String displayAdminPagePage() {
        return "adminpage";
    }
    @RequestMapping(value = "/page/{pageId}", method = RequestMethod.GET)
    @ResponseBody
    public Page getBlogById(@PathVariable("pageId") int pageId) {
        return pageDao.getPageById(pageId);
    }
    
    @RequestMapping(value = "/pages", method = RequestMethod.GET)
    @ResponseBody public List<Page> getAllPages() {
        return pageDao.getAllPages();
    }
    
    @RequestMapping(value = "/postedPages", method = RequestMethod.GET)
    @ResponseBody public List<Page> getAllPostedPages() {
        return pageDao.getAllPostedPages();
    }
    
    @RequestMapping(value = "/page/{pageId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePage(@PathVariable("pageId") int pageId) {
        pageDao.deletePage(pageId);
    }
    
    @RequestMapping(value = "/page/{pageId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editPage(@PathVariable("pageId") int pageId, @RequestBody Page page) {
        page.setPageId(pageId);
        pageDao.editPage(page);
    }
    
    @RequestMapping(value = "/unpostpage/{pageId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unpostBlog(@PathVariable("pageId") int pageId) {
        pageDao.unPostPage(pageId);
    }
    
    @RequestMapping(value = "/postpage/{pageId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void postBlog(@PathVariable("pageId") int pageId) {
        pageDao.postPage(pageId);
    }
}
