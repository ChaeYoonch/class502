package Q3;

public class CoffeeBeanCoffee {

        int money;

        public String brewing(int money) {

        this.money += money;
        if(money == CoffeeMenu.CoffeeBeanAmericano) {
            return "콩다방 CoffeeBean 에서 아메리카노를 구매했습니다";
        }
        else if(money == CoffeeMenu.CoffeeBeanLatte) {
            return "콩다방 CoffeeBean 에서 라떼를 구매했습니다";
        }
        else {
            return null;
        }
    }
}
