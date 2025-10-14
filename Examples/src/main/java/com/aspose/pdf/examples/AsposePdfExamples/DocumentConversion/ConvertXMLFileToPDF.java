package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextSegment;
import com.aspose.pdf.examples.Utils;

public class ConvertXMLFileToPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/ConvertXMLFileToPDF/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertXMLFileToPDF start");
        convertXMLFileToPDF(dataDir, outputDir);
        System.out.println("Example convertXMLFileToPDF end");
    }

    public static void convertXMLFileToPDF(String dataDir, String outputDir) {
        // instantiate Document object
        Document doc = new Document();
        try {
            // bind source XML file
            doc.bindXml(dataDir + "source.xml");
            // get reference of first TextSegment with ID boldHtml
            TextSegment segment = (TextSegment) doc.getObjectById("boldHtml");
            // get reference of second TextSegment with ID strongHtml
            segment = (TextSegment) doc.getObjectById("strongHtml");
            // update TextSegement text
            segment.setText("TestSegment");
            // save resultant PDF file
            doc.save(outputDir + "resultant.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
