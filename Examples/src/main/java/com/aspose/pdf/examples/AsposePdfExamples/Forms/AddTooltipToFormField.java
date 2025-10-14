package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextBoxField;
import com.aspose.pdf.examples.Utils;

public class AddTooltipToFormField {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Forms/AddTooltipToFormField/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addTooltipToFormField start");
        addTooltipToFormField(dataDir, outputDir);
        System.out.println("Example addTooltipToFormField end");
    }

    public static void addTooltipToFormField(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "TextBoxField.pdf");
        try {
            // Get a field
            TextBoxField textBoxField = (TextBoxField) doc.getForm().get("textbox1");
            // Set the tooltip for textfield
            textBoxField.setAlternateName("Text box tool tip");
            // Save modified document
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
