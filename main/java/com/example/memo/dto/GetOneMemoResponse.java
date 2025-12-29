package com.example.memo.dto;


import lombok.Getter;

@Getter
public class GetOneMemoResponse {

    private final Long id;
    private final String contents;

    public GetOneMemoResponse(Long id, String contents) {
        this.id = id;
        this.contents = contents;
    }
}
