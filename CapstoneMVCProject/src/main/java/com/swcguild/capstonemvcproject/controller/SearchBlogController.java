package com.swcguild.capstonemvcproject.controller;

import com.swcguild.capstonemvcproject.dao.BlogDao;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchBlogController {
private BlogDao dao;

    @Inject
    public SearchBlogController(BlogDao dao) {
       this.dao = dao;
    }
    @RequestMapping(value={"/searchresultpage"}, method=RequestMethod.GET)
    public String displaysearchpage() {
        return "searchresultpage";
    }
}
