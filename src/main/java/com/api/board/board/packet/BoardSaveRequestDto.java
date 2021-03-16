package com.api.board.board.packet;


import com.api.board.board.domain.Board;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel("게시물 객체")
public class BoardSaveRequestDto {
    @ApiModelProperty(value = "게시물 순번")
    private String boardSubject;
    @ApiModelProperty(value = "게시물 작성자")
    private String boardWriter;
    @ApiModelProperty(value = "게시물 내용")
    private String boardContent;

    @Builder
    public BoardSaveRequestDto(String boardSubject, String boardWriter, String boardContent) {
        this.boardSubject = boardSubject;
        this.boardWriter = boardWriter;
        this.boardContent = boardContent;
    }

    public Board toEntity() {
        return Board.builder()
                .boardSubject(boardSubject)
                .boardWriter(boardWriter)
                .boardContent(boardContent)
                .build();
    }
}
