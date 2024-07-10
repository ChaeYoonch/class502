package mappers.member;

import member.entities.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
    @Select("SELECT COUNT(*) FROM MEMBER")
    long getTotal();

    int register(Member member); // MemberMapper.xml 의 <insert id="register"> 부분 - 회원 가입
    Member get(String email); // MemberMapper.xml 의 <select id="get" resultMap="memberMap"> 부분 - 이메일로 조회
    int exists(String email); // MemberMapper.xml 의 <select id="exists" resultType="int"> 부분 - 이메일로 회원 존재 여부 확인
}