package com.aspose.pdf.examples.AsposePdfFacades.Attachments;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;

import java.io.File;

public class AddAttachment {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Attachments/AddAttachment/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example addAttachment start");
        addAttachment(dataDir, outputDir);
        System.out.println("Example addAttachment end");
    }

    public static void addAttachment(String dataDir, String outputDir) {
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            contentEditor.bindPdf(dataDir + "AddAttachment.pdf");
            // add attachment
            contentEditor.addDocumentAttachment(dataDir + "test.txt", "Attachment Description");
            contentEditor.save(outputDir + "AddAttachment_out.pdf");
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
