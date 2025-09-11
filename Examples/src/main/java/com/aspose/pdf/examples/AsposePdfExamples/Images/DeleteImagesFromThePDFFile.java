package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;

public class DeleteImagesFromThePDFFile {

	public static void main(String[] args) {
		// Open a document
		Document doc = new Document("input.pdf");
		// Delete a particular image
		doc.getPages().get_Item(1).getResources().getImages().delete(1);
		// Save the updated PDF file
		doc.save("output.pdf");
	}
}
