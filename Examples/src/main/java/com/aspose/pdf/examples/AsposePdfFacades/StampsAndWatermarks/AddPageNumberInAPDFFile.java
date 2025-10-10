package com.aspose.pdf.examples.AsposePdfFacades.StampsAndWatermarks;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.EncodingType;
import com.aspose.pdf.facades.FormattedText;
import com.aspose.pdf.facades.PdfFileInfo;
import com.aspose.pdf.facades.PdfFileStamp;

import java.awt.Color;

public class AddPageNumberInAPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/StampsAndWatermarks/AddPageNumberInAPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addPageNumberInAPDFFile start");
        addPageNumberInAPDFFile(dataDir, outputDir);
        System.out.println("Example addPageNumberInAPDFFile end");
    }

    public static void addPageNumberInAPDFFile(String dataDir, String outputDir) {
        PdfFileStamp fileStamp = new PdfFileStamp();
        try {
            // open document
            fileStamp.bindPdf(dataDir + "input.pdf");
            PdfFileInfo fileInfo = new PdfFileInfo(dataDir + "input.pdf");
            try {
                // get total number of pages
                int totalPages = fileInfo.getNumberOfPages();
                // create formatted text for page number
                FormattedText formattedText = new FormattedText("Page # Of " + totalPages, Color.BLUE, Color.GRAY,
                        com.aspose.pdf.facades.FontStyle.Courier, EncodingType.Winansi, false, 14);
                // set starting number for first page; you might want to start from 2 or more
                fileStamp.setStartingNumber(1);
                // add page number
                fileStamp.addPageNumber(formattedText, 0);
            } finally {
                if (fileInfo != null)
                    fileInfo.close();
            }
            // save updated PDF file
            fileStamp.save(outputDir + "output.pdf");
        } finally {
            if (fileStamp != null)
                fileStamp.close();
        }
    }
}
