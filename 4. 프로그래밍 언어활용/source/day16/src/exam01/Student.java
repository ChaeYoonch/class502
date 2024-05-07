package exam01;

public class Student {
    private int ban;
    private String name;

    private int score;

    public Student(int ban, String name) {
        this.ban = ban;
        this.name = name;
    } // constructor

    public Student(int ban, String name, int score) {
        this.ban = ban;
        this.name = name;
        this.score =score;
    } // constructor

    public int getScore() {
        return score;
    }

    public int getBan() {
        return ban;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ban=" + ban +
                ", name='" + name + '\'' +
                '}';
    } // toString
}
