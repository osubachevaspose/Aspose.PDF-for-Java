package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.PsLoadOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertPostScriptFileToPDFFormat {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/ConvertPostScriptFileToPDFFormat/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertPostScriptFileToPDFFormat start");
        convertPostScriptFileToPDFFormat(dataDir, outputDir);
        System.out.println("Example convertPostScriptFileToPDFFormat end");
    }

    private static void convertPostScriptFileToPDFFormat(String dataDir, String outputDir) {
        // Create a new instance of PsLoadOptions
        PsLoadOptions options = new PsLoadOptions();
        // Open .ps document with created load options
        Document doc = new Document(dataDir + "input.ps", options);
        try {
            // Save document
            doc.save(outputDir + "outPSToPDF_out.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
