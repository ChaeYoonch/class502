package exam03;

public class Card {
    private static int num; // 카드번호
    private int cardNum;
    private String holder; // 카드 소유자명

    public Card() {
        this.holder = holder;
        cardNum = ++num; // 생성할 때마다 번호 1씩 증가
    }

    public String toString() {
        return String.format("카드번호: %d, 카드 소유자: %s%n", cardNum, holder);
    }
}
