package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.IllustrationElement;

public class CreatePDFwithTaggedImage {

    public static void main(String[] args) {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir() + "TaggedPDFs\\";
        Document doc = new Document();
        try {
            ITaggedContent taggedContent = doc.getTaggedContent();
            taggedContent.setTitle("CreatePDFwithTaggedImage");
            taggedContent.setLanguage("en-US");
            IllustrationElement figure1 = taggedContent.createFigureElement();
            taggedContent.getRootElement().appendChild(figure1);
            figure1.setAlternativeText("Aspose Logo");
            figure1.setTitle("Image 1");
            figure1.setTag("Fig");
            // Add image with resolution 300 DPI (by default)
            figure1.setImage(dataDir + "aspose-logo.jpg");
            // Save PDF Document
            doc.save(dataDir + "PDFwithTaggedImage.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
