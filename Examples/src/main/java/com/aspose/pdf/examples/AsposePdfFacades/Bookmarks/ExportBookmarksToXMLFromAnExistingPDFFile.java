package com.aspose.pdf.examples.AsposePdfFacades.Bookmarks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.aspose.pdf.facades.PdfBookmarkEditor;

public class ExportBookmarksToXMLFromAnExistingPDFFile {

    public static void main(String[] args) throws IOException {
        toExportBookmarks();
        exportBookmarksToXML();
    }

    public static void toExportBookmarks() {
        // Create PdfBookmarkEditor object
        PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();
        try {
            // Open PDF file
            bookmarkEditor.bindPdf("Input.pdf");
            // Export bookmarks
            bookmarkEditor.exportBookmarksToXML("bookmarks.xml");
        } finally {
            if (bookmarkEditor != null)
                bookmarkEditor.close();
        }
    }

    public static void exportBookmarksToXML() throws IOException {
        // Create PdfBookmarkEditor object
        PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();
        try {
            // Open PDF file
            bookmarkEditor.bindPdf("Input.pdf");
            OutputStream os = new FileOutputStream("bookmark.xml");
            bookmarkEditor.exportBookmarksToXML(os);
        } finally {
            if (bookmarkEditor != null)
                bookmarkEditor.close();
        }
    }
}
