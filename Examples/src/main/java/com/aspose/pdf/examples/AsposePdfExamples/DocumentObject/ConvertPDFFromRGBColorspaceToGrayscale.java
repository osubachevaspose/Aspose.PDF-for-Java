package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.RgbToDeviceGrayConversionStrategy;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFFromRGBColorspaceToGrayscale {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/ConvertPDFFromRGBColorspaceToGrayscale/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertPDFFromRGBColorspaceToGrayscale start");
        convertPDFFromRGBColorspaceToGrayscale(dataDir, outputDir);
        System.out.println("Example convertPDFFromRGBColorspaceToGrayscale end");
    }

    public static void convertPDFFromRGBColorspaceToGrayscale(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "input.pdf");
        try {
            RgbToDeviceGrayConversionStrategy strategy = new RgbToDeviceGrayConversionStrategy();
            for (int i = 1; i <= doc.getPages().size(); i++) {
                Page page = doc.getPages().get_Item(i);
                strategy.convert(page);
            }
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
