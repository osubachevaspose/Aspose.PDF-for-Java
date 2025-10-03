package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.HeaderElement;
import com.aspose.pdf.tagged.logicalstructure.elements.grouping.SectElement;

public class StructureElementsProperties {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/TaggedPDFs/StructureElementsProperties/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example structureElementsProperties start");
        structureElementsProperties(outputDir);
        System.out.println("Example structureElementsProperties end");
    }

    public static void structureElementsProperties(String outputDir) {
        // Create Pdf Document
        Document doc = new Document();
        try {
            // Get Content for work with TaggedPdf
            ITaggedContent taggedContent = doc.getTaggedContent();
            // Set Title and Language for Documnet
            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");
            // Create Structure Elements
            StructureElement rootElement = taggedContent.getRootElement();
            SectElement sect = taggedContent.createSectElement();
            rootElement.appendChild(sect);
            HeaderElement h1 = taggedContent.createHeaderElement(1);
            sect.appendChild(h1);
            h1.setText("The Header");
            h1.setTitle("Title");
            h1.setLanguage("en-US");
            h1.setAlternativeText("Alternative Text");
            h1.setExpansionText("Expansion Text");
            h1.setActualText("Actual Text");
            // Save Tagged Pdf Document
            doc.save(outputDir + "StructureElementsProperties.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
