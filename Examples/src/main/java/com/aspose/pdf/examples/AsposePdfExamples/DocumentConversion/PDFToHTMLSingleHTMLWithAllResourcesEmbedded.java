package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.LettersPositioningMethods;
import com.aspose.pdf.examples.Utils;

public class PDFToHTMLSingleHTMLWithAllResourcesEmbedded {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/PDFToHTML/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example singleHTMLWithAllResourcesEmbedded start");
        singleHTMLWithAllResourcesEmbedded(dataDir, outputDir);
        System.out.println("Example singleHTMLWithAllResourcesEmbedded end");
    }

    public static void singleHTMLWithAllResourcesEmbedded(String dataDir, String outputDir) {
        // Load source PDF file
        Document doc = new Document(dataDir + "input.pdf");
        try {
            HtmlSaveOptions htmlSaveOptions = new HtmlSaveOptions();
            // Enable option to embed all resources inside the HTML
            htmlSaveOptions.setPartsEmbeddingMode(HtmlSaveOptions.PartsEmbeddingModes.EmbedAllIntoHtml);
            // This is just optimization for IE and can be omitted
            htmlSaveOptions.setLettersPositioningMethod(
                    LettersPositioningMethods.UseEmUnitsAndCompensationOfRoundingErrorsInCss);
            htmlSaveOptions.setRasterImagesSavingMode(
                    HtmlSaveOptions.RasterImagesSavingModes.AsEmbeddedPartsOfPngPageBackground);
            htmlSaveOptions.setFontSavingMode(HtmlSaveOptions.FontSavingModes.SaveInAllFormats);
            // Output file path
            String outHtmlFile = outputDir + "Single_output.html";
            doc.save(outHtmlFile, htmlSaveOptions);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
