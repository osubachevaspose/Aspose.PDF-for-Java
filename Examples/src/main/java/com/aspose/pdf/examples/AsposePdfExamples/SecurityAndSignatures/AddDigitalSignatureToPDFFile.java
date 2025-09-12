package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import com.aspose.pdf.Document;
import com.aspose.pdf.PKCS1;
import com.aspose.pdf.facades.PdfFileSignature;

public class AddDigitalSignatureToPDFFile {

	public static void main(String[] args) {
		String dataDir = "PathToDir";
		// Instantiate Document object
		Document doc = new Document();
		try {
			// Add a page to PDF document
			doc.getPages().add();
			OutputStream out = new java.io.ByteArrayOutputStream();
			// Save document to Stream object
			doc.save(out);
			// Create PdfFileSignature instance
			PdfFileSignature signSingle = new PdfFileSignature();
			try {
				// Bind the source PDF by reading contents of Stream
				signSingle.bindPdf(new ByteArrayInputStream(((ByteArrayOutputStream) out).toByteArray()));
				// Sign the PDF file using PKCS1 object
				signSingle.sign(1, true, new java.awt.Rectangle(100, 100, 150, 50),
						new PKCS1(dataDir + "VirtualCabinetPortal (1).pfx", "password"));
				// Set image for signature appearance
				signSingle.setSignatureAppearance(dataDir + "im.jpg");
				// Save final output
				signSingle.save(dataDir + "out_PDFNEWJAVA_33311.pdf");
			} finally {
				if (signSingle != null)
					signSingle.close();
			}
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
