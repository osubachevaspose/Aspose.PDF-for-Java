package com.aspose.pdf.examples.AsposePdfFacades.Forms;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.Form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExportDataToXMLFromAPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Forms/ExportDataToXMLFromAPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example exportDataToXMLFromAPDFFile start");
        exportDataToXMLFromAPDFFile(dataDir, outputDir);
        System.out.println("Example exportDataToXMLFromAPDFFile end");
    }

    public static void exportDataToXMLFromAPDFFile(String dataDir, String outputDir) {
        Form form = new Form();
        try {
            // open document
            form.bindPdf(dataDir + "FormDataXfa_in.pdf");
            // create XML file.
            FileOutputStream xmlOutputStream = new FileOutputStream(outputDir + "formData.xml");
            // export data
            form.exportXml(xmlOutputStream);
            // close file stream
            xmlOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (form != null)
                form.close();
        }
    }
}
