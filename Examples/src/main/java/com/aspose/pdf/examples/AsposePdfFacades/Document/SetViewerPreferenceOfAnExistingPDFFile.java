package com.aspose.pdf.examples.AsposePdfFacades.Document;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;
import com.aspose.pdf.facades.ViewerPreference;

public class SetViewerPreferenceOfAnExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Document/SetViewerPreferenceOfAnExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example setViewerPreferenceOfAnExistingPDFFile start");
        setViewerPreferenceOfAnExistingPDFFile(dataDir, outputDir);
        System.out.println("Example setViewerPreferenceOfAnExistingPDFFile end");
    }

    public static void setViewerPreferenceOfAnExistingPDFFile(String dataDir, String outputDir) {
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            // open document
            contentEditor.bindPdf(dataDir + "input.pdf");
            // change Viewer Preferences
            contentEditor.changeViewerPreference(ViewerPreference.PAGE_MODE_FULL_SCREEN);
            // save output PDF file
            contentEditor.save(outputDir + "ChangePreference_output.pdf");
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
