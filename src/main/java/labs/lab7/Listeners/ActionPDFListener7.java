package labs.lab7.Listeners;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Обработчик нажатия кнопки "Сделать PDF"
 */
public class ActionPDFListener7 implements ActionListener {
    protected DefaultTableModel model;

    /**
     * Конструктор
     * @param m
     */
    public ActionPDFListener7(DefaultTableModel m) {
        model = m;
    }

    /**
     * Запись таблицы в pdf-файл
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        savePDF();
    }

    public void savePDF () {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        PdfPTable pdftable = new PdfPTable(4);

        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream("D:\\Work\\Java\\Универ\\labs\\Сохранённые таблицы\\makePDF.pdf"));
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (DocumentException ex) {
            ex.printStackTrace();
        }

        BaseFont bfComic = null;
        try {
            bfComic = BaseFont.createFont("C:/Windows/Fonts/Calibri.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        }
        catch (DocumentException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        Font font = new Font(bfComic, 12);

        pdftable.addCell(new PdfPCell(new Phrase("Клиент", font)));
        pdftable.addCell(new PdfPCell(new Phrase("Марка машины", font)));
        pdftable.addCell(new PdfPCell(new Phrase("Дата сдачи", font)));
        pdftable.addCell(new PdfPCell(new Phrase("Готовность", font)));


        for(int i = 0; i < model.getRowCount(); i++){
            pdftable.addCell(new Phrase((String) model.getValueAt(i, 0), font));
            pdftable.addCell(new Phrase((String) model.getValueAt(i, 1), font));
            pdftable.addCell(new Phrase((String) model.getValueAt(i, 2), font));
            pdftable.addCell(new Phrase((String) model.getValueAt(i, 3), font));
        }

        document.open();

        try {
            document.add(pdftable);
        }
        catch (DocumentException ex) {
            ex.printStackTrace();
        }

        document.close();
    }
}
