package com.aspose.pdf.examples.AsposePdfExamples.Text;

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
        Document doc = new Document(dataDir + "TextFragmentTests_Rotated.pdf");
        try {
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber();
            doc.getPages().get_Item(1).accept(textFragmentAbsorber);
            for (TextFragment textFragment : textFragmentAbsorber.getTextFragments()) {
                if (textFragment.getTextState().getRotation() == 0.0)
                    continue;
                System.out.println("Fragment: " + textFragment.getText() + " " + textFragment.getRectangle());
                for (TextSegment textSegment : textFragment.getSegments()) {
                    System.out.println("Segment: " + textSegment.getText() + " " + textSegment.getRectangle());
                    for (CharInfo charInfo : textSegment.getCharacters()) {
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
