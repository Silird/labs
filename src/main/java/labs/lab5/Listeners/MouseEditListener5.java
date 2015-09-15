package labs.lab5.Listeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку редактирования
 */

public class MouseEditListener5 implements MouseListener {
    private JButton editBut;

    /**
     * Конструктор
     * @param editB
     */
    public MouseEditListener5(JButton editB) {
        editBut = editB;
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
        editBut.setIcon(new ImageIcon("pictures/edit_active.png"));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        editBut.setIcon(new ImageIcon("pictures/edit.png"));
    }
}
