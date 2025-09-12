package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;

public class GetParticularPageInPDFFile {

	public static void main(String[] args) {
		// Open the first document
		Document doc = new Document("Mobile Software.pdf");
		try {
			// Get the page at a particular index of the Page Collection
			Page page = doc.getPages().get_Item(3);
			// Create a new Document object
			Document newDoc = new Document();
			try {
				// Add the page to the Pages collection of new document object
				newDoc.getPages().add(page);
				// Save the new file
				newDoc.save("page_" + page.getNumber() + ".pdf");
			} finally {
				if (newDoc != null)
					newDoc.close();
			}
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
