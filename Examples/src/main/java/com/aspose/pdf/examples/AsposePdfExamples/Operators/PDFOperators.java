package com.aspose.pdf.examples.AsposePdfExamples.Operators;

import com.aspose.pdf.Document;
import com.aspose.pdf.Matrix;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.XImage;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.operators.*;

import java.io.FileInputStream;
import java.io.IOException;

public class PDFOperators {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Operators/PDFOperators/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example pdfOperators start");
        pdfOperators(dataDir, outputDir);
        System.out.println("Example pdfOperators end");
    }

    public static void pdfOperators(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "PDFOperators.pdf");
        try {
            // Set coordinates
            int lowerLeftX = 100;
            int lowerLeftY = 100;
            int upperRightX = 200;
            int upperRightY = 200;
            // Get the page where image needs to be added
            Page page = doc.getPages().get_Item(1);
            // Load image into stream
            FileInputStream imageStream = new FileInputStream(dataDir + "PDFOperators.jpg");
            // Add image to Images collection of Page Resources
            page.getResources().getImages().add(imageStream);
            // Using GSave operator: this operator saves current graphics state
            page.getContents().add(new GSave());
            // Create Rectangle and Matrix objects
            Rectangle rectangle = new Rectangle(lowerLeftX, lowerLeftY, upperRightX, upperRightY);
            Matrix matrix = new Matrix(new double[] { rectangle.getURX() - rectangle.getLLX(), 0, 0,
                    rectangle.getURY() - rectangle.getLLY(), rectangle.getLLX(), rectangle.getLLY() });
            // Using ConcatenateMatrix (concatenate matrix) operator: defines how image must be placed
            page.getContents().add(new ConcatenateMatrix(matrix));
            XImage ximage = page.getResources().getImages().get_Item(page.getResources().getImages().size());
            // [page.Resources.Images.Count];
            // Using Do operator: this operator draws image
            page.getContents().add(new Do(ximage.getName()));
            // Using GRestore operator: this operator restores graphics state
            page.getContents().add(new GRestore());
            doc.save(outputDir + "PDFOperators_out.pdf");
            imageStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
