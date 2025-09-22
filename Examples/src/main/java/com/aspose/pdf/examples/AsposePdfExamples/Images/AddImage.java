package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;
import com.aspose.pdf.ImageFileType;
import com.aspose.pdf.examples.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AddImage {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example AddDicomImage start");
        AddDicomImage(dataDir, outputDir);
        System.out.println("Example AddDicomImage end");
    }

    public static void AddDicomImage(String dataDir, String outputDir) {
        try {
            // Load image into stream
            FileInputStream imageStream = new FileInputStream(new File(dataDir + "0002.dcm"));
            Document doc = new Document();
            try {
                doc.getPages().add();
                com.aspose.pdf.Image image = new com.aspose.pdf.Image();
                image.setFileType(ImageFileType.Dicom);
                image.setImageStream(imageStream);
                doc.getPages().get_Item(1).getParagraphs().add(image);
                // Save output as PDF format
                doc.save(outputDir + "PdfWithDicomImage_out.pdf");
            } finally {
                if (doc != null)
                    doc.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
