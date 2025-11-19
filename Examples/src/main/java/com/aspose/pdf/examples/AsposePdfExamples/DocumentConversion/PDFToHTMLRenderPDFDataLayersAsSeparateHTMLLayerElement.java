package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.examples.Utils;

public class PDFToHTMLRenderPDFDataLayersAsSeparateHTMLLayerElement {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/PDFToHTML/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example renderPDFDataLayersAsSeparateHTMLLayerElement start");
        renderPDFDataLayersAsSeparateHTMLLayerElement(dataDir, outputDir);
        System.out.println("Example renderPDFDataLayersAsSeparateHTMLLayerElement end");
    }

    public static void renderPDFDataLayersAsSeparateHTMLLayerElement(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "input2.pdf");
        try {
            HtmlSaveOptions htmlSaveOptions = new HtmlSaveOptions();
            // Specify to render PDF document layers separately in output HTML
            htmlSaveOptions.setConvertMarkedContentToLayers(true);
            doc.save(outputDir + "renderPDFDataLayersAsSeparateHTMLLayerElement.html", htmlSaveOptions);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
