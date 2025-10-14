package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.ImageStamp;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfFileStamp;
import com.aspose.pdf.facades.Stamp;

public class ControlImageQualityWhenAddingImageStamp {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/StampsAndWatermarks/ControlImageQualityWhenAddingImageStamp/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example domApproach start");
        domApproach(dataDir, outputDir);
        System.out.println("Example domApproach end");

        System.out.println("Example facadesApproach start");
        facadesApproach(dataDir, outputDir);
        System.out.println("Example facadesApproach end");
    }

    public static void domApproach(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "PdfWithText.pdf");
        try {
            ImageStamp stamp = new ImageStamp(dataDir + "butterfly.jpg");
            // Specify the quality of stamp image
            stamp.setQuality(10);
            doc.getPages().get_Item(1).addStamp(stamp);
            // Save updated document
            doc.save(outputDir + "out.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void facadesApproach(String dataDir, String outputDir) {
        PdfFileStamp fileStamp = new PdfFileStamp();
        try {
            fileStamp.bindPdf(dataDir + "PdfWithText.pdf");
            Stamp stamp = new Stamp();
            stamp.bindImage(dataDir + "butterfly.jpg");
            stamp.setQuality(10);
            fileStamp.addStamp(stamp);
            fileStamp.save(outputDir + "34959-1.pdf");
        } finally {
            if (fileStamp != null)
                fileStamp.close();
        }
    }
}
