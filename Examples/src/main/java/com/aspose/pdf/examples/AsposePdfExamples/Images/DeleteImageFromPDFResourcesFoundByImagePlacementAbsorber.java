package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;
import com.aspose.pdf.ImagePlacement;
import com.aspose.pdf.ImagePlacementAbsorber;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class DeleteImageFromPDFResourcesFoundByImagePlacementAbsorber {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/DeleteImageFromPDFResourcesFoundByImagePlacementAbsorber/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example deleteImageFromPDFResourcesFoundByImagePlacementAbsorber start");
        deleteImageFromPDFResourcesFoundByImagePlacementAbsorber(dataDir, outputDir);
        System.out.println("Example deleteImageFromPDFResourcesFoundByImagePlacementAbsorber end");
    }

    public static void deleteImageFromPDFResourcesFoundByImagePlacementAbsorber(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "input.pdf");
        try {
            for (Page page : doc.getPages()) {
                ImagePlacementAbsorber imagePlacementAbsorber = new ImagePlacementAbsorber();
                page.accept(imagePlacementAbsorber);
                for (ImagePlacement imagePlacement : imagePlacementAbsorber.getImagePlacements())
                    imagePlacement.getImage().delete();
            }
            doc.save(outputDir + "ImagesRemoved_output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
