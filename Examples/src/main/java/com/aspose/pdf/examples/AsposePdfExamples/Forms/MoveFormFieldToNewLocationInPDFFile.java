package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TextBoxField;

public class MoveFormFieldToNewLocationInPDFFile {

	public static void main(String[] args) {
		// Open a document
		Document doc = new Document("input.pdf");
		try {
			// Get a field
			TextBoxField textBoxField = (TextBoxField) doc.getForm().get("textbox1");
			// Modify the field location
			textBoxField.setRect(new Rectangle(300, 400, 600, 500));
			// Save the modified document
			doc.save("output.pdf");
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
