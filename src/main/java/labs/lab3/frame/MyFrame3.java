package labs.lab3.frame;

import labs.lab2.frame.MyFrame2;
import labs.lab3.Listeners.*;

/**
 * Конструктор формы для 3 лабы
 */

public class MyFrame3 extends MyFrame2 {

    /**
     * Инициализация компоненотов формы и отображение
     */
    public void show() {
        super.show();
        filterBut.addActionListener(new ActionFilterListener3(carsList));// (\(\
        saveBut.addMouseListener(new MouseSaveListener3(saveBut));       // (>'•')
        openBut.addMouseListener(new MouseOpenListener3(openBut));       // (~(")(")
        printBut.addMouseListener(new MousePrintListener3(printBut));
        filterBut.addMouseListener(new MouseFilterListener3(filterBut));
        exitBut.addMouseListener(new MouseExitListener3(exitBut));
        createBut.addMouseListener(new MouseCreateListener3(createBut));
        exitBut.addActionListener(new ActionExitListener3());
        carName.addFocusListener(new FocusBNameListener3(carName));
    }
}
