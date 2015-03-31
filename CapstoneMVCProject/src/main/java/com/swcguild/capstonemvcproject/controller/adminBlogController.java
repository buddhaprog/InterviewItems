/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.capstonemvcproject.controller;

import com.swcguild.capstonemvcproject.dao.BlogDao;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Helvinator
 */
@Controller
public class adminBlogController {
    
     private BlogDao dao;

    @Inject
    public adminBlogController(BlogDao dao) {
       this.dao = dao;
    }
    
@RequestMapping(value={"/adminblog"}, method=RequestMethod.GET)
    public String displayadminblog() {
        return "adminblog";
    }
}
