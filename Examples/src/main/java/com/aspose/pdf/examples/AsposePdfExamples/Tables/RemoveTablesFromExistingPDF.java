package com.aspose.pdf.examples.AsposePdfExamples.Tables;

import com.aspose.pdf.AbsorbedCell;
import com.aspose.pdf.AbsorbedRow;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TableAbsorber;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfAnnotationEditor;

public class RemoveTablesFromExistingPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Tables/RemoveTablesFromExistingPDF/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example removeTablesFromExistingPDF start");
        removeTablesFromExistingPDF(dataDir, outputDir);
        System.out.println("Example removeTablesFromExistingPDF end");
    }

    public static void removeTablesFromExistingPDF(String dataDir, String outputDir) {
        PdfAnnotationEditor annotationEditor = new PdfAnnotationEditor();
        try {
            // annotationEditor.bindPdf(dataDir + "table2.pdf");
            annotationEditor.bindPdf(dataDir + "SampleDataTable.pdf");
            // Create TableAbsorber object to find tables
            TableAbsorber absorber = new TableAbsorber();
            // Visit first page with absorber
            absorber.visit(annotationEditor.getDocument().getPages().get_Item(1));
            // Getting the table rectangle
            Rectangle rect = absorber.getTableList().get(0).getRectangle();
            // clear text for the table
            for (AbsorbedRow row : absorber.getTableList().get(0).getRowList())
                for (AbsorbedCell cell : row.getCellList())
                    for (TextFragment fragment : cell.getTextFragments())
                        fragment.setText("");
            // Need to add a pixel to delete the border
            rect.setLLX(rect.getLLX() - 1);
            rect.setLLY(rect.getLLY() - 1);
            rect.setURX(rect.getURX() + 1);
            rect.setURY(rect.getURY() + 1);
            annotationEditor.redactArea(1, rect, java.awt.Color.WHITE);
            annotationEditor.save(outputDir + "out_table_deleted.pdf");
        } finally {
            if (annotationEditor != null)
                annotationEditor.close();
        }
    }
}
