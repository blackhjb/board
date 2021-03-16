package com.api.board.board.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity@DynamicInsert
//@DynamicUpdate
//
@Table(name = "tbl_board")
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_seq")
    private Long boardSeq;

    @Lob
    @Column(name = "board_subject")
    private String boardSubject;

    @Column(name = "board_writer")
    private String boardWriter;

    @Lob
    @Column(name = "board_content")
    private String boardContent;


    @Builder
    public Board(String boardSubject, String boardWriter, String boardContent) {
        this.boardSubject = boardSubject;
        this.boardWriter = boardWriter;
        this.boardContent = boardContent;
    }

    public void update(String boardSubject, String boardContent,String boardWriter) {
        this.boardSubject = boardSubject;
        this.boardContent = boardContent;
        this.boardWriter = boardWriter;

    }
}
