package com.aspose.pdf.examples.AsposePdfExamples.Tables;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Cell;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.Row;
import com.aspose.pdf.Table;
import com.aspose.pdf.TableBroken;
import com.aspose.pdf.examples.Utils;

public class HideSpannedCellBorder {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Tables/HideSpannedCellBorder/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example hideSpannedCellBorder start");
        hideSpannedCellBorder(dataDir, outputDir);
        System.out.println("Example hideSpannedCellBorder end");
    }

    public static void hideSpannedCellBorder(String dataDir, String outputDir) {
        Document doc = new Document();
        try {
            Page page = doc.getPages().add();
            // Instantiate a table object that will be nested inside outerTable that will
            // break inside the same page
            Table mytable = new Table();
            mytable.setBroken(TableBroken.Vertical);
            mytable.setDefaultCellBorder(new BorderInfo(BorderSide.All));
            mytable.setRepeatingColumnsCount(2);
            page.getParagraphs().add(mytable);
            // Add header Row
            Row row = mytable.getRows().add();
            Cell cell = row.getCells().add("header 1");
            cell.setColSpan(2);
            cell.setBackgroundColor(Color.getLightGray());
            Cell header3 = row.getCells().add("header 3");
            Cell cell2 = row.getCells().add("header 4");
            cell2.setColSpan(2);
            cell2.setBackgroundColor(Color.getLightBlue());
            row.getCells().add("header 6");
            Cell cell3 = row.getCells().add("header 7");
            cell3.setColSpan(2);
            cell3.setBackgroundColor(Color.getLightGreen());
            Cell cell4 = row.getCells().add("header 9");
            cell4.setColSpan(3);
            cell4.setBackgroundColor(Color.getLightCoral());
            row.getCells().add("header 12");
            row.getCells().add("header 13");
            row.getCells().add("header 14");
            row.getCells().add("header 15");
            row.getCells().add("header 16");
            row.getCells().add("header 17");
            for (int rowCounter = 0; rowCounter < 1; rowCounter++) {
                // Create rows in the table and then cells in the rows
                Row row1 = mytable.getRows().add();
                row1.getCells().add("col " + rowCounter + ", 1");
                row1.getCells().add("col " + rowCounter + ", 2");
                row1.getCells().add("col " + rowCounter + ", 3");
                row1.getCells().add("col " + rowCounter + ", 4");
                row1.getCells().add("col " + rowCounter + ", 5");
                row1.getCells().add("col " + rowCounter + ", 6");
                row1.getCells().add("col " + rowCounter + ", 7");
                row1.getCells().add("col " + rowCounter + ", 8");
                row1.getCells().add("col " + rowCounter + ", 9");
                row1.getCells().add("col " + rowCounter + ", 10");
                row1.getCells().add("col " + rowCounter + ", 11");
                row1.getCells().add("col " + rowCounter + ", 12");
                row1.getCells().add("col " + rowCounter + ", 13");
                row1.getCells().add("col " + rowCounter + ", 14");
                row1.getCells().add("col " + rowCounter + ", 15");
                row1.getCells().add("col " + rowCounter + ", 16");
                row1.getCells().add("col " + rowCounter + ", 17");
            }
            doc.save(outputDir + "3_out.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
