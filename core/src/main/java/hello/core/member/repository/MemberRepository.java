package hello.core.member.repository;

import hello.core.member.model.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
