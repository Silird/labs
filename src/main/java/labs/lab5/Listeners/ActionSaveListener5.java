package labs.lab5.Listeners;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Обработчик нажатия кнопки сохранить
 */
public class ActionSaveListener5 implements ActionListener {
    protected JFrame carsList;
    protected FileDialog save;
    protected DefaultTableModel model;

    /**
     * Конструктор
     * @param cList
     * @param s
     * @param m
     */
    public ActionSaveListener5(JFrame cList, FileDialog s, DefaultTableModel m) {
        carsList = cList;
        save = s;
        model = m;
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
     * Запись таблицы в файл
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        save.setVisible(true);
        int i, j;
        String fileName = save.getDirectory() + save.getFile();
        try {
            if (save.getFile() == null) {
                throw new NullFileException();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter((fileName)));
            for (i = 0; i < model.getRowCount(); i++) {
                for (j = 0; j < model.getColumnCount(); j++) {
                    writer.write((String) model.getValueAt(i, j));
                    writer.write("@");
                }
                writer.write("\r\n");
            }
            writer.close();
        }
        catch (NullFileException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
    }
}
