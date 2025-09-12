package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import com.aspose.pdf.CryptoAlgorithm;
import com.aspose.pdf.Document;

public class EncryptPDFDocumentUsingEncryptionTypes {

	public static void main(String[] args) {
		// open document
		Document doc = new Document("input.pdf");
		try {
			// encrypt PDF
			doc.encrypt("user", "owner", 0, CryptoAlgorithm.AESx256);
			// save updated PDF
			doc.save("Encrypted_output.pdf");
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
