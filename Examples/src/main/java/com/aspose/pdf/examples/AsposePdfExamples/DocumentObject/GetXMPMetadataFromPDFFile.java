package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class GetXMPMetadataFromPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/GetXMPMetadataFromPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example getXMPMetadataFromPDFFile start");
        getXMPMetadataFromPDFFile(dataDir, outputDir);
        System.out.println("Example getXMPMetadataFromPDFFile end");
    }

    public static void getXMPMetadataFromPDFFile(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "4pagesPdfA.pdf");
        try {
            // Get properties
            System.out.println("xmp:CreateDate: " + doc.getMetadata().get_Item("xmp:CreateDate"));
            System.out.println("xmp:ModifyDate: " + doc.getMetadata().get_Item("xmp:ModifyDate"));
            System.out.println("xmp:CreatorTool: " + doc.getMetadata().get_Item("xmp:CreatorTool"));
            System.out.println("pdf:Producer: " + doc.getMetadata().get_Item("pdf:Producer"));
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
