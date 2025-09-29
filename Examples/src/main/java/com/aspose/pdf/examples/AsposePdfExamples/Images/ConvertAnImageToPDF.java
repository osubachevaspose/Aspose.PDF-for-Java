package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;
import com.aspose.pdf.Image;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.examples.Utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

public class ConvertAnImageToPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/ConvertAnImageToPDF/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example pdfImageApproach start");
        pdfImageApproach(dataDir, outputDir);
        System.out.println("Example pdfImageApproach end");

        System.out.println("Example addImageFromBufferedImage start");
        addImageFromBufferedImage(dataDir, outputDir);
        System.out.println("Example addImageFromBufferedImage end");
    }

    public static void pdfImageApproach(String dataDir, String outputDir) {
        // Instantiate Document Object
        Document doc = new Document();
        try {
            // Add a page to pages collection of document
            Page page = doc.getPages().add();
            // Set margins so image will fit, etc.
            page.getPageInfo().getMargin().setBottom(0);
            page.getPageInfo().getMargin().setTop(0);
            page.getPageInfo().getMargin().setLeft(0);
            page.getPageInfo().getMargin().setRight(0);
            page.setCropBox(new Rectangle(0, 0, 400, 400));
            // Create an image object
            Image image = new Image();
            // Add the image into paragraphs collection of the section
            page.getParagraphs().add(image);
            // Load the source image file to Stream object
            FileInputStream fis = new FileInputStream(dataDir + "source.tif");
            // Set the image file stream
            image.setImageStream(fis);
            // Save resultant PDF file
            doc.save(outputDir + "Image2PDF_DOM.pdf");
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void addImageFromBufferedImage(String dataDir, String outputDir) {
        // instantiate Document instance
        Document doc = new Document();
        try {
            // add a page to pages collection of Pdf file
            Page page = doc.getPages().add();
            // create image instance
            Image image = new Image();
            // create BufferedImage instance
            BufferedImage bufferedImage = ImageIO.read(new File(dataDir + "source.gif"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // write buffered Image to OutputStream instance
            ImageIO.write(bufferedImage, "gif", baos);
            baos.flush();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            // add image to paragraphs collection of first page
            page.getParagraphs().add(image);
            // set image stream as OutputStream holding Buffered image
            image.setImageStream(bais);
            // save resultant PDF file
            doc.save(outputDir + "BufferedImage.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
