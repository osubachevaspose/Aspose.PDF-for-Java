package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.optimization.OptimizationOptions;

public class OptimizePDFFileSize {

	public static void main(String[] args) {
		runExamples();
	}

	public static void runExamples() {
		// The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/OptimizePDFFileSize/";
		String dataDir = Utils.getDataDir(testID);
		String outputDir = Utils.getOutDir(testID);

		System.out.println("============================");
		System.out.println("Example removeUnnecessaryObjects start");
		removeUnnecessaryObjects(dataDir, outputDir);
		System.out.println("Example removeUnnecessaryObjects end");

		System.out.println("Example compressingPDFWithImages start");
		compressingPDFWithImages(dataDir, outputDir);
		System.out.println("Example compressingPDFWithImages end");
	}

	public static void removeUnnecessaryObjects(String dataDir, String outputDir) {
		// Open document
		Document doc = new Document(dataDir + "Aspose_End-User-License-Agreement_2017-01-09.pdf");
		try {
			// Set RemoveUsedObject option
			OptimizationOptions optimizeOptions = new OptimizationOptions();
			optimizeOptions.setRemoveUnusedObjects(true);
			optimizeOptions.setSubsetFonts(true);
			// Optimize PDF document using OptimizationOptions
			doc.optimizeResources(optimizeOptions);
			// Save updated document
			doc.save(outputDir + "removeUnnecessaryObjects_out.pdf");
		} finally {
			if (doc != null)
				doc.close();
		}
	}

	public static void compressingPDFWithImages(String dataDir, String outputDir) {
		// Load source PDF file
		Document doc = new Document(dataDir + "Aspose_End-User-License-Agreement_2017-01-09.pdf");
		try {
			OptimizationOptions opt = new OptimizationOptions();
			opt.setRemoveUnusedObjects(false);
			opt.setLinkDuplicateStreams(false);
			opt.setRemoveUnusedStreams(false);
			// Enable image compression
			opt.getImageCompressionOptions().setCompressImages(true);
			// Set the quality of images in PDF file
			opt.getImageCompressionOptions().setImageQuality(10);
			doc.optimizeResources(opt);
			// Save the updated file
			doc.save(outputDir + "compressingPDFWithImages_out.pdf");
		} finally {
			if (doc != null)
				doc.close();
		}
	}
}
