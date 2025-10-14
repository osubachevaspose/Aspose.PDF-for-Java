package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFToXML {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/ConvertPDFToXML/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertPDFToXML start");
        convertPDFToXML(dataDir, outputDir);
        System.out.println("Example convertPDFToXML end");
    }

    private static void convertPDFToXML(String dataDir, String outputDir) {
        // instantiate Document object
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // save the output in XML format
            doc.save(outputDir + "resultant.xml", SaveFormat.Xml);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
