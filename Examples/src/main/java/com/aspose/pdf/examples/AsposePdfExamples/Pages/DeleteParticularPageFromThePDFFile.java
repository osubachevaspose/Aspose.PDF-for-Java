package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;

public class DeleteParticularPageFromThePDFFile {

    public static void main(String[] args) {
        // Open a document
        Document doc = new Document("Mobile Software.pdf");
        try {
            // Delete a page
            doc.getPages().delete(3);
            // Save the new PDF file
            doc.save("Updated_document.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
