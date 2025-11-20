package com.aspose.pdf.examples.AsposePdfExamples.Operators;

import com.aspose.pdf.Document;
import com.aspose.pdf.OperatorCollection;
import com.aspose.pdf.XForm;
import com.aspose.pdf.XImage;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.operators.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DrawXFormOnPage {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Operators/DrawXFormOnPage/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example drawXFormOnPage start");
        drawXFormOnPage(dataDir, outputDir);
        System.out.println("Example drawXFormOnPage end");
    }

    public static void drawXFormOnPage(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "DrawXFormOnPage.pdf");
        try {
            // Add the pages of the source document to the target document
            OperatorCollection pageContents = doc.getPages().get_Item(1).getContents();
            // The sample demonstrates
            // GSave/GRestore operators usage
            // ConcatenateMatrix operator usage to position xForm
            // Do operator usage to draw xForm on page

            // Wrap existing contents with GSave/GRestore operators pair
            // this is to get initial graphics state at the end of existing contents
            // otherwise there might remain some undesirable transformations at the end of
            // existing operators chain
            pageContents.insert(1, new GSave());
            pageContents.add(new GRestore());

            // Add save graphics state operator to properly clear graphics state after new commands
            pageContents.add(new GSave());

            XForm form = XForm.createNewForm(doc.getPages().get_Item(1), doc);
            doc.getPages().get_Item(1).getResources().getForms().add(form);
            form.getContents().add(new GSave());
            // Define image width and heigh
            form.getContents().add(new ConcatenateMatrix(200, 0, 0, 200, 0, 0));
            // Load image into stream
            FileInputStream imageStream = new FileInputStream(dataDir + "aspose-logo.jpg");
            // Add image to Images collection of the XForm Resources
            form.getResources().getImages().add(imageStream);
            XImage ximage = form.getResources().getImages().get_Item(form.getResources().getImages().size());
            // Using Do operator: this operator draws image
            form.getContents().add(new Do(ximage.getName()));
            form.getContents().add(new GRestore());
            imageStream.close();

            pageContents.add(new GSave());
            // Place form to the x=100 y=500 coordinates
            pageContents.add(new ConcatenateMatrix(1, 0, 0, 1, 100, 500));
            // Draw form with Do operator
            pageContents.add(new Do(form.getName()));
            pageContents.add(new GRestore());

            pageContents.add(new GSave());
            // Place form to the x=100 y=300 coordinates
            pageContents.add(new ConcatenateMatrix(1, 0, 0, 1, 100, 300));
            // Draw form with Do operator
            pageContents.add(new Do(form.getName()));
            pageContents.add(new GRestore());

            // Restore graphics state with GRestore after the GSave
            pageContents.add(new GRestore());

            doc.save(outputDir + "blank-sample2_out.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
