package com.aspose.pdf.examples.AsposePdfFacades.Images;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;

public class ReplaceImageInAnExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Images/ReplaceImageInAnExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example replaceImageInAnExistingPDFFile start");
        replaceImageInAnExistingPDFFile(dataDir, outputDir);
        System.out.println("Example replaceImageInAnExistingPDFFile end");
    }

    public static void replaceImageInAnExistingPDFFile(String dataDir, String outputDir) {
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            // open input PDF
            contentEditor.bindPdf(dataDir + "input.pdf");
            // replace image on a particular page
            contentEditor.replaceImage(1, 1, dataDir + "aspose-logo.jpg");
            // save output PDF
            contentEditor.save(outputDir + "output.pdf");
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
