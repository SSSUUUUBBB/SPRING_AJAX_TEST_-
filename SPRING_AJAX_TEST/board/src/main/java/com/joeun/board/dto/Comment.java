package com.joeun.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Comment {
    private int boardNo;        
    private int commentNo;        
    private String writer;
    private String content;
    private Date regDate;
    private Date updDate;
}
