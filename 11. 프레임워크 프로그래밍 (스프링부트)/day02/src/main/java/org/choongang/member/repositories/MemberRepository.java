package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> { // 프록시 형태로 JPA 가 다 만들어줌

}