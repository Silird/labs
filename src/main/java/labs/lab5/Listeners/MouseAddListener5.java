package labs.lab5.Listeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку добавления записи
 */

public class MouseAddListener5 implements MouseListener {
    private JButton addBut;

    /**
     * Конструктор
     * @param addB
     */
    public MouseAddListener5(JButton addB) {
        addBut = addB;
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
        addBut.setIcon(new ImageIcon("pictures/add_active.png"));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        addBut.setIcon(new ImageIcon("pictures/add.png"));
    }
}
