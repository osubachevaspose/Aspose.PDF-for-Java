package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.JavascriptAction;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class SetPDFExpiration {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/SetPDFExpiration/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example setPDFExpiration start");
        setPDFExpiration(dataDir, outputDir);
        System.out.println("Example setPDFExpiration end");
    }

    public static void setPDFExpiration(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "input.pdf");
        try {
            JavascriptAction javaScript = new JavascriptAction("var year=2014;" + "var month=4;"
                    + "today = new Date(); today = new Date(today.getFullYear(), today.getMonth());"
                    + "expiry = new Date(year, month);" + "if (today.getTime() > expiry.getTime())"
                    + "app.alert('The file is expired. You need a new one.');");
            doc.setOpenAction(javaScript);
            doc.save(outputDir + "JavaScript-Added.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
