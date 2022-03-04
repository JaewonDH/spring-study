package com.example.demo.repository;
import com.example.demo.domain.Member;

import java.util.ArrayList;
import java.util.Optional;

public interface MemberRespository {
    public void saveMember(Member member);
    public Optional<Member> findById(Long id);
    public Optional<Member> findByName(String name);
    public ArrayList<Member> findAll();
}
