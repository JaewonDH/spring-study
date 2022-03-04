package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryRepository implements MemberRespository {
    private Map<Long,Member> store = new HashMap<>();
    private long id=0L;

    @Override
    public void saveMember(Member member) {
        member.setId(++id);
        store.put(member.getId(),member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
       return store.values().stream().filter(member -> {
            return  member.getName().equals(name);
        }).findAny();
    }

    @Override
    public ArrayList<Member> findAll() {
        return new ArrayList(store.values());
    }
}
