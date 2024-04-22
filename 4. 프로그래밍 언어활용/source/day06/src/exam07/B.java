package exam07;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class B implements MouseListener /* interface MouseListener 의 내용물을 안써도 모두 넣어야만 됨 */ {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("클릭!");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
