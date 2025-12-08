package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.Document.CallBackGetHocr;
import com.aspose.pdf.examples.Utils;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ConvertingNonSearchablePDFToSearchablePDFDocument {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/ConvertingNonSearchablePDFToSearchablePDFDocument/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example convertingNonSearchablePDFToSearchablePDFDocument start");
        convertingNonSearchablePDFToSearchablePDFDocument(dataDir, outputDir);
        System.out.println("Example convertingNonSearchablePDFToSearchablePDFDocument end");
    }

    public static void convertingNonSearchablePDFToSearchablePDFDocument(String dataDir, String outputDir) {
        // Create callBack - logic recognize text for pdf images.
        // Use outer OCR support HOCR standard(http://en.wikipedia.org/wiki/HOCR).
        // We have used free google tesseract OCR
        // (http://en.wikipedia.org/wiki/Tesseract_%28software%29)
        CallBackGetHocr cbgh = new CallBackGetHocr() {
            @SuppressWarnings("deprecation")
            @Override
            public String invoke(java.awt.image.BufferedImage img) {
                File outputfile = new File(outputDir + "test.jpg");
                try {
                    ImageIO.write(img, "jpg", outputfile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    String tesseractCommand = "tesseract" + " " + outputDir + "test.jpg" + " " + outputDir + "out hocr";
                    java.lang.Process process = Runtime.getRuntime().exec(tesseractCommand);
                    System.out.println(tesseractCommand);
                    process.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // reading out.html to string
                File file = new File(outputDir + "out.html");
                StringBuilder fileContents = new StringBuilder((int) file.length());
                Scanner scanner = null;
                try {
                    scanner = new Scanner(file);
                    String lineSeparator = System.getProperty("line.separator");
                    while (scanner.hasNextLine()) {
                        fileContents.append(scanner.nextLine() + lineSeparator);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    if (scanner != null)
                        scanner.close();
                }
                // deleting temp files
                File fileOut = new File(outputDir + "out.html");
                if (fileOut.exists()) {
                    fileOut.delete();
                }
                File fileTest = new File(outputDir + "test.jpg");
                if (fileTest.exists()) {
                    fileTest.delete();
                }
                return fileContents.toString();
            }
        };
        Document doc = new Document(outputDir + "outFile.pdf");
        try {
            doc.convert(cbgh);
            doc.save(outputDir + "output971.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}