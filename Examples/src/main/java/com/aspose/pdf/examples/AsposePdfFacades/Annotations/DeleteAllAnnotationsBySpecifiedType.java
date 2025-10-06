package com.aspose.pdf.examples.AsposePdfFacades.Annotations;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfAnnotationEditor;

public class DeleteAllAnnotationsBySpecifiedType {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Annotations/DeleteAllAnnotationsBySpecifiedType/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example deleteAllAnnotationsBySpecifiedType start");
        deleteAllAnnotationsBySpecifiedType(dataDir, outputDir);
        System.out.println("Example deleteAllAnnotationsBySpecifiedType end");
    }

    public static void deleteAllAnnotationsBySpecifiedType(String dataDir, String outputDir) {
        // open document
        PdfAnnotationEditor annotationEditor = new PdfAnnotationEditor();
        try {
            // open document
            annotationEditor.bindPdf(dataDir + "PdfWithAnnotation.pdf");
            // delete all annotations
            annotationEditor.deleteAnnotations("Text");
            // save updated PDF
            annotationEditor.save(outputDir + "output.pdf");
        } finally {
            if (annotationEditor != null)
                annotationEditor.close();
        }
    }
}
