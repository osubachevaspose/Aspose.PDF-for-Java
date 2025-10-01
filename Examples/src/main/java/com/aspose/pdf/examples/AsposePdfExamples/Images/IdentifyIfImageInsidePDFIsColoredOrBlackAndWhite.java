package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.ColorType;
import com.aspose.pdf.Document;
import com.aspose.pdf.ImagePlacement;
import com.aspose.pdf.ImagePlacementAbsorber;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.Utils;

public class IdentifyIfImageInsidePDFIsColoredOrBlackAndWhite {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/IdentifyIfImageInsidePDFIsColoredOrBlackAndWhite/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example identifyIfImageInsidePDFIsColoredOrBlackAndWhite start");
        identifyIfImageInsidePDFIsColoredOrBlackAndWhite(dataDir);
        System.out.println("Example identifyIfImageInsidePDFIsColoredOrBlackAndWhite end");
    }

    public static void identifyIfImageInsidePDFIsColoredOrBlackAndWhite(String dataDir) {
        // read source PDF file
        Document doc = new Document(dataDir + "PdfWith2Images.pdf");
        try {
            // iterate through all pages of PDF file
            for (Page page : (Iterable<Page>) doc.getPages()) {
                // create Image Placement Absorber instance
                ImagePlacementAbsorber abs = new ImagePlacementAbsorber();
                page.accept(abs);
                for (ImagePlacement ia : (Iterable<ImagePlacement>) abs.getImagePlacements()) {
                    /* ColorType */
                    ColorType colorType = ia.getImage().getColorType();
                    switch (colorType) {
                        case Grayscale:
                            System.out.println("Grayscale Image");
                            break;
                        case Rgb:
                            System.out.println("Colored Image");
                            break;
                    }
                }
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
