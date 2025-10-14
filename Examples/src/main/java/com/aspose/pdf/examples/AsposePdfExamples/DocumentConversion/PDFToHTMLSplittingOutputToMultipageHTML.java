package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.examples.Utils;

public class PDFToHTMLSplittingOutputToMultipageHTML {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/PDFToHTML/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example splittingOutputToMultipageHTML start");
        splittingOutputToMultipageHTML(dataDir, outputDir);
        System.out.println("Example splittingOutputToMultipageHTML end");
    }

    public static void splittingOutputToMultipageHTML(String dataDir, String outputDir) {
        // Load PDF document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Instantiate HtmlSaveOptions instance
            HtmlSaveOptions options = new HtmlSaveOptions();
            // Specify the folder to save images during conversion process
            options.setSplitIntoPages(true);
            // Save the resultant HTML file
            doc.save(outputDir + "splittingOutputToMultipageHTML.html", options);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
