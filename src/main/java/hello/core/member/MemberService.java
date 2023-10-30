package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);


}
