package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.Utils;

public class UseLatexScript {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/UseLatexScript/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example useLatexScript start");
        useLatexScript(outputDir);
        System.out.println("Example useLatexScript end");
    }

    // @SuppressWarnings("deprecation")
    public static void useLatexScript(String outputDir) {
        // Create a new Document Object
        Document doc = new Document();
        try {
            // Add Page in Pages Collection
            Page page = doc.getPages().add();
            // Create a Table
            Table table = new Table();
            // Add a row into Table
            Row row = table.getRows().add();
            // Add Cell with Latex Script to add methematical expressions/formulae
            String text = "$123456789+\\sqrt{1}+\\int_a^b f(x)dx$";
            Cell cell = row.getCells().add();
            MarginInfo marginInfo = new MarginInfo();
            marginInfo.setLeft(20);
            marginInfo.setRight(20);
            marginInfo.setTop(20);
            marginInfo.setBottom(20);
            cell.setMargin(marginInfo);
            // Second LatexFragment constructor bool parameter provides LaTeX paragraph
            // indents elimination.
            LatexFragment ltext1 = new LatexFragment(text, true);
            cell.getParagraphs().add(ltext1);
            // Add table inside page
            page.getParagraphs().add(table);
            // Save the document
            doc.save(outputDir + "LatextScriptInPdf_out.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
