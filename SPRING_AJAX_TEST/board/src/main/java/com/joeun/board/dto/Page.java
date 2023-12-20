package com.joeun.board.dto;

import java.util.Date;
import lombok.Data;

@Data
public class Page {
    private int boardNo;        
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private Date updDate;
    private int like;

    private Integer page;
    private Integer start;
    private Integer rows;
}
