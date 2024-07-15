package org.choongang.user.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.user.controllers.RequestJoin;
import org.choongang.user.entities.User;
import org.choongang.user.mappers.UserMapper;
import org.choongang.user.validators.JoinValidator;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // final 쓸 때 사용
public class JoinService {

    private final JoinValidator validator;
    private final UserMapper mapper;

    public void process(RequestJoin form) {
        // 유효성 검사
        validator.check(form);

        // 비밀번호 해시화
        String hash = BCrypt.hashpw(form.getPassword(), BCrypt.gensalt(12));

        // DB 저장
        User userLogin = User.builder()
                .email(form.getEmail())
                .password(hash)
                .userName(form.getUserName())
                .build();

        int result = mapper.register(userLogin);
        if (result < 1) {
            throw new BadRequestException("회원가입 실패");
        }
    }
}