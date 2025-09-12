package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlFragment;
import com.aspose.pdf.Page;

public class AddHTMLOrderedListIntoDocuments {

    public static void main(String[] args) {
        // Instantiate Document object
        Document doc = new Document();
        try {
            // Instantiate HtmlFragment object with corresponding HTML fragment
            HtmlFragment t = new HtmlFragment(
                    "`<body style='line-height: 100px;'><ul><li>First</li><li>Second</li><li>Third</li><li>Fourth</li><li>Fifth</li></ul>Text after the list.<br/>Next line<br/>Last line</body>`");
            // Add Page in Pages Collection
            Page page = doc.getPages().add();
            // Add HtmlFragment inside page
            page.getParagraphs().add(t);
            // Save resultant PDF file
            doc.save("AddHTMLOrderedListIntoDocuments_out.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
