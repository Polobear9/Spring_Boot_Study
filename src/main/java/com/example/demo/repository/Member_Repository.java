package com.example.demo.repository;
import com.example.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface Member_Repository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);

    Optional<Member> findByInfo(Long id, String name);

    List<Member> findAll();

}
