package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextExtractionOptions;
import com.aspose.pdf.devices.TextDevice;
import com.aspose.pdf.examples.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExtractTextFromPDFUsingTextDevice {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/ExtractTextFromPDFUsingTextDevice/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example extractTextFromParticularPage start");
        extractTextFromParticularPage(dataDir, outputDir);
        System.out.println("Example extractTextFromParticularPage end");

        System.out.println("Example extractTextFromAllPagesOfPDF start");
        extractTextFromAllPagesOfPDF(dataDir, outputDir);
        System.out.println("Example extractTextFromAllPagesOfPDF end");
    }

    public static void extractTextFromParticularPage(String dataDir, String outputDir) {
        // open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // create text device
            TextDevice textDevice = new TextDevice();
            // set text extraction options - set text extraction mode (Raw or Pure)
            TextExtractionOptions textExtOptions = new TextExtractionOptions(
                    TextExtractionOptions.TextFormattingMode.Raw);
            textDevice.setExtractionOptions(textExtOptions);
            // get the text from first page of PDF and save it to file format
            textDevice.process(doc.getPages().get_Item(1), outputDir + "ExtractedTextPage.txt");
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void extractTextFromAllPagesOfPDF(String dataDir, String outputDir) {
        // open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // text file in which extracted text will be saved
            FileOutputStream text_stream = new FileOutputStream(outputDir + "ExtractedTextAllPages.txt", false);
            // iterate through all the pages of PDF file
            for (Page page : (Iterable<Page>) doc.getPages()) {
                // create text device
                TextDevice textDevice = new TextDevice();
                // set text extraction options - set text extraction mode (Raw or
                // Pure)
                TextExtractionOptions textExtOptions = new TextExtractionOptions(
                        TextExtractionOptions.TextFormattingMode.Raw);
                textDevice.setExtractionOptions(textExtOptions);
                // get the text from pages of PDF and save it to OutputStream object
                textDevice.process(page, text_stream);
            }
            // close stream object
            text_stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
