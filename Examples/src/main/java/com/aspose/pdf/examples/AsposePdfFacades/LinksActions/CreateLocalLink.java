package com.aspose.pdf.examples.AsposePdfFacades.LinksActions;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;

import java.io.File;

public class CreateLocalLink {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/LinksActions/CreateLocalLink/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example createLocalLink start");
        createLocalLink(dataDir, outputDir);
        System.out.println("Example createLocalLink end");
    }

    public static void createLocalLink(String dataDir, String outputDir) {
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            // open document
            contentEditor.bindPdf(dataDir + "CreateApplicationLink.pdf");
            java.awt.Rectangle rect = new java.awt.Rectangle(100, 100, 200, 200);
            contentEditor.createLocalLink(rect, 3, 1, java.awt.Color.RED);
            // save updated PDF file
            contentEditor.save(outputDir + "CreateLocalLink_out.pdf");
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
