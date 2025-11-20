package com.aspose.pdf.examples.AsposePdfExamples.Tables;

import com.aspose.pdf.Document;
import com.aspose.pdf.TableAbsorber;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class ManipulateTablesInExistingPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Tables/ManipulateTablesInExistingPDF/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example manipulateTablesInExistingPDF start");
        manipulateTablesInExistingPDF(dataDir, outputDir);
        System.out.println("Example manipulateTablesInExistingPDF end");
    }

    public static void manipulateTablesInExistingPDF(String dataDir, String outputDir) {
        // load existing PDF file
        // Document doc = new Document(dataDir + "table.pdf");
        Document doc = new Document(dataDir + "SampleDataTable.pdf");
        try {
            // Create TableAbsorber object to find tables
            TableAbsorber absorber = new TableAbsorber();
            // Visit first page with absorber
            absorber.visit(doc.getPages().get_Item(1));
            // Get access to first table on page, first cell and text fragment in it
            TextFragment fragment = absorber.getTableList().get(0).getRowList().get(0).getCellList().get(0)
                    .getTextFragments().get_Item(1);
            // Change text of the first text fragment in the cell
            fragment.setText("Hello World !");
            // save updated document
            doc.save(outputDir + "Table_Manipulated.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
