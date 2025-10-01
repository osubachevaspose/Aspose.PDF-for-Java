package com.aspose.pdf.examples.AsposePdfExamples.Graphs;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.drawing.Line;
import com.aspose.pdf.examples.Utils;

public class DrawingLineAcrossThePage {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Graphs/DrawingLineAcrossThePage/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example drawingLineAcrossThePage start");
        drawingLineAcrossThePage(outputDir);
        System.out.println("Example drawingLineAcrossThePage end");
    }

    public static void drawingLineAcrossThePage(String outputDir) {
        // Create Document instance
        Document doc = new Document();
        try {
            // Add page to pages collection of PDF file
            Page page = doc.getPages().add();
            // set page margin on all sides as 0
            page.getPageInfo().getMargin().setLeft(0);
            page.getPageInfo().getMargin().setRight(0);
            page.getPageInfo().getMargin().setBottom(0);
            page.getPageInfo().getMargin().setTop(0);
            // create Graph object with Width and Height equal to page dimensions
            Graph graph = new Graph((float) page.getPageInfo().getWidth(), (float) page.getPageInfo().getHeight());
            // create first line object starting from Lower-Left to Top-Right corner of page
            Line line = new Line(new float[] { (float) page.getRect().getLLX(), 0,
                    (float) page.getPageInfo().getWidth(), (float) page.getRect().getURY() });
            // add line to shapes collection of Graph object
            graph.getShapes().addItem(line);
            // draw line from Top-Left corner of page to Bottom-Right corner of page
            Line line2 = new Line(new float[] { 0, (float) page.getRect().getURY(),
                    (float) page.getPageInfo().getWidth(), (float) page.getRect().getLLX() });
            // add line to shapes collection of Graph object
            graph.getShapes().addItem(line2);
            // add Graph object to paragraphs collection of page
            page.getParagraphs().add(graph);
            // save resultant PDF file
            doc.save(outputDir + "Line_Across_Page.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
