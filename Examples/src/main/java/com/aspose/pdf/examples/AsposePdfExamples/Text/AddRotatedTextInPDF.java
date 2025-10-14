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
            Page pdfPage = doc.getPages().add();
            // Create rotated text fragment
            TextFragment textFragment = new TextFragment("rotated text");
            textFragment.setPosition(new Position(200, 600));
            // Set text properties
            textFragment.getTextState().setFontSize(12);
            textFragment.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));
            textFragment.getTextState().setBackgroundColor(com.aspose.pdf.Color.getLightGray());
            textFragment.getTextState().setForegroundColor(com.aspose.pdf.Color.getRed());
            textFragment.getTextState().setRotation(45);
            textFragment.getTextState().setUnderline(true);
            // Create TextBuilder object
            TextBuilder textBuilder = new TextBuilder(pdfPage);
            // Append the text fragment to the PDF page
            textBuilder.appendText(textFragment);
            // Save document
            doc.save(outputDir + "TextFragmentTests_Rotated.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
