package com.aspose.pdf.examples.AsposePdfExamples.LinksAndActions;

import com.aspose.pdf.AnnotationSelector;
import com.aspose.pdf.Document;
import com.aspose.pdf.GoToURIAction;
import com.aspose.pdf.LinkAnnotation;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.examples.Utils;

import java.util.List;

public class GetPDFHyperlinkDestination {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/LinksAndActions/GetPDFHyperlinkDestination/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example getPDFHyperlinkDestination start");
        getPDFHyperlinkDestination(dataDir);
        System.out.println("Example getPDFHyperlinkDestination end");
    }

    public static void getPDFHyperlinkDestination(String dataDir) {
        Document doc = new Document(dataDir + "PdfWithHyperlink.pdf");
        try {
            // Extract actions
            Page page = doc.getPages().get_Item(1);
            AnnotationSelector selector = new AnnotationSelector(new LinkAnnotation(page, Rectangle.getTrivial()));
            page.accept(selector);
            List list = selector.getSelected();
            // Iterate through individual item inside list
            if (list.size() == 0)
                System.out.println("No Hyperlinks found.");
            else {
                // Loop through all the annotations
                for (LinkAnnotation link : (Iterable<LinkAnnotation>) list) {
                    // Print the destination URL
                    System.out.println("Destination: " + ((GoToURIAction) link.getAction()).getURI());
                }
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
