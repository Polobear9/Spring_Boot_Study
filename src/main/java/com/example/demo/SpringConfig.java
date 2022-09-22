package com.example.demo;

import com.example.demo.Service.MemberService;
import com.example.demo.repository.JdbcMemberRepository;
import com.example.demo.repository.Memory_Member_Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }



    @Bean
    public MemberService memberService() {
        return new MemberService(memory_member_repository());
    }

    @Bean
    public Memory_Member_Repository memory_member_repository() {
        return new JdbcMemberRepository(dataSource);
    }
}
