package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.PdfPageStamp;
import com.aspose.pdf.Rotation;
import com.aspose.pdf.examples.Utils;

public class AddingPDFPageStampInThePDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/StampsAndWatermarks/AddingPDFPageStampInThePDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addingPDFPageStampInThePDFFile start");
        addingPDFPageStampInThePDFFile(dataDir, outputDir);
        System.out.println("Example addingPDFPageStampInThePDFFile end");
    }

    public static void addingPDFPageStampInThePDFFile(String dataDir, String outputDir) {
        // open document with stamp
        Document stampDoc = new Document(dataDir + "ImageStamp.pdf");
        try {
            // create page stamp
            PdfPageStamp pageStamp = new PdfPageStamp(stampDoc.getPages().get_Item(1));
            pageStamp.setBackground(true);
            pageStamp.setXIndent(100);
            pageStamp.setYIndent(100);
            pageStamp.setRotate(Rotation.on180);
            Document doc = new Document(dataDir + "input.pdf");
            try {
                // add stamp to particular page
                doc.getPages().get_Item(1).addStamp(pageStamp);
                // save output document
                doc.save(outputDir + "output_pdfpagestamp.pdf");
            } finally {
                if (doc != null)
                    doc.close();
            }
        } finally {
            if (stampDoc != null)
                stampDoc.close();
        }
    }
}
