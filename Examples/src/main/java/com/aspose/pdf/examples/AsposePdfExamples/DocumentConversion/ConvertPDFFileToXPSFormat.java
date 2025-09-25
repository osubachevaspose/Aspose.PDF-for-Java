package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.XpsSaveOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFFileToXPSFormat {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/ConvertPDFFileToXPSFormat/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example keepingTextSelectableInConvertedXPS start");
        keepingTextSelectableInConvertedXPS(dataDir, outputDir);
        System.out.println("Example keepingTextSelectableInConvertedXPS end");

        System.out.println("Example convertPDFtoXPS start");
        convertPDFtoXPS(dataDir, outputDir);
        System.out.println("Example convertPDFtoXPS end");
    }

    public static void convertPDFtoXPS(String dataDir, String outputDir) {
        // Load PDF document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Instantiate XPS Save options
            XpsSaveOptions options = new XpsSaveOptions();
            // Save the XPS document
            doc.save(outputDir + "ConvertPDFtoXPS_out.xps", options);
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void keepingTextSelectableInConvertedXPS(String dataDir, String outputDir) {
        // load PDF document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // instantiate an object of XpsSaveOptions
            XpsSaveOptions options = new XpsSaveOptions();
            // Allow text selectable in output XPS
            options.setSaveTransparentTexts(true);
            // save the output in XPS files
            doc.save(outputDir + "KeepingTextSelectableInConvertedXPS_out.xps", options);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
