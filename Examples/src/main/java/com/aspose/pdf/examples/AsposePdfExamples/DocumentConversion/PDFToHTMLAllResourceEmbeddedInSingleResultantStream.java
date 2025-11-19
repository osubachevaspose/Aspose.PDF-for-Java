package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.LettersPositioningMethods;
import com.aspose.pdf.examples.Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDFToHTMLAllResourceEmbeddedInSingleResultantStream {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/PDFToHTML/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example allResourceEmbeddedInSingleResultantStream start");
        allResourceEmbeddedInSingleResultantStream(dataDir, outputDir);
        System.out.println("Example allResourceEmbeddedInSingleResultantStream end");
    }

    public static void allResourceEmbeddedInSingleResultantStream(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // tune conversion parameters
            HtmlSaveOptions htmlSaveOptions = new HtmlSaveOptions();
            htmlSaveOptions.setRasterImagesSavingMode(
                    HtmlSaveOptions.RasterImagesSavingModes.AsEmbeddedPartsOfPngPageBackground);
            htmlSaveOptions.setFontSavingMode(HtmlSaveOptions.FontSavingModes.SaveInAllFormats);
            htmlSaveOptions.setPartsEmbeddingMode(HtmlSaveOptions.PartsEmbeddingModes.EmbedAllIntoHtml);
            htmlSaveOptions.setLettersPositioningMethod(
                    LettersPositioningMethods.UseEmUnitsAndCompensationOfRoundingErrorsInCss);
            htmlSaveOptions.setSplitIntoPages(false);// force write HTMLs of all pages into one output document
            htmlSaveOptions.setCustomHtmlSavingStrategy(new HtmlSaveOptions.HtmlPageMarkupSavingStrategy() {
                public void invoke(HtmlSaveOptions.HtmlPageMarkupSavingInfo htmlSavingInfo) {
                    try {
                        byte[] resultHtmlAsBytes = new byte[(int) htmlSavingInfo.getContentStream().available()];
                        htmlSavingInfo.getContentStream().read(resultHtmlAsBytes, 0, resultHtmlAsBytes.length);
                        // here you can use any writable stream, file stream is taken just as example
                        FileOutputStream fos;
                        try {
                            fos = new FileOutputStream(outputDir + "allResourceEmbeddedInSingleResultantStream.html");
                            fos.write(resultHtmlAsBytes);
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(PDFToHTMLAllResourceEmbeddedInSingleResultantStream.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }
                }
            });
            // we can use some non-existing file name all real saving will be done in
            // CustomHtmlSavingStrategy
            String outHtmlFile = outputDir + "ThisFileWillNotAppearOnDisk.html";
            doc.save(outHtmlFile, htmlSaveOptions);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
