package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class DeleteImagesFromThePDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/DeleteImagesFromThePDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example deleteImagesFromThePDFFile start");
        deleteImagesFromThePDFFile(dataDir, outputDir);
        System.out.println("Example deleteImagesFromThePDFFile end");
    }

    public static void deleteImagesFromThePDFFile(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "PdfWith2Images.pdf");
        try {
            // Delete a particular image
            doc.getPages().get_Item(1).getResources().getImages().delete(1);
            // Save the updated PDF file
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
