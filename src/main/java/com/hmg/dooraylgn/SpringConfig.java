package com.hmg.dooraylgn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hmg.dooraylgn.aop.TimeTraceAop;
import com.hmg.dooraylgn.service.MemberService;
import com.hmg.dooraylgn.service.impl.MemberServiceImpI;

@Configuration
public class SpringConfig {
    // private final MemberMapper memberMapper;

    // public SpringConfig(MemberMapper memberMapper) {
    // this.memberMapper = memberMapper;
    // }

    @Bean
    public MemberServiceImpI memberService() {
        // return new MemberService(memberMapper);
        return new MemberService();
    }

    // AOP 사용한다 명시하는게 좋다.
    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }

}
