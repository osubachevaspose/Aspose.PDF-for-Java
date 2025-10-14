package com.aspose.pdf.examples.AsposePdfExamples.Images;

import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.aspose.pdf.Document;
import com.aspose.pdf.devices.BmpDevice;
import com.aspose.pdf.devices.Resolution;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFPagesToBMPImage {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/ConvertPDFPagesToBMPImage/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example convertPDFPageToBMPImage start");
        convertPDFPageToBMPImage(dataDir, outputDir);
        System.out.println("Example convertPDFPageToBMPImage end");

        System.out.println("Example convertAllPDFPagesToBMPImages start");
        convertAllPDFPagesToBMPImages(dataDir, outputDir);
        System.out.println("Example convertAllPDFPagesToBMPImages end");
    }

    public static void convertPDFPageToBMPImage(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Create stream object to save the output image
            OutputStream imageStream = new FileOutputStream(outputDir + "Converted_Image.bmp");
            // Create Resolution object
            Resolution resolution = new Resolution(300);
            // Create BmpDevice object with particular resolution
            BmpDevice bmpDevice = new BmpDevice(resolution);
            // Convert a particular page and save the image to stream
            bmpDevice.process(doc.getPages().get_Item(1), imageStream);
            // Close the stream
            imageStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void convertAllPDFPagesToBMPImages(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Loop through all the pages of PDF file
            for (int i = 1; i <= doc.getPages().size(); i++) {
                // Create stream object to save the output image
                OutputStream imageStream = new FileOutputStream(outputDir + "Converted_Image" + i + ".bmp");
                // Create Resolution object
                Resolution resolution = new Resolution(300);
                // Create BmpDevice object with particular resolution
                BmpDevice bmpDevice = new BmpDevice(resolution);
                // Convert a particular page and save the image to stream
                bmpDevice.process(doc.getPages().get_Item(i), imageStream);
                // Close the stream
                imageStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
