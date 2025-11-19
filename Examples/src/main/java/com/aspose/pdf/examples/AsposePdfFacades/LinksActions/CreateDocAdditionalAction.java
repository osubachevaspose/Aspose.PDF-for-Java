package com.aspose.pdf.examples.AsposePdfFacades.LinksActions;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;

import java.io.File;

public class CreateDocAdditionalAction {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/LinksActions/CreateDocAdditionalAction/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example createDocAdditionalAction start");
        createDocAdditionalAction(dataDir, outputDir);
        System.out.println("Example createDocAdditionalAction end");
    }

    public static void createDocAdditionalAction(String dataDir, String outputDir) {
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            contentEditor.bindPdf(dataDir + "CreateDocumentLink.pdf");
            contentEditor.addDocumentAdditionalAction(PdfContentEditor.DOCUMENT_CLOSE,
                    "app.alert('Thank you for using Aspose products!');");
            // save updated PDF file
            contentEditor.save(outputDir + "CreateDocAdditionalAction_out.pdf");
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
