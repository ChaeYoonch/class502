package Q3;

public class CoffeeTest {
    public static void main(String[] args) {

        Person kim = new Person("김씨", 10000);
        Person lee = new Person("이씨", 15000);

        StarBucksCoffee starCoffee = new StarBucksCoffee();
        CoffeeBeanCoffee beanCoffee = new CoffeeBeanCoffee();

        kim.buyStarCoffee(starCoffee, 4000);
        lee.buyBeanCoffee(beanCoffee, 4500);

    }
}
