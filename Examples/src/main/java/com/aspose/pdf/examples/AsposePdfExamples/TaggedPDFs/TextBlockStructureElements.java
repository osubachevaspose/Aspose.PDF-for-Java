package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.HeaderElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ParagraphElement;

public class TextBlockStructureElements {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/TaggedPDFs/TextBlockStructureElements/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example textBlockStructureElements start");
        textBlockStructureElements(outputDir);
        System.out.println("Example textBlockStructureElements end");
    }

    public static void textBlockStructureElements(String outputDir) {
        // Create Pdf Document
        Document doc = new Document();
        try {
            // Get Content for work with TaggedPdf
            ITaggedContent taggedContent = doc.getTaggedContent();
            // Set Title and Language for Documnet
            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");
            // Get Root Structure Element
            StructureElement rootElement = taggedContent.getRootElement();
            HeaderElement h1 = taggedContent.createHeaderElement(1);
            HeaderElement h2 = taggedContent.createHeaderElement(2);
            HeaderElement h3 = taggedContent.createHeaderElement(3);
            HeaderElement h4 = taggedContent.createHeaderElement(4);
            HeaderElement h5 = taggedContent.createHeaderElement(5);
            HeaderElement h6 = taggedContent.createHeaderElement(6);
            h1.setText("H1. Header of Level 1");
            h2.setText("H2. Header of Level 2");
            h3.setText("H3. Header of Level 3");
            h4.setText("H4. Header of Level 4");
            h5.setText("H5. Header of Level 5");
            h6.setText("H6. Header of Level 6");
            rootElement.appendChild(h1);
            rootElement.appendChild(h2);
            rootElement.appendChild(h3);
            rootElement.appendChild(h4);
            rootElement.appendChild(h5);
            rootElement.appendChild(h6);
            ParagraphElement paragraphElement = taggedContent.createParagraphElement();
            paragraphElement.setText(
                    "P. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec lectus ac sem faucibus imperdiet. Sed ut erat ac magna ullamcorper hendrerit. Cras pellentesque libero semper, gravida magna sed, luctus leo. Fusce lectus odio, laoreet nec ullamcorper ut, molestie eu elit. Interdum et malesuada fames ac ante ipsum primis in faucibus. Aliquam lacinia sit amet elit ac consectetur. Donec cursus condimentum ligula, vitae volutpat sem tristique eget. Nulla in consectetur massa. Vestibulum vitae lobortis ante. Nulla ullamcorper pellentesque justo rhoncus accumsan. Mauris ornare eu odio non lacinia. Aliquam massa leo, rhoncus ac iaculis eget, tempus et magna. Sed non consectetur elit. Sed vulputate, quam sed lacinia luctus, ipsum nibh fringilla purus, vitae posuere risus odio id massa. Cras sed venenatis lacus.");
            rootElement.appendChild(paragraphElement);
            // Save Tagged Pdf Document
            doc.save(outputDir + "TextBlockStructureElements.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
