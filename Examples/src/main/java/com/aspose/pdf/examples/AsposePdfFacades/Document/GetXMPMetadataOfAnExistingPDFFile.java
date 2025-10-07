package com.aspose.pdf.examples.AsposePdfFacades.Document;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.DefaultMetadataProperties;
import com.aspose.pdf.facades.PdfXmpMetadata;

public class GetXMPMetadataOfAnExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Document/GetXMPMetadataOfAnExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example getXMPMetadataOfAnExistingPDFFile start");
        getXMPMetadataOfAnExistingPDFFile(dataDir);
        System.out.println("Example getXMPMetadataOfAnExistingPDFFile end");
    }

    public static void getXMPMetadataOfAnExistingPDFFile(String dataDir) {
        // create PdfXmpMetadata object
        PdfXmpMetadata xmpMetadata = new PdfXmpMetadata();
        try {
            // bind PDF file to the object
            xmpMetadata.bindPdf(dataDir + "4pagesPdfA.pdf");
            // get XMP Meta Data properties
            System.out.println("Creation Date : "
                    + xmpMetadata.getByDefaultMetadataProperties(DefaultMetadataProperties.CreateDate));
            System.out.println("MetaData Date : "
                    + xmpMetadata.getByDefaultMetadataProperties(DefaultMetadataProperties.MetadataDate));
            System.out.println("Creator Tool : "
                    + xmpMetadata.getByDefaultMetadataProperties(DefaultMetadataProperties.CreatorTool));
            System.out
                    .println("User Property Name : " + xmpMetadata.getXmpMetadata("customNamespace:UserPropertyName"));
        } finally {
            if (xmpMetadata != null)
                xmpMetadata.close();
        }
    }
}
