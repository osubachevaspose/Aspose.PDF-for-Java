package com.aspose.pdf.examples.AsposePdfFacades.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfFileEditor;

public class ResizePageContentsOfSpecificPagesInAPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Pages/ResizePageContentsOfSpecificPagesInAPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example resizePageContentsOfSpecificPagesInAPDFFile start");
        resizePageContentsOfSpecificPagesInAPDFFile(dataDir, outputDir);
        System.out.println("Example resizePageContentsOfSpecificPagesInAPDFFile end");
    }

    public static void resizePageContentsOfSpecificPagesInAPDFFile(String dataDir, String outputDir) {
        // Open PDF Document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Create PdfFileEditor Object
            PdfFileEditor fileEditor = new PdfFileEditor();
            // Specify Parameter to be used for resizing
            PdfFileEditor.ContentsResizeParameters parameters = new PdfFileEditor.ContentsResizeParameters(
                    // left margin = 10% of page width
                    PdfFileEditor.ContentsResizeValue.percents(10),
                    // new contents width calculated automatically as width - left margin - right
                    // margin (100% - 10% - 10% = 80%)
                    null,
                    // right margin is 10% of page
                    PdfFileEditor.ContentsResizeValue.percents(10),
                    // top margin = 10% of height
                    PdfFileEditor.ContentsResizeValue.percents(10),
                    // new contents height is calculated automatically (similar to width)
                    null,
                    // bottom margin is 10%
                    PdfFileEditor.ContentsResizeValue.percents(10));
            // Resize Page Contents
            fileEditor.resizeContents(doc, new int[] { 1 }, parameters);
            // save resized document
            doc.save(outputDir + "ResizeContents.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
