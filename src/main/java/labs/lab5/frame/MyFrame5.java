package labs.lab5.frame;

import labs.lab4.frame.MyFrame4;
import labs.lab5.Listeners.*;
import javax.swing.*;
import java.awt.*;

/**
 * Конструктор формы для 5 лабы
 */

public class MyFrame5 extends MyFrame4 {
    protected FileDialog save, load;
    protected JTextField clientName, carName, date;
    protected JLabel addLabel;
    protected JCheckBox checkcar;
    protected JButton addBut, removeBut, editBut, checkEditBut, undoBut;
    protected JPanel addPanel, southPanel, addLabelPanel;

    /**
     * Инициализация компоненотов формы и отображение
     */
    public void show() {
        super.show();

        save = new FileDialog(carsList, "Сохранение таблицы", FileDialog.SAVE);
        save.setFile("*.txt");
        save.setDirectory("D:\\Work\\Java\\Универ\\labs\\Сохранённые таблицы");

        load = new FileDialog(carsList, "Загрузка таблицы", FileDialog.LOAD);
        load.setFile("*.txt");
        load.setDirectory("D:\\Work\\Java\\Универ\\labs\\Сохранённые таблицы");

        saveBut.addActionListener(new ActionSaveListener5(carsList, save, model));
        openBut.addActionListener(new ActionLoadListener5(carsList, load, model, client));
        createBut.addActionListener(new ActionCreateListener5(model, client));

        addPanel = new JPanel();
        addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.X_AXIS));
        addLabel = new JLabel("Работа с таблицей");

        addLabelPanel = new JPanel();
        addLabelPanel.add(addLabel);

        southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.add(addLabelPanel);

        clientName = new JTextField("Клиент");
        clientName.addFocusListener(new FocusAddclientNameListener5(clientName));

        carName = new JTextField("Марка машины");
        carName.addFocusListener(new FocusAddcarNameListener5(carName));

        date = new JTextField("Дата");
        date.addFocusListener(new FocusAddDateListener5(date));
        dateTake.addFocusListener(new FocusAddDateListener5(dateTake));


        checkcar = new JCheckBox("Готовность");

        addBut = new JButton(new ImageIcon(getClass().getResource("/pictures/add.png")));
        addBut.setToolTipText("Добавить элемент в таблицу");
        addBut.addMouseListener(new MouseAddListener5(addBut));
        addBut.addActionListener(new ActionAddListener5(carsList, model, clientName, carName, date, checkcar, client));

        removeBut = new JButton(new ImageIcon(getClass().getResource("/pictures/remove.png")));
        removeBut.setToolTipText("Удалить выбранные строки из таблицы");
        removeBut.addActionListener(new ActionRemoveListener5(carsList, model, cars, client));
        removeBut.addMouseListener(new MouseRemoveListener5(removeBut));

        editBut = new JButton(new ImageIcon(getClass().getResource("/pictures/edit.png")));
        editBut.setToolTipText("Редактировать выбранную строку таблицы");
        editBut.addMouseListener(new MouseEditListener5(editBut));

        checkEditBut = new JButton(new ImageIcon(getClass().getResource("/pictures/add.png")));
        checkEditBut.setToolTipText("Принять редактирование");
        checkEditBut.setVisible(false);
        checkEditBut.addMouseListener(new MouseAddListener5(checkEditBut));

        undoBut = new JButton(new ImageIcon(getClass().getResource("/pictures/undo.png"))); //  (\/)
        undoBut.setToolTipText("Отменить редактирование");                                  //  ( ..)
        undoBut.setVisible(false);                                                          // c(")(")
        undoBut.addMouseListener(new MouseUndoListener5(undoBut));

        editBut.addActionListener(new ActionEditListener5(carsList, model, cars, addBut, checkEditBut,
                editBut, undoBut, removeBut, clientName, carName, date, checkcar));
        undoBut.addActionListener(new ActionUndoListener5(carsList, model, cars, addBut, checkEditBut,
                editBut, undoBut, removeBut, clientName, carName, date, checkcar));
        checkEditBut.addActionListener(new ActionAcceptListener5(carsList, model, cars, addBut, checkEditBut,
                editBut, undoBut, removeBut, clientName, carName, date, checkcar, client));

        addPanel.add(clientName);
        addPanel.add(carName);
        addPanel.add(date);
        addPanel.add(checkcar);
        addPanel.add(addBut);
        addPanel.add(checkEditBut);
        addPanel.add(editBut);
        addPanel.add(undoBut);
        addPanel.add(removeBut);

        southPanel.add(addPanel);
        carsList.add(southPanel, BorderLayout.SOUTH);
        carsList.setVisible(true);
    }
}
