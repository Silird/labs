package labs.lab5.Listeners;

import labs.lab2.frame.MyComboBox;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Обработка события нажатия на кнопку создания
 */

public class ActionCreateListener5 implements ActionListener {
    protected DefaultTableModel model;
    protected MyComboBox сCombo;

    /**
     * Конструктор
     * @param m
     * @param с
     */
    public ActionCreateListener5(DefaultTableModel m, MyComboBox с) {
        model = m;
        сCombo = с;
    }

    /**
     * Очистка таблицы
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        int i, rows;
        rows = model.getRowCount();
        for (i = 0; i < rows; i++) {
            model.removeRow(0);
        }
        сCombo.refresh(model);
    }
}
