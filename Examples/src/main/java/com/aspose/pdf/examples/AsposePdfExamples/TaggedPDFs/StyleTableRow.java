package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.*;

public class StyleTableRow {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/TaggedPDFs/StyleTableRow/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example styleTableRow start");
        styleTableRow(outputDir);
        System.out.println("Example styleTableRow end");
    }

    public static void styleTableRow(String outputDir) {
        // Create document
        Document doc = new Document();
        try {
            ITaggedContent taggedContent = doc.getTaggedContent();
            taggedContent.setTitle("Example table row style");
            taggedContent.setLanguage("en-US");
            // Get root structure element
            StructureElement rootElement = taggedContent.getRootElement();
            // Create table structure element
            TableElement tableElement = taggedContent.createTableElement();
            rootElement.appendChild(tableElement);
            TableTHeadElement tableTHeadElement = tableElement.createTHead();
            TableTBodyElement tableTBodyElement = tableElement.createTBody();
            TableTFootElement tableTFootElement = tableElement.createTFoot();
            TableTRElement headTrElement = tableTHeadElement.createTR();
            headTrElement.setAlternativeText("Head Row");
            for (int col = 0; col < 3; col++) {
                TableTHElement thElement = headTrElement.createTH();
                thElement.setText(String.format("Head %s", col));
            }
            for (int row = 0; row < 7; row++) {
                TableTRElement trElement = tableTBodyElement.createTR();
                trElement.setAlternativeText(String.format("Row %s", row));
                trElement.setBackgroundColor(Color.getLightSeaGreen());
                trElement.setBorder(new BorderInfo(BorderSide.All, 0.75F, Color.getDarkGray()));
                trElement.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.50F, Color.getBlue()));
                trElement.setMinRowHeight(100.0);
                trElement.setFixedRowHeight(120.0);
                trElement.setRowBroken(true);
                TextState cellTextState = new TextState();
                cellTextState.setForegroundColor(Color.getRed());
                trElement.setDefaultCellTextState(cellTextState);
                trElement.setDefaultCellPadding(new MarginInfo(16.0, 2.0, 8.0, 2.0));
                trElement.setVerticalAlignment(VerticalAlignment.Bottom);
                for (int col = 0; col < 3; col++) {
                    TableTDElement tdElement = trElement.createTD();
                    tdElement.setText(String.format("Cell [{0}, {1}]", row, col));
                }
            }
            TableTRElement footTrElement = tableTFootElement.createTR();
            footTrElement.setAlternativeText("Foot Row");
            for (int col = 0; col < 3; col++) {
                TableTDElement tdElement = footTrElement.createTD();
                tdElement.setText(String.format("Foot %s", col));
            }
            // Save Tagged Pdf Document
            doc.save(outputDir + "StyleTableRow.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
