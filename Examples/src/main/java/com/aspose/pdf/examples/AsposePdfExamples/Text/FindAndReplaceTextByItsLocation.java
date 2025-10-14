package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.TextExtractionOptions;
import com.aspose.pdf.TextReplaceOptions;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;

public class FindAndReplaceTextByItsLocation {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/FindAndReplaceTextByItsLocation/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example findAndReplaceTextByItsLocation start");
        findAndReplaceTextByItsLocation(dataDir);
        System.out.println("Example findAndReplaceTextByItsLocation end");
    }

    public static void findAndReplaceTextByItsLocation(String dataDir) {
        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            Rectangle rect = new Rectangle(100, 200, 300, 700);
            // Text replace scenario
            // Create PdfContentEditor object to replace text
            PdfContentEditor contentEditor = new PdfContentEditor(doc);
            try {
                // Limit text search area to the rectangle
                contentEditor.getTextSearchOptions().setRectangle(rect);
                contentEditor.getTextReplaceOptions().setReplaceScope(TextReplaceOptions.Scope.REPLACE_ALL);
                // Replace O with Z
                contentEditor.replaceText("o", 1, "z");
            } finally {
                if (contentEditor != null)
                    contentEditor.close();
            }
            // Extract text scenario
            // Create TextAbsorber object to extract text
            TextAbsorber absorber = new TextAbsorber();
            absorber.getExtractionOptions().setFormattingMode(TextExtractionOptions.TextFormattingMode.Pure);
            // Limit text search area to page bounds
            absorber.getTextSearchOptions().setLimitToPageBounds(true);
            // Limit text search area to the same rectangle
            absorber.getTextSearchOptions().setRectangle(rect);
            // Accept the absorber for first page
            doc.getPages().get_Item(1).accept(absorber);
            // Get the extracted text
            String extractedText = absorber.getText();
            System.out.println(extractedText);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
