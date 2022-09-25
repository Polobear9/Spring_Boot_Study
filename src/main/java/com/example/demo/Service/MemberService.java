package com.example.demo.Service;

import com.example.demo.repository.Member_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.Memory_Member_Repository;
import com.example.demo.domain.Member;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional

public class MemberService {

    private final Member_Repository memory_member_repository;

    public MemberService(Member_Repository memory_member_repository) {
        this.memory_member_repository = memory_member_repository;
    }


    /**
     * take a members
     */
    public Long join(Member member) {
        validateDuplicateMember(member);
        // if member is already in repository, we throw the Exception.
        memory_member_repository.save(member);
        return member.getId();
    }

    /**
     * find all members
     */

    public List<Member> findMembers() {
        //not allowed the same user to join.
        return memory_member_repository.findAll();
    }

    /**
     * find some selected members.
     *
     * @param memberID // that is the id of the member.
     * @return return the selected member is already in repository or not.
     */

    public Optional<Member> findOne(Long memberID) {
        return memory_member_repository.findById(memberID);
    }

    private void validateDuplicateMember(Member member) {
        memory_member_repository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("Member " + member.getName() + " is already in repository");
                });
    }


}
