package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;
import com.aspose.pdf.devices.PngDevice;
import com.aspose.pdf.devices.Resolution;
import com.aspose.pdf.examples.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConvertPDFPagesToPNGImages {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/ConvertPDFPagesToPNGImages/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example convertAllPDFPagesToPNGImages start");
        convertAllPDFPagesToPNGImages(dataDir, outputDir);
        System.out.println("Example convertAllPDFPagesToPNGImages end");

        System.out.println("Example convertOnePageToPNGImage start");
        convertOnePageToPNGImage(dataDir, outputDir);
        System.out.println("Example convertOnePageToPNGImage end");
    }

    public static void convertAllPDFPagesToPNGImages(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Loop through all the pages of PDF file
            for (int i = 1; i <= doc.getPages().size(); i++) {
                // Create stream object to save the output image
                FileOutputStream imageStream = new FileOutputStream(outputDir + "Converted_Image" + i + ".png");
                // Create Resolution object
                Resolution resolution = new Resolution(300);
                // Create PngDevice object with particular resolution
                PngDevice pngDevice = new PngDevice(resolution);
                // Convert a particular page and save the image to stream
                pngDevice.process(doc.getPages().get_Item(i), imageStream);
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

    public static void convertOnePageToPNGImage(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Create stream object to save the output image
            FileOutputStream imageStream = new FileOutputStream(outputDir + "Converted_Image.png");
            // Create Resolution object
            Resolution resolution = new Resolution(300);
            // Create PngDevice object with particular resolution
            PngDevice pngDevice = new PngDevice(resolution);
            // Convert a particular page and save the image to stream
            pngDevice.process(doc.getPages().get_Item(1), imageStream);
            // Close the stream
            imageStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
