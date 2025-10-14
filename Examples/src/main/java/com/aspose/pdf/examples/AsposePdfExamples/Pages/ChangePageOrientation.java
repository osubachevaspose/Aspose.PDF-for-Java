package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.Rotation;
import com.aspose.pdf.examples.Utils;

public class ChangePageOrientation {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Pages/ChangePageOrientation/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example changePageOrientation start");
        changePageOrientation(dataDir, outputDir);
        System.out.println("Example changePageOrientation end");

        System.out.println("Example fittingThePageContentToNewPageOrientation start");
        fittingThePageContentToNewPageOrientation(dataDir);
        System.out.println("Example fittingThePageContentToNewPageOrientation end");
    }

    public static void changePageOrientation(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "input.pdf");
        try {
            int pageCount = doc.getPages().size();
            for (int i = 1; i <= pageCount; i++) {
                Rectangle r = doc.getPages().get_Item(i).getMediaBox();
                double newHeight = r.getWidth();
                double newWidth = r.getHeight();
                double newLLX = r.getLLX();
                // We must move page upper in order to compensate changing page size
                // (lower edge of the page is 0,0 and information is usually placed from the top of the page).
                // That's why we move lower edge upper on difference between old and new height.
                double newLLY = r.getLLY() + (r.getHeight() - newHeight);
                Page p = doc.getPages().get_Item(i);
                p.setMediaBox(new Rectangle(newLLX, newLLY, newLLX + newWidth, newLLY + newHeight));
                // Sometimes we also need to set CropBox (if it was set in original file)
                p.setCropBox(new Rectangle(newLLX, newLLY, newLLX + newWidth, newLLY + newHeight));
                // Setting Rotation angle of page
                p.setRotate(Rotation.on90);
            }
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void fittingThePageContentToNewPageOrientation(String dataDir) {
        Document doc = new Document(dataDir + "input.pdf");
        try {
            Rectangle rect = doc.getPages().get_Item(1).getMediaBox();
            // New height the same
            double newHeight = rect.getHeight();
            // New width is expanded proportionally to make orientation landscape
            // (we assume that previous orientation is portrait)
            double newWidth = rect.getHeight() * rect.getHeight() / rect.getWidth();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
