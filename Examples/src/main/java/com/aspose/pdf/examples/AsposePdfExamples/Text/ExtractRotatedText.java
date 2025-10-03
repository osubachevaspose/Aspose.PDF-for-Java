package com.aspose.pdf.examples.AsposePdfExamples.Text;

import java.util.Iterator;
import com.aspose.pdf.*;
import com.aspose.pdf.examples.Utils;

public class ExtractRotatedText {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/ExtractRotatedText/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example extractRotatedText start");
        extractRotatedText(dataDir);
        System.out.println("Example extractRotatedText end");
    }

    public static void extractRotatedText(String dataDir) {
        Document doc = new Document(dataDir + "PdfWithRotatedText.pdf");
        try {
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("Ｒ");
            // Accept the absorber for 4th page of document
            doc.getPages().get_Item(4).accept(textFragmentAbsorber);
            // Get the extracted text fragments into collection
            TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
            Iterator<TextFragment> iterF = textFragmentCollection.iterator(); // assume textFragmentCollection has 2
                                                                              // results
            while (iterF.hasNext()) {
                TextFragment tf = iterF.next();
                System.out.println("Fragment: " + tf.getText() + " " + tf.getRectangle());
                TextFragmentState state = tf.getTextState();
                System.out.println("Rotation: " + state.getRotation());
                Iterator<TextSegment> iterS = tf.getSegments().iterator(); // assume textFragmentCollection has 2
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
