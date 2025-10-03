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
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/TaggedPDFs/AccessChildrenElements/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example accessChildrenElements start");
        accessChildrenElements(dataDir, outputDir);
        System.out.println("Example accessChildrenElements end");
    }

    public static void accessChildrenElements(String dataDir, String outputDir) {
        // String path = Utils.getDataDir() + "TaggedPDFs\\";
        // Open Pdf Document
        // Document doc = new Document(path + "StructureElements.pdf");
        Document doc = new Document(dataDir + "StructureElements.pdf");
        try {
            // Get Content for work with TaggedPdf
            ITaggedContent taggedContent = doc.getTaggedContent();
            // Access to root element(s)
            ElementList elementList = taggedContent.getStructTreeRootElement().getChildElements();
            for (Element element : elementList) {
                if (element instanceof StructureElement) {
                    StructureElement structureElement = (StructureElement) element;
                    // Get properties
                    String title = structureElement.getTitle();
                    String language = structureElement.getLanguage();
                    String actualText = structureElement.getActualText();
                    String expansionText = structureElement.getExpansionText();
                    String alternativeText = structureElement.getAlternativeText();
                }
            }
            // Access to children elements of first element in root element
            elementList = taggedContent.getRootElement().getChildElements().get_Item(1).getChildElements();
            for (Element element : elementList)
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
