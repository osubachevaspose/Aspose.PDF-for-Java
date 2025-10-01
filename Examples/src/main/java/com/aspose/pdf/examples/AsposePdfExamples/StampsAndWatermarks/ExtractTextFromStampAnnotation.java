package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.Document;
import com.aspose.pdf.StampAnnotation;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.XForm;
import com.aspose.pdf.examples.Utils;

public class ExtractTextFromStampAnnotation {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/StampsAndWatermarks/ExtractTextFromStampAnnotation/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example extractTextFromStampAnnotation start");
        extractTextFromStampAnnotation(dataDir);
        System.out.println("Example extractTextFromStampAnnotation end");
    }

    public static void extractTextFromStampAnnotation(String dataDir) {
        Document doc = new Document(dataDir + "test.pdf");
        try {
            Annotation item = doc.getPages().get_Item(1).getAnnotations().get_Item(3);
            if (item instanceof StampAnnotation) {
                StampAnnotation annot = (StampAnnotation) item;
                TextAbsorber textAbsorber = new TextAbsorber();
                XForm ap = annot.getNormalAppearance();
                textAbsorber.visit(ap);
                System.out.println(textAbsorber.getText());
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
