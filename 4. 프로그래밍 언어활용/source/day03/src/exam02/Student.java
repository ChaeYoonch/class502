package exam02;

public class Student {
    public static int id; // 정적 변수
    private String name = "이이름"; // 정의만 한 것 |변수가 되고, 공간을 할당 받으면 호출 시에 name 값에 "이이름"이 나옴
    private String subject;

    public Student() {}

    public Student(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }





    public static void staticMethod() {
        System.out.println("정적 메서드!!"); // this 지역 변수 X -> 객체의 자원 접근 X
        /* this.name = "이이름"; this.instanceMethod(); 오류 발생 */
        id = 1000; // 정적 자원만 접근 가능(static 변수, 메서드)
    } // 객체와 상관없이 사용 가능

    public void instanceMethod() {
        System.out.println("인스턴스 메서드!!"); // this 지역 변수 O : 객체 자원 접근
        System.out.println(this.name);

        // 정적 자원은 객체 생성 이전부터 존재
        staticMethod();
        id = 1000;
    } // 객체가 존재해야지만 호출 가능

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
