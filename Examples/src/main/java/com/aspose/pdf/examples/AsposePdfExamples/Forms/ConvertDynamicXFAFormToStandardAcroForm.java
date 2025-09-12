package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.FormType;

public class ConvertDynamicXFAFormToStandardAcroForm {

	public static void main(String[] args) {
		// Load dynamic XFA form
		Document doc = new Document("XFAform.pdf");
		try {
			// Set the form fields type as standard AcroForm
			doc.getForm().setType(FormType.Standard);
			// Save the resultant PDF
			doc.save("Standard_AcroForm.pdf");
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
