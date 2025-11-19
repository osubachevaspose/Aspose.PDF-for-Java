package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class DeleteBookmarksFromPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Bookmarks/DeleteBookmarksFromPDFDocument/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example deleteBookmarksFromPDFDocument start");
        deleteBookmarksFromPDFDocument(dataDir, outputDir);
        System.out.println("Example deleteBookmarksFromPDFDocument end");

        System.out.println("Example deleteParticularBookmark start");
        deleteParticularBookmark(dataDir, outputDir);
        System.out.println("Example deleteParticularBookmark end");
    }

    public static void deleteBookmarksFromPDFDocument(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "PdfWithBookmark.pdf");
        try {
            // Delete all bookmarks
            doc.getOutlines().delete();
            // Save output
            doc.save(outputDir + "deleteBookmarksFromPDFDocument.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void deleteParticularBookmark(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "PdfWithChildBookmark.pdf");
        try {
            // Delete a specific bookmarks
            doc.getOutlines().delete("Child Outline");
            // Save output
            doc.save(outputDir + "deleteParticularBookmark.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
