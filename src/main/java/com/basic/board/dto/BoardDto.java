package com.basic.board.dto;

import com.basic.board.domain.Board;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private Integer board_id;
    private String board_title;
    private String user_name;
    private String board_contents;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public Board toEntity() {
        return Board.builder()
                .title(this.board_title)
                .username(this.user_name)
                .content(this.board_contents)
                .build();
    }
}
