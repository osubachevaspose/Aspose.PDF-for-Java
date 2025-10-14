package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfExtractor;

import java.io.File;

public class ExtractTextFromARangeOfPages {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Text/ExtractTextFromARangeOfPages/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example extractTextFromARangeOfPages start");
        extractTextFromARangeOfPages(dataDir, outputDir);
        System.out.println("Example extractTextFromARangeOfPages end");
    }

    public static void extractTextFromARangeOfPages(String dataDir, String outputDir) {
        PdfExtractor extractor = new PdfExtractor();
        try {
            // open input PDF
            extractor.bindPdf(dataDir + "4pages.pdf");
            // specify start and end pages
            extractor.setStartPage(2);
            extractor.setEndPage(3);
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
