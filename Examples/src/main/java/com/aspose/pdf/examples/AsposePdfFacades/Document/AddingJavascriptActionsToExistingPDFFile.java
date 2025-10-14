package com.aspose.pdf.examples.AsposePdfFacades.Document;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;

import java.awt.Color;
import java.awt.Rectangle;

public class AddingJavascriptActionsToExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Document/AddingJavascriptActionsToExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addingJavascriptActionsToExistingPDFFile start");
        addingJavascriptActionsToExistingPDFFile(dataDir, outputDir);
        System.out.println("Example addingJavascriptActionsToExistingPDFFile end");
    }

    public static void addingJavascriptActionsToExistingPDFFile(String dataDir, String outputDir) {
        // create PdfContentEditor object to manipulate contents
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            contentEditor.bindPdf(dataDir + "input.pdf");
            // create Javascript link
            Rectangle rect = new Rectangle(50, 50, 200, 200);
            Color clr = new Color(0, 255, 0);
            String code = "app.alert('welcome to aspose!');";
            contentEditor.createJavaScriptLink(code, rect, 1, clr);
            // save the output file
            contentEditor.save(outputDir + "JavaScriptAdded_output.pdf");
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
