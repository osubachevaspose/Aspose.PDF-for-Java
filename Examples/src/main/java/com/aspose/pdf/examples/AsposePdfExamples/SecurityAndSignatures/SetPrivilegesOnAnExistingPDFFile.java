package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import com.aspose.pdf.CryptoAlgorithm;
import com.aspose.pdf.Document;
import com.aspose.pdf.facades.DocumentPrivilege;

public class SetPrivilegesOnAnExistingPDFFile {

	public static void main(String[] args) {
		Document doc = new Document("inputFile.pdf");
		try {
			DocumentPrivilege documentPrivilege = DocumentPrivilege.getForbidAll();
			documentPrivilege.setAllowScreenReaders(true);
			documentPrivilege.setAllowPrint(true);
			doc.encrypt("user", "owner", documentPrivilege, CryptoAlgorithm.AESx128, false);
			doc.save("outputFile.pdf");
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
