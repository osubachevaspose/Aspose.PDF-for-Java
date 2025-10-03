package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;
import com.aspose.pdf.TextSearchOptions;
import com.aspose.pdf.examples.Utils;

public class SearchAndGetTextFromPagesUsingRegularExpression {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/SearchAndGetTextFromPagesUsingRegularExpression/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example searchAndGetTextFromPagesUsingRegularExpression start");
        searchAndGetTextFromPagesUsingRegularExpression(dataDir);
        System.out.println("Example searchAndGetTextFromPagesUsingRegularExpression end");
    }

    public static void searchAndGetTextFromPagesUsingRegularExpression(String dataDir) {
        // Open a document
        Document doc = new Document(dataDir + "source.pdf");
        try {
            // Create TextAbsorber object to find all instances of the input search phrase
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("\\d{4}-\\d{4}"); // like 1999-2000
            // Set text search option to specify regular expression usage
            TextSearchOptions textSearchOptions = new TextSearchOptions(true);
            textFragmentAbsorber.setTextSearchOptions(textSearchOptions);
            // Accept the absorber for first page of document
            doc.getPages().accept(textFragmentAbsorber);
            // Get the extracted text fragments into collection
            TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
            // Loop through the fragments
            for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
                System.out.println("Text: " + textFragment.getText());
                System.out.println("Position: " + textFragment.getPosition());
                System.out.println("XIndent: " + textFragment.getPosition().getXIndent());
                System.out.println("YIndent: " + textFragment.getPosition().getYIndent());
                System.out.println("Font - Name: " + textFragment.getTextState().getFont().getFontName());
                System.out.println("Font - IsAccessible: " + textFragment.getTextState().getFont().isAccessible());
                System.out.println("Font - IsEmbedded - " + textFragment.getTextState().getFont().isEmbedded());
                System.out.println("Font - IsSubset: " + textFragment.getTextState().getFont().isSubset());
                System.out.println("Font Size: " + textFragment.getTextState().getFontSize());
                System.out.println("Foreground Color: " + textFragment.getTextState().getForegroundColor());
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
