package spring.spring_basic.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.spring_basic.repository.MemberRepository;
import spring.spring_basic.repository.MemoryMemberRepository;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
