package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.TextReplaceOptions;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;

public class ReplaceTextInAnExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Text/ReplaceTextInAnExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example replaceTextInAnExistingPDFFile start");
        replaceTextInAnExistingPDFFile(dataDir, outputDir);
        System.out.println("Example replaceTextInAnExistingPDFFile end");
    }

    public static void replaceTextInAnExistingPDFFile(String dataDir, String outputDir) {
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            // open input PDF
            contentEditor.bindPdf(dataDir + "4pages.pdf");
            // replace text on all pages
            contentEditor.getTextReplaceOptions().setReplaceScope(TextReplaceOptions.Scope.REPLACE_ALL);
            contentEditor.replaceText("Page", "p.");
            // save output PDF
            contentEditor.save(outputDir + "ReplaceTextOnAllPages.pdf");
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
