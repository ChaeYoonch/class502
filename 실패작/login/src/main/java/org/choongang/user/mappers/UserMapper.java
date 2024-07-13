package org.choongang.user.mappers;

import org.apache.ibatis.annotations.Select;
import org.choongang.user.entities.User;

public interface UserMapper {
    @Select("SELECT COUNT(*) FROM MEMBER")
    long getTotal();

    int register(User user); // UserMapper.xml 의 <insert id="register"> 부분 - 회원 가입
    User check(String email); // UserMapper.xml 의 <select id="check" resultMap="userMap"> 부분 - 이메일로 조회
    int exists(String email); // UserMapper.xml 의 <select id="exists" resultType="int"> 부분 - 이메일로 회원 존재 여부 확인
}