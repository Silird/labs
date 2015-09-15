package labs.lab5.Listeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку удаления
 */

public class MouseRemoveListener5 implements MouseListener {
    private JButton removeBut;

    /**
     * Конструктор
     * @param removeB
     */
    public MouseRemoveListener5(JButton removeB) {
        removeBut = removeB;
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
        removeBut.setIcon(new ImageIcon("pictures/remove_active.png"));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        removeBut.setIcon(new ImageIcon("pictures/remove.png"));
    }
}
