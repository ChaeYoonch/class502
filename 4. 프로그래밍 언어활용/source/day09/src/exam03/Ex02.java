package exam03;

public class Ex02 {
    public static void main(String[] args) {
        String fileName = "image.png";
        String extension = fileName.substring(6);
        System.out.println(extension);
        String str = fileName.substring(2, 5); // 2, 3, 4 만 나오고 마지막 5는 나오지 않음 (2이상 5미만)
        System.out.println(str);
        // String extension2 = fileName.substring(-3);
        // System.out.println(extension2);
    }
}
