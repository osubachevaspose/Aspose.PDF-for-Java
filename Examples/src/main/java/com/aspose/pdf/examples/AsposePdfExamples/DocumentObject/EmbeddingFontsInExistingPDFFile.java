package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.Font;
import com.aspose.pdf.Page;
import com.aspose.pdf.XForm;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class EmbeddingFontsInExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/EmbeddingFontsInExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example embeddingFontsInExistingPDFFile start");
        embeddingFontsInExistingPDFFile(dataDir, outputDir);
        System.out.println("Example embeddingFontsInExistingPDFFile end");
    }

    public static void embeddingFontsInExistingPDFFile(String dataDir, String outputDir) {
        // Open the document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Iterate through all the pages
            for (Page page : (Iterable<Page>) doc.getPages()) {
                if (page.getResources().getFonts() != null) {
                    for (Font pageFont : (Iterable<Font>) page.getResources().getFonts()) {
                        // Check if font is already embedded
                        if (!pageFont.isEmbedded())
                            pageFont.setEmbedded(true);
                    }
                }
                // Check for the Form objects
                for (XForm form : (Iterable<XForm>) page.getResources().getForms()) {
                    if (form.getResources().getFonts() != null) {
                        for (Font formFont : (Iterable<Font>) form.getResources().getFonts()) {
                            // Check if the font is embedded
                            if (!formFont.isEmbedded())
                                formFont.setEmbedded(true);
                        }
                    }
                }
            }
            // Save the document
            doc.save(outputDir + "FontEmbedded_output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
