package com.green.board;

import com.green.board.BoardService;
import com.green.board.model.BoardGetDetailRes;
import com.green.board.model.BoardGetRes;
import com.green.board.model.BoardPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
BoardController는 클라이언트와의 상호작용을 담당하고, 요청을 받아들이고 응답을 반환하는 역할을 합니다.
 */

    @RestController //이 어노테이션은 해당 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타냅니다.
                // HTTP 요청을 처리하고 JSON 또는 XML 형식의 응답을 반환합니다.
    @RequiredArgsConstructor /*롬복(Lombok) 라이브러리를 사용하여 생성자 인젝션을 처리합니다.
                            롬복은 코드의 반복적인 부분을 줄여주는 라이브러리로, 여기서는 생성자를 자동으로 생성합니다.
                            */
    @RequestMapping("board")/*해당 컨트롤러의 기본 URL 경로를 "/board"로 지정합니다.
                                이 클래스의 모든 엔드포인트에는 "/board"가 접두어로 붙습니다.
                                 */
    public class BoardController{

        private final BoardService service;
//        BoardController(){
//            this.service = new BoardService();
//        } 같음

        @PostMapping /*이 어노테이션은 해당 메서드가 HTTP POST 요청을 처리하는 핸들러임을 나타냅니다.
                            즉, 클라이언트가 HTTP POST 요청을 보내면 이 메서드가 실행됩니다.
                        이 메서드는 주로 리소스를 생성하거나 업데이트하는 데 사용됩니다.
                        */
        public int postBoard(@RequestBody BoardPostReq p){ //@RequestBody이걸 붙히면 제이슨형태로 받을 수있음
            System.out.println(p);
            service.postBoard(p);
            return 10;
        }
        /*

@RequestBody 어노테이션은 Spring에서 HTTP 요청의 본문(body)에 있는 데이터를 Java 객체로 바인딩(binding)하도록 지정하는 역할을 합니다.

클라이언트가 HTTP POST 요청을 보낼 때, 데이터는 일반적으로 요청의 본문에 포함됩니다. 이 데이터는 주로 JSON 또는 XML 형식으로 전송됩니다.
Spring에서 @RequestBody 어노테이션이 메서드의 매개변수에 적용되면, Spring은 요청의 본문으로부터 데이터를 읽어와서 해당 매개변수의 타입에
맞게 변환합니다. 이렇게 변환된 데이터는 해당 메서드 내에서 사용될 수 있게 됩니다.

즉, @RequestBody 어노테이션이 사용된 매개변수는 Spring이 요청의 본문을 해당 객체로 자동으로 매핑하여 전달한다는 의미입니다. 따라서 개발자는
클라이언트가 보낸 데이터를 수동으로 파싱하고 객체로 변환할 필요 없이, 해당 객체를 메서드의 매개변수로 직접 사용할 수 있습니다. 이는 개발자가
코드를 간결하고 읽기 쉽게 유지할 수 있도록 도와줍니다.

         */

        @GetMapping
        public List<BoardGetRes> getBoardList(){
            return service.getBoardList();
        }

        @GetMapping("{boardId}")
        public BoardGetDetailRes getBoardOne(@PathVariable long boardId){
            return service.getBoardOne(boardId);
        }

        @DeleteMapping
        public int deleteBoard(@RequestParam(name="board_id") int boardId) { //boardId 가 포스트맨의 키값이됨 //@RequestParam쿼리스트링으로 받겠다.
            return service.deleteBoard(boardId);
            //@RequestParam(name="board_name")
/*
@RequestParam은 URL의 쿼리 문자열이나 HTML 폼 데이터를 받아오는 반면, @RequestBody는 HTTP 요청의 본문에 있는 데이터를 받아옵니다.
 또한 @RequestParam은 간단한 데이터를 받아오는데 사용되고, @RequestBody는 복잡한 객체를 받아오는데 사용됩니다.
 */
        }
    }

