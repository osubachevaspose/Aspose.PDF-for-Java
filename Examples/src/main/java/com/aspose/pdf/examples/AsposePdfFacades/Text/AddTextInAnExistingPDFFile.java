package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.EncodingType;
import com.aspose.pdf.facades.FontStyle;
import com.aspose.pdf.facades.FormattedText;
import com.aspose.pdf.facades.PdfFileMend;
import com.aspose.pdf.facades.WordWrapMode;

import java.awt.Color;

public class AddTextInAnExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Text/AddTextInAnExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addTextInAnExistingPDFFile start");
        addTextInAnExistingPDFFile(dataDir, outputDir);
        System.out.println("Example addTextInAnExistingPDFFile end");
    }

    public static void addTextInAnExistingPDFFile(String dataDir, String outputDir) {
        // create PdfFileMend object to add text
        PdfFileMend fileMend = new PdfFileMend();
        try {
            fileMend.bindPdf(dataDir + "input.pdf");
            // create formatted text
            FormattedText text = new FormattedText("Aspose - Your File Format Experts!",
                    Color.BLUE, Color.GRAY, FontStyle.Courier, EncodingType.Winansi, true, 14);
            // set whether to use Word Wrap or not and using which mode
            fileMend.setWordWrap(true);
            fileMend.setWrapMode(WordWrapMode.Default);
            // add text in the PDF file
            fileMend.addText(text, 1, 100, 200, 200, 400);
            // save output PDF
            fileMend.save(outputDir + "output.pdf");
        } finally {
            if (fileMend != null)
                fileMend.close();
        }
    }
}
