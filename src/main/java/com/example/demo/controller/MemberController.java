package com.example.demo.controller;

import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

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


}
