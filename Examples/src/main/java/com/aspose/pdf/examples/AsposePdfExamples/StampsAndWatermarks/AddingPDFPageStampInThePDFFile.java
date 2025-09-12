package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.PdfPageStamp;
import com.aspose.pdf.Rotation;

public class AddingPDFPageStampInThePDFFile {

    public static void main(String[] args) {
        String myDir = "PathToDir";
        // open document
        Document doc = new Document(myDir + "stamp.pdf");
        try {
            // create page stamp
            PdfPageStamp pageStamp = new PdfPageStamp(doc.getPages().get_Item(1));
            pageStamp.setBackground(true);
            pageStamp.setXIndent(100);
            pageStamp.setYIndent(100);
            pageStamp.setRotate(Rotation.on180);
            Document newDoc = new Document(myDir + "input.pdf");
            try {
                // add stamp to particular page
                newDoc.getPages().get_Item(1).addStamp(pageStamp);
                // save output document
                newDoc.save(myDir + "output_pdfpagestamp.pdf");
            } finally {
                if (newDoc != null)
                    newDoc.close();
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
