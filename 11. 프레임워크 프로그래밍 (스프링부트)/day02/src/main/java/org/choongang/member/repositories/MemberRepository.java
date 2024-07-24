package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> { // 프록시 형태로 JPA 가 다 만들어줌
    Member findByEmail(String email); // findMemberBy 가 원래 형태이지만 위에 <Member> 라고 정의되어 있으므로 생략가능 | Member 대신 Optional<Member> 도 가능

    Page<Member> findByEmailContaining(String keyword, Pageable pageable); // Pageable 메서드 매개변수로 정의 -> 정렬, 페이징

    List<Member> findByEmailContainingAndUserNameContainingOrderByCreatedAtDesc(String key1, String key2);

    @Query("SELECT m FROM Member m WHERE m.email LIKE : k1 AND m.userName LIKE : k2 ORDER BY m.createdAt DESC") // SELECT 별칭 FROM 별칭 | 치환되는 부분 = k1 = key1 & k2 = key2
    List<Member> getMembers(@Param("k1")String key1, @Param("k2") String key2);
}