package com.aspose.pdf.examples.AsposePdfExamples.Graphs;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.drawing.Rectangle;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class CreateFilledRectangleObject {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Graphs/CreateFilledRectangleObject/";
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example createFilledRectangleObject start");
        createFilledRectangleObject(outputDir);
        System.out.println("Example createFilledRectangleObject end");
    }

    public static void createFilledRectangleObject(String outputDir) {
        // Create Document instance
        Document doc = new Document();
        try {
            // Add page to pages collection of PDF file
            Page page = doc.getPages().add();
            // Create Graph instance
            Graph graph = new Graph(100, 400);
            // Add graph object to paragraphs collection of page instance
            page.getParagraphs().add(graph);
            // Create Rectangle instance
            Rectangle rect = new Rectangle(100, 100, 200, 120);
            // Specify fill color for Graph object
            rect.getGraphInfo().setFillColor(Color.getRed());
            // Add rectangle object to shapes collection of Graph object
            graph.getShapes().addItem(rect);
            // save resultant PDF file
            doc.save(outputDir + "Filled_Rect.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
