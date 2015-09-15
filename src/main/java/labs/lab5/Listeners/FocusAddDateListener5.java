package labs.lab5.Listeners;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by Александр on 15.09.2015.
 */
public class FocusAddDateListener5 implements FocusListener {
    private JTextField date;

    /**
     * Конструктор
     * @param d
     */
    public FocusAddDateListener5(JTextField d) {
        date = d;
    }

    /**
     * Если при попадании в фокус введена стандартная строка, то стереть её
     * @param e
     */
    @Override
    public void focusGained(FocusEvent e) {
        if (date.getText().equals(new String("Дата"))) {
            date.setText("");
        }
    }

    /**
     * Если при исчезновении фокуса введена пустая строка, то ввести стандартную
     * @param e
     */
    @Override
    public void focusLost(FocusEvent e) {
        if (date.getText().equals("")) {
            date.setText("Дата");
        }
    }
}
