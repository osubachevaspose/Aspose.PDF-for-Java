package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class DeleteParticularFormFieldFromPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Forms/DeleteParticularFormFieldFromPDFDocument/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example deleteParticularFormFieldFromPDFDocument start");
        deleteParticularFormFieldFromPDFDocument(dataDir, outputDir);
        System.out.println("Example deleteParticularFormFieldFromPDFDocument end");
    }

    public static void deleteParticularFormFieldFromPDFDocument(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "TextBoxField.pdf");
        try {
            // Delete a named field by name
            doc.getForm().delete("textbox1");
            // Save the modified PDF
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
