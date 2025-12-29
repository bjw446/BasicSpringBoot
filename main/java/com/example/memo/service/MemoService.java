package com.example.memo.service;

import com.example.memo.dto.*;
import com.example.memo.entity.Memo;
import com.example.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public CreateMemoResponse save(CreateMemoRequest request) {
        Memo memo = new Memo(request.getContents());
        Memo savedMemo = memoRepository.save(memo);
        return new CreateMemoResponse(
                savedMemo.getId(),
                savedMemo.getContents()
        );
    }

    @Transactional(readOnly = true)
    public GetOneMemoResponse findOne(Long memoId) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalArgumentException("없는 메모 입니다.")
        );
        return new GetOneMemoResponse(
                memo.getId(),
                memo.getContents()
        );
    }

    @Transactional(readOnly = true)
    public List<GetOneMemoResponse> findAll() {
        List<Memo> memos = memoRepository.findAll();

        List<GetOneMemoResponse> dtos = new ArrayList<>();
        for (Memo memo : memos) {
           GetOneMemoResponse dto =  new GetOneMemoResponse(
                    memo.getId(),
                    memo.getContents()
            );
           dtos.add(dto);
        }
        return dtos;
    }

    @Transactional
    public UpdateMemoResponse update(Long memoId, UpdateMemoRequest request) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalArgumentException("없는 메모 입니다.")
        );
        memo.updateContents(request.getContents());

        return new UpdateMemoResponse(
                memo.getId(),
                memo.getContents()
        );
    }

    @Transactional
    public void delete(Long memoId) {
        boolean existence = memoRepository.existsById(memoId);

        if (!existence) {
            throw new IllegalArgumentException("없는 메모 입니다.");
        }
        memoRepository.deleteById(memoId);

    }
}
