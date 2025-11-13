package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;
import com.aspose.pdf.XImage;
import com.aspose.pdf.examples.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExtractImagesFromThePDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/ExtractImagesFromThePDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example extractImagesFromThePDFFile start");
        extractImagesFromThePDFFile(dataDir, outputDir);
        System.out.println("Example extractImagesFromThePDFFile end");
    }

    public static void extractImagesFromThePDFFile(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "PdfWith2Images.pdf");
        try {
            // Extract a particular image
            XImage xImage = doc.getPages().get_Item(1).getResources().getImages().get_Item(1);
            // Create stream object to save the output image
            FileOutputStream output = new FileOutputStream(outputDir + "output.jpg");
            // Save the output image
            xImage.save(output);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
