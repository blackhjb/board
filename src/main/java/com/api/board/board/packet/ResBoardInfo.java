package com.api.board.board.packet;

import com.api.board.board.domain.Board;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@ApiModel("게시물 리스펀스 객체")
public class ResBoardInfo {
    @ApiModelProperty(value = "게시물 순번")
    private Long boardSeq;
    @ApiModelProperty(value = "게시물 제목")
    private String boardSubject;
    @ApiModelProperty(value = "게시물 작성자")
    private String boardWriter;
    @ApiModelProperty(value = "게시물 내용")
    private String boardContent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "작성 일자")
    private LocalDateTime createdDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "수정 일자")
    private LocalDateTime modifiedDate;


    public ResBoardInfo(Board board) {
        this.boardSeq = board.getBoardSeq();
        this.boardSubject = board.getBoardSubject();
        this.boardWriter = board.getBoardWriter();
        this.boardContent = board.getBoardContent();
        this.createdDate = board.getCreatedDate();
        this.modifiedDate = board.getModifiedDate();
    }

}
