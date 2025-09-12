package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;

public class SplitPDFFileIntoIndividualPages {

	public static void main(String[] args) {
		// Open a document
		Document doc = new Document("input.pdf");
		try {
			// Loop through the pages
			for (int i = 1; i <= doc.getPages().size(); i++) {
				// Create a new Document object
				Document newDoc = new Document();
				try {
					// Get the page at a given index of the Page Collection
					newDoc.getPages().add(doc.getPages().get_Item(i));
					// Save the new PDF file
					newDoc.save("page_" + i + ".pdf");
				} finally {
					if (newDoc != null)
						newDoc.close();
				}
			}
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
