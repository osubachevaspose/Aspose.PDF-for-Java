package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.TextExtractionOptions;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;
import com.aspose.pdf.examples.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExtractTextBasedOnColumns {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/ExtractTextBasedOnColumns/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example extractTextBasedOnColumns start");
        extractTextBasedOnColumns(dataDir, outputDir);
        System.out.println("Example extractTextBasedOnColumns end");

        System.out.println("Example usingSetScaleFactorMethod start");
        usingSetScaleFactorMethod(dataDir);
        System.out.println("Example usingSetScaleFactorMethod end");
    }

    public static void extractTextBasedOnColumns(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "net_New-age NED's.pdf");
        try {
            // create TextFragment Absorber instance
            TextFragmentAbsorber tfa = new TextFragmentAbsorber();
            doc.getPages().accept(tfa);
            // create TextFragment Collection instance
            TextFragmentCollection tfc = tfa.getTextFragments();
            for (TextFragment tf : (Iterable<TextFragment>) tfc) {
                // need to reduce font size at least for 70%
                tf.getTextState().setFontSize(tf.getTextState().getFontSize() * 0.7f);
            }
            // temporary save the file
            doc.save(outputDir + "TempOutput.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
        Document tempDoc = new Document(outputDir + "TempOutput.pdf");
        try {
            TextAbsorber textAbsorber = new TextAbsorber();
            tempDoc.getPages().accept(textAbsorber);
            String extractedText = textAbsorber.getText();
            textAbsorber.visit(tempDoc);
            // Create a writer and open the file
            FileWriter writer = new FileWriter(new File("Extracted_text.txt"));
            // Write a line of text to the file
            writer.write(extractedText);
            // Close the stream
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (tempDoc != null)
                tempDoc.close();
        }
    }

    public static void usingSetScaleFactorMethod(String dataDir) {
        Document doc = new Document(dataDir + "inputFile.pdf");
        try {
            TextAbsorber textAbsorber = new TextAbsorber();
            textAbsorber.setExtractionOptions(new TextExtractionOptions(TextExtractionOptions.TextFormattingMode.Pure));
            // Setting scale factor to 0.5 is enough to split columns in the majority of documents
            // Setting to zero allows to choose scale factor automatically
            textAbsorber.getExtractionOptions().setScaleFactor((double) 0.5);
            doc.getPages().accept(textAbsorber);
            String extractedText = textAbsorber.getText();
            System.out.println(extractedText);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
