package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.facades.PdfExtractor;

public class ExtractTextFromIndividualPagesOfAPDF {

	public static void main(String[] args) {
		// open input PDF
		PdfExtractor extractor = new PdfExtractor();
		try {
			extractor.bindPdf("Input.pdf");
			// use parameterless ExtractText method
			extractor.extractText();
			int pageNumber = 1;
			while (extractor.hasNextPageText()) {
				extractor.getNextPageText("output" + pageNumber + ".txt");
				pageNumber++;
			}
		} finally {
			if (extractor != null)
				extractor.close();
		}
	}
}
