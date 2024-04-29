package exam02;

public enum Transportation { // 상수처럼 대문자로 작성하는 것이 관례
    BUS(1350) {
        public int getTotal(int person) {
        return getFare() * person;
        } // 추상클래스
    },
    SUBWAY(1450) {
        public int getTotal(int person) {
            return getFare() * person;
        }
    },
    TAXI(4800) {
        public int getTotal(int person) {
            return getFare() * person;
        }
    };

    private final int fare; // Enum 상수 : 고정해서 쓸 목적 -> final 로 정의 | 상수 = 값을 초기화해야 함

    Transportation(int fare) {
        this.fare = fare;
    }

    public int getFare() {
        return fare;
    }

   public abstract int getTotal(int person); // 추상 클래스 -> 추상 메서드 예시
} // 정적 상수 객체
