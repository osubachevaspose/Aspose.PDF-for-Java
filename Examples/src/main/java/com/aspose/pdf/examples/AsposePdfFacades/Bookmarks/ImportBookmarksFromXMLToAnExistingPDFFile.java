package com.aspose.pdf.examples.AsposePdfFacades.Bookmarks;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.aspose.pdf.facades.PdfBookmarkEditor;

public class ImportBookmarksFromXMLToAnExistingPDFFile {

    public static void main(String[] args) throws IOException {
        toImportBookmarks();
        importBookmarksWithXML();
    }

    public static void toImportBookmarks() {
        // Create PdfBookmarkEditor class
        PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();
        try {
            // Open PDF file
            bookmarkEditor.bindPdf("Input.pdf");
            // Import bookmarks
            bookmarkEditor.importBookmarksWithXML("bookmarks.xml");
            // Save updated PDF file
            bookmarkEditor.save("output.pdf");
        } finally {
            if (bookmarkEditor != null)
                bookmarkEditor.close();
        }
    }

    public static void importBookmarksWithXML() throws IOException {
        // Create PdfBookmarkEditor object
        PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();
        try {
            // Open PDF file
            bookmarkEditor.bindPdf("Input.pdf");
            InputStream is = new FileInputStream("bookmark.xml");
            bookmarkEditor.importBookmarksWithXML(is);
            bookmarkEditor.save("output.pdf");
        } finally {
            if (bookmarkEditor != null)
                bookmarkEditor.close();
        }
    }
}
