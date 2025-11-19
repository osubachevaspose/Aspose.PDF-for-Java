package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.DocSaveOptions;
import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class ConvertPDFToDOCOrDOCXFormat {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/ConvertPDFToDOCOrDOCXFormat/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example savingToDoc start");
        savingToDoc(dataDir, outputDir);
        System.out.println("Example savingToDoc end");

        System.out.println("Example savingToDOCX start");
        savingToDOCX(dataDir, outputDir);
        System.out.println("Example savingToDOCX end");

        System.out.println("Example usingTheDocSaveOptionsClass start");
        usingTheDocSaveOptionsClass(dataDir, outputDir);
        System.out.println("Example usingTheDocSaveOptionsClass end");
    }

    public static void savingToDoc(String dataDir, String outputDir) {
        // Open the source PDF document
        Document doc = new Document(dataDir + "input2.pdf");
        try {
            // Save the file into Microsoft document format
            doc.save(outputDir + "TableHeightIssue.doc", SaveFormat.Doc);
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void savingToDOCX(String dataDir, String outputDir) {
        // Load source PDF file
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Instantiate Doc SaveOptions instance
            DocSaveOptions options = new DocSaveOptions();
            // Set output file format as DOCX
            options.setFormat(DocSaveOptions.DocFormat.DocX);
            // Save resultant DOCX file
            doc.save(outputDir + "savingToDOCX.docx", options);
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void usingTheDocSaveOptionsClass(String dataDir, String outputDir) {
        // Open a document
        // Path of input PDF document
        String filePath = dataDir + "source.pdf";
        // Instantiate the Document object
        Document doc = new Document(filePath);
        try {
            // Create DocSaveOptions object
            DocSaveOptions options = new DocSaveOptions();
            // Set the recognition mode as Flow
            options.setMode(DocSaveOptions.RecognitionMode.Flow);
            // Set the Horizontal proximity as 2.5
            options.setRelativeHorizontalProximity(2.5f);
            // Enable the value to recognize bullets during conversion process
            options.setRecognizeBullets(true);
            // Save the resultant DOC file
            doc.save(outputDir + "usingTheDocSaveOptionsClass.doc", options);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
