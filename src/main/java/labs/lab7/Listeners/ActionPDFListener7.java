package labs.lab7.Listeners;

/*
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
*/
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import com.itextpdf.text.Document;
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
import java.util.HashMap;

/**
 * Created by Александр on 26.10.2015.
 */
public class ActionPDFListener7 implements ActionListener {
    protected JFrame carsList;
    protected DefaultTableModel model;

    public ActionPDFListener7(JFrame cList, DefaultTableModel m) {
        carsList = cList;
        model = m;
    }

    public void actionPerformed(ActionEvent e) {
        /*
        try {

            JRDataSource ds = new JRXmlDataSource("D:\\Work\\Java\\Универ\\labs\\Сохранённые таблицы\\template.xml", "XPath");
            JasperReport jasperReport = JasperCompileManager.compileReport("/report2.jrxml");
            JasperPrint print = JasperFillManager.fillReport(jasperReport, new HashMap(), ds);
            JRExporter exporter = null;
            exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "D:\\Work\\Java\\Универ\\labs\\Сохранённые таблицы\\makepdf.pdf");
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.exportReport();
        }
        catch (JRException e1) {
            e1.printStackTrace();
        }
        */
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
