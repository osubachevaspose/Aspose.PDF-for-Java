package com.aspose.pdf.examples.AsposePdfFacades.Images;

import com.aspose.pdf.ImageType;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfConverter;

public class ConvertPDFPagesToDifferentImageFormats {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Images/ConvertPDFPagesToDifferentImageFormats/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertPDFPagesToDifferentImageFormats start");
        convertPDFPagesToDifferentImageFormats(dataDir, outputDir);
        System.out.println("Example convertPDFPagesToDifferentImageFormats end");
    }

    public static void convertPDFPagesToDifferentImageFormats(String dataDir, String outputDir) {
        // create PdfConverter object
        PdfConverter converter = new PdfConverter();
        try {
            // bind input pdf file
            converter.bindPdf(dataDir + "input.pdf");
            // initialize the converting process
            converter.doConvert();
            int i = 1;
            // check if pages exist and then convert to image one by one
            while (converter.hasNextImage()) {
                converter.getNextImage(outputDir + i + ".jpg", ImageType.getJpeg());
                i++;
            }
        } finally {
            if (converter != null)
                converter.close();
        }
    }
}
