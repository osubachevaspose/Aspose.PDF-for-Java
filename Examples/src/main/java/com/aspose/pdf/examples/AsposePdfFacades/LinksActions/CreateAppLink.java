package com.aspose.pdf.examples.AsposePdfFacades.LinksActions;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;

import java.io.File;

public class CreateAppLink {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/LinksActions/CreateAppLink/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example createAppLink start");
        createAppLink(dataDir, outputDir);
        System.out.println("Example createAppLink end");
    }

    public static void createAppLink(String dataDir, String outputDir) {
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            // open document
            contentEditor.bindPdf(dataDir + "CreateApplicationLink.pdf");
            java.awt.Rectangle rect = new java.awt.Rectangle(100, 100, 200, 200);
            contentEditor.createApplicationLink(rect, dataDir + "test.txt", 1);
            // save updated PDF file
            contentEditor.save(outputDir + "CreateApplicationLink_out.pdf");
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
