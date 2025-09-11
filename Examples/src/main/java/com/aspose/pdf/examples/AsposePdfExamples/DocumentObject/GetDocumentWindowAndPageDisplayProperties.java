package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;

public class GetDocumentWindowAndPageDisplayProperties {

	public static void main(String[] args) {
		// Open document
		Document doc = new Document("Original.pdf");
		try {
			// Get different document properties
			// Position of document's window - Default: false
			System.out.printf("CenterWindow :- " + doc.isCenterWindow());
			// Predominant reading order; determine the position of page when displayed side
			// by side - Default: L2R
			System.out.printf("Direction :- " + doc.getDirection());
			// Whether window's title bar should display document title.
			// If false, title bar displays PDF file name - Default: false
			System.out.printf("DisplayDocTitle :- " + doc.isDisplayDocTitle());
			// Whether to resize the document's window to fit the size of first displayed
			// page - Default: false
			System.out.printf("FitWindow :- " + doc.isFitWindow());
			// Whether to hide menu bar of the viewer application - Default: false
			System.out.printf("HideMenuBar :-" + doc.isHideMenubar());
			// Whether to hide tool bar of the viewer application - Default: false
			System.out.printf("HideToolBar :-" + doc.isHideToolBar());
			// Whether to hide UI elements like scroll bars and leaving only the page
			// contents displayed - Default: false
			System.out.printf("HideWindowUI :-" + doc.isHideWindowUI());
			// The document's page mode. How to display document on exiting full-screen
			// mode.
			System.out.printf("NonFullScreenPageMode :-" + doc.getNonFullScreenPageMode());
			// The page layout i.e. single page, one column
			System.out.printf("PageLayout :-" + doc.getPageLayout());
			// How the document should display when opened.
			System.out.printf("pageMode :-" + doc.getPageMode());
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
