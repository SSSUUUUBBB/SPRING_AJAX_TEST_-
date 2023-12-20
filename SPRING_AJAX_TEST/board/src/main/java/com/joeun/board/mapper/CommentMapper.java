package com.joeun.board.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.joeun.board.dto.Comment;
 
@Mapper
public interface CommentMapper {

    public List<Comment> list(int boardNo) throws Exception;
    public int insert(Comment comment) throws Exception;
    public int update(Comment comment) throws Exception;
    public int delete(int commentNo) throws Exception;

}












