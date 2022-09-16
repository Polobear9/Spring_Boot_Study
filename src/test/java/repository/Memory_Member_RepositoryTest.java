package repository;

import Service.MemberService;
import domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Memory_Member_RepositoryTest {


    MemberService memberService = new MemberService();


    @Test
    void save() { //save --> join the repository
        //given
        Member member = new Member();
        member.setName("hello");


        //when
        Long saveId = memberService.join(member);


        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findAll() {
    }
}