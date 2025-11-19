package com.aspose.pdf.examples.AsposePdfFacades.Annotations;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;

import java.io.File;

public class AddAnnotationInAnExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Annotations/AddAnnotationInAnExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example addAnnotationInAnExistingPDFFile start");
        addAnnotationInAnExistingPDFFile(dataDir, outputDir);
        System.out.println("Example addAnnotationInAnExistingPDFFile end");
    }

    public static void addAnnotationInAnExistingPDFFile(String dataDir, String outputDir) {
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            // open document
            contentEditor.bindPdf(dataDir + "input.pdf");
            // create rectangle
            java.awt.Rectangle rect = new java.awt.Rectangle(50, 50, 100, 100);
            // create annotation
            contentEditor.createFreeText(rect, "Sample content", 1);
            // save updated PDF file
            contentEditor.save(outputDir + "output.pdf");
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
