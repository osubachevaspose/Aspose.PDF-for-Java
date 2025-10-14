package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Direction;
import com.aspose.pdf.Document;
import com.aspose.pdf.PageLayout;
import com.aspose.pdf.PageMode;
import com.aspose.pdf.examples.Utils;

public class SetDocumentWindowAndPageDisplayProperties {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/SetDocumentWindowAndPageDisplayProperties/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example setDocumentWindowAndPageDisplayProperties start");
        setDocumentWindowAndPageDisplayProperties(dataDir, outputDir);
        System.out.println("Example setDocumentWindowAndPageDisplayProperties end");
    }

    public static void setDocumentWindowAndPageDisplayProperties(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Set different document properties specify to position document's window -
            // Default: false
            doc.setCenterWindow(true);
            // Predominant reading order; determine the position of page when displayed side
            // by side - Default: L2R
            doc.setDirection(Direction.R2L);
            // Specify whether window's title bar should display document title if false,
            // title bar displays PDF file name - Default: false
            doc.setDisplayDocTitle(true);
            // Specify whether to resize the document's window to fit the size of first
            // displayed page - Default: false
            doc.setFitWindow(true);
            // Specify whether to hide menu bar of the viewer application - Default: false
            doc.setHideMenubar(true);
            // Specify whether to hide tool bar of the viewer application - Default: false
            doc.setHideToolBar(true);
            // Specify whether to hide UI elements like scroll bars and leaving only the
            // page contents displayed - Default: false
            doc.setHideWindowUI(true);
            // Document's page mode. specify how to display document on exiting full-screen
            // mode.
            doc.setNonFullScreenPageMode(PageMode.UseOC);
            // Specify the page layout i.e. single page, one column
            doc.setPageLayout(PageLayout.TwoColumnLeft);
            // Specify how the document should display when opened i.e. show thumbnails,
            // full-screen, show attachment panel
            doc.setPageMode(PageMode.UseThumbs);
            // Save updated PDF file
            doc.save(outputDir + "UpdatedFile_output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
