package Q5;

public class AcademyTest {
    public static void main(String[] args) { // Academy 에 ChoongangAcademy1 와 ChoongangAcademy2 2개 존재

        Academy ChoongangAcademy1 = Academy.getInstance();
        Academy ChoongangAcademy2 = Academy.getInstance();

        System.out.println( ChoongangAcademy1 == ChoongangAcademy2); // ChoongangAcademy1 와 ChoongangAcademy2 가 동일한가?
    }
}
