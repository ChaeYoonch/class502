package exam03;

public interface Calculator { // 인터페이스 = 설계 목적 하위 클래스가 이 목적을 실제로 구현 하는가 아닌가가 중요함
    // 메서드가 정의되면 추상 메서드가 들어가야 함!!
    // public abstract int add(...);
    int add(int num1, int num2); //  public abstract 만 자동으로 추가
} // default 절대 X!!!!! | interface = 클래스의 일종
