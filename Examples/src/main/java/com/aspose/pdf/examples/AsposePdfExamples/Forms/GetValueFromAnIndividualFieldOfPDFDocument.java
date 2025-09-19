package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextBoxField;

public class GetValueFromAnIndividualFieldOfPDFDocument {

	public static void main(String[] args) {
		// Open a document
		Document doc = new Document("Field_Added_output.pdf");
		try {
			// Get a field
			TextBoxField textBoxField = (TextBoxField) doc.getForm().get("textbox1");
			// Get the field name
			System.out.println("PartialName :-" + textBoxField.getPartialName());
			// Get the field value
			System.out.println("Value :-" + textBoxField.getValue());
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
