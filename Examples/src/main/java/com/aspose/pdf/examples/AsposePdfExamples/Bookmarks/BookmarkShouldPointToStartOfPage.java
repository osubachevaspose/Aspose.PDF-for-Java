package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.ExplicitDestination;
import com.aspose.pdf.ExplicitDestinationType;
import com.aspose.pdf.FitVExplicitDestination;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.OutlineItemCollection;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;
import com.aspose.pdf.facades.ViewerPreference;

public class BookmarkShouldPointToStartOfPage {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Bookmarks/BookmarkShouldPointToStartOfPage/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example bookmarkShouldPointToStartOfPage start");
        bookmarkShouldPointToStartOfPage(dataDir, outputDir);
        System.out.println("Example bookmarkShouldPointToStartOfPage end");

        System.out.println("============================");
        System.out.println("Example setDestinationWhileCreatingPDF start");
        setDestinationWhileCreatingPDF(dataDir, outputDir);
        System.out.println("Example setDestinationWhileCreatingPDF end");

        System.out.println("============================");
        System.out.println("Example settingViewerPreferences start");
        settingViewerPreferences(dataDir, outputDir);
        System.out.println("Example settingViewerPreferences end");
    }

    public static void bookmarkShouldPointToStartOfPage(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "PdfWithBookmark.pdf");
        try {
            // Editing existing bookmark
            OutlineItemCollection pdfOutline = doc.getOutlines().get_Item(1);
            pdfOutline.setDestination(
                    // 1st variant new FitVExplicitDestination(doc.getPages().get_Item(1),0)
                    // 2nd variant. You can tweak using the bookmark links using different
                    // parameters of ExplicitDestinationType
                    ExplicitDestination.createDestination(doc.getPages().get_Item(1), ExplicitDestinationType.FitH,
                            doc.getPages().get_Item(1).getMediaBox().getHeight()));
            doc.save(outputDir + "bookmarkShouldPointToStartOfPage.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void setDestinationWhileCreatingPDF(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "PdfWithBookmark.pdf");
        try {
            OutlineItemCollection pdfOutline_new = new OutlineItemCollection(doc.getOutlines());
            pdfOutline_new.setTitle("Test bookmark");
            pdfOutline_new.setItalic(true);
            pdfOutline_new.setBold(true);
            // Set the destination page number and position
            pdfOutline_new.setAction(new GoToAction(new FitVExplicitDestination(doc.getPages().get_Item(2), 0)));
            // Add bookmark in the document's outline collection.
            doc.getOutlines().add(pdfOutline_new);
            doc.save(outputDir + "setDestinationWhileCreatingPDF.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void settingViewerPreferences(String dataDir, String outputDir) {
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            contentEditor.bindPdf(dataDir + "PdfWithBookmark.pdf");
            contentEditor.changeViewerPreference(ViewerPreference.PAGE_LAYOUT_SINGLE_PAGE);
            contentEditor.save(outputDir + "settingViewerPreferences.pdf");
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
