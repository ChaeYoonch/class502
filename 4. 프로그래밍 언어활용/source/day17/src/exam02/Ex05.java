package exam02;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class Ex05 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate lastYear = today.with(ChronoField.YEAR, 2023); // 2024 -> 변경되지 않음
        System.out.println("변경 X : " + today); // 불변성 유지 O
        System.out.println("변경 O : " + lastYear);
    }
}
