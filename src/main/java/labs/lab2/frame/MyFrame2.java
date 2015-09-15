package labs.lab2.frame;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Конструктор формы для 2 лабы
 */

public class MyFrame2 {
    protected JFrame carsList;
    protected DefaultTableModel model;
    protected JButton createBut, openBut, saveBut, printBut, exitBut;
    protected JToolBar toolBar;
    protected JScrollPane scroll;
    protected MyTable cars;
    protected MyComboBox client;
    protected JTextField carName;
    protected JTextField dateTake;
    protected JButton filterBut;
    protected JPanel filterPanel;
    protected JLabel filterLabel;
    protected JPanel eastPanel;

    /**
     * Инициализация всех элементов и отображение формы на экране
     */
    public void show() {
        //Create
        carsList = new JFrame("Автомастерская");
        carsList.setSize(700, 300);
        carsList.setMinimumSize(new Dimension(700, 260));
        carsList.setLocationRelativeTo(null);
        carsList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createBut = new JButton(new ImageIcon("pictures/create.png"));
        createBut.setToolTipText("Создать новый список клиентов");

        openBut = new JButton(new ImageIcon("pictures/open.png"));
        openBut.setToolTipText("Открыть список клиентов");

        saveBut = new JButton(new ImageIcon("pictures/save.png"));
        saveBut.setToolTipText("Сохранить список клиентов");

        printBut = new JButton(new ImageIcon("pictures/print.png"));
        printBut.setToolTipText("Распечатать список клиентов");

        exitBut = new JButton(new ImageIcon("/pictures/exit.png"));
        exitBut.setToolTipText("Выход");

        toolBar = new JToolBar("Панель инструментов");
        toolBar.add(createBut);
        toolBar.add(openBut);
        toolBar.add(saveBut);
        toolBar.add(printBut);
        toolBar.add(exitBut);
        carsList.add(toolBar, BorderLayout.NORTH);

        String columns[] = {"Клиент", "Марка машины", "Дата сдачи", "Готовность"};
        String data[][] = {{"Салимов Анушервон", "Bugatti Veyron", "20.08.2015", "Готово"},
                {"Быков Андрей", "Москвич 412", "25.08.2015", "Не готово"}};
        model = new DefaultTableModel(data, columns);
        cars = new MyTable(model);
        scroll = new JScrollPane(cars);
        carsList.add(scroll, BorderLayout.CENTER);

        client = new MyComboBox(model);
        carName = new JTextField("Марка машины");
        carName.setColumns(12);
        dateTake = new JTextField("Дата");
        dateTake.setColumns(12);
        filterLabel = new JLabel("Поиск");
        //bookName.sets
        filterBut = new JButton(new ImageIcon("pictures/filter.png"));
        filterPanel = new JPanel();
        filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
        filterPanel.add(filterLabel);
        filterPanel.add(client);
        filterPanel.add(carName);
        filterPanel.add(dateTake);
        filterPanel.add(filterBut);
        eastPanel = new JPanel();
        eastPanel.add(filterPanel, BorderLayout.NORTH);
        carsList.add(eastPanel, BorderLayout.EAST);
        carsList.setVisible(true);
    }
}

