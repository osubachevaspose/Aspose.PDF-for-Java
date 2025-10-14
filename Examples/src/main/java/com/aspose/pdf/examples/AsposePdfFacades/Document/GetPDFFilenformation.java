package com.aspose.pdf.examples.AsposePdfFacades.Document;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfFileInfo;

public class GetPDFFilenformation {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Document/GetPDFFilenformation/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example getPDFFilenformation start");
        getPDFFilenformation(dataDir);
        System.out.println("Example getPDFFilenformation end");
    }

    public static void getPDFFilenformation(String dataDir) {
        // open document
        PdfFileInfo fileInfo = new PdfFileInfo(dataDir + "input.pdf");
        try {
            // get PDF information
            System.out.println("Subject : " + fileInfo.getSubject());
            System.out.println("Title : " + fileInfo.getTitle());
            System.out.println("Keywords : " + fileInfo.getKeywords());
            System.out.println("Creator : " + fileInfo.getCreator());
            System.out.println("Creation Date : " + fileInfo.getCreationDate());
            System.out.println("Modification Date : " + fileInfo.getModDate());
            // find whether is it valid PDF and it is encrypted as well
            System.out.println("Is Valid PDF : " + fileInfo.isPdfFile());
            // in case the file is encrypted, you need to provide file opening password
            // as second argument to PdfFileInfo constructor
            System.out.println("Is Encrypted : " + fileInfo.isEncrypted());
        } finally {
            if (fileInfo != null)
                fileInfo.close();
        }
    }
}
