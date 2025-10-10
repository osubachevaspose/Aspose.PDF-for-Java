package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfExtractor;

import java.io.File;

public class ExtractTextFromTheWholePDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Text/ExtractTextFromTheWholePDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example addTextInAnExistingPDFFile start");
        addTextInAnExistingPDFFile(dataDir, outputDir);
        System.out.println("Example addTextInAnExistingPDFFile end");
    }

    public static void addTextInAnExistingPDFFile(String dataDir, String outputDir) {
        PdfExtractor extractor = new PdfExtractor();
        try {
            // open input PDF
            extractor.bindPdf(dataDir + "input.pdf");
            // use parameterless ExtractText method
            extractor.extractText();
            // Save the extracted text to a text file
            extractor.getText(outputDir + "output.txt");
        } finally {
            if (extractor != null)
                extractor.close();
        }
    }
}
