package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.RgbToDeviceGrayConversionStrategy;

public class ConvertPDFFromRGBColorspaceToGrayscale {

    public static void main(String[] args) {
        Document doc = new Document("input.pdf");
        try {
            RgbToDeviceGrayConversionStrategy strategy = new RgbToDeviceGrayConversionStrategy();
            for (int idxPage = 1; idxPage <= doc.getPages().size(); idxPage++) {
                Page page = doc.getPages().get_Item(idxPage);
                strategy.convert(page);
            }
            doc.save("output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
