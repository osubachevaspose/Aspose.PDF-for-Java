package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.PageCollection;
import com.aspose.pdf.examples.Utils;

public class GetPageProperties {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Pages/GetPageProperties/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example getPageProperties start");
        getPageProperties(dataDir);
        System.out.println("Example getPageProperties end");
    }

    public static void getPageProperties(String dataDir) {
        // Open a document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Get the page collection
            PageCollection pageCollection = doc.getPages();
            // Get a specific page
            Page page = pageCollection.get_Item(1);
            // Get the page properties
            System.out.println("ArtBox : Height = " + page.getArtBox().getHeight() + ", Width = "
                    + page.getArtBox().getWidth() + ", LLX = " + page.getArtBox().getLLX() + ", LLY = "
                    + page.getArtBox().getLLY() + ", URX = " + page.getArtBox().getURX() + ", URY = "
                    + page.getArtBox().getURY());
            System.out.println("BleedBox : Height = " + page.getBleedBox().getHeight() + ", Width = "
                    + page.getBleedBox().getWidth() + ", LLX = " + page.getBleedBox().getLLX() + ", LLY = "
                    + page.getBleedBox().getLLY() + ", URX = " + page.getBleedBox().getURX() + ", URY = "
                    + page.getBleedBox().getURY());
            System.out.println("CropBox : Height = " + page.getCropBox().getHeight() + ", Width = "
                    + page.getCropBox().getWidth() + ", LLX = " + page.getCropBox().getLLX() + ", LLY = "
                    + page.getCropBox().getLLY() + ", URX = " + page.getCropBox().getURX() + ", URY = "
                    + page.getCropBox().getURY());
            System.out.println("MediaBox : Height = " + page.getMediaBox().getHeight() + ", Width = "
                    + page.getMediaBox().getWidth() + ", LLX = " + page.getMediaBox().getLLX() + ", LLY = "
                    + page.getMediaBox().getLLY() + ", URX = " + page.getMediaBox().getURX() + ", URY = "
                    + page.getMediaBox().getURY());
            System.out.println("TrimBox : Height = " + page.getTrimBox().getHeight() + ", Width = "
                    + page.getTrimBox().getWidth() + ", LLX = " + page.getTrimBox().getLLX() + ", LLY = "
                    + page.getTrimBox().getLLY() + ", URX = " + page.getTrimBox().getURX() + ", URY = "
                    + page.getTrimBox().getURY());
            System.out.println(
                    "Rect : Height = " + page.getRect().getHeight() + ", Width = " + page.getRect().getWidth()
                            + ", LLX = " + page.getRect().getLLX() + ", LLY = " + page.getRect().getLLY()
                            + ", URX = " + page.getRect().getURX() + ", URY = " + page.getRect().getURY());
            System.out.println("Page Number: " + page.getNumber());
            System.out.println("Rotate : " + page.getRotate());
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
