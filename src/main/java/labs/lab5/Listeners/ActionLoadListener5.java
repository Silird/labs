package labs.lab5.Listeners;

import labs.lab2.frame.MyComboBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Обработка события нажатия на кнопку загрузки
 */
public class ActionLoadListener5 implements ActionListener {
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
    public ActionLoadListener5(JFrame cList, FileDialog l, DefaultTableModel m, MyComboBox c) {
        carsList = cList;
        load = l;
        model = m;
        cCombo = c;
    }

    /**
     * Исключительная ситуация, когда файл не выбран
     */
    private class NullFileException extends Exception {
        public NullFileException() {
            super("Ошибка выбора файла");
        }
    }

    /**
     * Чтение таблицы из файла
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        load.setVisible(true);
        int i, rows;
        String str, tmp[];
        String fileName = load.getDirectory() + load.getFile();
        try {
            if (load.getFile() == null) {
                throw new NullFileException();
            }
            BufferedReader reader = new BufferedReader(new FileReader((fileName)));
            rows = model.getRowCount();
            for (i = 0; i < rows; i++) {
                model.removeRow(0);
            }
            do {
                str = reader.readLine();
                if (str != null) {
                    tmp = str.split("@");
                    model.addRow(new String[] {tmp[0], tmp[1], tmp[2], tmp[3]});
                }
            } while (str != null);
            reader.close();
            cCombo.refresh(model);
        }
        catch (NullFileException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
    }
}
