package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.Field;
import com.aspose.pdf.Form;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.examples.Utils;

public class GetFormFieldsFromSpecificRegionOfPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Forms/GetFormFieldsFromSpecificRegionOfPDFFile/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example getFormFieldsFromSpecificRegionOfPDFFile start");
        getFormFieldsFromSpecificRegionOfPDFFile(dataDir);
        System.out.println("Example getFormFieldsFromSpecificRegionOfPDFFile end");
    }

    public static void getFormFieldsFromSpecificRegionOfPDFFile(String dataDir) {
        // Open document
        Document doc = new Document(dataDir + "InlineField.pdf");
        try {
            // whole page: Rectangle(0, 0, 612, 792)
            // Create rectangle object to get fields in that area
            Rectangle rectangle = new Rectangle(0, 0, 300, 792);
            // Get the PDF form
            Form form = doc.getForm();
            // Get fields in the rectangular area
            Field[] fields = form.getFieldsInRect(rectangle);
            System.out.println("fields found: " + fields.length);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
