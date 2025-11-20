package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextBoxField;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class FillFormFieldInPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Forms/FillFormFieldInPDFDocument/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example fillFormFieldInPDFDocument start");
        fillFormFieldInPDFDocument(dataDir, outputDir);
        System.out.println("Example fillFormFieldInPDFDocument end");
    }

    public static void fillFormFieldInPDFDocument(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "TextBoxField.pdf");
        try {
            // Get a field
            TextBoxField textBoxField = (TextBoxField) doc.getForm().get("textbox1");
            // Set the field value
            textBoxField.setValue("Value of TextField");
            // Save the updated document
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
