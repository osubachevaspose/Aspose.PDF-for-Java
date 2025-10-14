package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.ElementList;
import com.aspose.pdf.tagged.logicalstructure.elements.Element;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;

public class AccessChildrenElements {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/TaggedPDFs/AccessChildrenElements/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example accessChildrenElements start");
        accessChildrenElements(dataDir, outputDir);
        System.out.println("Example accessChildrenElements end");
    }

    public static void accessChildrenElements(String dataDir, String outputDir) {
        // Open Pdf Document
        Document doc = new Document(dataDir + "StructureElementsTree.pdf");
        try {
            // Get Content for work with TaggedPdf
            ITaggedContent taggedContent = doc.getTaggedContent();
            // Access to root element(s)
            ElementList rootChildElements = taggedContent.getRootElement().getChildElements();
            System.out.println(rootChildElements.getCount());
            for (Element element : rootChildElements)
                if (element instanceof StructureElement) {
                    StructureElement structureElement = (StructureElement) element;
                    // Get properties
                    System.out.println("Title: " + structureElement.getTitle());
                    System.out.println("Language: " + structureElement.getLanguage());
                    System.out.println("ActualText: " + structureElement.getActualText());
                    System.out.println("ExpansionText: " + structureElement.getExpansionText());
                    System.out.println("AlternativeText: " + structureElement.getAlternativeText());
                }
            // Access to children elements of first element in root element
            ElementList childElements = taggedContent.getRootElement().getChildElements().get_Item(1)
                    .getChildElements();
            for (Element element : childElements)
                if (element instanceof StructureElement) {
                    StructureElement structureElement = (StructureElement) element;
                    // Set properties
                    structureElement.setTitle("title");
                    structureElement.setLanguage("fr-FR");
                    structureElement.setActualText("actual text");
                    structureElement.setExpansionText("exp");
                    structureElement.setAlternativeText("alt");
                }
            // Save Tagged Pdf Document
            doc.save(outputDir + "AccessChildrenElements.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
