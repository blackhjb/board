package com.api.board;

import com.api.board.board.domain.Board;
import com.api.board.board.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;
    @Test
    public void baseTimeEntity() {

        String boardSubject = "게시글_제목_저장_01";
        String boardWriter = "게시글_작성자_저장_01";
        String boardContent = "게시글_내용_저장_01";

        LocalDateTime now = LocalDateTime.of(2020, 7, 20, 0, 0, 0);

        boardRepository.save(Board.builder()
                .boardSubject(boardSubject)
                .boardWriter(boardWriter)
                .boardContent(boardContent)
                .build());

        List<Board> boardList = boardRepository.findAll();
        Board board = boardList.get(boardList.size() - 1);

        System.out.println("==== ==== ==== ==== ==== ==== ==== ====");
        System.out.println("createdDate : " + board.getCreatedDate());
        System.out.println("modifiedDate : " + board.getModifiedDate());
        System.out.println("==== ==== ==== ==== ==== ==== ==== ====");

        assertThat(board.getCreatedDate()).isAfter(now);
        assertThat(board.getModifiedDate()).isAfter(now);
    }

}
