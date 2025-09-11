package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;

public class TrimWhiteSpaceAroundPage {

	public static void main(String[] args) {
		// load the source PDF document
		Document doc = new Document("input.pdf");
		try {
			// get page to trim white space
			Page pdfPage = doc.getPages().get_Item(1);
			// get the content boundaries
			Rectangle contentBBox = pdfPage.calculateContentBBox();
			// set Page CropBox and MedioBos as per content boundries to tirm white space
			pdfPage.setCropBox(contentBBox);
			pdfPage.setMediaBox(contentBBox);
			// save the resultant PDF
			doc.save("output_trim.pdf");
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
