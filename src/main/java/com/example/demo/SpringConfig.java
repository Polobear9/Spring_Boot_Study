package com.example.demo;

import com.example.demo.Service.MemberService;
import com.example.demo.repository.Memory_Member_Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memory_member_repository());
    }

    @Bean
    public Memory_Member_Repository memory_member_repository() {
        return new Memory_Member_Repository();
    }
}
