package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import com.aspose.pdf.Document;

public class DecryptPDFFileUsingOwnerPassword {

	public static void main(String[] args) {
		// open document
		Document doc = new Document("input.pdf", "password");
		try {
			// decrypt PDF
			doc.decrypt();
			// save updated PDF
			doc.save("output.pdf");
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
