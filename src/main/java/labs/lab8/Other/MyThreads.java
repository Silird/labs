package labs.lab8.Other;


import labs.lab2.frame.MyComboBox;
import labs.lab6.Listeners.ActionLoadListener6;
import labs.lab7.Listeners.ActionHTMLListener7;
import labs.lab7.Listeners.ActionPDFListener7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Класс обработки 3 потоков
 */
public class MyThreads extends Thread {
    private int type;
    private Object mutex;
    protected JFrame carsList;
    protected FileDialog load;
    protected DefaultTableModel model;
    protected MyComboBox cCombo;

    /**
     * Конструктор
     * @param i
     * @param cList
     * @param l
     * @param m
     * @param c
     * @param mut
     */
    public MyThreads(int i, JFrame cList, FileDialog l, DefaultTableModel m, MyComboBox c, Object mut) {
        type=i;
        mutex = mut;
        carsList = cList;
        load = l;
        model = m;
        cCombo = c;
    }

    /**
     * Обработка потока по его типу
     */
    public void run() {

        if (type == 1) {
            synchronized (mutex) {
                try {
                    mutex.wait();
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                try {
                    new ActionLoadListener6(carsList, load, model, cCombo).LoadXML(
                            "D:\\Work\\Java\\Универ\\labs\\Сохранённые таблицы\\таблица3.xml");
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                mutex.notify();
            }
        }

        if (type == 2) {
            synchronized (mutex) {
                mutex.notifyAll();
                try {
                    mutex.wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                model.addRow(new String[]{"Изменение таблицы", "для теста потоков", "10.12.2015", "Готово"});
                new ActionPDFListener7(model).savePDF();
            }
        }

        if (type==3) {
            synchronized (mutex) {
                mutex.notifyAll();
                try {
                    mutex.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                new ActionHTMLListener7(model).saveHTML();
            }
        }
    }
}
