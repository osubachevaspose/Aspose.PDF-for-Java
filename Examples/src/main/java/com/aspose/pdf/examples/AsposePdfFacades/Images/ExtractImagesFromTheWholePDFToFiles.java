package com.aspose.pdf.examples.AsposePdfFacades.Images;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfExtractor;

import java.io.File;

public class ExtractImagesFromTheWholePDFToFiles {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Images/ExtractImagesFromTheWholePDFToFiles/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example extractImagesFromTheWholePDFToFiles start");
        extractImagesFromTheWholePDFToFiles(dataDir, outputDir);
        System.out.println("Example extractImagesFromTheWholePDFToFiles end");
    }

    public static void extractImagesFromTheWholePDFToFiles(String dataDir, String outputDir) {
        // open input PDF
        PdfExtractor extractor = new PdfExtractor();
        try {
            extractor.bindPdf(dataDir + "SampleDataTable.pdf");
            // extract all the images
            extractor.extractImage();
            int imageCount = 1;
            // get all the extracted images
            while (extractor.hasNextImage()) {
                extractor.getNextImage(outputDir + "Image" + imageCount + ".jpg");
                imageCount++;
            }
        } finally {
            if (extractor != null)
                extractor.close();
        }
    }
}
