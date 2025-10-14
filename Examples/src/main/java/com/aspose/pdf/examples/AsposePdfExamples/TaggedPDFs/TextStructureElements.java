package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ParagraphElement;

public class TextStructureElements {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/TaggedPDFs/TextStructureElements/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example textStructureElements start");
        textStructureElements(outputDir);
        System.out.println("Example textStructureElements end");
    }

    public static void textStructureElements(String outputDir) {
        // Create Pdf Document
        Document doc = new Document();
        try {
            // Get Content for work with TaggedPdf
            ITaggedContent taggedContent = doc.getTaggedContent();
            // Set Title and Language for Documnet
            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");
            // Get Root Structure Elements
            StructureElement rootElement = taggedContent.getRootElement();
            ParagraphElement paragraphElement = taggedContent.createParagraphElement();
            // Set Text to Text Structure Element
            paragraphElement.setText("Paragraph.");
            rootElement.appendChild(paragraphElement);
            // Save Tagged Pdf Document
            doc.save(outputDir + "TextStructureElement.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
