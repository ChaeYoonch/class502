package exam01;

import java.util.StringTokenizer;

public class Ex04 {
    public static void main(String[] args) {
        String fruits = "Apple#Orange,Melon_Banana+Mango"; // # -> Token
        StringTokenizer st = new StringTokenizer(fruits, "#,_+"); // Apple#Orange#Melon#Banana#Mango -> # 으로 분해

        while(st.hasMoreTokens()) {
            String fruit = st.nextToken();
            System.out.println(fruit);
        }
    }
}
