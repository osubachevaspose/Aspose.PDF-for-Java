package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.StructTreeRootElement;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;

public class RootStructure {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        System.out.println("============================");
        System.out.println("Example rootStructure start");
        rootStructure();
        System.out.println("Example rootStructure end");
    }

    // @SuppressWarnings("unused")
    public static void rootStructure() {
        // Create Pdf Document
        Document doc = new Document();
        try {
            // Get Content for work with TaggedPdf
            ITaggedContent taggedContent = doc.getTaggedContent();
            // Set Title and Language for Documnet
            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");
            // Properties StructTreeRootElement and RootElement are used for access to
            // StructTreeRoot object of pdf document and to root structure element (Document
            // structure element).
            StructTreeRootElement structTreeRootElement = taggedContent.getStructTreeRootElement();
            StructureElement rootElement = taggedContent.getRootElement();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
