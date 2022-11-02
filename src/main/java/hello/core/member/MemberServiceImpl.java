package hello.core.member;

public class MemberServiceImpl implements MemberService{ //회원 서비스 구현체

    //문제점 : MemberServiceImpl은 MemberRepository, MemoryMemberRepository 둘 다 의존
    //추상화도 의존, 구체화에도 의존 --> so 큰 문제
    private final MemberRepository memberRepository;
    //MemberRepository의 인터페이스만 남음. MemberServiceImpl에 대한건 밖에서 생성(AppConFig) --> 생성자 주입

    public MemberServiceImpl(MemberRepository memberRepository) { //생성자를 통해서 MemberRepository에 구현체가 뭐가 들어갈지 봄
        this.memberRepository=memberRepository;
    }
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
