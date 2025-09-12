package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextBoxField;

public class AddTooltipToFormField {

	public static void main(String[] args) {
		// Open a document
		Document doc = new Document("input.pdf");
		try {
			// Get a field
			TextBoxField textBoxField = (TextBoxField) doc.getForm().get("textbox1");
			// Set the tooltip for textfield
			textBoxField.setAlternateName("Text box tool tip");
			// Save modified document
			doc.save("output.pdf");
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
