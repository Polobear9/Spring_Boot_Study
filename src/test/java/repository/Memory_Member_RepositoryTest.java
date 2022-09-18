package repository;

import Service.MemberService;
import domain.Member;
import org.assertj.core.api.Assertions;

class Memory_Member_RepositoryTest {

    Memory_Member_Repository memory_member_repository;

    MemberService memberService = new MemberService(memory_member_repository);


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

    public void same_User_exception(){
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        memberService.join(member2);
        //then
    }

    void findById() {
    }

    void findByName() {
    }

    void findAll() {
    }
}