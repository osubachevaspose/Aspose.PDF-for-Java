package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.PdfFormat;

public class ValidatePDFDocumentForPDFAStandard {

	public static void main(String[] args) {
		// open document
		Document doc = new Document("Original.pdf");
		// validate PDF for PDF/A-1a
		doc.validate("validation-result-A1A.xml", PdfFormat.PDF_A_1B);
		// save output document
		doc.save("Optimized_output.pdf");
	}
}
