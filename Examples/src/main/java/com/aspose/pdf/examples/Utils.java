package com.aspose.pdf.examples;

import com.aspose.pdf.examples.AsposePdfExamples.Annotations.*;
import com.aspose.pdf.examples.AsposePdfExamples.Attachments.*;
import com.aspose.pdf.examples.AsposePdfExamples.Bookmarks.*;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.*;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentObject.*;
import com.aspose.pdf.examples.AsposePdfExamples.Forms.*;
import com.aspose.pdf.examples.AsposePdfExamples.Graphs.*;
import com.aspose.pdf.examples.AsposePdfExamples.Headings.*;
import com.aspose.pdf.examples.AsposePdfExamples.Images.*;
import com.aspose.pdf.examples.AsposePdfExamples.LinksAndActions.*;
import com.aspose.pdf.examples.AsposePdfExamples.Miscellaneous.*;
import com.aspose.pdf.examples.AsposePdfExamples.Operators.*;
import com.aspose.pdf.examples.AsposePdfExamples.Pages.*;
import com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures.*;
import com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks.*;
import com.aspose.pdf.examples.AsposePdfExamples.Tables.*;
import com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs.*;
import com.aspose.pdf.examples.AsposePdfExamples.Text.*;
import com.aspose.pdf.examples.AsposePdfFacades.Annotations.*;
import com.aspose.pdf.examples.AsposePdfFacades.Attachments.*;
import com.aspose.pdf.examples.AsposePdfFacades.Bookmarks.*;
import com.aspose.pdf.examples.AsposePdfFacades.Document.*;
import com.aspose.pdf.examples.AsposePdfFacades.Forms.*;
import com.aspose.pdf.examples.AsposePdfFacades.Images.*;
import com.aspose.pdf.examples.AsposePdfFacades.Pages.*;
import com.aspose.pdf.examples.AsposePdfFacades.PDFPrinting.*;
import com.aspose.pdf.examples.AsposePdfFacades.SecurityAndSignatures.*;
import com.aspose.pdf.examples.AsposePdfFacades.StampsAndWatermarks.*;
import com.aspose.pdf.examples.AsposePdfFacades.Text.*;

import java.io.File;

public class Utils {

