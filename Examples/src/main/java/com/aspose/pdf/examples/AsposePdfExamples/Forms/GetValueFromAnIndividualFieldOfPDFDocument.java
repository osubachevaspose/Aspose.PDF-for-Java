package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextBoxField;
import com.aspose.pdf.examples.Utils;

public class GetValueFromAnIndividualFieldOfPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Forms/GetValueFromAnIndividualFieldOfPDFDocument/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example getValueFromAnIndividualFieldOfPDFDocument start");
        getValueFromAnIndividualFieldOfPDFDocument(dataDir);
        System.out.println("Example getValueFromAnIndividualFieldOfPDFDocument end");
    }

    public static void getValueFromAnIndividualFieldOfPDFDocument(String dataDir) {
        // Open a document
        Document doc = new Document(dataDir + "TextBoxField.pdf");
        try {
            // Get a field
            TextBoxField textBoxField = (TextBoxField) doc.getForm().get("textbox1");
            // Get the field name
            System.out.println("PartialName: " + textBoxField.getPartialName());
            // Get the field value
            System.out.println("Value: " + textBoxField.getValue());
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
