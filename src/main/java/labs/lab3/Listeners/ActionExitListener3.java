package labs.lab3.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Действие по нжатию на кнопку выхода
 */

public class ActionExitListener3 implements ActionListener {

    /**
     * Выход из программы
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
