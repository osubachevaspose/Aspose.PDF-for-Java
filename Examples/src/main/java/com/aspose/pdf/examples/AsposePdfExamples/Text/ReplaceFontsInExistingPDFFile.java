package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.TextEditOptions;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;
import com.aspose.pdf.examples.Utils;

import java.util.Iterator;

public class ReplaceFontsInExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/ReplaceFontsInExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example replaceFontsInExistingPDFFile start");
        replaceFontsInExistingPDFFile(dataDir, outputDir);
        System.out.println("Example replaceFontsInExistingPDFFile end");
    }

    public static void replaceFontsInExistingPDFFile(String dataDir, String outputDir) {
        // Load existing PDF Document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Search text fragments and set edit option as remove unused fonts
            TextFragmentAbsorber absorber = new TextFragmentAbsorber(
                    new TextEditOptions(TextEditOptions.FontReplace.RemoveUnusedFonts));
            // accept the absorber for all the pages
            doc.getPages().accept(absorber);
            // traverse through all the TextFragments
            TextFragmentCollection textFragmentCollection = absorber.getTextFragments();
            for (Iterator<TextFragment> iter = textFragmentCollection.iterator(); iter.hasNext();) {
                TextFragment textFragment = iter.next();
                String fontName = textFragment.getTextState().getFont().getFontName();
                // if the font name is ArialMT, replace font name with Arial
                if (fontName.equals("ArialMT"))
                    textFragment.getTextState().setFont(FontRepository.findFont("Arial"));
            }
            // Save the updated document
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
