package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.Utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class ConvertTextFileToPDFFormat {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/ConvertTextFileToPDFFormat/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertTextFileToPDFFormat start");
        convertTextFileToPDFFormat(dataDir, outputDir);
        System.out.println("Example convertTextFileToPDFFormat end");
    }

    public static void convertTextFileToPDFFormat(String dataDir, String outputDir) {
        try {
            // Source PDF file
            File file = new File(dataDir + "test.txt");
            FileInputStream fis = new FileInputStream(file);
            try {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum); // no doubt here is 0
                    // Writes len bytes from the specified byte array starting at offset off to this
                    // byte array output stream.
                    System.out.println("read " + readNum + " bytes");
                }
                byte[] bytes = bos.toByteArray();
                ByteArrayInputStream srcStream = new ByteArrayInputStream(bytes);
                BufferedReader reader = new BufferedReader(new InputStreamReader(srcStream));
                String line;
                StringBuilder builder = new StringBuilder(5024);
                try {
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                        builder.append("\r\n");
                    }
                } finally {
                    reader.close();
                    // Instantiate a Document object by calling its empty constructor
                    Document doc = new Document();
                    try {
                        // Add a new page in Pages collection of Document
                        Page page = doc.getPages().add();
                        // Create an instance of TextFragmet and pass the text from reader object to its
                        // constructor as argument
                        TextFragment text = new TextFragment(builder.toString());
                        // text.TextState.Font = FontRepository.FindFont("Arial Unicode MS");
                        // Add a new text paragraph in paragraphs collection and pass the TextFragment object
                        page.getParagraphs().add(text);
                        // Save resultant PDF file
                        doc.save(outputDir + "textToPdf.pdf");
                    } finally {
                        if (doc != null)
                            doc.close();
                    }
                }
            } finally {
                if (fis != null)
                    fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
