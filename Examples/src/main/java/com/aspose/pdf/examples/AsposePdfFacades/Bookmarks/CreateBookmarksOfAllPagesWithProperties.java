package com.aspose.pdf.examples.AsposePdfFacades.Bookmarks;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfBookmarkEditor;

import java.awt.Color;

public class CreateBookmarksOfAllPagesWithProperties {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Bookmarks/CreateBookmarksOfAllPagesWithProperties/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example createBookmarksOfAllPagesWithProperties start");
        createBookmarksOfAllPagesWithProperties(dataDir, outputDir);
        System.out.println("Example createBookmarksOfAllPagesWithProperties end");
    }

    public static void createBookmarksOfAllPagesWithProperties(String dataDir, String outputDir) {
        PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();
        try {
            // open document
            bookmarkEditor.bindPdf(dataDir + "input.pdf");
            // create bookmark of all pages
            bookmarkEditor.createBookmarks(Color.GREEN, true, true);
            // save updated PDF file
            bookmarkEditor.save(outputDir + "output.pdf");
        } finally {
            if (bookmarkEditor != null)
                bookmarkEditor.close();
        }
    }
}
