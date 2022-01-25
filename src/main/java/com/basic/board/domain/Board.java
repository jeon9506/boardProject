package com.basic.board.domain;

import com.basic.board.dto.BoardDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED) // 접근제어자 설정
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Board extends Timestamped {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Integer board_id;

    @Column(name = "board_title", nullable = false, columnDefinition = "varchar(20)") // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String board_title;

    @Column(name = "user_name", nullable = false, columnDefinition = "varchar(12)")
    private String user_name;

    @Column(name = "board_contents", nullable = false, columnDefinition = "varchar(20)")
    private String board_contents;

    @Builder // 빌더 패턴
    public Board(String title, String username, String content) {
        this.board_title = title;
        this.user_name = username;
        this.board_contents = content;
    }

    public BoardDto toDto() {
        return BoardDto.builder()
                .board_id(this.board_id)
                .board_title(this.board_title)
                .user_name(this.user_name)
                .board_contents(this.board_contents)
                .createAt(this.getCreateAt())
                .modifiedAt(this.getModifiedAt())
                .build();
    }

    public Board(BoardDto requestDto) {
        this.board_title = requestDto.getBoard_title();
        this.user_name = requestDto.getUser_name();
        this.board_contents = requestDto.getBoard_contents();
    }

    public void update(BoardDto requestDto) {
        this.board_title = requestDto.getBoard_title();
        this.user_name = requestDto.getUser_name();
        this.board_contents = requestDto.getBoard_contents();
    }
}