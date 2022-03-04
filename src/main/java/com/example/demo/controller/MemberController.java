package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.domain.User;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class MemberController {
    private final MemberService memberService;

    /**
     *
     * 스프링 빈 등록 하는 2가지 방법
     *  자동 등록 방법
     *   1. 컨트롤러 생성자에 사용할 서비스를 넘겨 받는 코드 추가 하며 @Autowired 추가 한다.
     *   2. 서비스클래스에는 @Service 등록이 되어 있어야 하며 사용할 레포지터리를 생성자로 받고  @Autowired 추가한다.
     *   3. 레포지터리 클래스에 @Repository 추가한다.
     *  수동 등록 방법  springConfig 참조
     *   1. 서비스 클래스에
     */

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/user/create")  // 회원 추가 페이지
    public String createUser(){
        return "user/create";
    }

    @GetMapping("/user/list")  // 회원 리스트 페이지
    public String userList(Model model){
        ArrayList arrayList=memberService.getMembers();
        model.addAttribute("members",arrayList);
        return "user/list";
    }

    @PostMapping("/user/createUser")  // 회원 추가 페이지에서 from에서 호출한 api
    public String createUser(User user){
        Member member = new Member();
        System.out.print(user.getName());
        member.setName(user.getName());
        memberService.join(member);
        return "redirect:/";
    }

}
