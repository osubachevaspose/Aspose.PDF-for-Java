package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationSelector;
import com.aspose.pdf.Document;
import com.aspose.pdf.ImagePlacement;
import com.aspose.pdf.ImagePlacementAbsorber;
import com.aspose.pdf.LinkAnnotation;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.examples.Utils;

public class DeleteImageFromPDFResourcesFoundByImagePlacementAbsorber {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/DeleteImageFromPDFResourcesFoundByImagePlacementAbsorber/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example deleteImageFromPDFResourcesFoundByImagePlacementAbsorber start");
        deleteImageFromPDFResourcesFoundByImagePlacementAbsorber(dataDir, outputDir);
        System.out.println("Example deleteImageFromPDFResourcesFoundByImagePlacementAbsorber end");
    }

    public static void deleteImageFromPDFResourcesFoundByImagePlacementAbsorber(String dataDir, String outputDir) {
        // Document doc = new Document(dataDir + "mde1257231R.pdf");
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Extract actions
            AnnotationSelector selector = new AnnotationSelector(
                    new LinkAnnotation(doc.getPages().get_Item(1), Rectangle.getTrivial()));
            doc.getPages().get_Item(1).accept(selector);
            java.util.List list = selector.getSelected();
            for (int i = 0; i < list.size(); i++) {
                Annotation annotation = (Annotation) list.get(i);
                // Create ImagePlacementAbsorber object to perform image placement search
                ImagePlacementAbsorber abs = new ImagePlacementAbsorber();
                // Accept the absorber for all the pages
                doc.getPages().get_Item(1).accept(abs);
                // Loop through all ImagePlacements
                for (ImagePlacement imagePlacement : (Iterable<ImagePlacement>) abs.getImagePlacements()) {
                    // Determine if URY of Hyperlink and image are matching
                    if ((int) annotation.getRect().getURY() == (int) imagePlacement.getRectangle().getURY()) {
                        System.out.println("Image with Hyperlink...");
                        // delete a particular image from resources
                        imagePlacement.getImage().delete();
                    }
                }
            }
            // Save updated document
            doc.save(outputDir + "ImageRemoved_output_3.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
