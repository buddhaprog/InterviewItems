package com.swcguild.capstonemvcproject.controller;


import com.swcguild.capstonemvcproject.dao.BlogDao;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    
    private BlogDao dao;

    @Inject
    public HomeController(BlogDao dao) {
       this.dao = dao;
    }
    
    @RequestMapping(value={"/", "/home", "/homepage", "index", "/index"}, method=RequestMethod.GET)
    public String displayHomePage() {
        return "homepage";
    }
    
    
    
    
    
}
