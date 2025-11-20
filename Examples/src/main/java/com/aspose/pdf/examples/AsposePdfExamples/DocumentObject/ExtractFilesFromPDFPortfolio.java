package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.aspose.pdf.Collection;
import com.aspose.pdf.Document;
import com.aspose.pdf.EmbeddedFileCollection;
import com.aspose.pdf.FileSpecification;
import com.aspose.pdf.examples.Utils;

public class ExtractFilesFromPDFPortfolio {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/ExtractFilesFromPDFPortfolio/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example createPortfolioFile start");
        createPortfolioFile(dataDir, outputDir);
        System.out.println("Example createPortfolioFile end");

        System.out.println("Example deletePDFPortfolioFile start");
        deletePDFPortfolioFile(dataDir, outputDir);
        System.out.println("Example deletePDFPortfolioFile end");

        System.out.println("Example extractFilesFromPDFPortfolio start");
        extractFilesFromPDFPortfolio(dataDir, outputDir);
        System.out.println("Example extractFilesFromPDFPortfolio end");
    }

    public static void createPortfolioFile(String dataDir, String outputDir) {
        // Create new PDF Portfolio
        Document doc = new Document();
        try {
            doc.getPages().add();
            doc.setCollection(new Collection());
            FileSpecification fs1 = new FileSpecification(dataDir + "image.jpg");
            fs1.setDescription("file1");
            doc.getCollection().add(fs1);
            FileSpecification fs2 = new FileSpecification(dataDir + "image.png");
            fs2.setDescription("file2");
            doc.getCollection().add(fs2);

            System.out.println(outputDir);
            // save document with portfolio
            doc.save(outputDir + "PdfWithPortfolio.pdf");
        } finally {
            if (doc != null) {
                doc.close();
            }
        }

    }

    public static void deletePDFPortfolioFile(String dataDir, String outputDir) {
        // load source PDF Portfolio
        Document doc = new Document(dataDir + "PdfWithPortfolio.pdf");
        try {
            // delete all files from Embedded files collection
            doc.getEmbeddedFiles().delete();
            // save updated document
            doc.save(outputDir + "NotFolio.pdf");
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }

    public static void extractFilesFromPDFPortfolio(String dataDir, String outputDir) {
        // load source PDF Portfolio
        Document doc = new Document(dataDir + "PdfWithPortfolio.pdf");
        try {
            // get collection of embedded files
            EmbeddedFileCollection embeddedFiles = doc.getEmbeddedFiles();
            // iterate through individual file of Portfolio
            for (int counter = 1; counter <= doc.getEmbeddedFiles().size(); counter++) {
                FileSpecification fileSpecification = embeddedFiles.get_Item(counter);
                InputStream input = fileSpecification.getContents();
                File file = new File(fileSpecification.getName());
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    // create path for file from pdf
                    parentFile.mkdirs();
                }
                // create and extract file from pdf
                FileOutputStream output = new FileOutputStream(outputDir + file.getName(), true);
                byte[] buffer = new byte[4096];
                int n = 0;
                while (-1 != (n = input.read(buffer))) {
                    output.write(buffer, 0, n);
                }
                output.close();
                input.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null) {
                doc.close();
            }
        }
    }
}
