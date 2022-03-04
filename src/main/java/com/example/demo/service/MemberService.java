package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MemberService {
    private MemberRespository memberRespository;

    @Autowired
    public MemberService(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }

    /**
     *  회원가입
     * @param member
     * @return
     */
    public Long join(Member member){
        memberRespository.findByName(member.getName()).ifPresent(m->{
            System.out.print(m);
            throw new IllegalStateException("이미 존재 하는 회원 입니다.");
        });
        memberRespository.saveMember(member);
        return member.getId();
    }

    /**
     * 회원 전체 조회
     * @return
     */
    public ArrayList<Member> getMembers(){
        return memberRespository.findAll();
    }

    /**
     *  회원 찾기
     * @return
     */
    public Optional<Member> getMember(long id){
        return  memberRespository.findById(id);
    }
}
