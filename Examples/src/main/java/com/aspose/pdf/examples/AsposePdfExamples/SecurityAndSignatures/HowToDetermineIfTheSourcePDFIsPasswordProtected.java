package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import com.aspose.pdf.Document;
import com.aspose.pdf.PasswordType;
import com.aspose.pdf.exceptions.InvalidPasswordException;
import com.aspose.pdf.facades.PdfFileInfo;

public class HowToDetermineIfTheSourcePDFIsPasswordProtected {

	public static void main(String[] args) {
		howToDetermineIfTheSourcePDFIsPasswordProtected();
		getInformationAboutPDFDocumentSecurity();
		determineCorrectPasswordFromArray();
	}

	public static void howToDetermineIfTheSourcePDFIsPasswordProtected() {
		// load the source PDF document
		PdfFileInfo fileInfo = new PdfFileInfo("source.pdf");
		try {
			// determine that source PDF file is Encrypted with password
			Boolean encrypted = fileInfo.isEncrypted();
			// MessageBox displays the current status related to PDf encryption
			System.out.println(encrypted.toString());
		} finally {
			if (fileInfo != null)
				fileInfo.close();
		}
	}

	public static void getInformationAboutPDFDocumentSecurity() {
		// instantiate FielInfo object
		PdfFileInfo fileInfo1 = new PdfFileInfo();
		try {
			// bind source PDF file
			fileInfo1.bindPdf("source.pdf");
			// print if source file is password encrypted
			System.out.println("Is document encrypted = " + fileInfo1.isEncrypted());
			// determine if the password type for document is User
			if (fileInfo1.getPasswordType() == PasswordType.User)
				;
			// print password type information
			System.out.println("Password type = " + fileInfo1.getPasswordType() + " (type = User)");
		} finally {
			if (fileInfo1 != null)
				fileInfo1.close();
		}

		PdfFileInfo fileInfo2 = new PdfFileInfo();
		try {
			fileInfo2.bindPdf("source.pdf", "user");
			// print if document is encrypted
			System.out.println("Document is encrypted = " + fileInfo2.isEncrypted());
			// determine if the password type for document is Owner
			if (fileInfo2.getPasswordType() == PasswordType.Owner)
				;
			// print password type information
			System.out.println("Password type = " + fileInfo2.getPasswordType() + " (type = Owner)");
			// print if document has open password specified
			System.out.println("Document has Open Password = " + fileInfo2.hasOpenPassword());
			// print if document has edit password specified
			System.out.println("Document has Edit Password = " + fileInfo2.hasEditPassword());
		} finally {
			if (fileInfo2 != null)
				fileInfo2.close();
		}

		PdfFileInfo fileInfo3 = new PdfFileInfo();
		try {
			fileInfo3.bindPdf("c:/pdftest/source.pdf");
			// print if document is encrypted
			System.out.println("Document is encrypted = " + fileInfo3.isEncrypted());
			if (fileInfo3.getPasswordType() == PasswordType.Inaccessible)
				;
			// print password type information
			System.out.println("Password type = " + fileInfo3.getPasswordType() + " (type = Inaccessible)");
			if (fileInfo3.hasOpenPassword())
				;
			// Document has open password enable
			System.out.println("Document has open password enabled = " +
					fileInfo3.hasOpenPassword());
			try {
				boolean hasOwnerPassword = fileInfo3.hasEditPassword();
				System.out.println("When PasswordType is Inaccessible we can't read HasEditPassword property.");
			} catch (Exception e) {
				// write what we expect
			}
		} finally {
			if (fileInfo3 != null)
				fileInfo3.close();
		}
	}

	public static void determineCorrectPasswordFromArray() {
		// load source PDF file
		PdfFileInfo fileInfo = new PdfFileInfo();
		try {
			fileInfo.bindPdf("source.pdf");
			// determine if the source PDF is encrypted
			System.out.println("File is password protected " + fileInfo.isEncrypted());
		} finally {
			if (fileInfo != null)
				fileInfo.close();
		}
		String[] passwords = new String[] { "test", "test1", "user", "test3", "sample" };
		for (int passwordcount = 0; passwordcount < passwords.length; passwordcount++) {
			try {
				Document doc = new Document("source.pdf", passwords[passwordcount]);
				try {
					if (doc.getPages().size() > 0) {
						System.out.println("Password = " + passwords[passwordcount] + " is correct");
						System.out.println("Number of Page in document are = " + doc.getPages().size());
					}
				} finally {
					if (doc != null)
						doc.close();
				}
			} catch (InvalidPasswordException ex) {
				System.out.println("------------------------------------------");
				System.out.println("Password = " + passwords[passwordcount] + "  is not correct");
			}
		}
	}
}
