package com.api.board.board.service;


import com.api.board.board.domain.Board;
import com.api.board.board.packet.ResBoardInfo;
import com.api.board.board.repository.BoardRepository;
import com.api.board.board.util.PagingUtil;
import com.api.board.board.packet.BoardSaveRequestDto;
import com.api.board.board.packet.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public int findAllCount() {
        return (int) boardRepository.count();
    }
    public ResponseEntity<Map> getPagingBoard(Integer pNum) {
        Map result = null;

        PagingUtil pu = new PagingUtil(pNum, 5, 5);
        List<Board> list = boardRepository.findFromTo(pu.getObjectStartNum(), pu.getObjectCountPerPage());
        pu.setObjectCountTotal(findAllCount());
        pu.setCalcForPaging();

        if (list == null || list.size() == 0) {
            return null;
        }

        result = new HashMap<>();
        result.put("pagingData", pu);
        result.put("list", list);

        return ResponseEntity.ok(result);
    }

    /** 게시글 - 등록 */
    @Transactional
    public Long save(BoardSaveRequestDto boardSaveRequestDto) {
        return boardRepository.save(boardSaveRequestDto.toEntity())
                .getBoardSeq();
    }

    /** 게시글 - 상세 조회 */
    @Transactional
    public ResBoardInfo findById(Long boardSeq) {

        Board board = boardRepository.findById(boardSeq)
                .orElseThrow(() -> new IllegalAccessError("[boardSeq=" + boardSeq + "] 해당 게시글이 존재하지 않습니다."));

        return new ResBoardInfo(board);
    }


    /** 게시글 - 수정 */
    @Transactional
    public Long update(Long boardSeq, BoardUpdateRequestDto boardUpdateRequestDto) {

        Board board = boardRepository.findById(boardSeq)
                .orElseThrow(() -> new IllegalAccessError("[boardSeq=" + boardSeq + "] 해당 게시글이 존재하지 않습니다."));

        board.update(boardUpdateRequestDto.getBoardSubject(), boardUpdateRequestDto.getBoardContent(),boardUpdateRequestDto.getBoardWriter());

        return boardSeq;
    }

    /** 게시글 - 삭제 */
    @Transactional
    public void delete(Long boardSeq) {
        Board board = boardRepository.findById(boardSeq)
                .orElseThrow(() -> new IllegalAccessError("[boardSeq=" + boardSeq + "] 해당 게시글이 존재하지 않습니다."));
        boardRepository.delete(board);
    }
}
