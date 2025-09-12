package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.Rotation;
import com.aspose.pdf.TextStamp;

public class AddingTextStampInPDFFile {

    public static void main(String[] args) {
        // open document
        Document doc = new Document("input.pdf");
        try {
            // create text stamp
            TextStamp textStamp = new TextStamp("Sample Stamp");
            // set whether stamp is background
            textStamp.setBackground(true);
            // set origin
            textStamp.setXIndent(100);
            textStamp.setYIndent(100);
            // rotate stamp
            textStamp.setRotate(Rotation.on90);
            // set text properties
            textStamp.getTextState().setFont(FontRepository.findFont("Arial"));
            textStamp.getTextState().setFontSize(14.0F);
            textStamp.getTextState().setFontStyle(FontStyles.Bold);
            textStamp.getTextState().setFontStyle(FontStyles.Italic);
            textStamp.getTextState().setForegroundColor(Color.getGreen());
            // add stamp to particular page
            doc.getPages().get_Item(1).addStamp(textStamp);
            // save output document
            doc.save("TextStamp_output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
