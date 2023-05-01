package spring.spring_basic.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spring.spring_basic.domain.Member;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        // Assertions.assertEquals의 매개변수에는 (기대하는 값, 실제 값)을 넣어서 실행
        // 만약 성공했다면 값은 안나오지만 초록불 / 아니라면 빨간불과 함께 오류
        // assertEquals(member, null);
        
        // Assertions.assertThat은 매개변수의 순서가 중요하지않음.
        // 그저 두개를 비교하고 성공과 실패를 판단
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member result = repository.findByName("Spring1").get();

        assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}

// findAll()이 실행되고 findByName()을 실행시켰을 때 findAll()에서 생성된 Spring1과 findByName()에서 생성된 Spring2는 서로 다른 객체이므로 오류.
// 그래서 테스트가 하나 끝나고나면 꼭! 클리어를 해주어야 함