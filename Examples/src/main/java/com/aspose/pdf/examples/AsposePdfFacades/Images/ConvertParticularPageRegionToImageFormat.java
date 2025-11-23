package com.aspose.pdf.examples.AsposePdfFacades.Images;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfConverter;
import com.aspose.pdf.facades.PdfPageEditor;

import java.io.File;

public class ConvertParticularPageRegionToImageFormat {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Images/ConvertParticularPageRegionToImageFormat/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example convertParticularPageRegionToImageFormat start");
        convertParticularPageRegionToImageFormat(dataDir, outputDir);
        System.out.println("Example convertParticularPageRegionToImageFormat end");
    }

    public static void convertParticularPageRegionToImageFormat(String dataDir, String outputDir) {
        // instantiate PdfPageEditor class to get particular page region
        PdfPageEditor pageEditor = new PdfPageEditor();
        try {
            // bind the source PDF file
            pageEditor.bindPdf(dataDir + "SampleDataTable.pdf");
            // move the origin of PDF file to particular point
            pageEditor.movePosition(100, 200);
            pageEditor.save(outputDir + "TempFile.pdf");
        } finally {
            if (pageEditor != null)
                pageEditor.close();
        }
        // create PdfConverter object
        PdfConverter converter = new PdfConverter();
        try {
            // bind input pdf file
            converter.bindPdf(outputDir + "TempFile.pdf");
            // set StartPage and EndPage properties to the page number you want to convert images from
            converter.setStartPage(1);
            converter.setEndPage(2);
            // Counter
            int page = 1;
            // initialize the converting process
            converter.doConvert();
            // check if pages exist and then convert to image one by one
            while (converter.hasNextImage()) {
                converter.getNextImage(outputDir + "Specific_Region-Image" + page + ".jpeg");
                page++;
            }
        } finally {
            if (converter != null)
                converter.close();
        }
    }
}
