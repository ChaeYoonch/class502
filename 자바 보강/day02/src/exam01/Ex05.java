package exam01;

public class Ex05 {
    public static void main(String[] args) {
        Student s1 = new Student(1000, "이이름", "과목1");
        Student s2 = new Student(1001, "김이름", "과목2");
        // static int id -> id=1001, name=이이름, subject=과목1 / id=1001, name=김이름, subject=과목2
        s1.study();
        s2.study();
    }
}
