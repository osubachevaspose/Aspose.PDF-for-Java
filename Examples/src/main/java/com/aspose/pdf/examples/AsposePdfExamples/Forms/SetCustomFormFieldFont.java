package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import java.awt.Color;

import com.aspose.pdf.DefaultAppearance;
import com.aspose.pdf.Document;
import com.aspose.pdf.Font;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.TextBoxField;
import com.aspose.pdf.examples.Utils;

public class SetCustomFormFieldFont {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Forms/SetCustomFormFieldFont/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example setCustomFormFieldFont start");
        setCustomFormFieldFont(dataDir, outputDir);
        System.out.println("Example setCustomFormFieldFont end");
    }

    public static void setCustomFormFieldFont(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "TextBoxField.pdf");
        try {
            // Get a field
            TextBoxField textBoxField = (TextBoxField) doc.getForm().get("textbox1");
            // Create an instance of font object and try loading ComicSansMS font
            // from system font repository
            // Font font = FontRepository.findFont("ComicSansMS");
            // Font font = FontRepository.findFont("Webdings");
            Font font = FontRepository.findFont("Times New Roman");
            // Set the font information for form field by using Font object
            textBoxField.setDefaultAppearance(new DefaultAppearance(font, 10, Color.black));
            // Set the font information for form field by using its name
            // textBoxField.setDefaultAppearance(new
            // DefaultAppearance("ComicSansMS", 10, Color.black));
            // Save updated document
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
