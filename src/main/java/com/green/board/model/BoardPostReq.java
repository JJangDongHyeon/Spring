package com.green.board.model;
import lombok.*;
//import lombok.Getter;
//import lombok.Setter;

@Setter
@Getter
@ToString
public class BoardPostReq {
    private String title;
    private String contents;
    private String writer;
}
