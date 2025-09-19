package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.Rotation;

public class ChangePageOrientation {

	public static void main(String[] args) {
		changePageOrientation();
		fittingThePageContentToNewPageOrientation();
	}

	public static void changePageOrientation() {
		Document doc = new Document("Input.pdf");
		try {
			int pageCount = doc.getPages().size();
			for (int i = 1; i <= pageCount; i++) {
				Rectangle r = doc.getPages().get_Item(i).getMediaBox();
				double newHeight = r.getWidth();
				double newWidth = r.getHeight();
				double newLLX = r.getLLX();
				// We must move page upper in order to compensate changing page size
				// (lower edge of the page is 0,0 and information is usually placed from the top of the page).
				// That's why we move lower edge upper on difference between old and new height.
				double newLLY = r.getLLY() + (r.getHeight() - newHeight);
				Page p = doc.getPages().get_Item(i);
				p.setMediaBox(new Rectangle(newLLX, newLLY, newLLX + newWidth, newLLY + newHeight));
				// Sometimes we also need to set CropBox (if it was set in original file)
				p.setCropBox(new Rectangle(newLLX, newLLY, newLLX + newWidth, newLLY + newHeight));
				// Setting Rotation angle of page
				p.setRotate(Rotation.on90);
			}
			doc.save("Output.pdf");
		} finally {
			if (doc != null)
				doc.close();
		}
	}

	@SuppressWarnings("unused")
    public static void fittingThePageContentToNewPageOrientation() {
		Document doc = new Document("Input.pdf");
		try {
			Rectangle r = doc.getPages().get_Item(0).getMediaBox();
			// New height the same
			double newHeight = r.getHeight();
			// New width is expanded proportionally to make orientation landscape
			// (we assume that previous orientation is portrait)
			double newWidth = r.getHeight() * r.getHeight() / r.getWidth();
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
