package com.aspose.pdf.examples.AsposePdfFacades.Pages;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfFileEditor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConcatenateArrayOfPDFFilesUsingStreams {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Pages/ConcatenateArrayOfPDFFilesUsingStreams/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example concatenateArrayOfPDFFilesUsingStreams start");
        concatenateArrayOfPDFFilesUsingStreams(dataDir, outputDir);
        System.out.println("Example concatenateArrayOfPDFFilesUsingStreams end");
    }

    public static void concatenateArrayOfPDFFilesUsingStreams(String dataDir, String outputDir) {
        try {
            // create PdfFileEditor object
            PdfFileEditor fileEditor = new PdfFileEditor();
            // array of input streams
            FileInputStream[] inputStreams = new FileInputStream[2];
            inputStreams[0] = new FileInputStream(dataDir + "input1.pdf");
            inputStreams[1] = new FileInputStream(dataDir + "input2.pdf");
            // output stream
            FileOutputStream outputStream = new FileOutputStream(outputDir + "output.pdf");
            // concatenate file
            fileEditor.concatenate(inputStreams, outputStream);
            outputStream.close();
            inputStreams[1].close();
            inputStreams[0].close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
