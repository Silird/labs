package labs.lab3.Listeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события при нажатии на кнопку Поиск
 */

public class ActionFilterListener3 implements ActionListener {
    protected JFrame carsList;

    /**
     * Конструктор
     * @param cList
     */
    public ActionFilterListener3(JFrame cList) {
        carsList = cList;
    }

    /**
     * Вывод на экран сообщения
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(carsList, "Проверка нажатия на кнопку");
    }
}
