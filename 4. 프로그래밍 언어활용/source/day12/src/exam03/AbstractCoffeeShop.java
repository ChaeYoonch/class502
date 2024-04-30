package exam03;

import java.util.Map;

public abstract class AbstractCoffeeShop implements CoffeeShop { // 미구현된 메서드 (enter, order)-> 구현 시킴!!
    private String name; // 커피숍 이름
    private int totalSalePrice; // 매출
    private Map<String, Integer> menus; // 메뉴
    private Person person;

    public AbstractCoffeeShop(String name, Map<String, Integer> menus) {
        this.name = name;
        this.menus = menus; // 커피숍 이름, 메뉴명 = 공통 자원 -> 추상 클래스에 정의 = 공유
    }

    @Override
    public CoffeeShop enter(Person person) {
        this.person = person; // enter 시 사람 입장 -> private Person person; 에 값 할당됨
        System.out.printf("%s님이 %s에 입장하였습니다.%n", person.getName(), name); // person.getName() 사람 이름, 커피숍명

        return this; // enter, order, exit 모두
    }

    @Override
    public CoffeeShop order() {
        String menu = person.getMenu();
        if (menu == null) {
            throw new RuntimeException("메뉴를 선택하세요.");
        }

        int price = menus.getOrDefault(menu, 0); // 없으면 0 으로 기본값 설정
        if (price == 0) {
            throw new RuntimeException("없는 메뉴 입니다.");
        }

        int money = person.getMoney();
        if (money < price) {
            throw new RuntimeException(menu + "%를 구입하기에 부족한 금액입니다.");
        }

        totalSalePrice += price; // 구매 전 돈 증가
        money -= price; // 구매 후 돈 차감
        person.setMoney(money);

        System.out.printf("%s님이 %S에서 %s를 %d원에 주문했습니다.%n", person.getName(), name, menu, price);
                                                                      // 주문자명, 커피숍명, 메뉴명, 가격
        return this;
    }

    public void exit() {
        System.out.printf("%s님이 %s에서 퇴장하였습니다.%n", person.getName(), name); // 주문자명, 커피숍명
        person = null;
    }

    public int getTotalSalePrice() {
        return totalSalePrice;
    }

    public String getName() {
        return name;
    }

} // Ex01.java 에서 명령어 입력 -> 결과 도출에 나오는 결과값을 만들어 놓은 것
