package ru.isa.catalogiser;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class PDFmaker {
    private Document document;
    private PdfWriter pdfwrt;
    private Font cellFont;
    //javaxt.io.Image image;
    public PDFmaker() {
        //document = new Document(PageSize.A4, 50, 50, 50, 50);
        document = new Document(PageSize.A4, 20, 20, 20, 20);
        try {
            pdfwrt = PdfWriter.getInstance(document, new FileOutputStream(System.getenv("USERPROFILE") + "\\Desktop\\temp.pdf"));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage imgwrkr(String path){
        javaxt.io.Image image = new javaxt.io.Image(path);
        //Установка значения высоты изображения. Ширина автоматически скалируется.
        image.setHeight(200);
        image.setOutputQuality(1);
        return image.getBufferedImage();
    }
    public void makePdf(){

        setCellFont();
        try {
            //pdfwrt.setCompressionLevel(50);
            PdfPCell cell = new PdfPCell();
            document.open();
            Paragraph pdfTitle = new Paragraph("Catalogue \"В наличии\"", titleFont());
            pdfTitle.setSpacingBefore(25);
            document.add(pdfTitle);
            //document.add(Image.getInstance(imgwrkr("C:\\Users\\sigdi\\Desktop\\ideatstPhotos\\11\\2 - 222\\IMG_20180202_091829_BURST1.jpg"), null));
            PdfPTable t = new PdfPTable(6);
            t.setSpacingBefore(25);
            t.setSpacingAfter(25);
            t.setWidthPercentage(100);
            t.addCell(new PdfPCell(new Phrase("Изделие",  cellFont)));
            t.addCell(new PdfPCell(new Phrase("Р",  cellFont)));
            t.addCell(new PdfPCell(new Phrase("Артикул",  cellFont)));
            t.addCell(new PdfPCell(new Phrase("Вставка",  cellFont)));
            t.addCell(new PdfPCell(new Phrase("Цена",  cellFont)));
            t.addCell(new PdfPCell(new Phrase("цена за грамм",  cellFont)));


            Image img = Image.getInstance(imgwrkr("C:\\Users\\sigdi\\Desktop\\ideatstPhotos\\11\\2 - 222\\IMG_20180202_091829_BURST1.jpg"), null);
            System.out.println("img.getPlainHeight() = " + img.getPlainHeight());
            System.out.println("img.getPlainWidth() = " + img.getPlainWidth());
            System.out.println("img.getWidthPercentage() = " + img.getWidthPercentage());


            //img.scalePercent(50);
            cell.addElement(Image.getInstance(imgwrkr("C:\\Users\\sigdi\\Desktop\\ideatstPhotos\\11\\2 - 222\\IMG_20180202_091829_BURST1.jpg"), null));
            img = Image.getInstance(imgwrkr("C:\\Users\\sigdi\\Desktop\\ideatstPhotos\\11\\2 - 222\\IMG_20180202_091926.jpg"), null);

            cell.addElement(Image.getInstance(imgwrkr("C:\\Users\\sigdi\\Desktop\\ideatstPhotos\\11\\2 - 222\\IMG_20180202_091926.jpg"), null));
            t.addCell(cell);
            //t.addCell(img);
            t.addCell("2.1");
            t.addCell("2.2");
            t.addCell("2.3");

            t.addCell("3.1");
            t.addCell("3.2");



            img.scalePercent(50);
            t.addCell(Image.getInstance(imgwrkr("C:\\Users\\sigdi\\Desktop\\ideatstPhotos\\11\\2 - 222\\IMG_20180202_091926.jpg"), null));

            t.addCell("3.3");

            t.addCell("J_J");
            t.completeRow();
            document.add(t);


            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Font titleFont(){
        Font font = new Font(baseFont());
        font.setSize(16);
        font.setColor(216,29,220);
        return font;
    }

    public void setCellFont() {
        cellFont = new Font(baseFont());
        cellFont.setSize(16);
        cellFont.setColor(216,29,220);
    }

    public BaseFont baseFont(){
        BaseFont bf = null;
        try {
            bf = BaseFont.createFont(System.getenv("windir") + "\\Fonts\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bf;
    }
    public static void staticmakePdf(){
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        final Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD, new CMYKColor(0, 255, 0, 0));
        BaseFont bf = null;
        try {
            bf = BaseFont.createFont(System.getenv("windir") + "\\Fonts\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font font = new Font(bf);
        font.setSize(14);
        font.setColor(216,29,220);
        System.out.println(font.getFamilyname());
        PdfWriter pdfwrt;

        try {
            pdfwrt = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\sigdi\\Desktop\\temp.pdf"));
            document.open();
            Paragraph pdfTitle = new Paragraph("Catalogue \"В наличии\"", font);
            document.add(pdfTitle);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




    }

}
