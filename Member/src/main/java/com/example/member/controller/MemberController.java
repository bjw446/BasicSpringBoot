package com.example.member.controller;


import com.example.member.dto.*;
import com.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public CreateMemberResponse createMember(@RequestBody CreateMemberRequest request) {
        return memberService.save(request);

    }

    @GetMapping("/member/{memberId}")
    public GetOneMemberResponse getOneMember(@PathVariable Long memberId) {
        return memberService.getOne(memberId);
    }

    @GetMapping("/members")
    public List<GetOneMemberResponse> getAllMembers() {
        return memberService.getAll();
    }

    @PutMapping("/members/{memberId}")
    public UpdateMemberResponse update(@PathVariable Long memberId, @RequestBody UpdateMemberRequest request) {
        return memberService.update(memberId, request);
    }

    @DeleteMapping("/members/{memberId}")
    public void delete(@PathVariable Long memberId) {
        memberService.delete(memberId);
    }
}
