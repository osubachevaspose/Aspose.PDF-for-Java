package com.aspose.pdf.examples.AsposePdfExamples.Miscellaneous;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.GraphInfo;
import com.aspose.pdf.Page;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.drawing.Rectangle;
import com.aspose.pdf.examples.Utils;

public class HowToAddDrawingWithTransparentColor {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Miscellaneous/HowToAddDrawingWithTransparentColor/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example howToAddDrawingWithTransparentColor start");
        howToAddDrawingWithTransparentColor(outputDir);
        System.out.println("Example howToAddDrawingWithTransparentColor end");
    }

    public static void howToAddDrawingWithTransparentColor(String outputDir) {
        // instantiate Document object
        Document doc = new Document();
        try {
            // add page to pages collection of PDF file
            Page page = doc.getPages().add();
            // create Graph object with certain dimensions
            Graph graph = new Graph(300, 400);
            // set border for Drawing object
            graph.setBorder(new BorderInfo(BorderSide.All, Color.getBlack()));
            // add graph object to paragraphs collection of Page instance
            page.getParagraphs().add(graph);
            // create Rectangle object with certain dimensions
            Rectangle rect1 = new Rectangle(0, 0, 100, 50);
            // create graphInfo object for Rectangle instance
            GraphInfo graphInfo1 = rect1.getGraphInfo();
            // set color information for GraphInfo instance
            graphInfo1.setColor(Color.getRed());
            // create Color object using Alpha RGB
            Color alphaRed = Color.fromArgb(50, 100, 0, 0); // provide alpha channel
            // set fill color for GraphInfo
            graphInfo1.setFillColor(alphaRed);
            // add rectangle shape to shapes collection of graph object
            graph.getShapes().addItem(rect1);

            // set border for Drawing object
            graph.setBorder(new BorderInfo(BorderSide.All, Color.getBlack()));
            // create Rectangle object with certain dimensions
            Rectangle rect2 = new Rectangle(50, 25, 100, 50);
            // create graphInfo object for Rectangle instance
            GraphInfo graphInfo2 = rect2.getGraphInfo();
            // set color information for GraphInfo instance
            graphInfo2.setColor(Color.getRed());
            // create Color object using Alpha RGB
            Color alphaBlue = Color.fromArgb(50, 0, 0, 100); // provide alpha channel
            // set fill color for GraphInfo
            graphInfo2.setFillColor(alphaBlue);
            // add rectangle shape to shapes collection of graph object
            graph.getShapes().addItem(rect2);

            // save PDF file
            doc.save(outputDir + "TransparentColor.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
