package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.tagged.ITaggedContent;

public class TaggedPDFContent {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/TaggedPDFs/TaggedPDFContent/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example taggedPDFContent start");
        taggedPDFContent(outputDir);
        System.out.println("Example taggedPDFContent end");
    }

    public static void taggedPDFContent(String outputDir) {
        // Create Pdf Document
        Document doc = new Document();
        try {
            // Get Content for work with TaggedPdf
            ITaggedContent taggedContent = doc.getTaggedContent();
            // Work with Tagged Pdf content
            // Set Title and Language for Documnet
            taggedContent.setTitle("Simple Tagged Pdf Document");
            taggedContent.setLanguage("en-US");
            // Save Tagged Pdf Document
            doc.save(outputDir + "TaggedPDFContent.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
