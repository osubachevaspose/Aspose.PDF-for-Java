package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Border;
import com.aspose.pdf.BorderStyle;
import com.aspose.pdf.Cell;
import com.aspose.pdf.ComboBoxField;
import com.aspose.pdf.Dash;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.RadioButtonField;
import com.aspose.pdf.RadioButtonOptionField;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.Row;
import com.aspose.pdf.SignatureField;
import com.aspose.pdf.Table;
import com.aspose.pdf.TextBoxField;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.Utils;

import java.awt.Color;

public class AddFormFieldInPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Forms/AddFormFieldInPDFDocument/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addFormFieldInPDFDocument start");
        addFormFieldInPDFDocument(dataDir, outputDir);
        System.out.println("Example addFormFieldInPDFDocument end");

        System.out.println("Example addRadioButtonFieldInPDFDocument start");
        addRadioButtonFieldInPDFDocument(outputDir);
        System.out.println("Example addRadioButtonFieldInPDFDocument end");

        System.out.println("Example addRadioButtonFieldWithThreeOptions start");
        addRadioButtonFieldWithThreeOptions(outputDir);
        System.out.println("Example addRadioButtonFieldWithThreeOptions end");

        System.out.println("Example addingComboBoxField start");
        addingComboBoxField(outputDir);
        System.out.println("Example addingComboBoxField end");

        System.out.println("Example addingSignatureField start");
        addingSignatureField(dataDir, outputDir);
        System.out.println("Example addingSignatureField end");
    }

    public static void addFormFieldInPDFDocument(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Create a field
            TextBoxField textBoxField1 = new TextBoxField(doc.getPages().get_Item(1),
                    new Rectangle(100, 200, 300, 300));
            // Set the field name
            textBoxField1.setPartialName("textbox1");
            // Set the field value
            textBoxField1.setValue("Text Box");
            // Create a border object
            Border border = new Border(textBoxField1);
            // Set the border width
            border.setWidth(5);
            // Set the border dash style
            border.setDash(new Dash(1, 1));
            // Set the field border
            textBoxField1.setBorder(border);
            // Add the field to the document
            doc.getForm().add(textBoxField1, 1);
            // Save the modified PDF
            doc.save(outputDir + "TextBoxField.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void addRadioButtonFieldInPDFDocument(String outputDir) {
        // instantiate Document object
        Document doc = new Document();
        try {
            // add a page to PDF file
            doc.getPages().add();
            // instantiate RadioButtonField object with page number as argument
            RadioButtonField radio = new RadioButtonField(doc.getPages().get_Item(1));
            // add first radio button option and also specify its origin using Rectangle
            // object
            radio.addOption("Test", new Rectangle(20, 720, 40, 740));
            // add second radio button option
            radio.addOption("Test1", new Rectangle(120, 720, 140, 740));
            // add radio button to form object of Document object
            doc.getForm().add(radio);
            // save the PDF file
            doc.save(outputDir + "RadioButtonSample.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void addRadioButtonFieldWithThreeOptions(String outputDir) {
        Document doc = new Document();
        try {
            Page page = doc.getPages().add();
            Table table = new Table();
            table.setColumnWidths("120 120 120");
            page.getParagraphs().add(table);
            Row r1 = table.getRows().add();
            Cell c1 = r1.getCells().add();
            Cell c2 = r1.getCells().add();
            Cell c3 = r1.getCells().add();
            RadioButtonField rf = new RadioButtonField(page);
            rf.setPartialName("radio");
            doc.getForm().add(rf, 1);
            RadioButtonOptionField opt1 = new RadioButtonOptionField();
            RadioButtonOptionField opt2 = new RadioButtonOptionField();
            RadioButtonOptionField opt3 = new RadioButtonOptionField();
            opt1.setOptionName("Item1");
            opt2.setOptionName("Item2");
            opt3.setOptionName("Item3");
            opt1.setWidth(15);
            opt1.setHeight(15);
            opt2.setWidth(15);
            opt2.setHeight(15);
            opt3.setWidth(15);
            opt3.setHeight(15);
            rf.add(opt1);
            rf.add(opt2);
            rf.add(opt3);
            opt1.setBorder(new Border(opt1));
            opt1.getBorder().setWidth(1);
            opt1.getBorder().setStyle(BorderStyle.Solid);
            opt1.getCharacteristics().setBorder(Color.BLACK);
            opt1.getDefaultAppearance().setTextColor(Color.RED);
            opt1.setCaption(new TextFragment("Item1"));
            opt2.setBorder(new Border(opt2));
            opt2.getBorder().setWidth(1);
            opt2.getBorder().setStyle(BorderStyle.Solid);
            opt2.getCharacteristics().setBorder(Color.BLACK);
            opt2.getDefaultAppearance().setTextColor(Color.RED);
            opt2.setCaption(new TextFragment("Item2"));
            opt3.setBorder(new Border(opt3));
            opt3.getBorder().setWidth(1);
            opt3.getBorder().setStyle(BorderStyle.Solid);
            opt3.getCharacteristics().setBorder(Color.BLACK);
            opt3.getDefaultAppearance().setTextColor(Color.RED);
            opt3.setCaption(new TextFragment("Item3"));
            c1.getParagraphs().add(opt1);
            c2.getParagraphs().add(opt2);
            c3.getParagraphs().add(opt3);
            doc.save(outputDir + "RadioButtonField.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void addingComboBoxField(String outputDir) {
        // create Document object
        Document doc = new Document();
        try {
            // add page to document object
            doc.getPages().add();
            // instantiate ComboBox Field object
            ComboBoxField combo = new ComboBoxField(doc.getPages().get_Item(1), new Rectangle(100, 600, 150, 616));
            // add option to ComboBox
            combo.addOption("Red");
            combo.addOption("Yellow");
            combo.addOption("Green");
            combo.addOption("Blue");
            // add combo box object to form fields collection of document object
            doc.getForm().add(combo);
            // save the PDF document
            doc.save(outputDir + "ComboBox_Added.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void addingSignatureField(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Create a field
            SignatureField signatureField = new SignatureField(doc.getPages().get_Item(1),
                    new Rectangle(100, 200, 300, 300));
            signatureField.setPartialName("signature1");
            // Add field to the document
            doc.getForm().add(signatureField, 1);
            // Save modified PDF
            doc.save(outputDir + "SignatureField.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
