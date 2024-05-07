package exam01;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex08 {
    public static void main(String[] args) {
        Student[] students = {
                new Student(1, "이이름"),
                new Student(1, "김이름"),
                new Student(1, "박이름"),

                new Student(2, "이이름"),
                new Student(2, "김이름"),
                new Student(2, "박이름"),

                new Student(3, "이이름"),
                new Student(3, "김이름"),
                new Student(3, "박이름"),
        }; // 1차원적인 배열 형태 -> 반별로 쪼개기

        /* Map<Integer, String > data = Arrays.stream(students).collect(toMap(Student::getBan, Student::getName));

        System.out.println(data); */

        Map<Integer, List<Student>> data = Arrays.stream(students).collect(Collectors.groupingBy(Student::getBan));
        // .collect(Collectors.groupingBy(s -> s.getBan())); 와 동일

        List<Student> students2 = data.get(2);
        students2.forEach(System.out::println);
    }
}
