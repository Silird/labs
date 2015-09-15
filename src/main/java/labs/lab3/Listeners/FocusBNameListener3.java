package labs.lab3.Listeners;

import javax.swing.*;
import java.awt.event.*;

/**
 * Обработчик события фокуса поля для ввода  названия книги
 */
public class FocusBNameListener3 implements FocusListener {
    private JTextField carName;

    /**
     * Конструктор
     * @param cName
     */
    public FocusBNameListener3(JTextField cName) {
        carName = cName;
    }

    /**
     * Если стоит стандартная фраза, то при попадании в фокус стереть её
     * @param e
     */
    public void focusGained(FocusEvent e) {
        if (carName.getText().equals("Марка машины")) {
            carName.setText("");
        }
    }

    /**
     * Если стоит пустая строка, то при исчезновении фокуса написать стандартную фразу
     * @param e
     */
    public void focusLost(FocusEvent e) {
        if (carName.getText().equals("")) {
            carName.setText("Марка машины");
        }
    }
}
