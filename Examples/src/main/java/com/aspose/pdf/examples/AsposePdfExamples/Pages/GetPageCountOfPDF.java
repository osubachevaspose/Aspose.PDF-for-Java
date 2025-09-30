package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.Utils;

public class GetPageCountOfPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Pages/GetPageCountOfPDF/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example getPageCountOfPDF start");
        getPageCountOfPDF(dataDir);
        System.out.println("Example getPageCountOfPDF end");

        System.out.println("Example getPageCountWithoutSavingPDF start");
        getPageCountWithoutSavingPDF();
        System.out.println("Example getPageCountWithoutSavingPDF end");
    }

    public static void getPageCountOfPDF(String dataDir) {
        // Open a document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Get page count
            System.out.println("Page Count: " + doc.getPages().size());
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void getPageCountWithoutSavingPDF() {
        // instantiate Document instance
        Document doc = new Document();
        try {
            // add page to pages collection of PDF file
            Page page = doc.getPages().add();
            // create a loop to add 300 TextFragment instances
            for (int i = 0; i < 300; i++)
                // add TextFragment to paragraphs collection of first page of PDF
                page.getParagraphs().add(new TextFragment("Pages count test"));
            // process paragraphs to get page count information
            doc.processParagraphs();
            System.out.println("Number of Pages in PDF = " + doc.getPages().size());
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
