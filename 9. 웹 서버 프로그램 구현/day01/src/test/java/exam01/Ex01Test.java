package exam01;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName(" 테스트 ")
public class Ex01Test {

    @Test
    @DisplayName(" 테스트 1 : Calculator ")
    void test1() {
        Calculator cal = new Calculator();
        int num1 = 10, num2 = 20; // 10 + 20 -> 30
        int result = cal.add(num1, num2);
        assertEquals(30, result);
    }

    @Test
    @Disabled
    @DisplayName(" 테스트 2 : LocalDate ")
    void test2() {
        LocalDate expected = LocalDate.now();
        LocalDate date = LocalDate.of(2024, 6, 5);
        assertEquals(expected, date); // expected 와 date 는 다름 -> equals and hashcode 로 동등성 비교하므로 동일하다고 나옴
        assertSame(expected, date); // 동일성 비교이므로 -> 테스트 실패
    }

    @Test
    @Disabled
    @DisplayName(" 테스트 3: fail ")
    void test3() {
        fail();
    }
}
