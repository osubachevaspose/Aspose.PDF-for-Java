package com.aspose.pdf.examples.AsposePdfFacades.Bookmarks;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfBookmarkEditor;

public class ImportBookmarksFromXMLToAnExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Bookmarks/ImportBookmarksFromXMLToAnExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example importBookmarksFromXMLToAnExistingPDFFile start");
        importBookmarksFromXMLToAnExistingPDFFile(dataDir, outputDir);
        System.out.println("Example importBookmarksFromXMLToAnExistingPDFFile end");
    }

    public static void importBookmarksFromXMLToAnExistingPDFFile(String dataDir, String outputDir) {
        // Create PdfBookmarkEditor class
        PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();
        try {
            // Open PDF file
            bookmarkEditor.bindPdf(dataDir + "input.pdf");
            // Import bookmarks
            bookmarkEditor.importBookmarksWithXML(dataDir + "bookmarks.xml");
            // Save updated PDF file
            bookmarkEditor.save(outputDir + "output.pdf");
        } finally {
            if (bookmarkEditor != null)
                bookmarkEditor.close();
        }
    }
}
