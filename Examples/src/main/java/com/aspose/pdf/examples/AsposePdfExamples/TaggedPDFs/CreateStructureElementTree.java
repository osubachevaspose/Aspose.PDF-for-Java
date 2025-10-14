package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.grouping.ArtElement;
import com.aspose.pdf.tagged.logicalstructure.elements.grouping.DivElement;
import com.aspose.pdf.tagged.logicalstructure.elements.grouping.SectElement;

public class CreateStructureElementTree {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/TaggedPDFs/CreateStructureElementTree/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example createStructureElementTree start");
        createStructureElementTree(outputDir);
        System.out.println("Example createStructureElementTree end");
    }

    public static void createStructureElementTree(String outputDir) {
        // Create Pdf Document
        Document doc = new Document();
        try {
            // Get Content for work with TaggedPdf
            ITaggedContent taggedContent = doc.getTaggedContent();
            // Set Title and Language for Documnet
            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");
            // Get root structure element (Document)
            StructureElement rootElement = taggedContent.getRootElement();
            // Create Logical Structure
            SectElement sect1 = taggedContent.createSectElement();
            sect1.setTitle("Section 1");
            sect1.setLanguage("en-US");
            sect1.setActualText("Section 1 Actual Text");
            sect1.setExpansionText("Section 1 Expansion Text");
            rootElement.appendChild(sect1);
            SectElement sect2 = taggedContent.createSectElement();
            sect2.setTitle("Section 2");
            sect2.setActualText("Section 2 Actual Text");
            sect2.setAlternativeText("Section 2 Alternative Text");
            rootElement.appendChild(sect2);
            DivElement div11 = taggedContent.createDivElement();
            sect1.appendChild(div11);
            DivElement div12 = taggedContent.createDivElement();
            sect1.appendChild(div12);
            ArtElement art21 = taggedContent.createArtElement();
            sect2.appendChild(art21);
            ArtElement art22 = taggedContent.createArtElement();
            sect2.appendChild(art22);
            DivElement div211 = taggedContent.createDivElement();
            art21.appendChild(div211);
            DivElement div212 = taggedContent.createDivElement();
            art21.appendChild(div212);
            DivElement div221 = taggedContent.createDivElement();
            art22.appendChild(div221);
            DivElement div222 = taggedContent.createDivElement();
            art22.appendChild(div222);
            SectElement sect3 = taggedContent.createSectElement();
            sect3.setTitle("Section 3");
            rootElement.appendChild(sect3);
            DivElement div31 = taggedContent.createDivElement();
            sect3.appendChild(div31);
            // Save Tagged Pdf Document
            doc.save(outputDir + "StructureElementsTree.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
