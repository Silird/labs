package labs.lab6.Listeners;

import labs.lab5.Listeners.ActionSaveListener5;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Обработчик нажатия кнопки сохранить
 */
public class ActionSaveListener6 extends ActionSaveListener5 {
    /**
     * Конструктор
     *
     * @param cList
     * @param s
     * @param m
     */
    public ActionSaveListener6(JFrame cList, FileDialog s, DefaultTableModel m) {
        super(cList, s, m);
    }

    /**
     * Исключительная ситуация, когда файл не выбран
     */
    private class NullFileException extends Exception {
        public NullFileException() {
            super("Ошибка выбора файла");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i;
        save.setVisible(true);
        String fileName = save.getDirectory() + save.getFile();
        try {
            if (save.getFile() == null) {
                throw new NullFileException();
            }
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.newDocument();
            Node carslist = doc.createElement("carslist");
            doc.appendChild(carslist);
            for (i = 0; i < model.getRowCount(); i++) {
                Element car = doc.createElement("car");
                carslist.appendChild(car);
                car.setAttribute("client", (String) model.getValueAt(i, 0));
                car.setAttribute("carname", (String) model.getValueAt(i, 1));
                car.setAttribute("date", (String) model.getValueAt(i, 2));
                car.setAttribute("ready", (String) model.getValueAt(i, 3));
            }
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            FileWriter fw = new FileWriter(fileName);
            trans.transform(new DOMSource(doc), new StreamResult(fw));
        }
        catch (TransformerConfigurationException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (TransformerException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
        catch (NullFileException ex) {
            JOptionPane.showMessageDialog(carsList, ex.getMessage());
        }
    }
}
