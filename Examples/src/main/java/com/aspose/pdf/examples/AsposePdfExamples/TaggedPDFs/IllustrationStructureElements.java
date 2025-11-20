package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.IllustrationElement;

import java.io.File;

public class IllustrationStructureElements {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/TaggedPDFs/IllustrationStructureElements/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example illustrationStructureElements start");
        illustrationStructureElements(dataDir, outputDir);
        System.out.println("Example illustrationStructureElements end");
    }

    public static void illustrationStructureElements(String dataDir, String outputDir) {
        // Create Pdf Document
        Document doc = new Document();
        try {
            // Get Content for work with TaggedPdf
            ITaggedContent taggedContent = doc.getTaggedContent();
            // Set Title and Language for Documnet
            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");
            // Under Development
            IllustrationElement figure1 = taggedContent.createFigureElement();
            taggedContent.getRootElement().appendChild(figure1);
            figure1.setActualText("Figure One");
            figure1.setTitle("Image 1");
            figure1.setTag("Fig1");
            figure1.setImage(dataDir + "aspose-logo.jpg");
            // Save Tagged Pdf Document
            doc.save(outputDir + "IllustrationStructureElements.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
