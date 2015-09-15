package labs.lab4.frame;

import labs.lab3.Listeners.ActionFilterListener3;
import labs.lab3.frame.MyFrame3;
import labs.lab4.Listeners.ActionFilterListener4;

import java.awt.event.ActionListener;

/**
 * Конструктор формы для 4 лабы
 */
public class MyFrame4 extends MyFrame3 {

    /**
     * Инициализация компоненотов формы и отображение
     */
    @Override
    public void show() {
        super.show();
        for (ActionListener l : filterBut.getActionListeners()) {
            filterBut.removeActionListener(l);
        }
        filterBut.addActionListener(new ActionFilterListener4(carsList, carName, client));
    }
}
