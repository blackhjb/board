package com.api.board.board.repository;


import com.api.board.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    public final static String SELECT_BOARD_LIST_PAGED = ""
            + "SELECT "
            +"*"
            + " FROM tbl_board WHERE 0 < board_seq "
            + "ORDER BY board_seq DESC LIMIT ?1, ?2";

    @Query(value = SELECT_BOARD_LIST_PAGED, nativeQuery = true)
    List<Board> findFromTo(
            final Integer objectStartNum,
            final Integer objectEndNum);
}



