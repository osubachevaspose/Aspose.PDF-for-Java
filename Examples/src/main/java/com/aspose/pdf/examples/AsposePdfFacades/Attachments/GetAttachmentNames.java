package com.aspose.pdf.examples.AsposePdfFacades.Attachments;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfExtractor;

import java.util.List;

public class GetAttachmentNames {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Attachments/GetAttachmentNames/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example getAttachmentNames start");
        getAttachmentNames(dataDir);
        System.out.println("Example getAttachmentNames end");
    }

    public static void getAttachmentNames(String dataDir) {
        PdfExtractor pdfExtractor = new PdfExtractor();
        try {
            pdfExtractor.bindPdf(dataDir + "GetAttachmentNames.pdf");
            // extract attachments
            pdfExtractor.extractAttachment();
            // get attachment names
            List attachmentNames = pdfExtractor.getAttachNames();
            for (String attachmentName : (Iterable<String>) attachmentNames) {
                System.out.println("Name: " + attachmentName);
            }
        } finally {
            if (pdfExtractor != null)
                pdfExtractor.close();
        }
    }
}
