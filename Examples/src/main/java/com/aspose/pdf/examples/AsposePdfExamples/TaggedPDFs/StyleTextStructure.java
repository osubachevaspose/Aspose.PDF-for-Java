package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.ms.System.Nullable;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ParagraphElement;

public class StyleTextStructure {

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
            ParagraphElement p = taggedContent.createParagraphElement();
            taggedContent.getRootElement().appendChild(p);
            // Under Development
            p.getStructureTextState().setFontSize(new Nullable<Float>(18F));
            p.getStructureTextState().setForegroundColor(Color.getRed());
            p.getStructureTextState().setFontStyle(FontStyles.Italic);
            p.setText("Red italic text.");
            // Save Tagged Pdf Document
            doc.save(path + "StyleTextStructure.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
