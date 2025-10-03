package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.Page;
import com.aspose.pdf.Position;
import com.aspose.pdf.TextBuilder;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.Utils;

public class AddRotatedTextInPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/AddRotatedTextInPDF/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addRotatedTextInPDF start");
        addRotatedTextInPDF(outputDir);
        System.out.println("Example addRotatedTextInPDF end");
    }

    public static void addRotatedTextInPDF(String outputDir) {
        // Open document
        Document doc = new Document();
        try {
            // Get particular page
            Page pdfPage = (Page) doc.getPages().add();
            // Create rotated text fragment
            TextFragment tf = new TextFragment("rotated text");
            tf.setPosition(new Position(200, 600));
            // Set text properties
            tf.getTextState().setFontSize(12);
            tf.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));
            tf.getTextState().setBackgroundColor(com.aspose.pdf.Color.getLightGray());
            tf.getTextState().setForegroundColor(com.aspose.pdf.Color.getRed());
            tf.getTextState().setRotation(45);
            tf.getTextState().setUnderline(true);
            // Create TextBuilder object
            TextBuilder textBuilder = new TextBuilder(pdfPage);
            // Append the text fragment to the PDF page
            textBuilder.appendText(tf);
            // Save document
            doc.save(outputDir + "TextFragmentTests_Rotated.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
