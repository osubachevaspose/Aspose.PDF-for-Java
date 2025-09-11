package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.DocumentInfo;

public class GetPDFFileInformation {

	public static void main(String[] args) {
		// Open document
		Document doc = new Document("Original.pdf");
		try {
			// Get document information
			DocumentInfo docInfo = doc.getInfo();
			// Show document information
			System.out.printf("Author:-" + docInfo.getAuthor());
			System.out.printf("\n Creation Date:-" + docInfo.getCreationDate());
			System.out.printf("\n Keywords:-" + docInfo.getKeywords());
			System.out.printf("\n Modify Date:-" + docInfo.getModDate());
			System.out.printf("\n Subject:-" + docInfo.getSubject());
			System.out.printf("\n Title:-" + docInfo.getTitle());
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
