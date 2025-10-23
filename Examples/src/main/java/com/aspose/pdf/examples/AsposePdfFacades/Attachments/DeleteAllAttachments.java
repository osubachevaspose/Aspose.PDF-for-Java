package com.aspose.pdf.examples.AsposePdfFacades.Attachments;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;

public class DeleteAllAttachments {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Attachments/DeleteAllAttachments/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example deleteAllAttachments start");
        deleteAllAttachments(dataDir, outputDir);
        System.out.println("Example deleteAllAttachments end");
    }

    public static void deleteAllAttachments(String dataDir, String outputDir) {
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            contentEditor.bindPdf(dataDir + "DeleteAllAttachments.pdf");
            // delete attachments
            contentEditor.deleteAttachments();
            contentEditor.save(outputDir + "DeleteAllAttachments_out.pdf");
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
