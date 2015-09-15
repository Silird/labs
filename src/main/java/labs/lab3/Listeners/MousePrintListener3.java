package labs.lab3.Listeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события наведения мышки на иконку сохранения
 */

public class MousePrintListener3 implements MouseListener {
    private JButton printBut;

    /**
     * Конструктор
     * @param printB
     */
    public MousePrintListener3(JButton printB) {
        printBut = printB;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    /**
     * При наведении мышки отобразить активную иконку
     * @param e
     */
    public void mouseEntered(MouseEvent e) {
        printBut.setIcon(new ImageIcon(getClass().getResource("/pictures/print_active.png")));
    }

    /**
     * При отведении мышки отобразить стандартную иконку
     * @param e
     */
    public void mouseExited(MouseEvent e) {
        printBut.setIcon(new ImageIcon(getClass().getResource("/pictures/print.png")));
    }
}
