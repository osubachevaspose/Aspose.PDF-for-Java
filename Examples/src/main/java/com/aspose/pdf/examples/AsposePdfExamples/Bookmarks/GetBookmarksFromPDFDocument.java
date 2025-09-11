package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.OutlineItemCollection;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.Bookmark;
import com.aspose.pdf.facades.Bookmarks;
import com.aspose.pdf.facades.PdfBookmarkEditor;

public class GetBookmarksFromPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Bookmarks/getchildbookmarks/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example gettingBookmarks start");
        gettingBookmarks(dataDir, outputDir);
        System.out.println("Example gettingBookmarks end");

        System.out.println("============================");
        System.out.println("Example gettingBookmarksPageNumber start");
        gettingBookmarksPageNumber(dataDir, outputDir);
        System.out.println("Example gettingBookmarksPageNumber end");
    }

    public static void gettingBookmarks(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Loop through all the bookmarks
            for (OutlineItemCollection outlineItem : doc.getOutlines()) {
                System.out.println("Title :- " + outlineItem.getTitle());
                System.out.println("Is Italic :- " + outlineItem.getItalic());
                System.out.println("Is Bold :- " + outlineItem.getBold());
                System.out.println("Color :- " + outlineItem.getColor());
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void gettingBookmarksPageNumber(String dataDir, String outputDir) {
        // Create PdfBookmarkEditor
        PdfBookmarkEditor editor = new PdfBookmarkEditor();
        try {
            // Open PDF file
            editor.bindPdf(dataDir + "input.pdf");
            // Extract bookmarks
            Bookmarks bookmarks = editor.extractBookmarks();
            for (Bookmark bookmark : bookmarks) {
                String strLevelSeprator = "";
                for (int i = 1; i < bookmark.getLevel(); i++) {
                    strLevelSeprator += "---- ";
                }
                System.out.println("Title :- " + strLevelSeprator + bookmark.getTitle());
                System.out.println("Page Number :- " + strLevelSeprator + bookmark.getPageNumber());
                System.out.println("Page Action :- " + strLevelSeprator + bookmark.getAction());
            }
        } finally {
            if (editor != null)
                editor.close();
        }
    }
}