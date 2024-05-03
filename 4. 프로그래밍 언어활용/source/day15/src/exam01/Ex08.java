package exam01;

import java.util.Optional;

public class Ex08 {
    public static void main(String[] args) {
        // String str ="ABC";
        String str = null;
        // Optional<String> opt = Optional.of(str); null 은 허용하지 않음
        Optional<String> opt = Optional.ofNullable(str);
        // System.out.println(opt.get()); // 안에 있는 객체의 값을 꺼내옴 | null 이면, NoSuchElementException 발생
        String value = opt.orElse("기본값"); // 값이 있으면 값이 나오고 없으면 정의된 "기본값"이 나옴
        System.out.println(value);
    }
}
