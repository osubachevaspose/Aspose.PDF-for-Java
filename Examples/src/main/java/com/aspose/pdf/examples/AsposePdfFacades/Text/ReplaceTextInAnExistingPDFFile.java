package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.facades.PdfContentEditor;

public class ReplaceTextInAnExistingPDFFile {

	public static void main(String[] args) {
		PdfContentEditor contentEditor = new PdfContentEditor();
		try {
			// open input PDF
			contentEditor.bindPdf("input.pdf");
			// replace text on all pages
			contentEditor.replaceText("Hello", "World");
			// save output PDF
			contentEditor.save("ReplaceTextOnAllPages.pdf");
		} finally {
			if (contentEditor != null)
				contentEditor.close();
		}
	}
}
