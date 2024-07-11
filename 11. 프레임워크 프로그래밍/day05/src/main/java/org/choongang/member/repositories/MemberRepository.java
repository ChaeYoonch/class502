package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> { // Member 의 값 여기서 지네릭으로 사용
    Member findByEmail(String email); // email 로 회원 찾음
}