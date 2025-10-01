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
import com.aspose.pdf.examples.AsposePdfExamples.Pages.*;
import com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures.*;
import com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks.*;

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
        ConvertPDFToXLSX.runExamples();
        ConvertPDFToXML.runExamples();
        ConvertPostScriptFileToPDFFormat.runExamples();
        ConvertSVGFileToPDFFormat.runExamples();
        ConvertTextFileToPDFFormat.runExamples();
        ConvertXMLFileToPDF.runExamples();
        ConvertXPSFileToPDFFormat.runExamples();
        ConvertXSLFOToPDF.runExamples();
        CreatePDFwithTaggedImage.runExamples();
        CreatePDFwithTaggedText.runExamples();
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
        PDFToHTMLWithFontSubstitution.runExamples();
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
        SetPDFFileInformation.runExamples();
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
        // no input file GetPDFHyperlinkDestination.runExamples();
        RemoveDocumentOpenActionFromPDFFile.runExamples();

        // AsposePdfExamples.Miscellaneous
        // no input file ChangingColorSpaceOfPDFDocument.runExamples();
        GettingProductAndBuildInformation.runExamples();
        HowToAddDrawingWithTransparentColor.runExamples();

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
        // no input file (pfx) AddDigitalSignatureToPDFFile.runExamples();
        DecryptPDFFileUsingOwnerPassword.runExamples();
        EncryptPDFDocumentUsingEncryptionTypes.runExamples();
        // no input file (seems it needs output file from addDigitalSignatureToPDFFile)
        // ExtractingImageFromSignatureField.runExamples();
        HowToDetermineIfTheSourcePDFIsPasswordProtected.runExamples();
        SetPrivilegesOnAnExistingPDFFile.runExamples();

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
        // ExtractTextFromStampAnnotation.runExamples(); throws
        // Exception in thread "main" class com.aspose.pdf.internal.ms.System.lh: Document context is null for license
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
