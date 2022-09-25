package com.example.demo;

import com.example.demo.Service.MemberService;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final Member_Repository memberRepository;

    @Autowired
    public SpringConfig(Member_Repository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

/*    @Bean
    public Member_Repository memory_member_repository() {
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(entityManager);
    }*/
}
