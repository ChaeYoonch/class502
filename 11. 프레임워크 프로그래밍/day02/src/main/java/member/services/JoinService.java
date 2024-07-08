package member.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.controllers.RequestJoin;
import member.dao.MemberDao;
import member.entities.Member;
import member.validators.JoinValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class JoinService { // 회원 가입 서비스

    private final JoinValidator validator; // final -> 상수 | /* */ 쓰지 않으려면 @RequiredArgsConstructor 쓰면 됨

    @NonNull
    private MemberDao memberDao; // 기능을 수행 하기 위해 필요한 객체

    /* public JoinService(JoinValidator validator, MemberDao memberDao) {
        this.validator = validator;
        this.memberDao = memberDao;
    } // @Autowired 사용 X 의존성 강제 주입 | 위의 private 부분 뒤에 final 이 붙어 있으면 생성자 초기화 무조건 필요함 */

    public void process(RequestJoin form) {
        validator.check(form); // JoinService 는 validator 와 form 객체 필요 (= 의존) -> 의존성

        // 데이터 영구 저장 - DAO (Data Access Object) ex. mybatis.mapper
        Member member = Member.builder()
                        .email(form.getEmail())
                        .password(form.getPassword())
                        .userName(form.getUserName())
                        .regDt(LocalDateTime.now())
                        .build();

        memberDao.register(member);
    }
}