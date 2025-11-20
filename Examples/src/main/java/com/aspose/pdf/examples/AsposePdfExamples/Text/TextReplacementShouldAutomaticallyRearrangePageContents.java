package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class TextReplacementShouldAutomaticallyRearrangePageContents {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/TextReplacementShouldAutomaticallyRearrangePageContents/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example textReplacementShouldAutomaticallyRearrangePageContents start");
        textReplacementShouldAutomaticallyRearrangePageContents(dataDir, outputDir);
        System.out.println("Example textReplacementShouldAutomaticallyRearrangePageContents end");
    }

    public static void textReplacementShouldAutomaticallyRearrangePageContents(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Create TextFragment Absorber object with regular expression
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("This is");
            doc.getPages().accept(textFragmentAbsorber);
            // Replace each TextFragment
            for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentAbsorber.getTextFragments()) {
                // Set font of text fragment being replaced
                textFragment.getTextState().setFont(FontRepository.findFont("Arial"));
                // Set font size
                textFragment.getTextState().setFontSize(12);
                textFragment.getTextState().setForegroundColor(Color.getNavy());
                // Replace the text with larger string than placeholder
                textFragment.setText("This is a much larger string than the placeholder to test this issue");
            }
            // Save resultant PDF
            doc.save(outputDir + "29860_out_large_NoHyphenation_1020.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
