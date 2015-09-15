package labs.lab4.Listeners;

import labs.lab3.Listeners.ActionFilterListener3;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события при нажатии на кнопку Поиск
 */
public class ActionFilterListener4 extends ActionFilterListener3 {
    protected JTextField carName;
    protected JComboBox client;

    /**
     * Конструктор
     * @param cList
     * @param cName
     * @param c
     */
    public ActionFilterListener4(JFrame cList, JTextField cName, JComboBox c) {
        super(cList);
        carName = cName;
        client = c;
    }

    /**
     * Исключительная синуация, когда пользователь не ввёл название книги
     */
    private class NullBookException extends Exception {
        public NullBookException() {
            super("Вы не ввели название книги для поиска");
        }
    }

    /**
     * Исключительная синуация, когда пользователь не выбрал автора
     */
    private class NullAuthorException extends Exception {
        public NullAuthorException() {
            super("Вы не выбрали автора");
        }
    }

    /**
     * Отлов исключительных ситуаций при нажатии на кнопку
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //Search();
            if (client.getSelectedItem().equals(new String("Клиент"))) {
                throw new NullAuthorException();
            }
            if (carName.getText().equals(new String("Марка машины"))) {
                throw new NullBookException();
            }
        }
        catch (NullAuthorException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (NullBookException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
    }
}