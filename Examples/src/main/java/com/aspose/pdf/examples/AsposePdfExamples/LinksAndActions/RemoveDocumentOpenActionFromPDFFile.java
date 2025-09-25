package com.aspose.pdf.examples.AsposePdfExamples.LinksAndActions;

import com.aspose.pdf.Document;

public class RemoveDocumentOpenActionFromPDFFile {

    public static void main(String[] args) {
        // Open document
        Document doc = new Document("input.pdf");
        try {
            // Remove document open action
            doc.setOpenAction(null);
            // Save updated document
            doc.save("output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
