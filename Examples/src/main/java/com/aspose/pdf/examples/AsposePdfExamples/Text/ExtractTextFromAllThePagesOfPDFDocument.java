package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.examples.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExtractTextFromAllThePagesOfPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/ExtractTextFromAllThePagesOfPDFDocument/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example extractTextFromAllThePagesOfPDFDocument start");
        extractTextFromAllThePagesOfPDFDocument(dataDir, outputDir);
        System.out.println("Example extractTextFromAllThePagesOfPDFDocument end");
    }

    public static void extractTextFromAllThePagesOfPDFDocument(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Create TextAbsorber object to extract text
            TextAbsorber textAbsorber = new TextAbsorber();
            // Accept the absorber for all the pages
            doc.getPages().accept(textAbsorber);
            // Get the extracted text
            String extractedText = textAbsorber.getText();
            // Create a writer and open the file
            FileWriter writer = new FileWriter(new File(outputDir + "Extracted_text.txt"));
            writer.write(extractedText);
            // Close the stream
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
