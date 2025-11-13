package com.aspose.pdf.examples.AsposePdfFacades.Annotations;

import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfAnnotationEditor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExportAnnotationsFromPDFFileToXFDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Annotations/ExportAnnotationsFromPDFFileToXFDF/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example exportAnnotationsFromPDFFileToXFDF start");
        exportAnnotationsFromPDFFileToXFDF(dataDir, outputDir);
        System.out.println("Example exportAnnotationsFromPDFFileToXFDF end");
    }

    public static void exportAnnotationsFromPDFFileToXFDF(String dataDir, String outputDir) {
        // create PdfAnnotationEditor object
        PdfAnnotationEditor annotationEditor = new PdfAnnotationEditor();
        try {
            // open PDF document
            annotationEditor.bindPdf(dataDir + "PdfWithAnnotation.pdf");
            // import annotations
            AnnotationType[] annotTypes = new AnnotationType[] {
                    com.aspose.pdf.AnnotationType.Text, com.aspose.pdf.AnnotationType.Highlight };
            FileOutputStream fileStream = new FileOutputStream(outputDir + "annotations.xfdf");
            annotationEditor.exportAnnotationsXfdf(fileStream, 1, 5, annotTypes);
            fileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (annotationEditor != null)
                annotationEditor.close();
        }
    }
}
