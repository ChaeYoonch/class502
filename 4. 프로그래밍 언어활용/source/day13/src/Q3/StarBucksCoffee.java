package Q3;

public class StarBucksCoffee {
    int money;

    public String brewing(int money) {

        this.money += money;
        if(money == CoffeeMenu.StarBucksAmericano) {
            return "별다방 StarBucks 에서 아메리카노를 구매했습니다";
        }
        else if(money == CoffeeMenu.StarBucksLatte) {
            return "별다방 StarBucks 에서 라떼를 구매했습니다";
        }
        else {
            return null;
        }
    }
}

