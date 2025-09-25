package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.facades.PdfExtractor;

public class ExtractTextFromARangeOfPages {

	public static void main(String[] args) {
		PdfExtractor extractor = new PdfExtractor();
		try {
			// open input PDF
			extractor.bindPdf("input.pdf");
			// specify start and end pages
			extractor.setStartPage(2);
			extractor.setEndPage(3);
			// use parameterless ExtractText method
			extractor.extractText();
			// Save the extracted text to a text file
			extractor.getText("output.txt");
		} finally {
			if (extractor != null)
				extractor.close();
		}
	}
}
