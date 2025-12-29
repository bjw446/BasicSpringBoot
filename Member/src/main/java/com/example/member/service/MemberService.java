package com.example.member.service;


import com.example.member.dto.*;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public CreateMemberResponse save(CreateMemberRequest request) {
        Member member = new Member(
                request.getName()
        );
        Member savedMember = memberRepository.save(member);
        return new CreateMemberResponse(
                savedMember.getId(),
                savedMember.getName()
        );
    }

    @Transactional(readOnly = true)
    public GetOneMemberResponse getOne(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("없는 멤버 입니다.")
        );
        return new GetOneMemberResponse(
                member.getId(),
                member.getName()
        );
    }

    @Transactional(readOnly = true)
    public List<GetOneMemberResponse> getAll() {
        List<Member> members = memberRepository.findAll();

        List<GetOneMemberResponse> dtos = new ArrayList<>();
        for (Member member : members) {
            GetOneMemberResponse dto = new GetOneMemberResponse(
                    member.getId(),
                    member.getName()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional
    public UpdateMemberResponse update(Long memberId, UpdateMemberRequest request) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("없는 멤버 입니다.")
        );
        member.update(
                request.getName()
        );
        return new UpdateMemberResponse(
                member.getId(),
                member.getName()
        );
    }

    @Transactional
    public void delete(Long memberId) {
        boolean existence = memberRepository.existsById(memberId);

        if(!existence){
            throw new IllegalArgumentException("없는 멤버 입니다.");
        }
        memberRepository.deleteById(memberId);
    }
}

