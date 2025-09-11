package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;

public class DeleteParticularFormFieldFromPDFDocument {

	public static void main(String[] args) {
		// Open a document
		Document doc = new Document("input.pdf");
		// Delete a named field by name
		doc.getForm().delete("textbox1");
		// Save the modified PDF
		doc.save("output.pdf");
	}

}
