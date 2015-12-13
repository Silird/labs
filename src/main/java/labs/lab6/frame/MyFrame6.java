package labs.lab6.frame;

import labs.lab5.frame.MyFrame5;
import labs.lab6.Listeners.ActionLoadListener6;
import labs.lab6.Listeners.ActionSaveListener6;

import java.awt.event.ActionListener;

/**
 * Конструктор формы для 6 лабы
 */
public class MyFrame6 extends MyFrame5 {

    /**
     * Инициализация компоненотов формы и отображение
     */
    @Override
    public void show() {
        super.show();
        save.setFile("*.xml");
        load.setFile("*.xml");
        for (ActionListener l : saveBut.getActionListeners()) {
            saveBut.removeActionListener(l);
        }
        saveBut.addActionListener(new ActionSaveListener6(carsList, save, model));
        for (ActionListener l : openBut.getActionListeners()) {
            openBut.removeActionListener(l);
        }
        openBut.addActionListener(new ActionLoadListener6(carsList, load, model, client));
    }
}