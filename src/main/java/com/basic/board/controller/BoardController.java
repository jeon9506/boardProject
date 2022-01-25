package com.basic.board.controller;

import com.basic.board.dto.BoardDto;
import com.basic.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    // 게시글 저장
    @PostMapping("api/board")
    public BoardDto createBoard(@RequestBody BoardDto requestDto) {
        return boardService.creatBoard(requestDto);
    }

    // 게시글 전체조회
    @GetMapping("api/board")
    public List<BoardDto> readBoardList() {
        return boardService.readBoardList();
    }

    // 게시글 한개조회
    @GetMapping("api/board/{board_id}")
    public BoardDto readBoard(@PathVariable Integer board_id) {
        return boardService.readBoard(board_id);
    }

    // 게시글 수정
    @PatchMapping("api/board/{board_id}")
    public Integer updateBoard(@PathVariable Integer board_id, @RequestBody BoardDto boardDto) {
        boardService.update(board_id, boardDto);
        System.out.println("수정완료 : " + board_id);
        return board_id;
    }

    // 게시글 삭제
    @DeleteMapping("api/board/{board_id}")
    public Integer deleteBoard(@PathVariable Integer board_id) {
        boardService.deleteBoard(board_id);
        return board_id;
    }
}