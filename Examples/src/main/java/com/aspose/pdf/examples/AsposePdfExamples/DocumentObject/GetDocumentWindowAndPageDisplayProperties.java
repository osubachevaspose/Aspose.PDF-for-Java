package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class GetDocumentWindowAndPageDisplayProperties {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/GetDocumentWindowAndPageDisplayProperties/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example getDocumentWindowAndPageDisplayProperties start");
        getDocumentWindowAndPageDisplayProperties(dataDir);
        System.out.println("Example getDocumentWindowAndPageDisplayProperties end");
    }

    public static void getDocumentWindowAndPageDisplayProperties(String dataDir) {
        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Get different document properties
            // Position of document's window - Default: false
            System.out.println("CenterWindow: " + doc.isCenterWindow());
            // Predominant reading order; determine the position of page when displayed side
            // by side - Default: L2R
            System.out.println("Direction: " + doc.getDirection());
            // Whether window's title bar should display document title.
            // If false, title bar displays PDF file name - Default: false
            System.out.println("DisplayDocTitle: " + doc.isDisplayDocTitle());
            // Whether to resize the document's window to fit the size of first displayed
            // page - Default: false
            System.out.println("FitWindow: " + doc.isFitWindow());
            // Whether to hide menu bar of the viewer application - Default: false
            System.out.println("HideMenuBar: " + doc.isHideMenubar());
            // Whether to hide tool bar of the viewer application - Default: false
            System.out.println("HideToolBar: " + doc.isHideToolBar());
            // Whether to hide UI elements like scroll bars and leaving only the page
            // contents displayed - Default: false
            System.out.println("HideWindowUI: " + doc.isHideWindowUI());
            // The document's page mode. How to display document on exiting full-screen mode
            System.out.println("NonFullScreenPageMode: " + doc.getNonFullScreenPageMode());
            // The page layout i.e. single page, one column
            System.out.println("PageLayout: " + doc.getPageLayout());
            // How the document should display when opened.
            System.out.println("pageMode: " + doc.getPageMode());
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
