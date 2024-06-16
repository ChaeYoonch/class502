package test01;

public class View { // 차의 정보를 출력하는 View 클래스 | 모델의 메소드를 호출하여 처리된데이터를 viewInfo() 라는 메소드를 통해 뷰에 전달
    // View data about car
    public void printCarInfo(String Name, String licensePlate, String releaseDate, int seatNum) {
        System.out.println("Car model name : " + Name);
        System.out.println("Car license plate : " + licensePlate);
        System.out.println("Release date : " + releaseDate);
        System.out.println("Num of seat : " + seatNum);
    }
}
