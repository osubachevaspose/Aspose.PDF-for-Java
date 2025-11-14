package com.aspose.pdf.examples.AsposePdfExamples.Operators;

import com.aspose.pdf.Document;
import com.aspose.pdf.Operator;
import com.aspose.pdf.OperatorCollection;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.operators.*;

public class RemoveGraphicsObjects {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Operators/RemoveGraphicsObjects/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example removeGraphicsObjects start");
        removeGraphicsObjects(dataDir, outputDir);
        System.out.println("Example removeGraphicsObjects end");
    }

    public static void removeGraphicsObjects(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "RemoveGraphicsObjects.pdf");
        try {
            Page page2 = doc.getPages().get_Item(2);
            OperatorCollection page2Contents = page2.getContents();
            Operator[] operators = new Operator[] {
                    new Stroke(),
                    new ClosePathStroke(),
                    new Fill()
            };
            page2Contents.delete(operators);
            doc.save(outputDir + "No_Graphics_out.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
