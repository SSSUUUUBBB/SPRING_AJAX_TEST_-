package com.joeun.board.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.joeun.board.dto.Board;
import com.joeun.board.dto.Page;
import com.joeun.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Slf4j  
@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    /**
     * 게시글 목록
     * [GET]
     * /board/list
     * model : boardList
     * @return
     * @throws Exception
     */
    @GetMapping(value="/list")
    public String list(Model model) throws Exception {
        log.info("[GET] - /board/list");

        List<Board> boardList= boardService.list();
        model.addAttribute("boardList", boardList);
        return "board/list";
    }

    /**
     * 게시글 조회
     * [GET] 
     * /board/read
     * - model : board, fileList
     * @param model
     * @param boardNo
     * @return
     * @throws Exception
     */
    @GetMapping(value="/read")
    public String read(Model model, int boardNo) throws Exception {
        log.info("[GET] - /board/read");

        Board board = boardService.select(boardNo);
        model.addAttribute("board", board);
        return "board/read";
    }

    /**
     * 게시글 쓰기
     * [GET]
     * /board/insert
     * model : ❌ 
     * @return
     */
    @GetMapping(value="/insert")
    public String insert(@ModelAttribute Board board) {
        return "board/insert";
    }
    /**
     * 게시글 쓰기 처리
     * [POST]
     * /board/insert
     * model : ❌
     * @param board
     * @return
     * @throws Exception
     */
    @PostMapping(value="/insert")
    public String insertPro(@ModelAttribute Board board) throws Exception {
        int result = boardService.insert(board);
        if( result == 0 ) return "board/insert";
        return "redirect:/board/list";
    }
    
    /**
     * 게시글 수정
     * [GET]
     * /board/update
     * model : board
     * @param model
     * @param boardNo
     * @return
     * @throws Exception
     */
    @GetMapping(value="/update")
    public String update(Model model, int boardNo) throws Exception {
        Board board = boardService.select(boardNo);
        model.addAttribute("board", board);
        return "board/update";
    }
    /**
     * 게시글 수정 처리
     * [POST]
     * /board/update
     * model : board
     * @param board
     * @return
     * @throws Exception
     */
    @PostMapping(value="/update")
    public String updatePro(Board board) throws Exception {
        int result = boardService.update(board);
        int boardNo = board.getBoardNo();
        if( result == 0 ) return "redirect:/board/update?boardNo=" + boardNo;
        return "redirect:/board/list";
    }

    /**
     * 게시글 삭제 처리
     * [POST]
     * /board/delete
     * model : ❌
     * @param boardNo
     * @return
     * @throws Exception
     */
    @PostMapping(value="/delete")
    public String deletePro(int boardNo) throws Exception {
        int result = boardService.delete(boardNo);
        if( result == 0 ) return "redirect:/board/update?boardNo=" + boardNo;
        return "redirect:/board/list";
    }

    @ResponseBody
    @GetMapping("/page")
    public List<Page> page(int page) throws Exception {
        int rows = 10;
        int start = rows * (page - 1);

        Page list = new Page();
        list.setPage(page);
        list.setStart(start);
        list.setRows(rows);
        
        List<Page> result = boardService.page(list);

        return result;
    }
    @ResponseBody
    @GetMapping("/count") 
    public int count() throws Exception {
        int result = boardService.count();
        return result;
    }

    @PostMapping(value="/like")
    public int like(@RequestParam("boardNo") int boardNo) throws Exception {
        int result = boardService.like(boardNo);
        return result;
    }
    @PostMapping(value="/unlike")
    public int unlike(@RequestParam("boardNo") int boardNo) throws Exception {
        int result = boardService.unlike(boardNo);
        return result;
    }
    
}
