package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;

public class ReplaceImageInExistingPDFFile {

    public static void main(String[] args) throws Exception {
        // Open a document
        Document doc = new Document("input.pdf");
        try {
            // Replace a particular image
            doc.getPages().get_Item(1).getResources().getImages()
                    .replace(1, new java.io.FileInputStream(new java.io.File("apose.png")));
            // Save the updated PDF file
            doc.save("output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
