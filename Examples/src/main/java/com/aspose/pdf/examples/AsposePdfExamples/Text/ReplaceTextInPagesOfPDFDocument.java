package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Font;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;
import com.aspose.pdf.TextSearchOptions;
import com.aspose.pdf.TextSegment;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class ReplaceTextInPagesOfPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/ReplaceTextInPagesOfPDFDocument/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example replaceTextOnAllPages start");
        replaceTextOnAllPages(dataDir, outputDir);
        System.out.println("Example replaceTextOnAllPages end");

        System.out.println("Example replaceTextUsingRegularExpression start");
        replaceTextUsingRegularExpression(dataDir, outputDir);
        System.out.println("Example replaceTextUsingRegularExpression end");

        System.out.println("Example useNonEnglishFontWhenReplacingText start");
        useNonEnglishFontWhenReplacingText(dataDir, outputDir);
        System.out.println("Example useNonEnglishFontWhenReplacingText end");

        System.out.println("Example searchTextStringsAndRemoveTheContentsBetweenThem start");
        searchTextStringsAndRemoveTheContentsBetweenThem(dataDir, outputDir);
        System.out.println("Example searchTextStringsAndRemoveTheContentsBetweenThem end");
    }

    public static void replaceTextOnAllPages(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Create TextAbsorber object to find all instances of the input search phrase
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("sample");
            // Accept the absorber for first page of document
            doc.getPages().accept(textFragmentAbsorber);
            // Get the extracted text fragments into collection
            TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
            // Loop through the fragments
            for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
                // Update text and other properties
                textFragment.setText("New Pharase");
                textFragment.getTextState().setFont(FontRepository.findFont("Verdana"));
                textFragment.getTextState().setFontSize(22);
                textFragment.getTextState().setForegroundColor(Color.getBlue());
                textFragment.getTextState().setBackgroundColor(Color.getGray());
            }
            // Save the updated PDF file
            doc.save(outputDir + "Updated_Text_all_pages.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void replaceTextUsingRegularExpression(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Create TextAbsorber object to find all instances of the input search phrase
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber(
                    "This is a sample text on page .{3} in PDF file");
            // Set text search option to specify regular expression usage
            TextSearchOptions textSearchOptions = new TextSearchOptions(true);
            textFragmentAbsorber.setTextSearchOptions(textSearchOptions);
            // Accept the absorber for first page of document
            doc.getPages().accept(textFragmentAbsorber);
            // Get the extracted text fragments into collection
            TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
            // Loop through the fragments
            for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
                // Update text and other properties
                textFragment.setText("New Phrase");
                textFragment.getTextState().setFont(FontRepository.findFont("Verdana"));
                textFragment.getTextState().setFontSize(22);
                textFragment.getTextState().setForegroundColor(Color.getBlue());
                textFragment.getTextState().setBackgroundColor(Color.getGray());
            }
            // Save the updated PDF file
            doc.save(outputDir + "Updated_Text_regex.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void useNonEnglishFontWhenReplacingText(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Lets to change every of word "Page" to some Japan text with specific font
            // MSGothic that might be installed in the OS
            // Also, it may be another font that supports hieroglyphs
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber(
                    "This is a sample text on page .{3} in PDF file");
            // Create instance of Text Search options
            TextSearchOptions searchOptions = new TextSearchOptions(true);
            textFragmentAbsorber.setTextSearchOptions(searchOptions);
            // Accept the absorber for all pages of document
            doc.getPages().accept(textFragmentAbsorber);
            // Get the extracted text fragments into collection
            TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
            // Loop through the fragments
            for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
                // Get particular segment from Segments collection of TextFragment object
                TextSegment textSegment = textFragment.getSegments().get_Item(1);
                // Create an instance of font object using MSGothic font
                Font font = FontRepository.findFont("MSGothic");
                // Get the size of current TextSegment object
                float size = textSegment.getTextState().getFontSize();
                // Replace the text Fragment with Japanese text
                textFragment.setText("ュヰレントヮタチナヒヘベサア");
                // Set font for TextFragment as MSGothic
                textFragment.getTextState().setFont(font);
                textFragment.getTextState().setFontSize(size);
            }
            // Save the updated document
            doc.save(outputDir + "Japanese_Text.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }

    public static void searchTextStringsAndRemoveTheContentsBetweenThem(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // create TextAbsorber object to find all instances of the input search phrase
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber(
                    "This is a sample text on page .{3} in PDF file",
                    new TextSearchOptions(true));
            // accept the absorber for first page of document
            doc.getPages().accept(textFragmentAbsorber);
            // get the extracted text fragments into collection
            TextFragmentCollection textFragments = textFragmentAbsorber.getTextFragments();
            // loop through the Text fragments
            for (TextFragment textFragment : (Iterable<TextFragment>) textFragments) {
                // It is enough to remove all segments between the first and the last if they
                // are separate segments.
                int size = textFragment.getSegments().size();
                size++;
                // after each deleting size is decremented by 1
                while (textFragment.getSegments().size() > 2)
                    // removes the second fragment and recalculates the remaining fragments
                    textFragment.getSegments().delete(2);
            }
            doc.save(outputDir + "testHeading_out.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
