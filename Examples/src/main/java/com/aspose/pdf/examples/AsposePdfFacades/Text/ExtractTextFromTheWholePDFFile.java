package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.facades.PdfExtractor;

public class ExtractTextFromTheWholePDFFile {

	public static void main(String[] args) {
		// open input PDF
		PdfExtractor extractor = new PdfExtractor();
		try {
			extractor.bindPdf("input.pdf");
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
