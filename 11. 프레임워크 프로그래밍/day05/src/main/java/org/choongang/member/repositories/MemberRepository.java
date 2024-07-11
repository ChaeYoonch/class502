package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> { // Member 의 값 여기서 지네릭으로 사용
    Member findByEmail(String email); // email 로 회원 찾음
    List<Member> findByUserNameContaining(String keyword);
    List<Member> findByUserNameContainingAndEmailContainingOrderByRegDtDesc(String key1, String key2); // (**)

    @Query("SELECT * FROM MEMBER WHERE USER_NAME LIKE :param1 AND EMAIL LIKE :param2 ORDER BY REG_DT DESC") // (**) 같은 내용
    List<Member> getMembers(@Param("param1") String key1, @Param("param2") String key2);
}