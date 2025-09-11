package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;

public class GetXMPMetadataFromPDFFile {

	public static void main(String[] args) {
		// Open document
		Document doc = new Document("input.pdf");
		try {
			// Get properties
			System.out.println("xmp:CreateDate: " + doc.getMetadata().get_Item("xmp:CreateDate"));
			System.out.println("xmp:Nickname: " + doc.getMetadata().get_Item("xmp:Nickname"));
			System.out.println("xmp:CustomProperty: " + doc.getMetadata().get_Item("xmp:CustomProperty"));
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
