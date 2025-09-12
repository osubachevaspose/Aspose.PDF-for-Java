package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.ImageStamp;
import com.aspose.pdf.facades.PdfFileStamp;
import com.aspose.pdf.facades.Stamp;

public class ControlImageQualityWhenAddingImageStamp {

    public static void main(String[] args) {
        domApproach();
        facadesApproach();
    }

    public static void domApproach() {
        Document doc = new Document("PdfWithText.pdf");
        try {
            ImageStamp stamp = new ImageStamp("butterfly.jpg");
            // Specify the quality of stamp image
            stamp.setQuality(10);
            doc.getPages().get_Item(1).addStamp(stamp);
            // Save updated document
            doc.save("out.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void facadesApproach() {
        PdfFileStamp fileStamp = new PdfFileStamp();
        try {
            fileStamp.bindPdf("PdfWithText.pdf");
            Stamp stamp1 = new Stamp();
            stamp1.bindImage("butterfly.jpg");
            stamp1.setQuality(10);
            fileStamp.addStamp(stamp1);
            fileStamp.save("34959-1.pdf");
        } finally {
            if (fileStamp != null)
                fileStamp.close();
        }
    }
}
