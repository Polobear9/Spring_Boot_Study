package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//need to study the Jpa and Spring Data Jpa , Hibernate.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, Member_Repository {

    @Override
    Optional<Member> findByName(String name);
}
