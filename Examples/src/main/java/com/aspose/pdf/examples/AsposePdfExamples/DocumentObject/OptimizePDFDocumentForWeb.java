package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;

public class OptimizePDFDocumentForWeb {

	public static void main(String[] args) {
		// Open document
		Document doc = new Document("Original.pdf");
		try {
			// Optimize for web
			doc.optimize();
			// Save output document
			doc.save("Optimized_output.pdf");
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
