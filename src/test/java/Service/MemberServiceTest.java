package Service;

import domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.Memory_Member_Repository;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    Memory_Member_Repository memory_Member_Repository;


    @BeforeEach
    public void beforeEach(){
        memory_Member_Repository = new Memory_Member_Repository();
        memberService = new MemberService(memory_Member_Repository);

    }
    @AfterEach
    public void afterEach(){
    }


    @Test
    void join() {
        //give
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);


        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void sameMemberFind() {
        //give
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }



    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}