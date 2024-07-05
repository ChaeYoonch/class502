package exam01.config;

import exam01.member.dao.MemberDao;
import exam01.member.services.InfoService;
import exam01.member.services.JoinService;
import exam01.member.validators.JoinValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class AppCtx2 {

    @Bean
    @Qualifier("mDao") // 빈의 이름 직접 지정
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberDao memberDao2() { // @Bean 빈의 이름 = memberDao2
        return new MemberDao();
    }

    @Bean
    public JoinValidator joinValidator() {
        JoinValidator joinValidator = new JoinValidator();
        joinValidator.setMemberDao(memberDao());

        return joinValidator;
    }

    @Bean
    public JoinService joinService() {
        return new JoinService(joinValidator(), memberDao()); // 의존성 주입
        // return new JoinService();
    }

    @Bean
    public InfoService infoService() {
        InfoService infoService = new InfoService();
        // infoService.setMemberDao(memberDao());

        return infoService;
    }

    @Bean // 자바 JDK, 외부 라이브러리는 수동 등록이 필수
    public DateTimeFormatter dateTimeFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");

        return formatter;
    }
}