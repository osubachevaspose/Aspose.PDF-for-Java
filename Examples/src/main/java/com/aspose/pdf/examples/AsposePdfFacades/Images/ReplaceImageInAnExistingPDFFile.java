package com.aspose.pdf.examples.AsposePdfFacades.Images;

import com.aspose.pdf.facades.PdfContentEditor;

public class ReplaceImageInAnExistingPDFFile {

    public static void main(String[] args) {
        PdfContentEditor contentEditor = new PdfContentEditor();
        try {
            // open input PDF
            contentEditor.bindPdf("Input.pdf");
            // replace image on a particular page
            contentEditor.replaceImage(1, 1, "Aspose-logo.bmp");
            // save output PDF
            contentEditor.save("Output.pdf");
        } finally {
            if (contentEditor != null)
                contentEditor.close();
        }
    }
}
