package labs.lab7.frame;

import labs.lab6.frame.MyFrame6;
import labs.lab7.Listeners.ActionHTMLListener7;
import labs.lab7.Listeners.ActionPDFListener7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Конструктор формы для 7 лабы
 */
public class MyFrame7 extends MyFrame6 {
    protected JButton makePDF, makeHTML;
    /**
     * Инициализация компоненотов формы и отображение
     */
    @Override
    public void show() {
        super.show();

        makePDF = new JButton("Make PDF");
        makePDF.addActionListener(new ActionPDFListener7(carsList, model));
        toolBar.add(makePDF);

        makeHTML = new JButton("Make HTML");
        makeHTML.addActionListener(new ActionHTMLListener7(carsList, model));
        //makeHTML.addActionListener();
        toolBar.add(makeHTML);

        carsList.setVisible(true);
    }
}
