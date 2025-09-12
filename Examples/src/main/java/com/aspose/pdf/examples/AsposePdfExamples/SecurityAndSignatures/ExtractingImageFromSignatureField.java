package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.aspose.pdf.Document;
import com.aspose.pdf.Field;
import com.aspose.pdf.SignatureField;

public class ExtractingImageFromSignatureField {

    public static void main(String[] args) {
        String myDir = "PathToString";
        // Load source PDF file
        Document doc = new Document(myDir + "test.pdf");
        int i = 0;
        try {
            for (Field field : doc.getForm().getFields()) {
                i++;
                SignatureField sf = (SignatureField) field;
                if (sf != null) {
                    FileOutputStream output = new FileOutputStream(myDir + "im" + i + ".jpeg");
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
