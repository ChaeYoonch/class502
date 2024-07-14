package org.choongang.user.repositories;

import org.choongang.user.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.choongang.user.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email); // email 로 회원 찾음
    Page<User> findByUserNameContaining(String keyword, Pageable pageable);
}