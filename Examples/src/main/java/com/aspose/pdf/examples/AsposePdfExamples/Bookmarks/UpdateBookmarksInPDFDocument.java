package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.OutlineItemCollection;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class UpdateBookmarksInPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Bookmarks/UpdateBookmarksInPDFDocument/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example updateBookmarksInPDFDocument start");
        updateBookmarksInPDFDocument(dataDir, outputDir);
        System.out.println("Example updateBookmarksInPDFDocument end");
    }

    private static void updateBookmarksInPDFDocument(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "PdfWithChildBookmark.pdf");
        try {
            // Get a bookmark object
            OutlineItemCollection pdfOutline = doc.getOutlines().get_Item(1);
            // Set the target page as 10
            pdfOutline.setDestination(new GoToAction(doc.getPages().get_Item(1)));
            // Save output
            doc.save(outputDir + "Bookmarkupdated_output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
