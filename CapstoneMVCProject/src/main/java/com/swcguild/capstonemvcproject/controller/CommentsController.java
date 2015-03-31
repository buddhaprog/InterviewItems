package com.swcguild.capstonemvcproject.controller;

import com.swcguild.capstonemvcproject.dao.BlogDao;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;

@Controller
public class CommentsController {
private BlogDao dao;

    @Inject
    public CommentsController(BlogDao dao) {
       this.dao = dao;
    }
}
