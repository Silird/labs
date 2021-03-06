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
    protected JPanel filterPanel, clientPanel, carPanel, datePanel, checkPanel;
    protected JCheckBox clientcheck, carcheck, datecheck, Checkcheck;
    protected JComboBox comboCheck;
    protected JLabel filterLabel;
    protected JPanel eastPanel;

    /**
     * Инициализация всех элементов и отображение формы на экране
     */
    public void show() {
        //Create
        carsList = new JFrame("Автомастерская");
        carsList.setSize(700, 300);
        carsList.setMinimumSize(new Dimension(700,300));
        carsList.setLocationRelativeTo(null);
        carsList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createBut = new JButton(new ImageIcon(getClass().getResource("/pictures/create.png")));
        createBut.setToolTipText("Создать новый список клиентов");

        openBut = new JButton(new ImageIcon(getClass().getResource("/pictures/open.png")));
        openBut.setToolTipText("Открыть список клиентов");

        saveBut = new JButton(new ImageIcon(getClass().getResource("/pictures/save.png")));
        saveBut.setToolTipText("Сохранить список клиентов");

        printBut = new JButton(new ImageIcon(getClass().getResource("/pictures/print.png")));
        printBut.setToolTipText("Распечатать список клиентов");

        exitBut = new JButton(new ImageIcon(getClass().getResource("/pictures/exit.png")));
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

        model.setValueAt("jdkjgkrj",1,1);
        client = new MyComboBox(model);
        clientcheck = new JCheckBox();
        clientPanel = new JPanel();
        clientPanel.setLayout(new BoxLayout(clientPanel, BoxLayout.X_AXIS));
        clientPanel.add(clientcheck);
        clientPanel.add(client);

        carName = new JTextField("Марка машины");
        carName.setColumns(12);
        carcheck = new JCheckBox();
        carPanel = new JPanel();
        carPanel.setLayout(new BoxLayout(carPanel, BoxLayout.X_AXIS));
        carPanel.add(carcheck);
        carPanel.add(carName);

        dateTake = new JTextField("Дата");
        dateTake.setColumns(12);
        datecheck = new JCheckBox();
        datePanel = new JPanel();
        datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.X_AXIS));
        datePanel.add(datecheck);
        datePanel.add(dateTake);

        comboCheck = new JComboBox(new String[] {"Готовность", "Готово", "Не готово"});
        Checkcheck = new JCheckBox();
        checkPanel = new JPanel();
        checkPanel.setLayout(new BoxLayout(checkPanel, BoxLayout.X_AXIS));
        checkPanel.add(Checkcheck);
        checkPanel.add(comboCheck);

        filterLabel = new JLabel("Поиск");
        //bookName.sets
        filterBut = new JButton(new ImageIcon(getClass().getResource("/pictures/filter.png")));
        filterPanel = new JPanel();
        filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
        filterPanel.add(filterLabel);
        filterPanel.add(clientPanel);
        filterPanel.add(carPanel);
        filterPanel.add(datePanel);
        filterPanel.add(checkPanel);
        filterPanel.add(new JLabel(" "));
        filterPanel.add(filterBut);
        eastPanel = new JPanel();
        eastPanel.add(filterPanel, BorderLayout.NORTH);
        carsList.add(eastPanel, BorderLayout.EAST);
        carsList.setVisible(true);
    }
}

