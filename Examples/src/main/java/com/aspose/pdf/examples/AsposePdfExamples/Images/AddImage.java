package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;
import com.aspose.pdf.Image;
import com.aspose.pdf.ImageFileType;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

public class AddImage {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/AddImage/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addDicomImage start");
        addDicomImage(dataDir, outputDir);
        System.out.println("Example addDicomImage end");

        System.out.println("Example addImageFromBufferedImageIntoPDF start");
        addImageFromBufferedImageIntoPDF(dataDir, outputDir);
        System.out.println("Example addImageFromBufferedImageIntoPDF end");
    }

    public static void addDicomImage(String dataDir, String outputDir) {
        Document doc = new Document();
        try {
            // Load image into stream
            doc.getPages().add();
            Image image = new Image();
            image.setFileType(ImageFileType.Dicom);
            FileInputStream imageStream = new FileInputStream(new File(dataDir + "0002.dcm"));
            image.setImageStream(imageStream);
            doc.getPages().get_Item(1).getParagraphs().add(image);
            // Save output as PDF format
            doc.save(outputDir + "PdfWithDicomImage_out.pdf");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void addImageFromBufferedImageIntoPDF(String dataDir, String outputDir) {
        Document doc = new Document();
        try {
            BufferedImage originalImage = ImageIO.read(new File(dataDir + "aspose-logo.jpg"));
            Page page = doc.getPages().add();
            page.getResources().getImages().add(originalImage);
            doc.save(outputDir + "bufferedImageAdded.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