    public static void main(String[] args) {
        // run all examples in evaluation mode:

        // AsposePdfExamples.Annotations
        AddAnnotationToPDF.runExamples();
        DeleteAllAnnotationsFromPageOfPDFFile.runExamples();
        DeleteParticularAnnotationFromThePDFFile.runExamples();
        GetAllAnnotationsFromPageInPDF.runExamples();
        GetParticularAnnotationFromPDF.runExamples();
        RedactCertainPageRegionWithRedactionAnnotation.runExamples();
        StrikeOutWordsUsingStrikeOutAnnotation.runExamples();

        // AsposePdfExamples.Attachments
        AddAttachmentToPDF.runExamples();
        DeleteAllAttachmentsFromPDF.runExamples();
        DisableFilesCompressionWhenAddingAsEmbeddedResources.runExamples();
        GetAttachmentInformation.runExamples();
        GetAttachmentsFromPDFDocument.runExamples();

        // AsposePdfExamples.Bookmarks
        AddBookmarkToPDFDocument.runExamples();
        AddChildBookmarkToPDFDocument.runExamples();
        BookmarkShouldPointToStartOfPage.runExamples();
        DeleteBookmarksFromPDFDocument.runExamples();
        ExpandedBookmarksWhenViewingDocument.runExamples();
        GetBookmarksFromPDFDocument.runExamples();
        UpdateBookmarksInPDFDocument.runExamples();

        // AsposePdfExamples.DocumentConversion
        ConvertEPUBFileToPDFFormat.runExamples();
        ConvertHTMLToPDFFormat.runExamples();
        ConvertPCLToPDFFormat.runExamples();
        ConvertPDFFileToXPSFormat.runExamples();
        ConvertPDFToDOCOrDOCXFormat.runExamples();
        ConvertPDFToEPUBFormat.runExamples();
        ConvertPDFToExcelWorkbook.runExamples();
        ConvertPDFToMobiXML.runExamples();
        ConvertPDFToPDFAFormat.runExamples();
        ConvertPDFToPPTX.runExamples();
        ConvertPDFToSVGFormat.runExamples();
        ConvertPDFtoXLSX.runExamples();
        // ConvertPDFToXML.runExamples(); Will be fixed in the version 25.10
        ConvertPostScriptFileToPDFFormat.runExamples();
        ConvertSVGFileToPDFFormat.runExamples();
        ConvertTextFileToPDFFormat.runExamples();
        ConvertXMLFileToPDF.runExamples();
        ConvertXPSFileToPDFFormat.runExamples();
        ConvertXSLFOToPDF.runExamples();
        EscapeHTMLTagsAndSpecialCharacters.runExamples();
        PDFToEMF.runExamples();
        PDFToHTMLAllResourceEmbeddedInSingleResultantStream.runExamples();
        PDFToHTMLAvoidSavingImagesInSVGFormat.runExamples();
        PDFtoHTMLExcludeFontResources.runExamples();
        PDFToHTMLGetWarningForFontSubstitution.runExamples();
        PDFToHTMLRenderPDFDataLayersAsSeparateHTMLLayerElement.runExamples();
        PDFToHTMLSingleHTMLWithAllResourcesEmbedded.runExamples();
        PDFToHTMLSpecifyImagesFolder.runExamples();
        PDFToHTMLSplittingOutputToMultipageHTML.runExamples();
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // PDFToHTMLWithFontSubstitution.runExamples();
        // AddStructureElementIntoElement.runExamples(); throws
        // Exception in thread "main" java.lang.NullPointerException: Cannot invoke
        // "com.aspose.pdf.internal.l6n.le.l1p()" because "<parameter2>" is null
        // at
        // com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs.AddStructureElementIntoElement
        // .addStructureElementIntoElement(AddStructureElementIntoElement.java:80)
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ValidatePDFUAStandards.runExamples();

        // AsposePdfExamples.DocumentObject
        AddingJavaScriptDOM.runExamples();
        AddLayersToPDFFile.runExamples();
        AddTOCToExistingPDF.runExamples();
        // requires tesseract
        // ConvertingNonSearchablePDFToSearchablePDFDocument.runExamples();
        ConvertPDFFromRGBColorspaceToGrayscale.runExamples();
        EmbeddingFontsInExistingPDFFile.runExamples();
        EmbeddingFontsWhileCreatingPDF.runExamples();
        ExtractFilesFromPDFPortfolio.runExamples();
        GetAllFonts.runExamples();
        GetDocumentWindowAndPageDisplayProperties.runExamples();
        GetPDFFileInformation.runExamples();
        GetSetZoomFactorOfPDFFile.runExamples();
        GetXMPMetadataFromPDFFile.runExamples();
        HelloWorld.runExamples();
        OptimizePDFDocumentForWeb.runExamples();
        OptimizePDFFileSize.runExamples();
        RemoveMetadataFromPDF.runExamples();
        SetDefaultFont.runExamples();
        SetDocumentWindowAndPageDisplayProperties.runExamples();
        SetPDFExpiration.runExamples();
        com.aspose.pdf.examples.AsposePdfExamples.DocumentObject.SetPDFFileInformation.runExamples();
        TrimWhiteSpaceAroundPage.runExamples();
        ValidatePDFDocumentForPDFAStandard.runExamples();

        // AsposePdfExamples.Forms
        AddFormFieldInPDFDocument.runExamples();
        AddTooltipToFormField.runExamples();
        ConvertDynamicXFAFormToStandardAcroForm.runExamples();
        DeleteParticularFormFieldFromPDFDocument.runExamples();
        FillFormFieldInPDFDocument.runExamples();
        GetFormFieldsFromSpecificRegionOfPDFFile.runExamples();
        GetValueFromAnIndividualFieldOfPDFDocument.runExamples();
        GetValuesFromAllFieldsInPDFDocument.runExamples();
        HowToAddGroupedCheckBoxes.runExamples();
        ModifyFormFieldInPDFDocument.runExamples();
        MoveFormFieldToNewLocationInPDFFile.runExamples();
        SetCustomFormFieldFont.runExamples();

        // AsposePdfExamples.Graphs
        AddLineObjectToPDF.runExamples();
        ControllingZOrderOfRectangle.runExamples();
        CreateFilledRectangleObject.runExamples();
        DrawingLineAcrossThePage.runExamples();

        // AsposePdfExamples.Headings
        ApplyNumberingStyleInHeading.runExamples();

        // AsposePdfExamples.Images
        AddImage.runExamples();
        AddImageToExistingPDFFile.runExamples();
        ConvertAnImageToPDF.runExamples();
        ConvertParticularPageRegionToImage.runExamples();
        ConvertPDFPagesToBMPImage.runExamples();
        ConvertPDFPagesToJPEGImage.runExamples();
        ConvertPDFPagesToPNGImages.runExamples();
        ConvertPDFPagesToTIFFImage.runExamples();
        // no input file
        // DeleteImageFromPDFResourcesFoundByImagePlacementAbsorber.runExamples();
        DeleteImagesFromThePDFFile.runExamples();
        ExtractImageProperties.runExamples();
        ExtractImagesFromThePDFFile.runExamples();
        GetNameOfImagesEmbeddedInPDFFile.runExamples();
        IdentifyIfImageInsidePDFIsColoredOrBlackAndWhite.runExamples();
        ReplaceImageInExistingPDFFile.runExamples();
        SettingDPIOrPPIOfImagesInPDF.runExamples();

        // AsposePdfExamples.LinksAndActions
        AddHyperlinkInPDFFile.runExamples();
        CreateALinkToAnotherPDFDocument.runExamples();
        GetPDFHyperlinkDestination.runExamples();
        RemoveDocumentOpenActionFromPDFFile.runExamples();

        // AsposePdfExamples.Miscellaneous
        // no input file ChangingColorSpaceOfPDFDocument.runExamples();
        GettingProductAndBuildInformation.runExamples();
        HowToAddDrawingWithTransparentColor.runExamples();

        // AsposePdfExamples.Operators
        DrawXFormOnPage.runExamples();
        PDFOperators.runExamples();
        RemoveGraphicsObjects.runExamples();

        // AsposePdfExamples.Pages
        AddImageAsPageBackground.runExamples();
        ChangePageOrientation.runExamples();
        ConcatenatePDFFiles.runExamples();
        DeleteParticularPageFromThePDFFile.runExamples();
        DeterminePageColor.runExamples();
        GetPageCountOfPDF.runExamples();
        GetPageProperties.runExamples();
        GetParticularPageInPDFFile.runExamples();
        InsertAnEmptyPageIntoPDFFile.runExamples();
        SplitPDFFileIntoIndividualPages.runExamples();
        UpdatePageDimensions.runExamples();

        // AsposePdfExamples.SecurityAndSignatures
        AddDigitalSignatureToPDFFile.runExamples();
        DecryptPDFFileUsingOwnerPassword.runExamples();
        EncryptPDFDocumentUsingEncryptionTypes.runExamples();
        ExtractingImageFromSignatureField.runExamples();
        HowToDetermineIfTheSourcePDFIsPasswordProtected.runExamples();
        com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures.SetPrivilegesOnAnExistingPDFFile.runExamples();

        // AsposePdfExamples.StampsAndWatermarks
        AddImageStampAsBackgroundInFloatingBox.runExamples();
        AddingDifferentHeadersInOnePDFFile.runExamples();
        AddingImageStampInPDFFile.runExamples();
        AddingPDFPageStampInThePDFFile.runExamples();
        AddingTextInHeaderOrFooterOfPDFFile.runExamples();
        AddingTextStampInPDFFile.runExamples();
        AddPageNumberStampInPDF.runExamples();
        ControlImageQualityWhenAddingImageStamp.runExamples();
        DefineAlignmentForTextStampObject.runExamples();
        ExtractTextFromStampAnnotation.runExamples();

        // AsposePdfExamples.Tables
        AddTableInExistingPDFDocument.runExamples();
        ForceTableRenderingOnNewPage.runExamples();
        HideSpannedCellBorder.runExamples();
        ManipulateTablesInExistingPDF.runExamples();
        RemoveTablesFromExistingPDF.runExamples();
        SetBorderStyleMarginsAndPaddingOfTable.runExamples();

        // AsposePdfExamples.TaggedPDFs
        AccessChildrenElements.runExamples();
        AddStructureElementIntoElement.runExamples();
        CreateNoteStructureElement.runExamples();
        CreatePDFwithTaggedImage.runExamples();
        CreatePDFwithTaggedText.runExamples();
        CreateStructureElement.runExamples();
        CreateStructureElementTree.runExamples();
        CreateTableElement.runExamples();
        CustomTagName.runExamples();
        IllustrationStructureElements.runExamples();
        InlineStructureElements.runExamples();
        RootStructure.runExamples();
        StructureElementsProperties.runExamples();
        StyleTableCell.runExamples();
        StyleTableElement.runExamples();
        StyleTableRow.runExamples();
        StyleTextStructure.runExamples();
        TaggedPDFContent.runExamples();
        TextBlockStructureElements.runExamples();
        TextStructureElements.runExamples();
        ValidatePDF.runExamples();

        // AsposePdfExamples.Text
        AddHTMLOrderedListIntoDocuments.runExamples();
        AddHTMLStringUsingDOM.runExamples();
        AddHTMLUsingDOMAndOverwrite.runExamples();
        AddRotatedTextInPDF.runExamples();
        AddTextToAnExistingPDFFile.runExamples();
        DetermineLineBreak.runExamples();
        // no input file ExtractRotatedText.runExamples();
        ExtractTextBasedOnColumns.runExamples();
        ExtractTextFromAllThePagesOfPDFDocument.runExamples();
        ExtractTextFromAnParticularPageRegion.runExamples();
        ExtractTextFromPDFUsingTextDevice.runExamples();
        FindAndReplaceTextByItsLocation.runExamples();
        FootNotesAndEndNotes.runExamples();
        HowToAddTransparentTextInPDF.runExamples();
        ReplaceFontsInExistingPDFFile.runExamples();
        ReplaceOnlyFirstOccurrenceOfThePhrase.runExamples();
        ReplaceTextInPagesOfPDFDocument.runExamples();
        SearchAndGetTextFromPagesUsingRegularExpression.runExamples();
        SearchAndGetTextFromThePagesOfPDFDocument.runExamples();
        SearchAndGetTextSegmentsFromPagesOfPDF.runExamples();
        TextReplacementShouldAutomaticallyRearrangePageContents.runExamples();
        UseLatexScript.runExamples();
        UseLatexScript3.runExamples();

        // AsposePdfFacades.Annotations
        AddAnnotationInAnExistingPDFFile.runExamples();
        DeleteAllAnnotationsBySpecifiedType.runExamples();
        ExportAnnotationsFromPDFFileToXFDF.runExamples();

        // AsposePdfFacades.Attachments
        AddAttachment.runExamples();
        AddAttachmentStream.runExamples();
        DeleteAllAttachments.runExamples();
        ExtractAllAttachments.runExamples();
        GetAttachmentNames.runExamples();

        // AsposePdfFacades.Bookmarks
        CreateBookmarksOfAllPages.runExamples();
        CreateBookmarksOfAllPagesWithProperties.runExamples();
        ExportBookmarksToXMLFromAnExistingPDFFile.runExamples();
        ImportBookmarksFromXMLToAnExistingPDFFile.runExamples();

        // AsposePdfFacades.Document
        AddingJavascriptActionsToExistingPDFFile.runExamples();
        GetPDFFilenformation.runExamples();
        GetXMPMetadataOfAnExistingPDFFile.runExamples();
        ResizePDFPageContents.runExamples();
        com.aspose.pdf.examples.AsposePdfFacades.Document.SetPDFFileInformation.runExamples();
        SetViewerPreferenceOfAnExistingPDFFile.runExamples();
        SetXMPMetadataOfAnExistingPDF.runExamples();

        // AsposePdfFacades.Forms
        ExportDataToFDFFromAPDFFile.runExamples();
        ExportDataToXMLFromAPDFFile.runExamples();
        FlattenAllFieldsInExistingPDFFile.runExamples();

        // AsposePdfFacades.Images
        ConvertParticularPageRegionToImageFormat.runExamples();
        ConvertPDFPagesToDifferentImageFormats.runExamples();
        ExtractImagesFromTheWholePDFToFiles.runExamples();
        ReplaceImageInAnExistingPDFFile.runExamples();

        // AsposePdfFacades.Pages
        ConcatenateArrayOfPDFFilesUsingFilePaths.runExamples();
        ConcatenateArrayOfPDFFilesUsingStreams.runExamples();
        ConcatenatePDFFilesUsingFilePaths.runExamples();
        ResizePageContentsOfSpecificPagesInAPDFFile.runExamples();

        // AsposePdfFacades.PDFPrinting
        PrintPDFFileToDefaultPrinter.runExamples();

        // AsposePdfFacades.SecurityAndSignatures
        AddDigitalSignatureInAPDFFile.runExamples();
        ChangeLanguageInDigitalSignText.runExamples();
        com.aspose.pdf.examples.AsposePdfFacades.SecurityAndSignatures.SetPrivilegesOnAnExistingPDFFile.runExamples();
        SuppressLocationAndReason.runExamples();

        // AsposePdfFacades.StampsAndWatermarks
        AddPageNumberInAPDFFile.runExamples();

        // AsposePdfFacades.Text
        AddTextInAnExistingPDFFile.runExamples();
        ExtractTextFromARangeOfPages.runExamples();
        ExtractTextFromIndividualPagesOfAPDF.runExamples();
        ExtractTextFromTheWholePDFFile.runExamples();
        ReplaceTextInAnExistingPDFFile.runExamples();
        ReplaceTextOnAParticularPageInAnExistingPDFFile.runExamples();
    }

    private static File dir = null;

    public static String getSharedDataDir() {
        if (dir == null) {
            dir = new File("src/main/resources/");
        }
        return dir.toString() + File.separator;
    }

    public static String getDataDir(String testID) {
        return getSharedDataDir() + testID;
    }

    public static String getOutDir(String testID) {
        return "testout/" + testID;
    }
}
