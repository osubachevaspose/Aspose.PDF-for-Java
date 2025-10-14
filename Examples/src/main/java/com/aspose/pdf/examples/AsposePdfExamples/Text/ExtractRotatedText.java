package com.aspose.pdf.examples.AsposePdfExamples.Text;

import java.util.Iterator;
import com.aspose.pdf.*;
import com.aspose.pdf.examples.Utils;

public class ExtractRotatedText {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/ExtractRotatedText/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example extractRotatedText start");
        extractRotatedText(dataDir);
        System.out.println("Example extractRotatedText end");
    }

    public static void extractRotatedText(String dataDir) {
        // Document doc = new Document(dataDir + "PdfWithRotatedText.pdf");
        Document doc = new Document(dataDir + "TextFragmentTests_Rotated.pdf");
        try {
            // TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("Ｒ");
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("rotated");
            // // Accept the absorber for 4th page of document
            // doc.getPages().get_Item(4).accept(textFragmentAbsorber);
            doc.getPages().get_Item(1).accept(textFragmentAbsorber);
            // Get the extracted text fragments into collection
            TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
            Iterator<TextFragment> iterF = textFragmentCollection.iterator(); // assume textFragmentCollection has 2
                                                                              // results
            while (iterF.hasNext()) {
                TextFragment textFragment = iterF.next();
                System.out.println("Fragment: " + textFragment.getText() + " " + textFragment.getRectangle());
                TextFragmentState state = textFragment.getTextState();
                System.out.println("Rotation: " + state.getRotation());
                Iterator<TextSegment> iterS = textFragment.getSegments().iterator(); // assume textFragmentCollection has 2
                                                                           // results
                while (iterS.hasNext()) {
                    TextSegment textSegment = iterS.next();
                    System.out.println("Segment: " + textSegment.getText() + " " + textSegment.getRectangle());
                    Iterator<CharInfo> iterC = textSegment.getCharacters().iterator();
                    while (iterC.hasNext()) {
                        CharInfo charInfo = iterC.next();
                        System.out.println(charInfo.getPosition());
                    }
                }
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
