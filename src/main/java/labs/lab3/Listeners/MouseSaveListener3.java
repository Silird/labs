package labs.lab3.Listeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку распечатки
 */

public class MouseSaveListener3 implements MouseListener {
    private JButton saveBut;

    /**
     * Конструктор
     * @param saveB
     */
    public MouseSaveListener3(JButton saveB) {
        saveBut = saveB;
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

    @Override
    public void mouseEntered(MouseEvent e) {
        saveBut.setIcon(new ImageIcon("pictures/save_active.png"));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        saveBut.setIcon(new ImageIcon("pictures/save.png"));
    }
}
