package com.aspose.pdf.examples.AsposePdfFacades.Bookmarks;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfBookmarkEditor;

import java.io.File;

public class ExportBookmarksToXMLFromAnExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Bookmarks/ExportBookmarksToXMLFromAnExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example exportBookmarksToXMLFromAnExistingPDFFile start");
        exportBookmarksToXMLFromAnExistingPDFFile(dataDir, outputDir);
        System.out.println("Example exportBookmarksToXMLFromAnExistingPDFFile end");
    }

    public static void exportBookmarksToXMLFromAnExistingPDFFile(String dataDir, String outputDir) {
        // Create PdfBookmarkEditor object
        PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();
        try {
            // Open PDF file
            bookmarkEditor.bindPdf(dataDir + "PdfWithChildBookmark.pdf");
            // Export bookmarks
            bookmarkEditor.exportBookmarksToXML(outputDir + "bookmarks.xml");
        } finally {
            if (bookmarkEditor != null)
                bookmarkEditor.close();
        }
    }
}
