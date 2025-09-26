package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;
import com.aspose.pdf.devices.JpegDevice;
import com.aspose.pdf.devices.Resolution;
import com.aspose.pdf.examples.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConvertPDFPagesToJPEGImage {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/ConvertPDFPagesToJPEGImage/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example convertAllPagesToJPEGImages start");
        convertAllPagesToJPEGImages(dataDir, outputDir);
        System.out.println("Example convertAllPagesToJPEGImages end");

        System.out.println("Example convertOnePDFPageToJPEGImage start");
        convertOnePDFPageToJPEGImage(dataDir, outputDir);
        System.out.println("Example convertOnePDFPageToJPEGImage end");
    }

    public static void convertAllPagesToJPEGImages(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Loop through all the pages of PDF file
            for (int i = 1; i <= doc.getPages().size(); i++) {
                // Create stream object to save the output image
                FileOutputStream imageStream = new FileOutputStream(outputDir + "Converted_Image" + i + ".jpg");
                // Create Resolution object
                Resolution resolution = new Resolution(300);
                // Create JpegDevice object where second argument indicates the quality of
                // resultant image
                JpegDevice jpegDevice = new JpegDevice(resolution, 100);
                // Convert a particular page and save the image to stream
                jpegDevice.process(doc.getPages().get_Item(i), imageStream);
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

    public static void convertOnePDFPageToJPEGImage(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Create stream object to save the output image
            FileOutputStream imageStream = new FileOutputStream(outputDir + "Converted_Image.jpg");
            // Create JPEG device with specified attributes
            // Quality [0-100], 100 is Maximum
            // Create Resolution object
            Resolution resolution = new Resolution(300);
            // Create JpegDevice object where second argument indicates the quality of
            // resultant image
            JpegDevice jpegDevice = new JpegDevice(resolution, 100);
            // Convert a particular page and save the image to stream
            jpegDevice.process(doc.getPages().get_Item(1), imageStream);
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
