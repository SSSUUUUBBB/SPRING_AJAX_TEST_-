package com.joeun.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeun.board.dto.Board;
import com.joeun.board.dto.Comment;
import com.joeun.board.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> list(int boardNo) throws Exception {
        List<Comment> commentList = commentMapper.list(boardNo);
        return commentList;
    }

    @Override
    public int insert(Comment comment) throws Exception {
        int result = commentMapper.insert(comment);
        return result;
    }

    @Override
    public int update(Comment comment) throws Exception {
        int result = commentMapper.update(comment);
        return result;
    }

    @Override
    public int delete(int commentNo) throws Exception {
        int result = commentMapper.delete(commentNo);
        return result;
    }
    
}
