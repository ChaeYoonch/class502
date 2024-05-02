package exam01;

import java.util.function.Supplier;

public class Book {
    private String title;

    public String getTitle() {
        return title;
    } // 제목을 조회할 수 있는 getter 형태 메서드 추가

    public void printTitle() {
        Supplier<String> t1 = () -> getTitle();
        Supplier<String> t2 = this::getTitle; // 메서드 참조
    }
}
