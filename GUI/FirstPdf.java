/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

package de.vogella.itext.write;

import BUS.Models.BusHoaDon;
import BUS.Services.HoaDonService;
import GUI.Models.CartModel;
import GUI.Services.DateService;
import GUI.Services.UtilityService;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.List;

public class FirstPdf {

    private static String FILE = "c:/temp/FirstPdf.pdf";
//    private static Font catFont = FontFactory.getFont("C:/temp/font-times-new-roman/SVN-Times New Roman Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, Font.NORMAL, BaseColor.BLACK);
//    private static Font catFont = new Font(Font.FontFamily.COURIER, 12,
//            Font.NORMAL, BaseColor.RED);
//    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
//            Font.BOLD);
    private static Font font_12_normer, font_20, titleFont, font_12, font_16, font_i;
    static BaseFont bf;
    public static BusHoaDon busHoaDon;
    public static List<CartModel> listCart = new ArrayList<>();

    public static boolean exportFile(BusHoaDon currentHoaDonSelected, List<CartModel> carts) {
        System.out.println("sizze cart" + carts.size());
        FirstPdf.busHoaDon = currentHoaDonSelected;
        FirstPdf.listCart = carts;
        try {
            titleFont = new Font(BaseFont.createFont("C:/temp/Tahoma Regular font.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25);
            font_20 = new Font(BaseFont.createFont("C:/temp/Tahoma Regular font.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 20);
            font_16 = new Font(BaseFont.createFont("C:/temp/Tahoma Regular font.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 16);
            font_12 = new Font(BaseFont.createFont("C:/temp/Tahoma Regular font.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 12);
            font_12_normer = new Font(BaseFont.createFont("C:/temp/Tahoma Regular font.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED), 12);
            font_i = new Font(BaseFont.createFont("C:/temp/Tahoma Regular font.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 22);
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document);
            addContent(document);
            document.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    static HoaDonService hoaDonService = new HoaDonService();

    public static void main(String[] args) {
        FirstPdf.busHoaDon = hoaDonService.selectByMahd(3, 1);
//        FirstPdf.listCart = carts;
        try {
            titleFont = new Font(BaseFont.createFont("C:/temp/Tahoma Regular font.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25);
            font_20 = new Font(BaseFont.createFont("C:/temp/Tahoma Regular font.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 20);
            font_16 = new Font(BaseFont.createFont("C:/temp/Tahoma Regular font.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 16);
            font_12 = new Font(BaseFont.createFont("C:/temp/Tahoma Regular font.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 12);
            font_12_normer = new Font(BaseFont.createFont("C:/temp/Tahoma Regular font.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED), 12);
            font_i = new Font(BaseFont.createFont("C:/temp/Tahoma Regular font.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 22);
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document);
            addContent(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private static void addMetaData(Document document) {
        document.addTitle("Cửa hàng điện thoại MobiMonster");
        document.addSubject("Biên nhận thanh toán " + new Date());
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Lars Vogel");
        document.addCreator("Lars Vogel");
    }

    private static void addTitlePage(Document document)
            throws DocumentException {

        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
        preface.add(new Paragraph("\t\t\t            Cửa hàng điện thoại MobiMonster", titleFont));

        addEmptyLine(preface, 1);
        // Will create: Report generated by: _name, _date
        preface.add(new Paragraph(
                "                            Biên nhận thanh toán ", font_20));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
                DateService.toString(new Date(), "                                                                   hh:mm:ss - dd/MM/yyyy"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                font_16));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
                "                                          ===========================================================",
                font_12));

        addEmptyLine(preface, 1);

        preface.add(new Paragraph(
                "Khách hàng: " + busHoaDon.getKhachHangModel().getTenKH(),
                font_12_normer));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
                "Điện thoại: " + busHoaDon.getKhachHangModel().getSDT(),
                font_12_normer));
        addEmptyLine(preface, 1);
        if (busHoaDon.getKhachHangModel().getDiaChi() != null) {
            preface.add(new Paragraph(
                    "Địa chỉ khách hàng: " + busHoaDon.getKhachHangModel().getDiaChi(),
                    font_12_normer));
            addEmptyLine(preface, 1);
        }
        System.out.println(busHoaDon.getDiaChiNhanHang());
        String diaChiNhanHang = busHoaDon.getDiaChiNhanHang() == null ? "Tại cửa hàng" : busHoaDon.getDiaChiNhanHang();
        preface.add(new Paragraph(
                "Địa chỉ nhận hàng: " + diaChiNhanHang,
                font_12_normer));
//        addEmptyLine(preface, 1);
        PdfPTable table = new PdfPTable(5);
//         t.setBorderColor(BaseColor.GRAY);
//         t.setPadding(4);
//         t.setSpacing(4);
//         t.setBorderWidth(1);
        table.setWidthPercentage(100);
        float[] columnWidths = new float[]{6f, 40f, 16f, 6f, 16f};
        table.setWidths(columnWidths);
        PdfPCell c1 = new PdfPCell(new Phrase("STT", font_12));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Tên sản phẩm", font_12));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Đơn giá", font_12));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("SL", font_12));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Thành tiền", font_12));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
        if (listCart.size() > 0) {
            for (CartModel ca : listCart) {
                table.addCell(new Phrase(listCart.indexOf(ca) + 1 + "", font_12_normer));
                table.addCell(new Phrase(ca.getTensp(), font_12_normer));
                table.addCell(new Phrase(UtilityService.toVnd(ca.getGia()), font_12_normer));
                table.addCell(new Phrase(ca.getSoLuong() + "", font_12_normer));
                table.addCell(new Phrase(UtilityService.toVnd(ca.getSoLuong() * ca.getGia()), font_12_normer));
            }
        }
        preface.add(table);
//        preface.add(new Paragraph(
//                "                                           ============================================================================",
//                font_12));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Tổng tiền hàng:                                                                                          " + UtilityService.toVnd(busHoaDon.getTongTien()) , font_12_normer));
        addEmptyLine(preface, 1);
//        preface.add(new Paragraph("Tổng tiền hàng:                                                                                           " + UtilityService.toVnd(busHoaDon.getPhiVanChuyen()) , font_12_normer));
//        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Phí vận chuyển:                                                                                          " + UtilityService.toVnd(busHoaDon.getTongTien()) , font_12_normer));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Tổng phải trả:                                                               " + UtilityService.toVnd(busHoaDon.getTongTien() + busHoaDon.getPhiVanChuyen()) , font_16));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Khách thanh toán:                                                                                      " + UtilityService.toVnd(busHoaDon.getTienKhachTra()) , font_12_normer));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Tiền thừa:                                                                                                 " + UtilityService.toVnd(0), font_12_normer));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
                "                                           ===========================================================",
                font_12));
        preface.add(new Paragraph("                                                            Xin cảm ơn quý khách", font_12_normer));
        preface.add(new Paragraph("                                                                  Hẹn gặp lại !" , font_12_normer));
        document.add(preface);
        // Start a new page
        document.newPage();
    }

    private static void addContent(Document document) throws DocumentException {
//        Anchor anchor = new Anchor("First Chapter", catFont);
//        anchor.setName("First Chapter");

        // Second parameter is the number of the chapter
//        Chapter catPart = new Chapter(new Paragraph(anchor), 1);
//        Paragraph subPara = new Paragraph("Subcategory 1", subFont);
//        Section subCatPart = catPart.addSection(subPara);
//        subCatPart.add(new Paragraph("Hello"));
//        subPara = new Paragraph("Subcategory 2", subFont);
//        subCatPart = catPart.addSection(subPara);
//        subCatPart.add(new Paragraph("Paragraph 1"));
//        subCatPart.add(new Paragraph("Paragraph 2"));
//        subCatPart.add(new Paragraph("Paragraph 3"));
        // add a list
//        createList(subCatPart);
//        Paragraph paragraph = new Paragraph();
//        addEmptyLine(paragraph, 5);
//        subCatPart.add(paragraph);
//         add a table
//        createTable(subCatPart);
        // now add all this to the document
//        document.add(catPart);
        // Next section
//        anchor = new Anchor("Second Chapter", catFont);
//        anchor.setName("Second Chapter");
        // Second parameter is the number of the chapter
//        catPart = new Chapter(new Paragraph(anchor), 1);
//        subPara = new Paragraph("Subcategory", subFont);
//        subCatPart = catPart.addSection(subPara);
//        subCatPart.add(new Paragraph("This is a very important message"));
        // now add all this to the document
//        document.add(catPart);
    }

    private static void createTable(Section subCatPart)
            throws BadElementException {
        PdfPTable table = new PdfPTable(5);

        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);
        PdfPCell c1 = new PdfPCell(new Phrase("STT"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Ten sp"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Gia ban"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("SL"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Thanh tien"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        table.addCell("1.0");
        table.addCell("1.1");
        table.addCell("1.2");
        table.addCell("2.1");
        table.addCell("2.2");
        table.addCell("2.3");

        subCatPart.add(table);

    }

    private static void createList(Section subCatPart) {
//        List list = new List(true, false, 10);
//        list.add(new ListItem("First point"));
//        list.add(new ListItem("Second point"));
//        list.add(new ListItem("Third point"));
//        subCatPart.add(list);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
