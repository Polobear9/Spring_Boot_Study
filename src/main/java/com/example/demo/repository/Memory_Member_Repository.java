package com.example.demo.repository;

import com.example.demo.domain.Member;

import java.util.*;


public class Memory_Member_Repository implements Member_Repository {

    private static Map<Long, Member> store = new HashMap<>();
    //conquerable desivel -> need to study.
    //atomLong --> need to study.
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public Optional<Member> findByInfo(Long id, String name) {
        return store.values().stream()
                .filter(member -> member.getId().equals(id))
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
