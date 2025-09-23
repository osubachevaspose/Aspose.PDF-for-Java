package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.FormType;
import com.aspose.pdf.examples.Utils;

public class ConvertDynamicXFAFormToStandardAcroForm {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Forms/ConvertDynamicXFAFormToStandardAcroForm/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertDynamicXFAFormToStandardAcroForm start");
        convertDynamicXFAFormToStandardAcroForm(dataDir, outputDir);
        System.out.println("Example convertDynamicXFAFormToStandardAcroForm end");
    }

    public static void convertDynamicXFAFormToStandardAcroForm(String dataDir, String outputDir) {
        // Load dynamic XFA form
        Document doc = new Document(dataDir + "FormDataXfa_in.pdf");
        try {
            // Set the form fields type as standard AcroForm
            doc.getForm().setType(FormType.Standard);
            // Save the resultant PDF
            doc.save(outputDir + "Standard_AcroForm.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
