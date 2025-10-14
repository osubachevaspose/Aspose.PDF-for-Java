package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.SvgSaveOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFToSVGFormat {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/ConvertPDFToSVGFormat/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertPDFToSVGFormat start");
        convertPDFToSVGFormat(dataDir, outputDir);
        System.out.println("Example convertPDFToSVGFormat end");
    }

    private static void convertPDFToSVGFormat(String dataDir, String outputDir) {
        // load PDF document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // instantiate an object of SvgSaveOptions
            SvgSaveOptions saveOptions = new SvgSaveOptions();
            // do not compress SVG image to Zip archive
            saveOptions.setCompressOutputToZipArchive(false);
            // resultant file name
            String outFileName = outputDir + "output.svg";
            // save the output in SVG files
            doc.save(outFileName, saveOptions);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
