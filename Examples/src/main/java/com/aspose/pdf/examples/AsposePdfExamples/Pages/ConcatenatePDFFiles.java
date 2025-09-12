package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;

public class ConcatenatePDFFiles {

    public static void main(String[] args) {
        // Open the target document
        Document doc1 = new Document("input1.pdf");
        try {
            // Open the source document
            Document doc2 = new Document("input2.pdf");
            try {
                // Add the pages of the source document to the target document
                doc1.getPages().add(doc2.getPages());
            } finally {
                if (doc2 != null)
                    doc2.close();
            }
            // Save the concatenated output file (the target document)
            doc1.save("Concatenate_output.pdf");
        } finally {
            if (doc1 != null)
                doc1.close();
        }
    }
}
