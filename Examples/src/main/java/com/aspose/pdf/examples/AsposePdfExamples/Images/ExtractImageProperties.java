package com.aspose.pdf.examples.AsposePdfExamples.Images;

import java.io.IOException;
import com.aspose.pdf.Document;
import com.aspose.pdf.XImage;

public class ExtractImageProperties {

    public static void main(String[] args) throws IOException {
        Document doc = new Document("page-0000000004.pdf");
        try {
            for (XImage image : doc.getPages().get_Item(1).getResources().getImages()) {
                XImage.RawParameters rawParameters = image.getRawParameters();
                System.out.println(rawParameters.getType());
                System.out.println(rawParameters.getName());
                System.out.println(rawParameters.getBitsPerComponent());
                System.out.println(rawParameters.getDecodeParms());
                System.out.println(rawParameters.getFilter());
                System.out.println(rawParameters.getHeight());
                System.out.println(rawParameters.getWidth());
                System.out.println(rawParameters.getLength());
                System.out.println(image.toString());
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
