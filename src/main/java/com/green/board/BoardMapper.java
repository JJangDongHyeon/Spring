package com.green.board;

import com.green.board.model.BoardGetDetailRes;
import com.green.board.model.BoardGetRes;
import com.green.board.model.BoardPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper /*
MyBatis에서 사용되며, 해당 인터페이스가 MyBatis의 매퍼 인터페이스임을 나타냅니다.
이 어노테이션이 붙은 인터페이스는 MyBatis가 자동으로 구현체를 생성하여 SQL 쿼리를 실행할 수 있는 Mapper로 동작합니다.
*/
// 빈등록: 스프링컨테이너한테 객체화를 해달라고 하는것
public interface BoardMapper {
    int postBoard(BoardPostReq p) ; //이게 메소드명이랑 xml의 아이디 값이랑 같아야함
    int deleteBoard(int p); //이하동문
    List<BoardGetRes> getBoardList();
    BoardGetDetailRes getBoardOne(long boardId);
}
/*
메서드 구현부가 없는 이유

MyBatis와 같은 ORM 프레임워크에서는 매퍼 인터페이스의 메서드를 구현하지 않고도 정상적으로 동작합니다.
따라서 매퍼 인터페이스의 메서드 구현이 없어도 MyBatis가 동적으로 SQL 쿼리를 생성하고 실행하기 때문에 정상적으로 동작합니다. 이는
ORM 프레임워크의 핵심 기능 중 하나이며, 개발자는 SQL 쿼리를 직접 작성하는 대신 메서드를 호출하여 데이터베이스 작업을 수행할 수 있습니다.
 */