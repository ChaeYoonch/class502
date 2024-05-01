package Q3;

public class Person {

    String name;
    int money;

    Person(String name, int money ){
        this.name = name;
        this.money = money;
    }

    public void buyStarCoffee(StarBucksCoffee sCoffee, int money) {
        String message = sCoffee.brewing(4000);
        if(message != null) {
            this.money -= money;
            System.out.println("김씨가 " + money + "원에 "  + message);
        }
    }

    public void buyBeanCoffee(CoffeeBeanCoffee bCoffee, int money) {
        String message = bCoffee.brewing(4500);
        if(message != null) {
            this.money -= money;
            System.out.println("이씨가 " + money + "원에 "  + message);
        }
    }
}
