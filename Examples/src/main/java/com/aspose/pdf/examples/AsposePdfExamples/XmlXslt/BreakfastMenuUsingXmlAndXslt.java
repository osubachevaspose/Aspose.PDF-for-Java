package com.aspose.pdf.examples.AsposePdfExamples.XmlXslt;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class BreakfastMenuUsingXmlAndXslt {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/XmlXslt/BreakfastMenuUsingXmlAndXslt/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example breakfastMenuUsingXmlAndXslt start");
        breakfastMenuUsingXmlAndXslt(dataDir, outputDir);
        System.out.println("Example breakfastMenuUsingXmlAndXslt end");
    }

    public static void breakfastMenuUsingXmlAndXslt(String dataDir, String outputDir) {
        Document doc = new Document();
        try {
            // Bind XML and XSLT files to the document
            doc.bindXml(dataDir + "Breakfast.xml", dataDir + "Breakfast.xslt");
            doc.save(outputDir + "BreakfastMenu.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
