package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ParagraphElement;
import com.aspose.pdf.tagged.logicalstructure.elements.ils.NoteElement;

public class CreateNoteStructureElement {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/TaggedPDFs/CreateNoteStructureElement/";
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example createNoteStructureElement start");
        createNoteStructureElement(outputDir);
        System.out.println("Example createNoteStructureElement end");
    }

    public static void createNoteStructureElement(String outputDir) {
        // The path to the documents directory.
        // String dataDir = Utils.getDataDir() + "TaggedPDFs\\";
        // Create Pdf Document
        Document doc = new Document();
        try {
            ITaggedContent taggedContent = doc.getTaggedContent();
            taggedContent.setTitle("Sample of Note Elements");
            taggedContent.setLanguage("en-US");
            // Add Paragraph Element
            ParagraphElement paragraph = taggedContent.createParagraphElement();
            taggedContent.getRootElement().appendChild(paragraph);
            // Add NoteElement
            NoteElement note1 = taggedContent.createNoteElement();
            paragraph.appendChild(note1);
            note1.setText("Note with auto generate ID. ");
            // Add NoteElement
            NoteElement note2 = taggedContent.createNoteElement();
            paragraph.appendChild(note2);
            note2.setText("Note with ID = 'note_002'. ");
            note2.setId("note_002");
            // Add NoteElement
            NoteElement note3 = taggedContent.createNoteElement();
            paragraph.appendChild(note3);
            note3.setText("Note with ID = 'note_003'. ");
            note3.setId("note_003");
            // Save Tagged Pdf Document
            doc.save(outputDir + "CreateNoteStructureElement.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
