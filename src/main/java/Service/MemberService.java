package Service;

import repository.Member_Repository;
import repository.Memory_Member_Repository;
import domain.Member;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final Memory_Member_Repository memory_member_repository;

    public MemberService(Memory_Member_Repository memory_member_repository) {
        this.memory_member_repository = memory_member_repository;
    }

    /**
     * take a members
     */
    public Long join(Member member) {
        validateDuplicateMember(member);
        // if member is already in repository, we throw the Exception.
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * find all members
     */

    public List<Member> findMembers() {
        //not allowed the same user to join.
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberID) {
        return memberRepository.findById(memberID);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("Member " + member.getName() + " is already in repository");
                });
    }


}
