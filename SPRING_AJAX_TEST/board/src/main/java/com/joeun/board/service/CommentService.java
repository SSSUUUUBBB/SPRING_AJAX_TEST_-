package com.joeun.board.service;

import java.util.List;

import com.joeun.board.dto.Comment;

public interface CommentService {
    public List<Comment> list(int boardNo) throws Exception;
    public int insert(Comment comment) throws Exception;
    public int update(Comment comment) throws Exception;
    public int delete(int commentNo) throws Exception;
}
