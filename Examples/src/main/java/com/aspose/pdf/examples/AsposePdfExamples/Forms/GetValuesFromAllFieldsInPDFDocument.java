package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.Field;

public class GetValuesFromAllFieldsInPDFDocument {

	public static void main(String[] args) {
		// Open document
		Document doc = new Document("Form.pdf");
		try {
			Field[] fields = doc.getForm().getFields();
			for (int i = 0; i < fields.length; i++) {
				System.out.println("Form field: " + fields[i].getFullName());
				System.out.println("Form field: " + fields[i].getValue());
			}
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
