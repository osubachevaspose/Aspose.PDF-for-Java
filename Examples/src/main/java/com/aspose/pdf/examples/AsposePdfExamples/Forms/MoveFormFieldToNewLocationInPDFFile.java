package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TextBoxField;
import com.aspose.pdf.examples.Utils;

public class MoveFormFieldToNewLocationInPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Forms/MoveFormFieldToNewLocationInPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example moveFormFieldToNewLocationInPDFFile start");
        moveFormFieldToNewLocationInPDFFile(dataDir, outputDir);
        System.out.println("Example moveFormFieldToNewLocationInPDFFile end");
    }

    public static void moveFormFieldToNewLocationInPDFFile(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Get a field
            TextBoxField textBoxField = (TextBoxField) doc.getForm().get("textbox1");
            // Modify the field location
            textBoxField.setRect(new Rectangle(300, 400, 600, 500));
            // Save the modified document
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
