package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.DocumentInfo;
import com.aspose.pdf.examples.Utils;

public class GetPDFFileInformation {

	public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/GetPDFFileInformation/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example getPDFFileInformation start");
        getPDFFileInformation(dataDir);
        System.out.println("Example getPDFFileInformation end");
    }

    public static void getPDFFileInformation(String dataDir) {
		// Open document
        Document doc = new Document(dataDir + "input.pdf");
		try {
			// Get document information
			DocumentInfo documentInfo = doc.getInfo();
			// Show document information
			System.out.println("Author: " + documentInfo.getAuthor());
			System.out.println("Creation Date: " + documentInfo.getCreationDate());
			System.out.println("Keywords: " + documentInfo.getKeywords());
			System.out.println("Modify Date: " + documentInfo.getModDate());
			System.out.println("Subject: " + documentInfo.getSubject());
			System.out.println("Title: " + documentInfo.getTitle());
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
