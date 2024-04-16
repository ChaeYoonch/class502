package 다른패키지;

import 같은패키지.A;

public class B extends A { // B가 A를 상속받는다!
    public void print() {
        protectedNum = 100;
        System.out.println(protectedNum); // 외부는 안되지만, 내부는 상속을 통해 가능 -> protected
    }
}
