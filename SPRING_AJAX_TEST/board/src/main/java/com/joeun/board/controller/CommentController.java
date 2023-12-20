package com.joeun.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joeun.board.dto.Comment;
import com.joeun.board.service.CommentService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@Slf4j
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @GetMapping("/list")
    public List<Comment> list(int boardNo) throws Exception {
        List<Comment> list = commentService.list(boardNo);
        return list;
    }

    @ResponseBody
    @PostMapping("/insert")
    public int insert(@ModelAttribute Comment comment) throws Exception {
        int result = commentService.insert(comment);
        return result;
    }

    @ResponseBody
    @PutMapping("/update")
    public int update(@ModelAttribute Comment comment) throws Exception {
        int result = commentService.update(comment);
        return result;
    }

    @ResponseBody
    @DeleteMapping("/delete")
    public int delete(int commentNo) throws Exception {
        int result = commentService.delete(commentNo);
        return result;
    }
    
}
