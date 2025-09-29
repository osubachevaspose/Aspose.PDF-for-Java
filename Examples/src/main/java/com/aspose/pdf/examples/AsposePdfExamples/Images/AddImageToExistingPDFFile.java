package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;
import com.aspose.pdf.Matrix;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.XImage;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.operators.ConcatenateMatrix;
import com.aspose.pdf.operators.Do;
import com.aspose.pdf.operators.GRestore;
import com.aspose.pdf.operators.GSave;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AddImageToExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/AddImageToExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addImageToExistingPDFFile start");
        addImageToExistingPDFFile(dataDir, outputDir);
        System.out.println("Example addImageToExistingPDFFile end");
    }

    public static void addImageToExistingPDFFile(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Set coordinates
            int lowerLeftX = 100;
            int lowerLeftY = 100;
            int upperRightX = 200;
            int upperRightY = 200;
            // Get the page you want to add the image to
            Page page = doc.getPages().get_Item(1);
            // Load image into stream
            FileInputStream imageStream = new FileInputStream(new File(dataDir +
                    "aspose-logo.jpg"));
            // Add an image to the Images collection of the page resources
            page.getResources().getImages().add(imageStream);
            // Using the GSave operator: this operator saves current graphics state
            page.getContents().add(new GSave());
            // Create Rectangle and Matrix objects
            Rectangle rectangle = new Rectangle(lowerLeftX, lowerLeftY, upperRightX,
                    upperRightY);
            Matrix matrix = new Matrix(new double[] { rectangle.getURX() -
                    rectangle.getLLX(), 0, 0,
                    rectangle.getURY() - rectangle.getLLY(), rectangle.getLLX(),
                    rectangle.getLLY() });
            // Using ConcatenateMatrix (concatenate matrix) operator: defines how
            // image must be placed
            page.getContents().add(new ConcatenateMatrix(matrix));
            XImage ximage = page.getResources().getImages().get_Item(page.getResources().getImages().size());
            // Using Do operator: this operator draws image
            page.getContents().add(new Do(ximage.getName()));
            // Using GRestore operator: this operator restores graphics state
            page.getContents().add(new GRestore());
            // Save the new PDF
            doc.save(outputDir + "Updated_document.pdf");
            // Close image stream
            imageStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
