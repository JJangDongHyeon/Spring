package com.green.board;


import com.green.board.model.BoardGetDetailRes;
import com.green.board.model.BoardGetRes;
import com.green.board.model.BoardPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service /*
이 클래스가 비즈니스 로직을 처리하는 서비스 객체임을 나타냅니다.
Spring 컨테이너는 @Service 어노테이션이 붙은 클래스를 자동으로 빈으로 등록합니다.
*/
@RequiredArgsConstructor
/*
이 어노테이션은 롬복(Lombok) 라이브러리를 사용하여 생성자를 자동으로 생성합니다.
롬복을 사용하면 생성자 주입을 간편하게 처리할 수 있습니다.
 */

/*
반면에 BoardService는 비즈니스 로직을 담당하고, 실제로 데이터를 처리하고 가공하는 역할을 합니다.
 */
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

    public List<BoardGetRes> getBoardList(){
        return mapper.getBoardList();
    }

    public BoardGetDetailRes getBoardOne(long boardId){
        return mapper.getBoardOne(boardId);
    }


}
