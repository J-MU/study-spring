package hello.core.member.Service.impl;

import hello.core.member.Service.MemberService;
import hello.core.member.model.Member;
import hello.core.member.repository.MemberRepository;
import hello.core.member.repository.impl.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
