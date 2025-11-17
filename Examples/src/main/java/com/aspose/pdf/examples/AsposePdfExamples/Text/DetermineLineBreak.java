package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class DetermineLineBreak {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/DetermineLineBreak/";
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example determineLineBreak start");
        determineLineBreak(outputDir);
        System.out.println("Example determineLineBreak end");
    }

    public static void determineLineBreak(String outputDir) {
        Document doc = new Document();
        try {
            Page page = doc.getPages().add();
            for (int i = 0; i < 4; i++) {
                TextFragment text = new TextFragment(
                        "Lorem ipsum \r\ndolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
                text.getTextState().setFontSize(20);
                page.getParagraphs().add(text);
            }
            String notifications = doc.getPages().get_Item(1).getNotifications();
            System.out.println(notifications);
            doc.save(outputDir + "DetermineLineBreak_out.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
