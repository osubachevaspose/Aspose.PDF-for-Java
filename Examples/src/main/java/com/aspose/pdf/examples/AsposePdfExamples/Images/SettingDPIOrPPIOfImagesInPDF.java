package com.aspose.pdf.examples.AsposePdfExamples.Images;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.aspose.pdf.Document;
import com.aspose.pdf.Image;
import com.aspose.pdf.Page;
import com.aspose.pdf.XImageCollection;

public class SettingDPIOrPPIOfImagesInPDF {

    public static void main(String[] args) throws FileNotFoundException {
        String myDir = "pathTodir";
        FileInputStream in = new FileInputStream(myDir + "image.jpg");
        // Test PDF creation
        Document doc = new Document();
        try {
            Page page = doc.getPages().add();
            Image image1 = new Image();
            image1.setImageStream(in);
            image1.setFixHeight(page.getMediaBox().getHeight() / 4);
            image1.setFixWidth(page.getMediaBox().getWidth() / 2);
            page.getParagraphs().add(image1);
            page.getPageInfo().getMargin().setLeft(5);
            page.getPageInfo().getMargin().setRight(0);
            page.getPageInfo().getMargin().setTop(0);
            page.getPageInfo().getMargin().setBottom(0);
            doc.save(myDir + "image.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
        // Internal image resolution change
        Document newDoc = new Document(myDir + "image.pdf");
        try {
            XImageCollection images = newDoc.getPages().get_Item(1).getResources().getImages();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            images.get_Item(1).save(baos, 10, 10);// define horizontal and vertical // resolutions
            images.get_Item(1).replace(new ByteArrayInputStream(baos.toByteArray()));
            newDoc.save(myDir + "imageWithNewResolution.pdf");
        } finally {
            if (newDoc != null)
                newDoc.close();
        }
    }
}
