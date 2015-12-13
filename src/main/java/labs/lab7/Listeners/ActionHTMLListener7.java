package labs.lab7.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 * Обработчик нажатия кнопки "Сделать HTML"
 */
public class ActionHTMLListener7 implements ActionListener {
    protected JFrame carsList;
    protected DefaultTableModel model;

    /**
     * Конструктор
     * @param cList
     * @param m
     */
    public ActionHTMLListener7(JFrame cList, DefaultTableModel m) {
        carsList = cList;
        model = m;
    }

    /**
     * Сохранение таблицы в html-файл
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("D:\\Work\\Java\\Универ\\labs\\Сохранённые таблицы\\makeHTML.html"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        pw.println("<TABLE BORDER><TR><TH>Клиент<TH>Марка машины<TH>Дата сдачи<TH>Готовность</TR>");
        for(int i = 0; i < model.getRowCount(); i++) {
            int square = i * i;
            pw.println("<TR><TD>" + (String) model.getValueAt(i,0)
                    + "<TD>" + (String) model.getValueAt(i,1)
                    + "<TD>" + (String) model.getValueAt(i,2)
                    + "<TD>" + (String) model.getValueAt(i,3));
        }
        pw.println("</TABLE>");
        pw.close();

    }
}
