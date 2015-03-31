package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Comment;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoInMemImpl implements CommentDao {

    private static int counter = 0;
    List<Comment> commentList = new ArrayList<>();

    @Override
    public Comment addComment(Comment comment) {
        comment.setBlogId(counter++);
        commentList.add(comment);
        return comment;
    }

    @Override
    public void editComment(Comment comment) {
        for (int i = 0; i < commentList.size(); i++) {
            if (commentList.get(i).getCommentId() == comment.getCommentId()) {
                commentList.get(i).setComment(comment.getComment());
            }
        }
    }

    @Override
    public void deleteComment(int commentId) {
        for (int i = 0; i < commentList.size(); i++) {
            if (commentList.get(i).getCommentId() == commentId) {
                commentList.remove(i);
            }
        }
    }

    @Override
    public List<Comment> getCommentsByBlog(int blogId) {
        List<Comment> commentListByBlog = new ArrayList<>();
        for (int i = 0; i < commentList.size(); i++) {
            if (commentList.get(i).getBlogId() == blogId) {
                commentListByBlog.add(commentList.get(i));
            }
        }
        return commentListByBlog;
    }

    @Override
    public List<Comment> getCommentByUser(int userId) {
        List<Comment> commentListByUser = new ArrayList<>();
        for (int i = 0; i < commentList.size(); i++) {
            if (commentList.get(i).getUserId() == userId) {
                commentListByUser.add(commentList.get(i));
            }
        }
        return commentListByUser;
    }

    @Override
    public void deleteCommentsByBlogId(int blogId) {
        for (int i = 0; i < commentList.size(); i++) {
            if (commentList.get(i).getBlogId() == blogId) {
                commentList.remove(i);
            }
        }
    }

    @Override
    public Comment getCommentByCommentId(int commentId) {
        Comment comment = new Comment();
        for (int i = 0; i < commentList.size(); i++) {
            if (commentList.get(i).getCommentId() == commentId) {
                comment = commentList.get(i);
            }
        }
        return comment;
    }

    @Override
    public List<Comment> getAllComments() {
        return commentList;
    }

    @Override
    public void deleteCommentsByUserId(int userId) {
        for (int i = 0; i < commentList.size(); i++) {
            if (commentList.get(i).getUserId() == userId) {
                commentList.remove(i);
            }
        }
    }

}
