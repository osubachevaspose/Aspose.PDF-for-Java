package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.facades.PdfContentEditor;

public class ReplaceTextOnAParticularPageInAnExistingPDFFile {

	public static void main(String[] args) {
		PdfContentEditor contentEditor = new PdfContentEditor();
		try {
			// open input PDF
			contentEditor.bindPdf("Input.pdf");
			// replace text on a particular page
			contentEditor.replaceText("Content", 2, "World");
			// save output PDF
			contentEditor.save("ReplaceTextOnAllPages.pdf");
		} finally {
			if (contentEditor != null)
				contentEditor.close();
		}
	}
}
