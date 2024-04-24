package exam03;

public class Person {
    public int age; // 정보 조회용 변수 정의
    public String name; // 정보 조회용 변수 정의

    public Person() {}
    public Person(int age, String name) {
        this.age = age; // 정보 조회용 생성자
        this.name = name; // 정보 조회용 생성자
    }

    public int getAge() {
        return age;
    } // 메서드

    public String getName() {
        return name;
    } // 메서드
}
