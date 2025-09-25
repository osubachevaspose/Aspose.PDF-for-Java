package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.examples.Utils;

public class PDFToHTMLSpecifyImagesFolder {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/PDFToHTML/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example specifyImagesFolder start");
        specifyImagesFolder(dataDir, outputDir);
        System.out.println("Example specifyImagesFolder end");
    }

    public static void specifyImagesFolder(String dataDir, String outputDir) {
        // Load PDF document
        Document doc = new Document(dataDir + "SampleDataTable.pdf");
        try {
            // Instantiate HtmlSaveOptions instance
            HtmlSaveOptions options = new HtmlSaveOptions();
            // Specify the folder (that exist) to save images during conversion process
            options.setSpecialFolderForAllImages(outputDir + "imageFolder/");
            // Save the resultant HTML file
            doc.save(outputDir + "resultant.html", options);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
