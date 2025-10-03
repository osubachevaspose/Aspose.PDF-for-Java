package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlFragment;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextState;
import com.aspose.pdf.examples.Utils;

public class AddHTMLUsingDOMAndOverwrite {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/AddHTMLUsingDOMAndOverwrite/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addHTMLUsingDOMAndOverwrite start");
        addHTMLUsingDOMAndOverwrite(outputDir);
        System.out.println("Example addHTMLUsingDOMAndOverwrite end");
    }

    public static void addHTMLUsingDOMAndOverwrite(String outputDir) {
        // Instantiate Document object
        Document doc = new Document();
        try {
            // Add a page to pages collection of PDF file
            Page page = doc.getPages().add();
            // Instantiate HtmlFragment with HTML contnets
            HtmlFragment title = new HtmlFragment(
                    "<p style='font-family: Verdana'><b><i>Table contains text</i></b></p>");
            // Font-family from 'Verdana' will be reset to 'Arial'
            title.setTextState(new TextState("Arial"));
            title.setTextState(new TextState(20));
            // Set bottom margin information
            title.getMargin().setBottom(10);
            // Set top margin information
            title.getMargin().setTop(400);
            // Add HTML Fragment to paragraphs collection of page
            page.getParagraphs().add(title);
            // Save PDF file
            doc.save(outputDir + "AddHTMLUsingDOMAndOverwrite_out.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
