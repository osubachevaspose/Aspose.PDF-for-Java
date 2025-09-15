package com.aspose.pdf.examples.AsposePdfFacades.Forms;

import com.aspose.pdf.facades.Form;

public class FlattenAllFieldsInExistingPDFFile {

    public static void main(String[] args) {
        Form form = new Form();
        try {
            // bind source PDF file
            form.bindPdf("input.pdf");
            // flatten fields
            form.flattenAllFields();
            // save output
            form.save("output.pdf");
        } finally {
            if (form != null)
                form.close();
        }
    }
}
