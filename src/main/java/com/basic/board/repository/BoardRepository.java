package com.basic.board.repository;

import com.basic.board.domain.Board;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    List<Board> findAllByOrderByCreateAtDesc();
}