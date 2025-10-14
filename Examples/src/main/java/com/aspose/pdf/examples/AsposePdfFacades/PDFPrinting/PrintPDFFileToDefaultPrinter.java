package com.aspose.pdf.examples.AsposePdfFacades.PDFPrinting;

import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfViewer;

public class PrintPDFFileToDefaultPrinter {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/PDFPrinting/PrintPDFFileToDefaultPrinter/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example printPDFFileToDefaultPrinter start");
        printPDFFileToDefaultPrinter(dataDir);
        System.out.println("Example printPDFFileToDefaultPrinter end");
    }

    public static void printPDFFileToDefaultPrinter(String dataDir) {
        // Create PdfViewer object
        PdfViewer viewer = new PdfViewer();
        try {
            // Open input PDF file
            viewer.openPdfFile(dataDir + "input.pdf");
            // Set attributes for printing
            viewer.setAutoResize(true); // Print the file with adjusted size
            viewer.setAutoRotate(true); // Print the file with adjusted rotation
            viewer.setPrintPageDialog(false); // Do not produce the page number dialog when printing
            // gets a printjob object.
            PrinterJob printJob = PrinterJob.getPrinterJob();
            // gets the default page.
            PageFormat pageFormat = printJob.defaultPage();
            // print PDF document
            viewer.printDocument();
            // close the Pdf file.
            viewer.closePdfFile();
        } finally {
            if (viewer != null)
                viewer.close();
        }
    }
}
