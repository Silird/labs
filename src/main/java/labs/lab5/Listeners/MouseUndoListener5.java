package labs.lab5.Listeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку отмены
 */

public class MouseUndoListener5 implements MouseListener {
    private JButton undoBut;

    /**
     * Конструктор
     * @param undoB
     */
    public MouseUndoListener5(JButton undoB) {
        undoBut = undoB;
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
        undoBut.setIcon(new ImageIcon("pictures/undo_active.png"));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        undoBut.setIcon(new ImageIcon("pictures/undo.png"));
    }
}
