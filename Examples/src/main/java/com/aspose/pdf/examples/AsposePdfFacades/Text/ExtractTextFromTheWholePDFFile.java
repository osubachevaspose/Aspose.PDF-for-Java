package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.facades.PdfExtractor;

public class ExtractTextFromTheWholePDFFile {

	public static void main(String[] args) {
		// open input PDF
		PdfExtractor extractor = new PdfExtractor();
		try {
			extractor.bindPdf("Input.pdf");
			// use parameterless ExtractText method
			extractor.extractText();
			// Save the extracted text to a text file
			extractor.getText("Output.txt");
		} finally {
			if (extractor != null)
				extractor.close();
		}
	}
}
