package com.aspose.pdf.examples.AsposePdfFacades.Forms;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.Form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExportDataToFDFFromAPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Forms/ExportDataToFDFFromAPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example exportDataToFDFFromAPDFFile start");
        exportDataToFDFFromAPDFFile(dataDir, outputDir);
        System.out.println("Example exportDataToFDFFromAPDFFile end");
    }

    public static void exportDataToFDFFromAPDFFile(String dataDir, String outputDir) {
        // open document
        Form form = new Form();
        try {
            form.bindPdf(dataDir + "FormDataXfa_in.pdf");
            // create fdf file.
            FileOutputStream fdfOutputStream = new FileOutputStream(outputDir + "formData.fdf");
            // export data
            form.exportFdf(fdfOutputStream);
            // close file stream
            fdfOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (form != null)
                form.close();
        }
    }
}
