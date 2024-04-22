package com.green.board;


import com.green.board.model.BoardPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    public int postBoard(BoardPostReq p){
        System.out.println("BoardService - postBoard");
        mapper.postBoard(p); //자바에 맞게 짜는 것
        return 0;
    }

    public int deleteBoard(int boardId) {
        return mapper.deleteBoard(boardId);
    }
}
