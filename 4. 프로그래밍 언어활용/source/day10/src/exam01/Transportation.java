package exam01;

public enum Transportation {
    BUS(1400); // 0번째
    // SUBWAY(1300), // 1번째
    // TAXI(4500); // 2번째 -> Ex04 에서 ordinal 로 가져온 값

    private final int fare;

    Transportation (int fare) {
        this.fare = fare;
    }

    public int getFare() {
        return fare;
    }

   // public abstract int getTotal(int person); // abstract : 추상 클래스
} // 상수 열거 -> 범주화 | 정적 상수 객체 -> 메서드가 보임
