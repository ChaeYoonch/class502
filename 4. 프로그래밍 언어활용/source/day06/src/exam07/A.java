package exam07;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class A extends MouseAdapter { // 기능이 추가되면 매번 추가
    // => MouseListener 인터페이스 기본 구현 클래스 | 기본 구현 제공 & 필요한 것만 추가 가능

    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
