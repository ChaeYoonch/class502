package exam02;

public class Ex05 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(100);
        // 메서드 체이닝 -> 여러 개를 연달아, 연결해서 사용 O
        String str = sb.append("ABC").append("DEF").append("GHI").toString();
        /* String str = sb.append("ABC")
                          .append("DEF")
                          .append("GHI")
                          .toString();
         */
        System.out.println(str);
        /*
        StringBuffer sb2 = sb.append("ABC"); // StringBuffer 객체 = sb.append("ABC"); | sb 와 sb2 는 동일한 객체
        StringBuffer sb3 = sb2.append("DEF"); // 내부에 this 반환함 | 반환값이 객체 그 자체를 반환
        StringBuffer sb4 = sb3.append("GHI");
        */
    }
}
