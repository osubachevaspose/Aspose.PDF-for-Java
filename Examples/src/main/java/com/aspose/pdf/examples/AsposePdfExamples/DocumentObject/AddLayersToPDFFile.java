package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.Layer;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.Utils;

import java.io.File;
import java.util.ArrayList;

public class AddLayersToPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/AddLayersToPDFFile/";
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example addLayersToPDFFile start");
        addLayersToPDFFile(outputDir);
        System.out.println("Example addLayersToPDFFile end");
    }

    public static void addLayersToPDFFile(String outputDir) {
        Document doc = new Document();
        try {
            Page page = doc.getPages().add();
            Layer layer = new Layer("oc1", "Red Line");
            layer.getContents().add(new com.aspose.pdf.operators.SetRGBColorStroke(1, 0, 0));
            layer.getContents().add(new com.aspose.pdf.operators.MoveTo(500, 700));
            layer.getContents().add(new com.aspose.pdf.operators.LineTo(400, 700));
            layer.getContents().add(new com.aspose.pdf.operators.Stroke());
            page.setLayers(new ArrayList());
            page.getLayers().add(layer);
            layer = new Layer("oc2", "Green Line");
            layer.getContents().add(new com.aspose.pdf.operators.SetRGBColorStroke(0, 1, 0));
            layer.getContents().add(new com.aspose.pdf.operators.MoveTo(500, 750));
            layer.getContents().add(new com.aspose.pdf.operators.LineTo(400, 750));
            layer.getContents().add(new com.aspose.pdf.operators.Stroke());
            page.getLayers().add(layer);
            layer = new Layer("oc3", "Blue Line");
            layer.getContents().add(new com.aspose.pdf.operators.SetRGBColorStroke(0, 0, 1));
            layer.getContents().add(new com.aspose.pdf.operators.MoveTo(500, 800));
            layer.getContents().add(new com.aspose.pdf.operators.LineTo(400, 800));
            layer.getContents().add(new com.aspose.pdf.operators.Stroke());
            page.getLayers().add(layer);
            doc.save(outputDir + "addLayersToPDFFile.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
