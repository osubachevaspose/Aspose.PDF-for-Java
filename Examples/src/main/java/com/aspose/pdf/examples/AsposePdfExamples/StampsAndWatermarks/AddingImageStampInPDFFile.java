package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.ImageStamp;
import com.aspose.pdf.Rotation;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class AddingImageStampInPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/StampsAndWatermarks/AddingImageStampInPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example addingImageStampInPDFFile start");
        addingImageStampInPDFFile(dataDir, outputDir);
        System.out.println("Example addingImageStampInPDFFile end");
    }

    public static void addingImageStampInPDFFile(String dataDir, String outputDir) {
        // open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // create image stamp
            // ImageStamp imageStamp = new ImageStamp(dataDir + "sample.jpg");
            ImageStamp imageStamp = new ImageStamp(dataDir + "aspose-logo.jpg");
            imageStamp.setBackground(true);
            imageStamp.setXIndent(100);
            imageStamp.setYIndent(100);
            imageStamp.setHeight(300);
            imageStamp.setWidth(300);
            imageStamp.setRotate(Rotation.on270);
            imageStamp.setOpacity(0.5);
            // add stamp to particular page
            doc.getPages().get_Item(1).addStamp(imageStamp);
            // save output document
            doc.save(outputDir + "PageNumberStamp_output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
