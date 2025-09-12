package com.aspose.pdf.examples.AsposePdfExamples.Text;

import java.io.IOException;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.TextExtractionOptions;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;

public class ExtractTextBasedOnColumns {

    public static void main(String[] args) throws IOException {
        extractTextBasedOnColumns();
        usingSetScaleFactorMethod();
    }

    public static void extractTextBasedOnColumns() throws IOException {
        String path = "PathToDir";
        // instantiate Document instance with path of input file as argument
        Document doc = new Document(path + "net_New-age NED's.pdf");
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
            doc.save("" + "TempOutput.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
        Document tempDoc = new Document("TempOutput.pdf");
        TextAbsorber textAbsorber = new TextAbsorber();
        tempDoc.getPages().accept(textAbsorber);
        String extractedText = textAbsorber.getText();
        textAbsorber.visit(tempDoc);
        // Create a writer and open the file
        java.io.FileWriter writer = new java.io.FileWriter(new java.io.File("Extracted_text.txt"));
        // Write a line of text to the file
        writer.write(extractedText);
        // Close the stream
        writer.close();
    }

    public static void usingSetScaleFactorMethod() {
        Document doc = new Document("inputFile.pdf");
        try {
            TextAbsorber textAbsorber = new TextAbsorber();
            textAbsorber.setExtractionOptions(new TextExtractionOptions(TextExtractionOptions.TextFormattingMode.Pure));
            // Setting scale factor to 0.5 is enough to split columns in the majority of
            // documents
            // Setting of zero allows to algorithm choose scale factor automatically
            textAbsorber.getExtractionOptions().setScaleFactor((double) 0.5);
            doc.getPages().accept(textAbsorber);
            String extractedText = textAbsorber.getText();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
