package com.aspose.pdf.examples.AsposePdfFacades.Images;

import com.aspose.pdf.facades.PdfExtractor;

public class ExtractImagesFromTheWholePDFToFiles {

    public static void main(String[] args) {
        // open input PDF
        PdfExtractor extractor = new PdfExtractor();
        try {
            extractor.bindPdf("input.pdf");
            // extract all the images
            extractor.extractImage();
            int imageCount = 1;
            // get all the extracted images
            while (extractor.hasNextImage()) {
                extractor.getNextImage("Image" + imageCount + ".jpg");
                imageCount++;
            }
        } finally {
            if (extractor != null)
                extractor.close();
        }
    }
}
