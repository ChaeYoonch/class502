package board.services;

// 가정 : 외부에서 제공받은 클래스 이고, 변경 불가를 가정하고 있음
public class BoardService2 {

    public void init() {
        System.out.println("init()!");
    }

    public void destroy() {
        System.out.println("destroy()!");
    }
}