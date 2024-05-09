package exam03;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Ex02 {
    public static void main(String[] args) throws ParseException { // main() 뒤에 throws ParseException 않 적으면 오류 발생
        String price = "1,000,000원";

        DecimalFormat df = new DecimalFormat("#,###원");
        Number number = df.parse(price); // parse : 형식화된 문자열을 원래 숫자로 바꿔줌 | 개발할 때 알아서 바꾸라고 Number 작성
        long num = number.longValue();
        System.out.println(num);
    }
}
