package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfExtractor;

public class ExtractTextFromIndividualPagesOfAPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Text/ExtractTextFromIndividualPagesOfAPDF/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example extractTextFromIndividualPagesOfAPDF start");
        extractTextFromIndividualPagesOfAPDF(dataDir, outputDir);
        System.out.println("Example extractTextFromIndividualPagesOfAPDF end");
    }

    public static void extractTextFromIndividualPagesOfAPDF(String dataDir, String outputDir) {
        PdfExtractor extractor = new PdfExtractor();
        try {
            // open input PDF
            extractor.bindPdf(dataDir + "input.pdf");
            // use parameterless ExtractText method
            extractor.extractText();
            int pageNumber = 1;
            while (extractor.hasNextPageText()) {
                extractor.getNextPageText(outputDir + "output" + pageNumber + ".txt");
                pageNumber++;
            }
        } finally {
            if (extractor != null)
                extractor.close();
        }
    }
}
