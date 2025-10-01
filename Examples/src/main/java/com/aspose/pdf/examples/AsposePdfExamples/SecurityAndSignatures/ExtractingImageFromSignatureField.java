package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import com.aspose.pdf.Document;
import com.aspose.pdf.Field;
import com.aspose.pdf.SignatureField;
import com.aspose.pdf.examples.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExtractingImageFromSignatureField {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/SecurityAndSignatures/ExtractingImageFromSignatureField/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example extractingImageFromSignatureField start");
        extractingImageFromSignatureField(dataDir, outputDir);
        System.out.println("Example extractingImageFromSignatureField end");
    }

    public static void extractingImageFromSignatureField(String dataDir, String outputDir) {
        // Load source PDF file
        Document doc = new Document(dataDir + "test.pdf");
        int i = 0;
        try {
            for (Field field : doc.getForm().getFields()) {
                i++;
                SignatureField sf = (SignatureField) field;
                if (sf != null) {
                    FileOutputStream output = new FileOutputStream(outputDir + "im" + i + ".jpeg");
                    try {
                        InputStream tempStream = sf.extractImage();
                        byte[] b = new byte[tempStream.available()];
                        tempStream.read(b);
                        output.write(b);
                    } finally {
                        if (output != null)
                            output.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
