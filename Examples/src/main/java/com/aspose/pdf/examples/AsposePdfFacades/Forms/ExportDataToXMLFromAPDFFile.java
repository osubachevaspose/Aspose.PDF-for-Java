package com.aspose.pdf.examples.AsposePdfFacades.Forms;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.aspose.pdf.facades.Form;

public class ExportDataToXMLFromAPDFFile {

    public static void main(String[] args) throws IOException {
        Form form = new Form();
        try {
            // open document
            form.bindPdf("student.pdf");
            // create XML file.
            OutputStream xmlOutputStream = new FileOutputStream("student.xml");
            // export data
            form.exportXml(xmlOutputStream);
            // close file stream
            xmlOutputStream.close();
        } finally {
            if (form != null)
                form.close();
        }
    }
}
