package org.choongang.user.validators;

import lombok.RequiredArgsConstructor;
import org.choongang.user.controllers.RequestJoin;
import org.choongang.user.mappers.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator {

    private final UserMapper mapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class); // RequestJoin 커맨드 객체만 검증하도록 제한
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}