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
        String testID = "com/aspose/pdf/examples/AsposePdf/Bookmarks/GetBookmarksFromPDFDocument/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example gettingBookmarks start");
        gettingBookmarks(dataDir);
        System.out.println("Example gettingBookmarks end");

        System.out.println("Example gettingBookmarksPageNumber start");
        gettingBookmarksPageNumber(dataDir);
        System.out.println("Example gettingBookmarksPageNumber end");
    }

    public static void gettingBookmarks(String dataDir) {
        // Open document
        Document doc = new Document(dataDir + "PdfWithChildBookmark.pdf");
        try {
            // Loop through all the bookmarks
            for (OutlineItemCollection outlineItem : doc.getOutlines()) {
                System.out.println("Title: " + outlineItem.getTitle());
                System.out.println("Is Italic: " + outlineItem.getItalic());
                System.out.println("Is Bold: " + outlineItem.getBold());
                System.out.println("Color: " + outlineItem.getColor());
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void gettingBookmarksPageNumber(String dataDir) {
        // Create PdfBookmarkEditor
        PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();
        try {
            // Open PDF file
            bookmarkEditor.bindPdf(dataDir + "PdfWithChildBookmark.pdf");
            // Extract bookmarks
            Bookmarks bookmarks = bookmarkEditor.extractBookmarks();
            for (Bookmark bookmark : bookmarks) {
                String strLevelSeprator = "";
                for (int i = 1; i < bookmark.getLevel(); i++) {
                    strLevelSeprator += "---- ";
                }
                System.out.println("Title: " + strLevelSeprator + bookmark.getTitle());
                System.out.println("Page Number: " + strLevelSeprator + bookmark.getPageNumber());
                System.out.println("Page Action: " + strLevelSeprator + bookmark.getAction());
            }
        } finally {
            if (bookmarkEditor != null)
                bookmarkEditor.close();
        }
    }
}