package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;

public class HelloWorld {

    public static void main(String[] args) {
        // Initialize document object
        Document doc = new Document();
        try {
            // Add page
            Page page = doc.getPages().add();
            // Add text to new page
            page.getParagraphs().add(new TextFragment("Hello World!"));
            // Save updated PDF
            doc.save("HelloWorld_out.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
