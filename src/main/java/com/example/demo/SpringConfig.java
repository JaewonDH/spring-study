package com.example.demo;
import com.example.demo.repository.JDBCMemberRepository;
import com.example.demo.repository.JdbcTemplateMemberRepository;
import com.example.demo.repository.MemberRespository;
import com.example.demo.repository.MemoryRepository;
import com.example.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }

    @Bean
    public MemberRespository memberRepository(){
        //return new MemoryRepository();
        //return new JDBCMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);

    }
    /**
     *   수동 등록 방법  springConfig 참조
     *    1. 서비스 클래스와, 레포지터리 클래스의  @Service , @Repository 제거 후
     *    2. springConfig @Bean을 선헌 후 위와 같이 두개를 직접 생성하며 리턴 하면 수동으로 등록된다.
     *
     */

}