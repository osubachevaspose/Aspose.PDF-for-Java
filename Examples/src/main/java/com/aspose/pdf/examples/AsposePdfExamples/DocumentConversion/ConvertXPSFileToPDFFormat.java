package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.LoadOptions;
import com.aspose.pdf.XpsLoadOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertXPSFileToPDFFormat {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/ConvertXPSFileToPDFFormat/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertXPSFileToPDFFormat start");
        convertXPSFileToPDFFormat(dataDir, outputDir);
        System.out.println("Example convertXPSFileToPDFFormat end");
    }

    public static void convertXPSFileToPDFFormat(String dataDir, String outputDir) {
        // Instantiate LoadOption object using XPS load option
        LoadOptions options = new XpsLoadOptions();
        // Create document object
        Document doc = new Document(dataDir + "test.xps", options);
        try {
            // Save the resultant PDF document
            doc.save(outputDir + "resultant.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
