package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextBoxField;
import com.aspose.pdf.examples.Utils;

public class ModifyFormFieldInPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Forms/ModifyFormFieldInPDFDocument/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example modifyFormFieldInPDFDocument start");
        modifyFormFieldInPDFDocument(dataDir, outputDir);
        System.out.println("Example modifyFormFieldInPDFDocument end");
    }

    public static void modifyFormFieldInPDFDocument(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Get a field
            TextBoxField textBoxField = (TextBoxField) doc.getForm().get("textbox1");
            // Modify the field value
            textBoxField.setValue("Updated Value");
            // Set the field as read only
            textBoxField.setReadOnly(true);
            // Save the updated document
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
