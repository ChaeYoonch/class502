package exam03;

import static java.lang.annotation.ElementType.*; // java 앞에 static + ElementType 뒤에 .* 쓰면 아래 ElementType 생략 가능
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({TYPE, METHOD, FIELD}) // value={ElementType.TYPE, ElementType.METHOD} | value= 생략 O
@Retention(RetentionPolicy.RUNTIME) // 정적 상수 형태 -> TYPE, METHOD, FIELD
public @interface MyAnno {
    int min() default 10; // min 설정 항목 | default = 기본값 설정 | 기본값 10
    int max() default 100; // max 설정 항목 | 기본값 100
    String[] names() default {"이름1", "이름2"}; // 배열 기호 => {}
    String value();
}
