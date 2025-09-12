package com.aspose.pdf.examples.AsposePdfFacades.Bookmarks;

import com.aspose.pdf.facades.PdfBookmarkEditor;

public class CreateBookmarksOfAllPages {

	public static void main(String[] args) {
		PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();
		try {
			// open document
			bookmarkEditor.bindPdf("Input.pdf");
			// create bookmark of all pages
			bookmarkEditor.createBookmarks();
			// save updated PDF file
			bookmarkEditor.save("Output.pdf");
		} finally {
			if (bookmarkEditor != null)
				bookmarkEditor.close();
		}
	}
}
