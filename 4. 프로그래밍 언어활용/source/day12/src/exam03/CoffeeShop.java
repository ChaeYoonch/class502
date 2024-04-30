package exam03;

public interface CoffeeShop {
    CoffeeShop enter (Person person); // 커피숍에 입장
    CoffeeShop order(); // 주문
    void exit(); // 퇴장
    int getTotalSalePrice();
    String getName();
                                                    // -> 아래 꺼 = 다형성 활용
    static void showSaleSummary(CoffeeShop shop) { // CoffeeShop 이 매개변수 -> StarBucks, CoffeeBean 중 무엇일지 모르니까
        System.out.printf("%s의 총 매출액은 %d원 입니다.%n", shop.getName(), shop.getTotalSalePrice());
    }
}
