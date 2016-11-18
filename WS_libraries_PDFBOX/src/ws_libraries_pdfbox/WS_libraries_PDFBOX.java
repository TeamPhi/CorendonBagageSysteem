/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws_libraries_pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Oscar
 */
public class WS_libraries_PDFBOX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PDDocument document = new PDDocument();
        
        PDPage blankPage = new PDPage();
        document.addPage(blankPage);
        
        PDFont font = PDType1Font.HELVETICA_BOLD;
        
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        
        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.moveTextPositionByAmount(100, 700);
        contentStream.drawString("Hello World");
        contentStream.endText();
        
        document.save("Hello World.pdf");
        document.close();
        
    }
    
}
