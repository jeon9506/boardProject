package com.basic.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
    // 메인페이지
    @RequestMapping(value = {"/","/board"})
    public String main() {
        System.out.println("메인페이지 호출완료!");
        return "boardMain.html";
    }

    // 상세페이지
    @RequestMapping(value = "/board/{board_id}")
    public String sub(@PathVariable("board_id") Integer board_id) {
        System.out.println(board_id.getClass().getName());
        System.out.println("board_id " + board_id + " 상세페이지 호출완료!");
        return "boardDetail.html";
    }
}