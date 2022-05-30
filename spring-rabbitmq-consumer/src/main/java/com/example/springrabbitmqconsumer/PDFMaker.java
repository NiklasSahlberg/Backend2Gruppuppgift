package com.example.springrabbitmqconsumer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class PDFMaker {

    private String info;
    private static int counter = 0;

    public PDFMaker(String info) {
        this.info = info;
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try {
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.COURIER, 12);


            contentStream.beginText();
            contentStream.newLineAtOffset(25, 725 );
            contentStream.showText(info);
            contentStream.endText();
            contentStream.close();

            String fileName = "receipt" + counter + ".pdf";

            document.save(fileName);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        counter++;

    }
}
