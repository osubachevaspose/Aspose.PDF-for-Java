package com.aspose.pdf.examples.AsposePdfFacades.Document;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfFileEditor;

public class ResizePDFPageContents {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Document/ResizePDFPageContents/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example resizePDFPageContents start");
        resizePDFPageContents(dataDir, outputDir);
        System.out.println("Example resizePDFPageContents end");
    }

    public static void resizePDFPageContents(String dataDir, String outputDir) {
        // load source PDF file
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // instantiate PdfFileEditor object
            PdfFileEditor fileEditor = new PdfFileEditor();
            // Specify Parameter to be used for resizing
            PdfFileEditor.ContentsResizeParameters parameters = new PdfFileEditor.ContentsResizeParameters(
                    // left margin = 10% of page width
                    PdfFileEditor.ContentsResizeValue.percents(0),
                    // new contents width calculated automatically as width - left margin - right
                    // margin (100% - 10% - 10% = 80%)
                    null,
                    // right margin is 10% of page
                    PdfFileEditor.ContentsResizeValue.percents(0),
                    // top margin = 10% of height
                    PdfFileEditor.ContentsResizeValue.percents(10),
                    // new contents height is calculated automatically (similar to width)
                    null,
                    // bottom margin is 10%
                    PdfFileEditor.ContentsResizeValue.percents(10));
            // re-size contents of the first page of PDF file
            fileEditor.resizeContents(doc, new int[] { 1 }, parameters);
            // save PDF file
            doc.save(outputDir + "ContentsResized.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
