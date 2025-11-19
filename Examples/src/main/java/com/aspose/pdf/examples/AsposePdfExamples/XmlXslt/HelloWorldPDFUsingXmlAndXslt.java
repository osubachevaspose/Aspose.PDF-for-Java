package com.aspose.pdf.examples.AsposePdfExamples.XmlXslt;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class HelloWorldPDFUsingXmlAndXslt {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/XmlXslt/HelloWorldPDFUsingXmlAndXslt/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example helloWorldPDFUsingXmlAndXslt start");
        helloWorldPDFUsingXmlAndXslt(dataDir, outputDir);
        System.out.println("Example helloWorldPDFUsingXmlAndXslt end");
    }

    public static void helloWorldPDFUsingXmlAndXslt(String dataDir, String outputDir) {
        Document doc = new Document();
        try {
            // Bind XML and XSLT files to the document
            doc.bindXml(dataDir + "HelloWorld.xml", dataDir + "HelloWorld.xslt");
            doc.save(outputDir + "HelloWorldPDFUsingXmlAndXslt.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
