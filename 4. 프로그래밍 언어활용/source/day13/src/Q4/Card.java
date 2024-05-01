package Q4;

public class Card {

    private int cardNumber;
    private static int serialNum = 10000;

    Card(){
        serialNum++;
        cardNumber = serialNum;
    } // 카드 고유 번호 = SerialNum & 카드 번호 자동 증가

    public int getCardNumber() {
        return cardNumber;
    } // 카드 발급 시마다 카드 고유 번호 SerialNum 부여

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

}