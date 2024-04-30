package exam03;

import java.util.HashMap;
import java.util.Map;

public class StarBucks extends AbstractCoffeeShop { // AbstractCoffeeShop 에 매개변수가 있어서 오류 발생

    private static Map<String, Integer> menus;

    static {
      menus = new HashMap<>();
      menus.put("아메리카노", 4000);
      menus.put("라떼", 4500);
    } // menus 초기화

    public StarBucks() {
        super("스타벅스", menus);
    }
}
