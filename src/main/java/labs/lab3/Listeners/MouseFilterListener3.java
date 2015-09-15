package labs.lab3.Listeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку фильтра
 */

public class MouseFilterListener3 implements MouseListener {
    private JButton filterBut;

    public MouseFilterListener3(JButton filterB) {
        filterBut = filterB;
    }

    /**
     * Конструктор
     * @param e
     */
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
        filterBut.setIcon(new ImageIcon("pictures/filter_active.png"));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        filterBut.setIcon(new ImageIcon("pictures/filter.png"));
    }
}
