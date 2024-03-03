package com.hmg.dooraylgn.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmg.dooraylgn.domain.HookRequest;
import com.hmg.dooraylgn.domain.MemberRequest;
import com.hmg.dooraylgn.domain.MemberResponse;
import com.hmg.dooraylgn.service.impl.MemberServiceImpI;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberServiceImpI memberService;

    // 생성자를 통한 의존성 주입
    public MemberController(MemberServiceImpI memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/createable")
    public ResponseEntity<MemberResponse> isCreateable(
            @RequestHeader("Content-Type") String contentType,
            @RequestHeader("Authorization") String authorization, // Added authorization header
            @RequestBody MemberRequest memberRequest) {
        System.out.println("hello1");

        // Check if the provided authorization key is correct
        if (!isValidAuthorizationKey(authorization)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        try {
            // Request Body 검증
            if (!"application/json".equals(contentType)) {
                return ResponseEntity.badRequest().build();
            }

            // 여기서 실제 가입 여부 체크 로직을 구현합니다.
            boolean isCreateable = memberService.checkIfCreateable(memberRequest.getEmailAddress());

            MemberResponse response = new MemberResponse();
            response.setSuccess(isCreateable);

            if (isCreateable) {
                // 가입 불가인 경우에만 idProviderType 설정 (sso 또는 service로 분기 처리 필요)
                response.setIdProviderType("sso");
            }

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // 서버 작업 실패
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/hook")
    public ResponseEntity<String> hook(
            @RequestHeader("Content-Type") String contentType,
            @RequestHeader("Authorization") String authorization, // Added authorization header
            @RequestBody HookRequest hookRequest) {
        System.out.println("hello2");
        // Check if the provided authorization key is correct
        if (!isValidAuthorizationKey(authorization)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        try {
            // Request Body 검증
            if (!"application/json".equals(contentType)) {
                return ResponseEntity.badRequest().body("Invalid Content-Type");
            }

            // 여기서 실제 로직을 구현합니다. 이는 예시이며 실제로는 데이터 저장, 처리 등이 포함되어야 합니다.
            // 여기에 작업 수행
            // draftMemberId, emailAddress, idProviderType 등을 활용하여 작업 수행
            // ...

            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            // 서버 작업 실패
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");
        }
    }

    private boolean isValidAuthorizationKey(String authorization) {
        // Replace "abc123" with your actual valid key
        return "abc123".equals(authorization);
    }

    @GetMapping("/first")
    public Map<String, Object> firstController() {
        System.out.println("hello3");
        return memberService.getFirstData();
    }
}