package Service;

import repository.Member_Repository;
import repository.Memory_Member_Repository;
import domain.Member;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final Memory_Member_Repository memberRepository = new Memory_Member_Repository();

    public Long join(Member member) {
        validateDuplicateMember(member);
        // if member is already in repository, we throw the Exception.
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("Member " + member.getName() + " is already in repository");});
    }


}
