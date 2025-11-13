package com.aspose.pdf.examples.AsposePdfFacades.Pages;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfFileEditor;

import java.io.File;

public class ConcatenateArrayOfPDFFilesUsingFilePaths {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Pages/ConcatenateArrayOfPDFFilesUsingFilePaths/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example concatenateArrayOfPDFFilesUsingFilePaths start");
        concatenateArrayOfPDFFilesUsingFilePaths(dataDir, outputDir);
        System.out.println("Example concatenateArrayOfPDFFilesUsingFilePaths end");
    }

    public static void concatenateArrayOfPDFFilesUsingFilePaths(String dataDir, String outputDir) {
        // create PdfFileEditor object
        PdfFileEditor fileEditor = new PdfFileEditor();
        // array of files
        String[] filesArray = new String[2];
        filesArray[0] = dataDir + "input1.pdf";
        filesArray[1] = dataDir + "input2.pdf";
        // concatenate files
        fileEditor.concatenate(filesArray, outputDir + "output.pdf");
    }
}
