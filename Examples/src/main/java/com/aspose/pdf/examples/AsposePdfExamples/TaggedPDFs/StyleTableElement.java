package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.*;

public class StyleTableElement {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/TaggedPDFs/StyleTableElement/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example styleTableElement start");
        styleTableElement(outputDir);
        System.out.println("Example styleTableElement end");
    }

    public static void styleTableElement(String outputDir) {
        // Create document
        Document doc = new Document();
        try {
            ITaggedContent taggedContent = doc.getTaggedContent();
            taggedContent.setTitle("Example table style");
            taggedContent.setLanguage("en-US");
            // Get root structure element
            StructureElement rootElement = taggedContent.getRootElement();
            // Create table structure element
            TableElement tableElement = taggedContent.createTableElement();
            rootElement.appendChild(tableElement);
            tableElement.setBackgroundColor(Color.getBeige());
            tableElement.setBorder(new BorderInfo(BorderSide.All, 0.80F, Color.getGray()));
            tableElement.setAlignment(HorizontalAlignment.Center);
            tableElement.setBroken(TableBroken.Vertical);
            tableElement.setColumnAdjustment(ColumnAdjustment.AutoFitToWindow);
            tableElement.setColumnWidths("80 80 80 80 80");
            tableElement.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.50F, Color.getDarkBlue()));
            tableElement.setDefaultCellPadding(new MarginInfo(16.0, 2.0, 8.0, 2.0));
            tableElement.getDefaultCellTextState().setForegroundColor(Color.getDarkCyan());
            tableElement.getDefaultCellTextState().setFontSize(8F);
            tableElement.setDefaultColumnWidth("70");
            tableElement.setBroken(false);
            tableElement.setBordersIncluded(true);
            tableElement.setLeft(0F);
            tableElement.setTop(40F);
            tableElement.setRepeatingColumnsCount(2);
            tableElement.setRepeatingRowsCount(3);
            TextState rowStyle = new TextState();
            rowStyle.setBackgroundColor(Color.getLightCoral());
            tableElement.setRepeatingRowsStyle(rowStyle);
            TableTHeadElement tableTHeadElement = tableElement.createTHead();
            TableTBodyElement tableTBodyElement = tableElement.createTBody();
            TableTFootElement tableTFootElement = tableElement.createTFoot();
            TableTRElement headTrElement = tableTHeadElement.createTR();
            headTrElement.setAlternativeText("Head Row");
            for (int col = 0; col < 5; col++) {
                TableTHElement thElement = headTrElement.createTH();
                thElement.setText(String.format("Head %s", col));
            }
            for (int row = 0; row < 10; row++) {
                TableTRElement trElement = tableTBodyElement.createTR();
                trElement.setAlternativeText(String.format("Row %s", row));
                for (int col = 0; col < 5; col++) {
                    TableTDElement tdElement = trElement.createTD();
                    tdElement.setText(String.format("Cell [%s, %s]", row, col));
                }
            }
            TableTRElement footTrElement = tableTFootElement.createTR();
            footTrElement.setAlternativeText("Foot Row");
            for (int col = 0; col < 5; col++) {
                TableTDElement tdElement = footTrElement.createTD();
                tdElement.setText(String.format("Foot %s", col));
            }
            // Save Tagged Pdf Document
            doc.save(outputDir + "StyleTableElement.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
