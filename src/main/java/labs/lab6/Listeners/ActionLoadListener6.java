package labs.lab6.Listeners;

import labs.lab2.frame.MyComboBox;
import labs.lab5.Listeners.ActionLoadListener5;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

/**
 * Обработка события нажатия на кнопку загрузки
 */
public class ActionLoadListener6 extends ActionLoadListener5 {

    public static final Logger logger = Logger.getLogger(ActionLoadListener6.class);

    /**
     * Конструктор
     *
     * @param cList
     * @param l
     * @param m
     * @param c
     */
    public ActionLoadListener6(JFrame cList, FileDialog l, DefaultTableModel m, MyComboBox c) {
        super(cList, l, m, c);
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
        String fileName = load.getDirectory() + load.getFile();
        LoadXML(fileName);
        load.setFile("*.xml");
    }

    public void LoadXML(String fileName) {
        int i;
        try {
            logger.info("Открытие XML-файла");
            if (load.getFile() == null) {
                throw new NullFileException();
            }
            int rows = model.getRowCount();
            for (i = 0; i < rows; i++) {
                model.removeRow(0);
            }
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(new File(fileName));
            NodeList nlCars = doc.getElementsByTagName("car");
            for (i = 0; i < nlCars.getLength(); i++) {
                Node elem = nlCars.item(i);
                NamedNodeMap attrs = elem.getAttributes();
                String client = attrs.getNamedItem("client").getNodeValue();
                String carName = attrs.getNamedItem("carname").getNodeValue();
                String date = attrs.getNamedItem("date").getNodeValue();
                String ready = attrs.getNamedItem("ready").getNodeValue();
                model.addRow(new String[] {client, carName, date, ready});
            }
            logger.info("XML открыт");
        }
        catch (NullFileException ex) {
            logger.error("File Not Found", ex);
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (SAXException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (Exception ex) {
            logger.error("Ошибка открытия XML");
        }
    }
}
