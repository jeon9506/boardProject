package com.basic.board.dto;

import com.basic.board.domain.Board;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private String board_title;
    private String user_name;
    private String board_contents;

    public Board toEntity() {
        return Board.builder()
                .title(this.board_title)
                .username(this.user_name)
                .content(this.board_contents)
                .build();
    }
}
