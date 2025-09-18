package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextSegment;
import com.aspose.pdf.TextState;
import com.aspose.pdf.examples.Utils;

public class EmbeddingFontsWhileCreatingPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/EmbeddingFontsWhileCreatingPDF/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example embeddingFontsWhileCreatingPDF start");
        embeddingFontsWhileCreatingPDF(outputDir);
        System.out.println("Example embeddingFontsWhileCreatingPDF end");
    }

    public static void embeddingFontsWhileCreatingPDF(String outputDir) {
        // Instantiate Document object by calling its empty constructor
        Document doc = new Document();
        try {
            // Create a page in the Pdf object
            Page page = doc.getPages().add();
            TextFragment fragment = new TextFragment("");
            TextSegment segment = new TextSegment("This is a sample text using Custom font.");
            TextState ts = new TextState();
            ts.setFont(FontRepository.findFont("Arial"));
            ts.getFont().setEmbedded(true);
            segment.setTextState(ts);
            fragment.getSegments().add(segment);
            page.getParagraphs().add(fragment);
            doc.save(outputDir + "EmbedFonts.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
