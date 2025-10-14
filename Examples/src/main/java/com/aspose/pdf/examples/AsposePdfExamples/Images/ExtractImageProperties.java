package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;
import com.aspose.pdf.XImage;
import com.aspose.pdf.examples.Utils;

public class ExtractImageProperties {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/ExtractImageProperties/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example extractImageProperties start");
        extractImageProperties(dataDir);
        System.out.println("Example extractImageProperties end");
    }

    public static void extractImageProperties(String dataDir) {
        Document doc = new Document(dataDir + "PdfWith2Images.pdf");
        try {
            for (XImage image : doc.getPages().get_Item(1).getResources().getImages()) {
                System.out.println(image.toString());
                XImage.RawParameters rawParameters = image.getRawParameters();
                System.out.println(rawParameters.getType());
                System.out.println(rawParameters.getName());
                System.out.println(rawParameters.getBitsPerComponent());
                System.out.println(rawParameters.getDecodeParms());
                System.out.println(rawParameters.getFilter());
                System.out.println(rawParameters.getHeight());
                System.out.println(rawParameters.getWidth());
                System.out.println(rawParameters.getLength());
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
