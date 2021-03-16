package com.api.board.board.packet;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel("게시물 객체")
public class BoardUpdateRequestDto {
    @ApiModelProperty(value = "게시물 순번")
    private String boardSubject;
    @ApiModelProperty(value = "게시물 작성자")
    private String boardWriter;
    @ApiModelProperty(value = "게시물 내용")
    private String boardContent;


    @Builder
    public BoardUpdateRequestDto(String boardSubject, String boardContent, String boardWriter) {
        this.boardSubject = boardSubject;
        this.boardContent = boardContent;
        this.boardWriter = boardWriter;
    }
}
