package com.basic.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
    // 메인페이지
    @RequestMapping(value = {"/", "/board"})
    public String main() {
        System.out.println("메인페이지 호출완료!");
        return "index";
    }

    // 상세페이지
    @RequestMapping(value = "/board/{board_id}")
    public String sub(Model model, @PathVariable("board_id") Integer board_id) {
        model.addAttribute("board_id", board_id);
        return "boardDetail";
    }
}