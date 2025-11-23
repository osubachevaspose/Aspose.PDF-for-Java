package com.aspose.pdf.examples.AsposePdfFacades.Document;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfXmpMetadata;

import java.io.File;

public class SetXMPMetadataOfAnExistingPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Document/SetXMPMetadataOfAnExistingPDF/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example setXMPMetadataOfAnExistingPDF start");
        setXMPMetadataOfAnExistingPDF(dataDir, outputDir);
        System.out.println("Example setXMPMetadataOfAnExistingPDF end");
    }

    public static void setXMPMetadataOfAnExistingPDF(String dataDir, String outputDir) {
        PdfXmpMetadata xmpMetadata = new PdfXmpMetadata();
        try {
            // bind pdf file
            xmpMetadata.bindPdf(dataDir + "input.pdf");
            // step #1: register namespace prefix and URI
            xmpMetadata.registerNamespaceURI("customNamespace", "http://www.customNameSpaces.com/ns/");
            // step #2: add user property with the prefix
            xmpMetadata.addItem("customNamespace:UserPropertyName", "UserPropertyValue");
            // save xmp meta data in the pdf file
            xmpMetadata.save(outputDir + "Updated_MetaData.pdf");
        } finally {
            if (xmpMetadata != null)
                xmpMetadata.close();
        }
    }
}
