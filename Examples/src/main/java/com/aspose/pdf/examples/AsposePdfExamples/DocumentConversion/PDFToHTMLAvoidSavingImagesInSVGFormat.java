package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.examples.Utils;

public class PDFToHTMLAvoidSavingImagesInSVGFormat {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/PDFToHTML/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example avoidSavingImagesInSVGFormat start");
        avoidSavingImagesInSVGFormat(dataDir, outputDir);
        System.out.println("Example avoidSavingImagesInSVGFormat end");
    }

    public static void avoidSavingImagesInSVGFormat(String dataDir, String outputDir) {
        // Open source PDF document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Create HtmlSaveOptions with tested feature
            HtmlSaveOptions options = new HtmlSaveOptions();
            options.setFixedLayout(true);
            // save images in PNG format instead of SVG
            options.setRasterImagesSavingMode(
                    HtmlSaveOptions.RasterImagesSavingModes.AsEmbeddedPartsOfPngPageBackground);
            // save output as HTML
            doc.save(outputDir + "avoidSavingImagesInSVGFormat.html", options);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
