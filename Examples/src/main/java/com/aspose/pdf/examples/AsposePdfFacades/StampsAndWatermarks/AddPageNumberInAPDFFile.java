package com.aspose.pdf.examples.AsposePdfFacades.StampsAndWatermarks;

import java.awt.Color;

import com.aspose.pdf.facades.EncodingType;
import com.aspose.pdf.facades.FormattedText;
import com.aspose.pdf.facades.PdfFileInfo;
import com.aspose.pdf.facades.PdfFileStamp;

public class AddPageNumberInAPDFFile {

    public static void main(String[] args) {
        PdfFileStamp fileStamp = new PdfFileStamp();
        try {
            // open document
            fileStamp.bindPdf("input.pdf");
            PdfFileInfo fileInfo = new PdfFileInfo("input.pdf");
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
            fileStamp.save("output.pdf");
        } finally {
            if (fileStamp != null)
                fileStamp.close();
        }
    }
}
