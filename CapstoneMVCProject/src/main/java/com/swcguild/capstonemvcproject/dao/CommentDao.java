/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Comment;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface CommentDao {

    public Comment addComment(Comment comment);

    public void editComment(Comment comment);

    public void deleteComment(int commentId);

    public Comment getCommentByCommentId(int commentId);

    public List<Comment> getAllComments();

    public List<Comment> getCommentsByBlog(int blogId);

    public List<Comment> getCommentByUser(int userId);

    public void deleteCommentsByBlogId(int blogId);

    public void deleteCommentsByUserId(int userId);

}
