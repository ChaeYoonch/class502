package exam03;

public class Ex01 {
    public static void main(String[] args) {
        StarBucks starBucks = new StarBucks();
        CoffeeBean coffeeBean = new CoffeeBean(); // 초기화 작업

        Person kim = new Person("김씨", 10000); // 김씨 현재 금액
        Person lee = new Person("이씨", 15000); // 이씨 현재 금액

        kim.setMenu("아메리카노"); // 김씨 = 아메리카노 주문 예정
        lee.setMenu("라떼"); // 이씨 = 라떼 주문 예정

        try {
            /* starBucks.enter(kim); // 김씨 스타벅스 입장
            starBucks.order(); // 주문
            starBucks.exit(); // 퇴장 | 간단하게 줄이면 아래와 같음 */
            starBucks.enter(kim).order().exit(); // 아메리카노 주문
            coffeeBean.enter(lee).order().exit(); // 라떼 주문

            System.out.println(kim);
            System.out.println(lee);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("커피숍별 매출액 요약");
        CoffeeShop.showSaleSummary(starBucks);
        CoffeeShop.showSaleSummary(coffeeBean);
    }
}
