package com.aspose.pdf.examples.AsposePdfFacades.LinksActions;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;

import java.io.File;

public class RemoveAction {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/LinksActions/RemoveAction/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example removeAction start");
        removeAction(dataDir, outputDir);
        System.out.println("Example removeAction end");
    }

    public static void removeAction(String dataDir, String outputDir) {
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            contentEditor.bindPdf(dataDir + "RemoveOpenAction.pdf");
            contentEditor.removeDocumentOpenAction();
            // save updated PDF file
            contentEditor.save(outputDir + "RemoveOpenAction_out.pdf");
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
