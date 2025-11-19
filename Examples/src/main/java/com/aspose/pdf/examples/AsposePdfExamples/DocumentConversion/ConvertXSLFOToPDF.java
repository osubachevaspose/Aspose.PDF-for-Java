package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.XslFoLoadOptions;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class ConvertXSLFOToPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/ConvertXSLFOToPDF/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example convertXSLFOToPDF start");
        convertXSLFOToPDF(dataDir, outputDir);
        System.out.println("Example convertXSLFOToPDF end");
    }

    public static void convertXSLFOToPDF(String dataDir, String outputDir) {
        // Instantiate XSLFO load options instance
        XslFoLoadOptions options = new XslFoLoadOptions();
        // Open document
        Document doc = new Document(dataDir + "test.fo", options);
        try {
            // Save PDF document
            doc.save(outputDir + "XSL_FO.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
