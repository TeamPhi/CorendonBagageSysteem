package backend;

import java.io.File;
import java.io.IOException;
import javafx.collections.ObservableList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
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
    //directory where found foundLuggageData is saved.
    private static final File FOUND_DIR = new File(DIRECTORY + File.separator + "Found");
    //directory where lost foundLuggageData is saved.
    private static final File LOST_DIR = new File(DIRECTORY + File.separator + "Lost");

    /**
     * Generate .pdf files for all foundLuggageData items in the given list.
     *
     * @param <X> this parameter exists to make sure both lost and found
     * foundLuggageData can be exported.
     * @param luggage the list of foundLuggageData items to be exported.
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
            contentStream.newLineAtOffset(100, 700);

            //generate the text in the .pdf file
            contentStream.showText("Luggage item: #" + luggage.get(i).getLuggageID()
                    + " has been succesfully registered with the following data:");
            contentStream.newLine();
            contentStream.newLine();
            contentStream.showText("labelNumber: ");
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText(luggage.get(i).getLabelNumber());
            contentStream.newLineAtOffset(-100, -14.5f);

            contentStream.showText("flightNumber: ");
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText(luggage.get(i).getFlightNumber());
            contentStream.newLineAtOffset(-100, -14.5f);

            contentStream.showText("airport: ");
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText(luggage.get(i).getAirport());
            contentStream.newLineAtOffset(-100, -14.5f);

            if (luggage.get(i) instanceof FoundLuggage) {
                contentStream.showText("lostFoundID: ");
                contentStream.newLineAtOffset(100, 0);
                contentStream.showText(LuggageListController.foundLuggageData.get(i).getLostFoundID());
                contentStream.newLineAtOffset(-100, -14.5f);
            }
            contentStream.showText("destination: ");
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText(luggage.get(i).getDestination());
            contentStream.newLineAtOffset(-100, -14.5f);

            contentStream.showText("type: ");
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText(luggage.get(i).getType());
            contentStream.newLineAtOffset(-100, -14.5f);

            contentStream.showText("brand: ");
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText(luggage.get(i).getBrand());
            contentStream.newLineAtOffset(-100, -14.5f);

            contentStream.showText("color: ");
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText(luggage.get(i).getColor());
            contentStream.newLineAtOffset(-100, -14.5f);

            contentStream.showText("date: ");
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText(luggage.get(i).getDate());
            contentStream.newLine();

            contentStream.endText();

            contentStream.close();
            if (luggage.get(i) instanceof FoundLuggage) {
                //create the correct directory if it doesn't exist.
                if (!FOUND_DIR.exists()) {
                    FOUND_DIR.mkdir();
                }
                //save the document.
                document.save(FOUND_DIR + File.separator + luggage.get(i).getLuggageID() + ".pdf");
                System.out.println("Found luggage document: " + luggage.get(i).getLuggageID() + ".pdf saved");
                document.close();
            } else if (luggage.get(i) instanceof LostLuggage) {
                //create the correct directory if it doesn't exist.
                if (!LOST_DIR.exists()) {
                    LOST_DIR.mkdir();
                }
                //save the document.
                document.save(LOST_DIR + File.separator + luggage.get(i).getLuggageID() + ".pdf");
                System.out.println("Lost luggage document: " + luggage.get(i).getLuggageID() + ".pdf saved");
                document.close();
            } else {
                //inform the user that the document could not be saved.
                System.out.println("Document not saved, " + luggage.get(i).getLuggageID() + " is not a valid luggage item");
            }
        }
    }
}
