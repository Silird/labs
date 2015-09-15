package labs.lab3.Listeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку загрузки
 */

public class MouseOpenListener3 implements MouseListener {
    private JButton openBut;

    /**
     * Конструктор
     * @param openB
     */
    public MouseOpenListener3(JButton openB) {
        openBut = openB;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * При наведении мышки отобразить активную иконку
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        openBut.setIcon(new ImageIcon("pictures/open_active.png"));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        openBut.setIcon(new ImageIcon("pictures/open.png"));
    }
}
