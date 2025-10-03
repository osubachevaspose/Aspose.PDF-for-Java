package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;
import com.aspose.pdf.examples.Utils;

public class ReplaceOnlyFirstOccurrenceOfThePhrase {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/ReplaceOnlyFirstOccurrenceOfThePhrase/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example replaceOnlyFirstOccurrenceOfThePhrase start");
        replaceOnlyFirstOccurrenceOfThePhrase(dataDir, outputDir);
        System.out.println("Example replaceOnlyFirstOccurrenceOfThePhrase end");
    }

    public static void replaceOnlyFirstOccurrenceOfThePhrase(String dataDir, String outputDir) {
        // open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // create TextAbsorber object to find all instances of the input search phrase
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("line");
            // accept the absorber for first page of document
            doc.getPages().get_Item(1).accept(textFragmentAbsorber);
            // get the extracted text fragments into collection
            TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
            // get first occurrence of text and replace
            TextFragment textFragment = textFragmentCollection.get_Item(1);
            // update text and other properties
            textFragment.setText("New Pharase");
            textFragment.getTextState().setFont(FontRepository.findFont("Verdana"));
            textFragment.getTextState().setFontSize(22);
            textFragment.getTextState().setForegroundColor(Color.getBlue());
            textFragment.getTextState().setBackgroundColor(Color.getGray());
            // save updated PDF file
            doc.save(outputDir + "Text_Updated.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
