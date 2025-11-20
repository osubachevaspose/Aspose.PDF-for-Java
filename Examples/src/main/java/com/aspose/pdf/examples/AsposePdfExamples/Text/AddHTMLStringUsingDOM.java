package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlFragment;
import com.aspose.pdf.MarginInfo;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class AddHTMLStringUsingDOM {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/AddHTMLStringUsingDOM/";
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example addHTMLStringUsingDOM start");
        addHTMLStringUsingDOM(outputDir);
        System.out.println("Example addHTMLStringUsingDOM end");
    }

    public static void addHTMLStringUsingDOM(String outputDir) {
        // Instantiate Document object
        Document doc = new Document();
        try {
            // Add a page to pages collection of PDF file
            Page page = doc.getPages().add();
            // Instantiate HtmlFragment with HTML contents
            HtmlFragment titel = new HtmlFragment("<fontsize=10><b><i>Table</i></b></fontsize>");
            // set MarginInfo for margin details
            MarginInfo Margin = new MarginInfo();
            Margin.setBottom(10);
            Margin.setTop(200);
            // Set margin information
            titel.setMargin(Margin);
            // Add HTML Fragment to paragraphs collection of page
            page.getParagraphs().add(titel);
            // Save PDF file
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
