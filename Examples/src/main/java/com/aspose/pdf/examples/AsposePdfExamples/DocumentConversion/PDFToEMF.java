package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.devices.EmfDevice;
import com.aspose.pdf.devices.Resolution;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class PDFToEMF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/PDFToEMF/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example pdftoemf start");
        pdftoemf(dataDir, outputDir);
        System.out.println("Example pdftoemf end");
    }

    public static void pdftoemf(String dataDir, String outputDir) {
        // instantiate EmfDevice object
        EmfDevice device = new EmfDevice(new Resolution(96));
        // load existing PDF file
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // save first page of PDF file as Emf image
            device.process(doc.getPages().get_Item(1), outputDir + "output.emf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
