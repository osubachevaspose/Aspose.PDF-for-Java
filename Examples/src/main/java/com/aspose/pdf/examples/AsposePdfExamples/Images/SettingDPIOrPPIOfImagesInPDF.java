package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;
import com.aspose.pdf.Image;
import com.aspose.pdf.Page;
import com.aspose.pdf.XImageCollection;
import com.aspose.pdf.examples.Utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SettingDPIOrPPIOfImagesInPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/SettingDPIOrPPIOfImagesInPDF/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example settingDPIOrPPIOfImagesInPDF start");
        settingDPIOrPPIOfImagesInPDF(dataDir, outputDir);
        System.out.println("Example settingDPIOrPPIOfImagesInPDF end");
    }

    public static void settingDPIOrPPIOfImagesInPDF(String dataDir, String outputDir) {
        // Test PDF creation
        Document doc = new Document();
        try {
            Page page = doc.getPages().add();
            Image image1 = new Image();
            FileInputStream in = new FileInputStream(dataDir + "aspose-logo.jpg");
            image1.setImageStream(in);
            image1.setFixHeight(page.getMediaBox().getHeight() / 4);
            image1.setFixWidth(page.getMediaBox().getWidth() / 2);
            page.getParagraphs().add(image1);
            page.getPageInfo().getMargin().setLeft(5);
            page.getPageInfo().getMargin().setRight(0);
            page.getPageInfo().getMargin().setTop(0);
            page.getPageInfo().getMargin().setBottom(0);
            doc.save(dataDir + "image.pdf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }

        // Internal image resolution change
        Document newDoc = new Document(dataDir + "image.pdf");
        try {
            XImageCollection images = newDoc.getPages().get_Item(1).getResources().getImages();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            images.get_Item(1).save(baos, 10, 10); // define horizontal and vertical resolutions
            images.get_Item(1).replace(new ByteArrayInputStream(baos.toByteArray()));
            newDoc.save(outputDir + "imageWithNewResolution.pdf");
        } finally {
            if (newDoc != null)
                newDoc.close();
        }

        new File(dataDir + "image.pdf").delete();
    }
}
