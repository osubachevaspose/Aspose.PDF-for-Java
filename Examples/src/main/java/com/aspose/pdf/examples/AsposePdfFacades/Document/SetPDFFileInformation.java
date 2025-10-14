package com.aspose.pdf.examples.AsposePdfFacades.Document;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfFileInfo;

import java.io.File;

public class SetPDFFileInformation {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Document/SetPDFFileInformation/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example setPDFFileInformation start");
        setPDFFileInformation(dataDir, outputDir);
        System.out.println("Example setPDFFileInformation end");
    }

    public static void setPDFFileInformation(String dataDir, String outputDir) {
        // open source document
        PdfFileInfo fileInfo = new PdfFileInfo(dataDir + "input.pdf");
        try {
            // set PDF information
            fileInfo.setAuthor("Nayyer");
            fileInfo.setTitle("Hello World!");
            fileInfo.setKeywords("Peace and Development");
            fileInfo.setCreator("Aspose");
            // save updated file
            fileInfo.saveNewInfo(outputDir + "Updated_Info_output.pdf");
        } finally {
            if (fileInfo != null)
                fileInfo.close();
        }
    }
}
