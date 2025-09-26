package com.aspose.pdf.examples.AsposePdfExamples.Miscellaneous;

import com.aspose.pdf.Document;
import com.aspose.pdf.Operator;
import com.aspose.pdf.OperatorCollection;
import com.aspose.pdf.operators.SetCMYKColor;
import com.aspose.pdf.operators.SetCMYKColorStroke;
import com.aspose.pdf.operators.SetRGBColor;
import com.aspose.pdf.operators.SetRGBColorStroke;

public class ChangingColorSpaceOfPDFDocument {

    public static void main(String[] args) {
        Document doc1 = new Document("input_color.pdf");
        try {
            OperatorCollection contents = doc1.getPages().get_Item(1).getContents();
            System.out.println("Values of RGB color operators in the pdf document");
            for (int j = 1; j <= contents.size(); j++) {
                Operator oper = contents.get_Item(j);
                if (oper instanceof SetRGBColor || oper instanceof SetRGBColorStroke) {
                    // Converting RGB to CMYK color
                    System.out.println(oper.toString());
                }
                double[] rgbFloatArray = new double[] {
                        Double.valueOf(oper.getParameters().get(0).toString()),
                        Double.valueOf(oper.getParameters().get(1).toString()),
                        Double.valueOf(oper.getParameters().get(2).toString()),
                };
                double[] cmyk = new double[4];
                if (oper instanceof SetRGBColor) {
                    ((SetRGBColor) oper).getCMYKColor(rgbFloatArray, cmyk);
                    contents.set_Item(j, new SetCMYKColor(cmyk[0], cmyk[1], cmyk[2], cmyk[3]));
                } else if (oper instanceof SetRGBColorStroke) {
                    ((SetRGBColorStroke) oper).getCMYKColor(rgbFloatArray, cmyk);
                    contents.set_Item(j, new SetCMYKColorStroke(cmyk[0], cmyk[1], cmyk[2], cmyk[3]));
                } else {
                    throw new java.lang.Throwable("Unsupported command");
                }
            }
            doc1.save("input_colorout.pdf");
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (doc1 != null)
                doc1.close();
        }
        // Testing the result
        System.out.println("Values of converted CMYK color operators in the result pdf document");
        Document doc2 = new Document("input_colorout.pdf");
        try {
            OperatorCollection contents = doc2.getPages().get_Item(1).getContents();
            for (int j = 1; j <= contents.size(); j++) {
                Operator oper = contents.get_Item(j);
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
