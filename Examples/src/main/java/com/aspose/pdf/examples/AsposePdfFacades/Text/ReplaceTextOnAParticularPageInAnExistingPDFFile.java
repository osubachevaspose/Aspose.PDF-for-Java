package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;

public class ReplaceTextOnAParticularPageInAnExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Text/ReplaceTextOnAParticularPageInAnExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example replaceTextOnAParticularPageInAnExistingPDFFile start");
        replaceTextOnAParticularPageInAnExistingPDFFile(dataDir, outputDir);
        System.out.println("Example replaceTextOnAParticularPageInAnExistingPDFFile end");
    }

    public static void replaceTextOnAParticularPageInAnExistingPDFFile(String dataDir, String outputDir) {
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            // open input PDF
            contentEditor.bindPdf(dataDir + "4pages.pdf");
            // replace text on a particular page
            contentEditor.replaceText("Page", 2, "p.");
            // save output PDF
            contentEditor.save(outputDir + "ReplaceTextOnAParticularPage.pdf");
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
