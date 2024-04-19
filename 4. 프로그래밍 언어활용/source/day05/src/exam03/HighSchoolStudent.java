package exam03;

public class HighSchoolStudent extends Student {

    public HighSchoolStudent() {
        super(1000, "이이름");
    } // public Student(int id, String name) { ... } 안의 내용을 결과로 도출

    @Override
    public String toString() {
        return "HighSchoolStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
