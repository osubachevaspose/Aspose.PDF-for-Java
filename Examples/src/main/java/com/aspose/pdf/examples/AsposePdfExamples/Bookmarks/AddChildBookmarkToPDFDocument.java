package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.OutlineItemCollection;
import com.aspose.pdf.examples.Utils;

public class AddChildBookmarkToPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Bookmarks/AddChildBookmarkToPDFDocument/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addChildBookmarkToPDFDocument start");
        addChildBookmarkToPDFDocument(dataDir, outputDir);
        System.out.println("Example addChildBookmarkToPDFDocument end");
    }

    private static void addChildBookmarkToPDFDocument(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Create a parent bookmark object
            OutlineItemCollection pdfOutline = new OutlineItemCollection(doc.getOutlines());
            pdfOutline.setTitle("Parent Outline");
            pdfOutline.setItalic(true);
            pdfOutline.setBold(true);
            // Set the destination page number
            pdfOutline.setDestination(new GoToAction(doc.getPages().get_Item(2)));
            // Create a child bookmark object
            OutlineItemCollection pdfChildOutline = new OutlineItemCollection(doc.getOutlines());
            pdfChildOutline.setTitle("Child Outline");
            pdfChildOutline.setItalic(true);
            pdfChildOutline.setBold(true);
            // Set the destination page number for child outline
            pdfChildOutline.setDestination(new GoToAction(doc.getPages().get_Item(2)));
            // Add child bookmark to parent bookmark's collection
            pdfOutline.add(pdfChildOutline);
            // Add parent bookmark to the document's outline collection.
            doc.getOutlines().add(pdfOutline);
            // Save output
            doc.save(outputDir + "PDF_with_ChildBookmarks.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
