package labs.lab8.frame;

import labs.lab7.frame.MyFrame7;
import labs.lab8.Listeners.ActionTreadListener8;

import javax.swing.*;

/**
 * Конструктор формы для 8 лабы
 */
public class MyFrame8 extends MyFrame7 {
    protected JButton RunThreads;

    @Override
    public void show() {
        super.show();

        RunThreads = new JButton("RunThreads");
        RunThreads.addActionListener(new ActionTreadListener8(carsList, load, model, client));
        toolBar.add(RunThreads);

        carsList.setVisible(true);
    }
}
