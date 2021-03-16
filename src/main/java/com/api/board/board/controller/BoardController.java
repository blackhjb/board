package com.api.board.board.controller;


import com.api.board.board.packet.BoardSaveRequestDto;
import com.api.board.board.packet.BoardUpdateRequestDto;
import com.api.board.board.packet.ResBoardInfo;
import com.api.board.board.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
@RestController
@Api(value = "게시글", tags = "게시글")
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시글 - 목록 조회
     */
    @ApiOperation(value = "게시글- 목록조회", notes = "사용자 목록조회")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map> getAllBoards(
            @ApiParam(name = "pNum", value = "페이지넘버")
            @RequestParam(value = "pNum", required = false) Integer pNum) {
        if (pNum == null || pNum <= 0) pNum = 1;
        return boardService.getPagingBoard(pNum);
    }

    /**
     * 게시글 - 상세 조회
     */
    @ApiOperation(value = "게시글 - 상세 조회", notes = "게시글 상세 조회")
    @GetMapping(value = "/{boardSeq}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResBoardInfo> findById(
            @ApiParam(name = "boardSeq", value = "게시글 순번")
            @PathVariable("boardSeq") Long boardSeq) {
        ResBoardInfo resBoardInfo = boardService.findById(boardSeq);
        return new ResponseEntity<ResBoardInfo>(resBoardInfo, HttpStatus.OK);
    }

    /**
     * 게시글 - 등록
     */
    @ApiOperation(value = "게시글 - 등록", notes = "게시글 등록")
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Long> save(
            @RequestBody BoardSaveRequestDto boardSaveRequestDto) {
        Long savedBoardSeq = boardService.save(boardSaveRequestDto);
        return new ResponseEntity<Long>(savedBoardSeq, HttpStatus.CREATED);
    }

    /**
     * 게시글 - 수정
     */
    @ApiOperation(value = "게시글 - 수정", notes = "게시글 수정")
    @PutMapping(value = "/{boardSeq}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Long> update(
            @ApiParam(name = "boardSeq", value = "게시글 순번")
            @PathVariable("boardSeq") Long boardSeq,
            @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {

        Long updatedBoardSeq = boardService.update(boardSeq, boardUpdateRequestDto);

        return new ResponseEntity<Long>(updatedBoardSeq, HttpStatus.CREATED);
    }

    /**
     * 게시글 - 삭제
     */
    @ApiOperation(value = "게시글 - 삭제", notes = "게시글 삭제")
    @DeleteMapping(value = "/{boardSeq}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Long> delete(
            @ApiParam(name = "boardSeq", value = "게시글 순번")
            @PathVariable("boardSeq") Long boardSeq) {
        boardService.delete(boardSeq);
        return new ResponseEntity<Long>(boardSeq, HttpStatus.NO_CONTENT);
    }
}

