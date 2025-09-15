package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextAbsorber;

public class ExtractTextFromAllThePagesOfPDFDocument {

    public static void main(String[] args) throws Exception {
        // Open document
        Document doc = new Document("input.pdf");
        try {
            // Create TextAbsorber object to extract text
            TextAbsorber textAbsorber = new TextAbsorber();
            // Accept the absorber for all the pages
            doc.getPages().accept(textAbsorber);
            // Get the extracted text
            String extractedText = textAbsorber.getText();
            // Create a writer and open the file
            java.io.FileWriter writer = new java.io.FileWriter(new java.io.File("Extracted_text.txt"));
            writer.write(extractedText);
            // Close the stream
            writer.close();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
