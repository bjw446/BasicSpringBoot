package com.example.member.dto;

import lombok.Getter;

@Getter
public class GetOneMemberResponse {
    private final Long id;
    private final String name;

    public GetOneMemberResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
