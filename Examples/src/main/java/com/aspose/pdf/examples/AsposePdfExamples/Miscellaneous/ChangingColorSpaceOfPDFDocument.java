package com.aspose.pdf.examples.AsposePdfExamples.Miscellaneous;

import com.aspose.pdf.Document;
import com.aspose.pdf.Operator;
import com.aspose.pdf.OperatorCollection;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.exceptions.PdfException;
import com.aspose.pdf.operators.SetCMYKColor;
import com.aspose.pdf.operators.SetCMYKColorStroke;
import com.aspose.pdf.operators.SetColorOperator;
import com.aspose.pdf.operators.SetRGBColor;
import com.aspose.pdf.operators.SetRGBColorStroke;

public class ChangingColorSpaceOfPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Miscellaneous/ChangingColorSpaceOfPDFDocument/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example changingColorSpaceOfPDFDocument start");
        changingColorSpaceOfPDFDocument(dataDir, outputDir);
        System.out.println("Example changingColorSpaceOfPDFDocument end");
    }

    public static void changingColorSpaceOfPDFDocument(String dataDir, String outputDir) {
        Document doc1 = new Document(dataDir + "input_color.pdf");
        try {
            OperatorCollection contents = doc1.getPages().get_Item(1).getContents();
            System.out.println("Values of RGB color operators in the pdf document");
            for (int i = 1; i <= contents.size(); i++) {
                Operator oper = contents.get_Item(i);
                if (oper instanceof SetRGBColor || oper instanceof SetRGBColorStroke) {
                    // Converting RGB to CMYK color
                    System.out.println(oper.toString());
                    double[] rgbFloatArray = new double[] {
                            (double) ((SetColorOperator) oper).getColor().getRed(),
                            (double) ((SetColorOperator) oper).getColor().getGreen(),
                            (double) ((SetColorOperator) oper).getColor().getBlue(),
                    };
                    double[] cmyk = new double[4];
                    if (oper instanceof SetRGBColor) {
                        ((SetRGBColor) oper).getCMYKColor(rgbFloatArray, cmyk);
                        contents.set_Item(i, new SetCMYKColor(cmyk[0], cmyk[1], cmyk[2], cmyk[3]));
                    } else if (oper instanceof SetRGBColorStroke) {
                        ((SetRGBColorStroke) oper).getCMYKColor(rgbFloatArray, cmyk);
                        contents.set_Item(i, new SetCMYKColorStroke(cmyk[0], cmyk[1], cmyk[2], cmyk[3]));
                    } else {
                        throw new PdfException("Unsupported command");
                    }
                }
            }
            doc1.save(outputDir + "input_colorout.pdf");
        } finally {
            if (doc1 != null)
                doc1.close();
        }
        // Testing the result
        System.out.println("Values of converted CMYK color operators in the result pdf document");
        Document doc2 = new Document(outputDir + "input_colorout.pdf");
        try {
            OperatorCollection contents = doc2.getPages().get_Item(1).getContents();
            for (int i = 1; i <= contents.size(); i++) {
                Operator oper = contents.get_Item(i);
                if (oper instanceof com.aspose.pdf.operators.SetCMYKColor
                        || oper instanceof com.aspose.pdf.operators.SetCMYKColorStroke) {
                    System.out.println(oper.toString());
                }
            }
        } finally {
            if (doc2 != null)
                doc2.close();
        }
    }
}
