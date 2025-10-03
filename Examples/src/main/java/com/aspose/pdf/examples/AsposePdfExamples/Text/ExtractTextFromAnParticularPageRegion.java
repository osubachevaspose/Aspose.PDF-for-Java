package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.examples.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExtractTextFromAnParticularPageRegion {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/ExtractTextFromAnParticularPageRegion/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example extractTextFromAnParticularPageRegion start");
        extractTextFromAnParticularPageRegion(dataDir, outputDir);
        System.out.println("Example extractTextFromAnParticularPageRegion end");
    }

    public static void extractTextFromAnParticularPageRegion(String dataDir, String outputDir) {
        // open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // create TextAbsorber object to extract text
            TextAbsorber absorber = new TextAbsorber();
            absorber.getTextSearchOptions().setLimitToPageBounds(true);
            absorber.getTextSearchOptions().setRectangle(new Rectangle(100, 200, 300, 700));
            // accept the absorber for first page
            doc.getPages().get_Item(1).accept(absorber);
            // get the extracted text
            String extractedText = absorber.getText();
            // create a writer and open the file
            FileWriter writer = new FileWriter(new File(outputDir + "ExtractedText.txt"));
            // write extracted contents
            writer.write(extractedText);
            // Close writer
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
