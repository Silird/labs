package labs.lab5.Listeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события фокуса поля для ввода названия книги при добавлении в таблицу
 */

public class FocusAddcarNameListener5 implements FocusListener {
    private JTextField carName;

    /**
     * Конструктор
     * @param c
     */
    public FocusAddcarNameListener5(JTextField c) {
        carName = c;
    }

    /**
     * Если при попадании в фокус введена стандартная строка, то стереть её
     * @param e
     */
    @Override
    public void focusGained(FocusEvent e) {
        if (carName.getText().equals(new String("Марка машины"))) {
            carName.setText("");
        }
    }

    /**
     * Если при исчезновении фокуса введена пустая строка, то ввести стандартную
     * @param e
     */
    @Override
    public void focusLost(FocusEvent e) {
        if (carName.getText().equals("")) {
            carName.setText("Марка машины");
        }
    }
}
