package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.DocumentInfo;
import com.aspose.pdf.examples.Utils;

public class SetPDFFileInformation {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/SetPDFFileInformation/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example setPDFFileInformation start");
        setPDFFileInformation(dataDir, outputDir);
        System.out.println("Example setPDFFileInformation end");
    }

    public static void setPDFFileInformation(String dataDir, String outputDir) {
        // open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // get document information
            DocumentInfo docInfo = doc.getInfo();
            // set Author information
            docInfo.setAuthor("Aspose.Pdf for java");
            docInfo.setCreationDate(new java.util.Date());
            docInfo.setKeywords("Aspose.Pdf, DOM, API");
            docInfo.setModDate(new java.util.Date());
            docInfo.setSubject("PDF Information");
            docInfo.setTitle("Setting PDF Document Information");
            // save update document with new information
            doc.save(outputDir + "Updated_Information.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
