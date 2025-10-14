package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.*;

public class StyleTableCell {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/TaggedPDFs/StyleTableCell/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example styleTableCell start");
        styleTableCell(outputDir);
        System.out.println("Example styleTableCell end");
    }

    public static void styleTableCell(String outputDir) {
        // Create document
        Document doc = new Document();
        try {
            ITaggedContent taggedContent = doc.getTaggedContent();
            taggedContent.setTitle("Example table cell style");
            taggedContent.setLanguage("en-US");
            // Get root structure element
            StructureElement rootElement = taggedContent.getRootElement();
            // Create table structure element
            TableElement tableElement = taggedContent.createTableElement();
            rootElement.appendChild(tableElement);
            TableTHeadElement tableTHeadElement = tableElement.createTHead();
            TableTBodyElement tableTBodyElement = tableElement.createTBody();
            TableTFootElement tableTFootElement = tableElement.createTFoot();
            int rowCount = 4;
            int colCount = 4;
            int rowIndex;
            int i;
            TableTRElement headTrElement = tableTHeadElement.createTR();
            headTrElement.setAlternativeText("Head Row");
            for (i = 0; i < colCount; i++) {
                TableTHElement thElement = headTrElement.createTH();
                thElement.setText(String.format("Head %s", i));
                thElement.setBackgroundColor(Color.getGreenYellow());
                thElement.setBorder(new BorderInfo(BorderSide.All, 4.0F, Color.getGray()));
                thElement.setNoBorder(false);
                thElement.setMargin(new MarginInfo(16.0, 2.0, 8.0, 2.0));
                thElement.setAlignment(HorizontalAlignment.Right);
            }
            for (rowIndex = 0; rowIndex < rowCount; rowIndex++) {
                TableTRElement trElement = tableTBodyElement.createTR();
                trElement.setAlternativeText(String.format("Row %s", rowIndex));
                for (i = 0; i < colCount; i++) {
                    int colSpan = 1;
                    int rowSpan = 1;
                    if (i == 1 && rowIndex == 1) {
                        colSpan = 2;
                        rowSpan = 2;
                    } else if (i == 2 && (rowIndex == 1 || rowIndex == 2)) {
                        continue;
                    } else if (rowIndex == 2 && (i == 1 || i == 2)) {
                        continue;
                    }
                    TableTDElement tdElement = trElement.createTD();
                    tdElement.setText(String.format("Cell [%s, %s]", rowIndex, i));
                    tdElement.setBackgroundColor(Color.getYellow());
                    tdElement.setBorder(new BorderInfo(BorderSide.All, 4.0F, Color.getGray()));
                    tdElement.setNoBorder(false);
                    tdElement.setMargin(new MarginInfo(8.0, 2.0, 8.0, 2.0));
                    tdElement.setAlignment(HorizontalAlignment.Center);
                    TextState cellTextState = new TextState();
                    cellTextState.setForegroundColor(Color.getDarkBlue());
                    cellTextState.setFontSize(7.5F);
                    cellTextState.setFontStyle(FontStyles.Bold);
                    cellTextState.setFont(FontRepository.findFont("Arial"));
                    tdElement.setDefaultCellTextState(cellTextState);
                    tdElement.setWordWrapped(false);
                    tdElement.setVerticalAlignment(VerticalAlignment.Center);
                    tdElement.setColSpan(colSpan);
                    tdElement.setRowSpan(rowSpan);
                }
            }
            TableTRElement footTrElement = tableTFootElement.createTR();
            footTrElement.setAlternativeText("Foot Row");
            for (i = 0; i < colCount; i++) {
                TableTDElement tdElement = footTrElement.createTD();
                tdElement.setText(String.format("Foot %s", i));
            }
            // Save Tagged Pdf Document
            doc.save(outputDir + "StyleTableCell.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
