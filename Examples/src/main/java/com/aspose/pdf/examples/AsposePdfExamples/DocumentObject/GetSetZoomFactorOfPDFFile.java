package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.FitHExplicitDestination;
import com.aspose.pdf.FitVExplicitDestination;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.XYZExplicitDestination;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class GetSetZoomFactorOfPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/GetSetZoomFactorOfPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example getSetZoomFactorOfPDFFile start");
        getSetZoomFactorOfPDFFile(dataDir, outputDir);
        System.out.println("Example getSetZoomFactorOfPDFFile end");

        System.out.println("Example getZoomFactor start");
        getZoomFactor(dataDir);
        System.out.println("Example getZoomFactor end");
    }

    public static void getSetZoomFactorOfPDFFile(String dataDir, String outputDir) {
        double zoom = .5;
        // instantiate new Document object
        Document doc = new Document(dataDir + "HelloWorld.pdf");
        try {
            // setting zoom factor of document
            GoToAction actionzoom = new GoToAction(new XYZExplicitDestination(doc.getPages().get_Item(1),
                    doc.getPages().get_Item(1).getMediaBox().getWidth(),
                    doc.getPages().get_Item(1).getMediaBox().getHeight(), zoom));
            doc.setOpenAction(actionzoom);
            // setting action to fit to page width zoom
            GoToAction actionFittoWidth = new GoToAction(new FitHExplicitDestination(doc.getPages().get_Item(1),
                    doc.getPages().get_Item(1).getMediaBox().getWidth()));
            doc.setOpenAction(actionFittoWidth);
            // setting action to fit to page height zoom
            GoToAction actionFittoHeight = new GoToAction(new FitVExplicitDestination(doc.getPages().get_Item(1),
                    doc.getPages().get_Item(1).getMediaBox().getHeight()));
            doc.setOpenAction(actionFittoHeight);
            doc.save(outputDir + "Zoomed_actionzoom.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void getZoomFactor(String dataDir) {
        // Instantiate new Document object
        Document doc = new Document(dataDir + "Zoomed_pdf.pdf");
        try {
            // Create GoToAction object
            GoToAction action = (GoToAction) doc.getOpenAction();
            // Get the Zoom factor of PDF file
            System.out.println(((XYZExplicitDestination) action.getDestination()).getZoom());
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
