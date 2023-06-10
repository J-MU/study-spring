package hello.servlet.basic.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save(){
        // given
        Member member = new Member("ayaan", 24);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        Member foundedMember = memberRepository.findById(member.getId());
        assertThat(foundedMember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2",20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> members = memberRepository.findAll();

        assertThat(members.size()).isEqualTo(2);
        assertThat(members).contains(member1,member2);

    }
}