package exam03;

public class Person {
    private String name; // 사람 이름 : 김씨, 이씨 -> 변화 X 조회는 가능 | getter
    private int money; // 현재 가지고 있는 돈 | getter & setter
    private String menu; // 메뉴 정하면 커피숍에서 확인 가능 | getter & setter

    public Person(String name, int money) {
        this.name = name;
        this.money = money; // 초기화 작업
    }

    public String getName() {
        return name; // 이름 조회
    }

    public int getMoney() {
        return money; // 구매 전 돈 조회
    }

    public void setMoney(int money) {
        this.money = money;
    } // 구매 후 돈 조회

    public String getMenu() {
        return menu;
    } // 메뉴 조회

    public void setMenu(String menu) {
        this.menu = menu;
    } // 메뉴 선택

    public String toString() {
        return String.format("%s님의 남은 금액은 %d원 입니다.%n", name, money);
    }
}
