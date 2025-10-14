package com.aspose.pdf.examples.AsposePdfFacades.Forms;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.Form;

public class FlattenAllFieldsInExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Forms/FlattenAllFieldsInExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example flattenAllFieldsInExistingPDFFile start");
        flattenAllFieldsInExistingPDFFile(dataDir, outputDir);
        System.out.println("Example flattenAllFieldsInExistingPDFFile end");
    }

    public static void flattenAllFieldsInExistingPDFFile(String dataDir, String outputDir) {
        Form form = new Form();
        try {
            // bind source PDF file
            form.bindPdf(dataDir + "FormDataXfa_in.pdf");
            // flatten fields
            form.flattenAllFields();
            // save output
            form.save(outputDir + "output.pdf");
        } finally {
            if (form != null)
                form.close();
        }
    }
}
