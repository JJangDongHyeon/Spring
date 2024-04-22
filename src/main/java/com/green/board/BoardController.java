package com.green.board;

import com.green.board.BoardService;
import com.green.board.model.BoardPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController //빈 등록 컨트롤러만들면 무조건 붙이면됨
    @RequiredArgsConstructor
    @RequestMapping("board")
    public class BoardController{

        private final BoardService service;
//        BoardController(){
//            this.service = new BoardService();
//        } 같음

        @PostMapping
        public int postBoard(@RequestBody BoardPostReq p){ //@RequestBody이걸 붙히면 제이슨형태로 받을 수있음
            System.out.println(p);
            service.postBoard(p);
            return 10;
        }

        @DeleteMapping
        public int deleteBoard(@RequestParam int boardId) { //boardId 가 포스트맨의 키값이됨
            return service.deleteBoard(boardId);
        }
    }

