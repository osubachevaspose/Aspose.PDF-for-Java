package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;
import com.aspose.pdf.devices.ColorDepth;
import com.aspose.pdf.devices.CompressionType;
import com.aspose.pdf.devices.Resolution;
import com.aspose.pdf.devices.TiffDevice;
import com.aspose.pdf.devices.TiffSettings;
import com.aspose.pdf.examples.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConvertPDFPagesToTIFFImage {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/ConvertPDFPagesToTIFFImage/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example convertAllPDFPagesToTIFFImages start");
        convertAllPDFPagesToTIFFImages(dataDir, outputDir);
        System.out.println("Example convertAllPDFPagesToTIFFImages end");

        System.out.println("Example convertOnePageToTIFF start");
        convertOnePageToTIFF(dataDir, outputDir);
        System.out.println("Example convertOnePageToTIFF end");
    }

    public static void convertAllPDFPagesToTIFFImages(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Create stream object to save the output image
            FileOutputStream imageStream = new FileOutputStream(outputDir + "all_pages.tiff");
            // Create Resolution object
            Resolution resolution = new Resolution(300);
            // instantiate TiffSettings object
            TiffSettings tiffSettings = new TiffSettings();
            // set the compression of resultant TIFF image
            tiffSettings.setCompression(CompressionType.CCITT4);
            // set the color depth for resultant image
            tiffSettings.setDepth(ColorDepth.Format8bpp);
            // skip blank pages while rendering PDF to TIFF
            tiffSettings.setSkipBlankPages(true);
            // Create TiffDevice object with particular resolution
            TiffDevice tiffDevice = new TiffDevice(resolution, tiffSettings);
            // Convert a all pages of PDF file to TIFF format
            tiffDevice.process(doc, imageStream);
            // Close the stream
            imageStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void convertOnePageToTIFF(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Create stream object to save the output image
            FileOutputStream imageStream = new FileOutputStream(outputDir + "one_page.tiff");
            // Create Resolution object
            Resolution resolution = new Resolution(300);
            // instantiate TiffSettings object
            TiffSettings tiffSettings = new TiffSettings();
            // set the compression of resultant TIFF image
            tiffSettings.setCompression(CompressionType.CCITT4);
            // set the color depth for resultant image
            tiffSettings.setDepth(ColorDepth.Format8bpp);
            // skip blank pages while rendering PDF to TIFF
            tiffSettings.setSkipBlankPages(true);
            // Create TiffDevice object with particular resolution
            TiffDevice tiffDevice = new TiffDevice(resolution, tiffSettings);
            // Convert a particular page (Page 1) and save the image to stream
            tiffDevice.process(doc, 1, 1, imageStream);
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
