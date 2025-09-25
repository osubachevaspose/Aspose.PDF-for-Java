package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.LettersPositioningMethods;
import com.aspose.pdf.examples.Utils;

public class PDFtoHTMLExcludeFontResources {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/PDFToHTML/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example pdfToHTMLExcludingFontResources start");
        pdfToHTMLExcludingFontResources(dataDir, outputDir);
        System.out.println("Example pdfToHTMLExcludingFontResources end");

        System.out.println("Example pdfToHTMLExcludeFontResourcesWithAdditionalOptions start");
        pdfToHTMLExcludeFontResourcesWithAdditionalOptions(dataDir, outputDir);
        System.out.println("Example pdfToHTMLExcludeFontResourcesWithAdditionalOptions end");
    }

    private static void pdfToHTMLExcludingFontResources(String dataDir, String outputDir) {
        String inFile = dataDir + "ExcludeFont.pdf";
        // Initialize HtmlSaveOptions
        HtmlSaveOptions options = new HtmlSaveOptions();
        options.setExcludeFontNameList(new String[] { "Arial", "Calibri" });
        options.setDefaultFontName("Arial Black");
        Document doc = new Document(inFile);
        try {
            // Save
            doc.save(outputDir + "ExcludeFontResources.html", options);
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    // Added two options in HtmlSaveOptions:
    // htmlOptions.FontSavingMode = HtmlSaveOptions.FontSavingModes.DontSave; - is
    // for prevent exporting all the fonts
    // htmlOptions.ExcludeFontNameList = (new String[] { "ArialMT", "SymbolMT" }); -
    // is for prevent exporting specific fonts, please specify font names without hash
    // In this example, Aspose.PDF tried to replace embedded fonts from PDF
    // 'LJMWCD+ArialMT', 'KPACHB+SymbolMT' with system fonts 'ArialMT', 'SymbolMT'
    // and specify them in HTML.
    private static void pdfToHTMLExcludeFontResourcesWithAdditionalOptions(String dataDir, String outputDir) {
        HtmlSaveOptions options = new HtmlSaveOptions();
        options.setExplicitListOfSavedPages(new int[] { 1 });
        options.setFixedLayout(true);
        options.setCompressSvgGraphicsIfAny(false);
        options.setSaveTransparentTexts(true);
        options.setSaveShadowedTextsAsTransparentTexts(true);
        options.setExcludeFontNameList((new String[] { "ArialMT", "SymbolMT" }));
        // options.setFontSavingMode(HtmlSaveOptions.FontSavingModes.DontSave);
        options.setDefaultFontName("Comic Sans MS");
        options.setUseZOrder(true);
        options.setLettersPositioningMethod(LettersPositioningMethods.UseEmUnitsAndCompensationOfRoundingErrorsInCss);
        options.setPartsEmbeddingMode(HtmlSaveOptions.PartsEmbeddingModes.NoEmbedding);
        options.setRasterImagesSavingMode(HtmlSaveOptions.RasterImagesSavingModes.AsEmbeddedPartsOfPngPageBackground);
        options.setSplitIntoPages(false);
        Document doc = new Document(dataDir + "ExcludeFontResourcesWithAdditionalOptions.pdf");
        try {
            doc.save(outputDir + "ExcludeFontResourcesWithAdditionalOptions.html", options);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
