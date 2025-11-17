package com.aspose.pdf.examples.AsposePdfFacades.Attachments;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AddAttachmentStream {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Attachments/AddAttachmentStream/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example addAttachmentStream start");
        addAttachmentStream(dataDir, outputDir);
        System.out.println("Example addAttachmentStream end");
    }

    public static void addAttachmentStream(String dataDir, String outputDir) {
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            contentEditor.bindPdf(dataDir + "AddAttachment-Stream.pdf");
            FileInputStream fileStream = new FileInputStream(dataDir + "test.txt");
            // add attachment
            contentEditor.addDocumentAttachment(fileStream, "Attachment Name", "Attachment Description");
            contentEditor.save(outputDir + "AddAttachment-Stream_out.pdf");
            fileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
