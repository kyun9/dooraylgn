package com.hmg.dooraylgn.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.hmg.dooraylgn.service.impl.MemberServiceImpI;

@Transactional
public class MemberService implements MemberServiceImpI {
    // private final MemberMapper memberMapper;

    // public MemberService(MemberMapper memberMapper) {
    // this.memberMapper = memberMapper; // memberService를 외부에서 넣어주는 것으로 바꾸기 : 이전에는
    // 테스트하려면 new로 새로 만들어서 서로
    // // instance가 달랐어. 그렇게 해서 같은 인스턴스를 공유할 수 있어
    // }

    @Override
    public Map<String, Object> getFirstData() {
        Map<String, Object> firstData = new HashMap<>();

        firstData.put("label1", "check1");
        firstData.put("label2", "check2");
        firstData.put("label3", "check3");

        return firstData;
    }

    // /**
    // * 회원가입
    // */
    // public Long join(Member member) {
    // validateDuplicateMember(member); // 중복 회원 검증
    // memberRepository.save(member);
    // return member.getId();
    // }

    // private void validateDuplicateMember(Member member) {
    // // ifPresent : 만일 값이 있으면 (Optional)
    // // orElseGet : 많이 값이 있으면 꺼내고, 없으면 메소드 및 default값을 실행해
    // memberRepository.findByName(member.getName()).ifPresent(m -> {
    // throw new IllegalStateException("이미 존재하는 회원입니다.");
    // });
    // }

    // /**
    // * 전체 회원 조회
    // */
    // public List<Member> findMembers() {
    // return memberRepository.findAll();
    // }

    // public Optional<Member> findOne(Long memberId) {
    // return memberRepository.findById(memberId);
    // }

    @Override
    public boolean checkIfCreateable(String email) {
        // 가입 가능 여부를 체크하는 비즈니스 로직을 구현합니다.
        // 여기서는 간단한 예시로 모두 true를 반환합니다.
        return true;
    }
}
