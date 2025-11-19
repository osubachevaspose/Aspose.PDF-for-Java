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
        HtmlSaveOptions htmlSaveOptions = new HtmlSaveOptions();
        htmlSaveOptions.setExcludeFontNameList(new String[] { "Arial", "Calibri" });
        htmlSaveOptions.setDefaultFontName("Arial Black");
        Document doc = new Document(inFile);
        try {
            doc.save(outputDir + "ExcludeFontResources.html", htmlSaveOptions);
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
        HtmlSaveOptions htmlSaveOptions = new HtmlSaveOptions();
        htmlSaveOptions.setExplicitListOfSavedPages(new int[] { 1 });
        htmlSaveOptions.setFixedLayout(true);
        htmlSaveOptions.setCompressSvgGraphicsIfAny(false);
        htmlSaveOptions.setSaveTransparentTexts(true);
        htmlSaveOptions.setSaveShadowedTextsAsTransparentTexts(true);
        htmlSaveOptions.setExcludeFontNameList((new String[] { "ArialMT", "SymbolMT" }));
        // htmlSaveOptions.setFontSavingMode(HtmlSaveOptions.FontSavingModes.DontSave);
        htmlSaveOptions.setDefaultFontName("Comic Sans MS");
        htmlSaveOptions.setUseZOrder(true);
        htmlSaveOptions.setLettersPositioningMethod(LettersPositioningMethods.UseEmUnitsAndCompensationOfRoundingErrorsInCss);
        htmlSaveOptions.setPartsEmbeddingMode(HtmlSaveOptions.PartsEmbeddingModes.NoEmbedding);
        htmlSaveOptions.setRasterImagesSavingMode(HtmlSaveOptions.RasterImagesSavingModes.AsEmbeddedPartsOfPngPageBackground);
        htmlSaveOptions.setSplitIntoPages(false);
        Document doc = new Document(dataDir + "ExcludeFontResourcesWithAdditionalOptions.pdf");
        try {
            doc.save(outputDir + "ExcludeFontResourcesWithAdditionalOptions.html", htmlSaveOptions);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
