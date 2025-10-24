package com.aspose.pdf.examples.AsposePdfExamples.Operators;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.Utils;

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
            Page page = doc.getPages().get_Item(2);
            doc.save(outputDir + "No_Graphics_out.pdf");
        // } catch (IOException e) {
        //     e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
