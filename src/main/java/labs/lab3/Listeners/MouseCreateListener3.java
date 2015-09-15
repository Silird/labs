package labs.lab3.Listeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку выхода
 */

public class MouseCreateListener3 implements MouseListener {
    private JButton createBut;

    /**
     * Конструктор
     * @param createB
     */
    public MouseCreateListener3(JButton createB) {
        createBut = createB;
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
        createBut.setIcon(new ImageIcon("pictures/create_active.png"));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        createBut.setIcon(new ImageIcon("pictures/create.png"));
    }
}
