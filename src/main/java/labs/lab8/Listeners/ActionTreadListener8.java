package labs.lab8.Listeners;

import labs.lab2.frame.MyComboBox;
import labs.lab8.Other.MyThreads;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Обработчик нажатия кнопки запуска потоков
 */
public class ActionTreadListener8 implements ActionListener {
    protected JFrame carsList;
    protected FileDialog load;
    protected DefaultTableModel model;
    protected MyComboBox cCombo;

    /**
     * Конструктор
     * @param cList
     * @param l
     * @param m
     * @param c
     */
    public ActionTreadListener8(JFrame cList, FileDialog l, DefaultTableModel m, MyComboBox c) {
        carsList = cList;
        load = l;
        model = m;
        cCombo = c;
    }

    /**
     * Запуск 3 потоков
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Object mutex = new Object();
        new MyThreads(2, carsList, load, model, cCombo, mutex).start();
        new MyThreads(3, carsList, load, model, cCombo, mutex).start();
        new MyThreads(1, carsList, load, model, cCombo, mutex).start();
        synchronized (mutex) {
            mutex.notifyAll();
        }
    }
}
