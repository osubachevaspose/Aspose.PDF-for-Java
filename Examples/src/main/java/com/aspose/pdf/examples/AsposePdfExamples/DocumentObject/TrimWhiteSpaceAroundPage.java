package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class TrimWhiteSpaceAroundPage {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/TrimWhiteSpaceAroundPage/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example trimWhiteSpaceAroundPage start");
        trimWhiteSpaceAroundPage(dataDir, outputDir);
        System.out.println("Example trimWhiteSpaceAroundPage end");
    }

    public static void trimWhiteSpaceAroundPage(String dataDir, String outputDir) {
        // load the source PDF document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // get page to trim white space
            Page page = doc.getPages().get_Item(1);
            // get the content boundaries
            Rectangle contentBBox = page.calculateContentBBox();
            // set Page CropBox and MedioBos as per content boundries to tirm white space
            page.setCropBox(contentBBox);
            page.setMediaBox(contentBBox);
            // save the resultant PDF
            doc.save(outputDir + "output_trim.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
