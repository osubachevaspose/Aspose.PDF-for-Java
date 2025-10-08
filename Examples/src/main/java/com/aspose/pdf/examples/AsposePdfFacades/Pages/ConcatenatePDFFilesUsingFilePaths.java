package com.aspose.pdf.examples.AsposePdfFacades.Pages;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfFileEditor;

import java.io.File;

public class ConcatenatePDFFilesUsingFilePaths {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Pages/ConcatenatePDFFilesUsingFilePaths/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example concatenatePDFFilesUsingFilePaths start");
        concatenatePDFFilesUsingFilePaths(dataDir, outputDir);
        System.out.println("Example concatenatePDFFilesUsingFilePaths end");

        System.out.println("Example settingCopyOutlines start");
        settingCopyOutlines();
        System.out.println("Example settingCopyOutlines end");
    }

    public static void concatenatePDFFilesUsingFilePaths(String dataDir, String outputDir) {
        // create PdfFileEditor object
        PdfFileEditor fileEditor = new PdfFileEditor();
        // concatenate files
        fileEditor.concatenate(dataDir + "input1.pdf", dataDir + "input2.pdf", outputDir + "output.pdf");
    }

    public static void settingCopyOutlines() {
        PdfFileEditor fileEditor = new PdfFileEditor();
        fileEditor.setCopyOutlines(false);
    }
}
