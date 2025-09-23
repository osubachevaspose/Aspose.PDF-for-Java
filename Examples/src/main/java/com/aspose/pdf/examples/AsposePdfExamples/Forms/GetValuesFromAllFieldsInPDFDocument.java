package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.Field;
import com.aspose.pdf.examples.Utils;

public class GetValuesFromAllFieldsInPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Forms/GetValuesFromAllFieldsInPDFDocument/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example getValuesFromAllFieldsInPDFDocument start");
        getValuesFromAllFieldsInPDFDocument(dataDir);
        System.out.println("Example getValuesFromAllFieldsInPDFDocument end");
    }

    public static void getValuesFromAllFieldsInPDFDocument(String dataDir) {
        // Open document
        Document doc = new Document(dataDir + "InlineField.pdf");
        try {
            Field[] fields = doc.getForm().getFields();
            for (int i = 0; i < fields.length; i++) {
                System.out.println(i + ": FullName: " + fields[i].getFullName());
                System.out.println(i + ": Value: " + fields[i].getValue());
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
