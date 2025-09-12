package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.HeaderElement;
import com.aspose.pdf.tagged.logicalstructure.elements.grouping.SectElement;

public class StructureElementsProperties {

    public static void main(String[] args) {
        // The path to the documents directory.
        String path = Utils.getDataDir() + "TaggedPDFs\\";
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
            doc.save(path + "StructureElementsProperties.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
