package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> { // 프록시 형태로 JPA 가 다 만들어줌
    Member findByEmail(String email); // findMemberBy 가 원래 형태이지만 위에 <Member> 라고 정의되어 있으므로 생략가능 | Member 대신 Optional<Member> 도 가능

    List<Member> findByEmailContainingAndUserNameContainingOrderByCreatedAtDesc(String key1, String key2);
}