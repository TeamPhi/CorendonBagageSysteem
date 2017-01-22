package backend;

import java.io.File;
import java.io.IOException;
import javafx.collections.ObservableList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import ui.LuggageListController;

/**
 *
 * @author Oscar
 */
public class PDFExport {

    //set the directory where the .pdf files should be created.
    private static final File DIRECTORY = new File("C:" + File.separator + "Users" + File.separator
            + System.getProperty("user.name") + File.separator + "Documents"
            + File.separator + "CorendonBagageSysteem");
    //directory where found luggage is saved.
    private static final File FOUND_DIR = new File(DIRECTORY + File.separator + "Found");
    //directory where lost luggage is saved.
    private static final File LOST_DIR = new File(DIRECTORY + File.separator + "Lost");

    /**
     * Generate .pdf files for all luggage items in the given list.
     *
     * @param <X> this parameter exists to make sure both lost and found luggage
     * can be exported.
     * @param luggage the list of luggage items to be exported.
     * @throws IOException
     */
    public static <X extends Luggage> void generateLuggagePDF(ObservableList<X> luggage) throws IOException {
        for (int i = 0; i < luggage.size(); i++) {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            /*create the folder "CorendonBagageSysteem" in the user's docements folder
            to store the .pdf files in, if it doesn't already exist. */
            if (!DIRECTORY.exists()) {
                DIRECTORY.mkdirs();
                System.out.println("Directory: \"" + DIRECTORY.getPath() + "\" created");
            }
            document.addPage(page);
            System.out.println("Document created");

            PDFont font = PDType1Font.HELVETICA_BOLD;

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.setLeading(14.5f);
            contentStream.moveTextPositionByAmount(100, 700);

            //generate the text in the .pdf file
            contentStream.drawString("Luggage item: #" + luggage.get(i).getLabelNumber()
                    + " has been succesfully registered with the following data:");
            contentStream.newLine();
            contentStream.newLine();
            contentStream.drawString("labelNumber: " + luggage.get(i).getLabelNumber());
            contentStream.newLine();
            contentStream.drawString("flightNumber: " + luggage.get(i).getFlightNumber());
            contentStream.newLine();
            contentStream.drawString("airport: " + luggage.get(i).getAirport());
            contentStream.newLine();
            if (luggage.get(i) instanceof FoundLuggage) {
                contentStream.drawString("lostFoundID: " + LuggageListController.luggage.get(i).getLostFoundID());
                contentStream.newLine();
            }
            contentStream.drawString("destination: " + luggage.get(i).getDestination());
            contentStream.newLine();
            contentStream.drawString("type: " + luggage.get(i).getType());
            contentStream.newLine();
            contentStream.drawString("brand: " + luggage.get(i).getBrand());
            contentStream.newLine();
            contentStream.drawString("color: " + luggage.get(i).getColor());
            contentStream.newLine();
            contentStream.drawString("date: " + luggage.get(i).getDate());
            contentStream.newLine();

            contentStream.endText();

            contentStream.close();
            //create the correct directory if it doesn't exist.
            if (luggage.get(i) instanceof FoundLuggage) {
                if (!FOUND_DIR.exists()) {
                    FOUND_DIR.mkdir();
                }
                document.save(FOUND_DIR + File.separator + luggage.get(i).getLabelNumber() + ".pdf");
                System.out.println("Found luggage document saved");
                document.close();
            } else if (luggage.get(i) instanceof LostLuggage) {
                if (!LOST_DIR.exists()) {
                    LOST_DIR.mkdir();
                }
                document.save(LOST_DIR + File.separator + luggage.get(i).getLabelNumber() + ".pdf");
                System.out.println("Lost luggage document saved");
                document.close();
            } else {
                System.out.println("Document not saved, " + luggage.get(i).getLabelNumber() + " is not a valid luggage item");
            }
        }
    }
}
