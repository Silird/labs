package labs.lab3.Listeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку выхода
 */

public class MouseExitListener3 implements MouseListener {
    private JButton exitBut;

    /**
     * Конструктор
     * @param exitB
     */
    public MouseExitListener3(JButton exitB) {
        exitBut = exitB;
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
        exitBut.setIcon(new ImageIcon("pictures/exit_active.png"));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        exitBut.setIcon(new ImageIcon("pictures/exit.png"));
    }
}
