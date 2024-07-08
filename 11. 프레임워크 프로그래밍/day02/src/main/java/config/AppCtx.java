package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 클래스 임을 알려 주는 애노테이션
/*@ComponentScan(basePackages="member",
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = ManualBean.class)
) // () 안이 스캔 범위 | 자동으로 검색되지 않도록 배제*/
/*@ComponentScan(basePackages = "member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {MemberDao.class, JoinValidator.class})) // 자동으로 검색되지 않도록 배제*/
/*@ComponentScan(basePackages = "member",
        excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX, pattern = "member\\.*\\w*Dao")) // 정규 표현식 사용 */
/*@ComponentScan(basePackages = {"member", "board"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "member..*Dao")) // Ant 패턴 사용 */
@ComponentScan({"member", "board"})
public class AppCtx {

}