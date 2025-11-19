package com.aspose.pdf.examples.AsposePdfFacades.LinksActions;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;

import java.io.File;

public class CreateDocLink {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/LinksActions/CreateDocLink/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example createDocLink start");
        createDocLink(dataDir, outputDir);
        System.out.println("Example createDocLink end");
    }

    public static void createDocLink(String dataDir, String outputDir) {
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            // open document
            contentEditor.bindPdf(dataDir + "CreateDocumentLink.pdf");
            java.awt.Rectangle rect = new java.awt.Rectangle(100, 100, 200, 200);
            contentEditor.createPdfDocumentLink(rect, dataDir + "RemoveOpenAction.pdf", 1, 4);
            // save updated PDF file
            contentEditor.save(outputDir + "CreateDocLink_out.pdf");
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
