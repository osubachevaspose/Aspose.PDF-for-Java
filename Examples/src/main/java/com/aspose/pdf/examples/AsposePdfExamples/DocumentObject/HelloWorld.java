package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.Utils;

public class HelloWorld {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/HelloWorld/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example helloWorld start");
        helloWorld(outputDir);
        System.out.println("Example helloWorld end");
    }

    public static void helloWorld(String outputDir) {
        // Initialize document object
        Document doc = new Document();
        try {
            // Add page
            Page page = doc.getPages().add();
            // Add text to new page
            page.getParagraphs().add(new TextFragment("Hello World!"));
            // Save updated PDF
            doc.save(outputDir + "HelloWorld_out.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
