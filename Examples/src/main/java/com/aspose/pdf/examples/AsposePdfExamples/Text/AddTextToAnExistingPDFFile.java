package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.Page;
import com.aspose.pdf.Position;
import com.aspose.pdf.TextBuilder;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.Utils;

public class AddTextToAnExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/AddTextToAnExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addTextToAnExistingPDFFile start");
        addTextToAnExistingPDFFile(dataDir, outputDir);
        System.out.println("Example addTextToAnExistingPDFFile end");
    }

    public static void addTextToAnExistingPDFFile(String dataDir, String outputDir) {
        // open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // get particular page
            Page pdfPage = doc.getPages().get_Item(1);
            // create text fragment
            TextFragment textFragment = new TextFragment("main text");
            textFragment.setPosition(new Position(100, 600));
            // set text properties
            textFragment.getTextState().setFont(FontRepository.findFont("Verdana"));
            textFragment.getTextState().setFontSize(14);
            textFragment.getTextState().setForegroundColor(Color.getBlue());
            textFragment.getTextState().setBackgroundColor(Color.getGray());
            // create TextBuilder object
            TextBuilder textBuilder = new TextBuilder(pdfPage);
            // append the text fragment to the PDF page
            textBuilder.appendText(textFragment);
            // save updated PDF file
            doc.save(outputDir + "Text_Added.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
