package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextBoxField;

public class FillFormFieldInPDFDocument {

	public static void main(String[] args) {
		// Open a document
		Document doc = new Document("input.pdf");
		try {
			// Get a field
			TextBoxField textBoxField = (TextBoxField) doc.getForm().get("textbox1");
			// Set the field value
			textBoxField.setValue("Value of TextField");
			// Save the updated document
			doc.save("output.pdf");
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
