package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;
import com.aspose.pdf.TextSegment;

public class SearchAndGetTextSegmentsFromPagesOfPDF {

    public static void main(String[] args) {
        // Open document
        Document doc = new Document("input.pdf");
        try {
            // Create TextAbsorber object to find all instances of the input search phrase
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("sample");
            // Accept the absorber for first page of document
            doc.getPages().accept(textFragmentAbsorber);
            // Get the extracted text fragments into collection
            TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
            // Loop through the Text fragments
            for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
                // Iterate through text segments
                for (TextSegment textSegment : (Iterable<TextSegment>) textFragment.getSegments()) {
                    System.out.println("Text :- " + textSegment.getText());
                    System.out.println("Position :- " + textSegment.getPosition());
                    System.out.println("XIndent :- " + textSegment.getPosition().getXIndent());
                    System.out.println("YIndent :- " + textSegment.getPosition().getYIndent());
                    System.out.println("Font - Name :- " + textSegment.getTextState().getFont().getFontName());
                    System.out.println("Font - IsAccessible :- " + textSegment.getTextState().getFont().isAccessible());
                    System.out.println("Font - IsEmbedded - " + textSegment.getTextState().getFont().isEmbedded());
                    System.out.println("Font - IsSubset :- " + textSegment.getTextState().getFont().isSubset());
                    System.out.println("Font Size :- " + textSegment.getTextState().getFontSize());
                    System.out.println("Foreground Color :- " + textSegment.getTextState().getForegroundColor());
                }
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
