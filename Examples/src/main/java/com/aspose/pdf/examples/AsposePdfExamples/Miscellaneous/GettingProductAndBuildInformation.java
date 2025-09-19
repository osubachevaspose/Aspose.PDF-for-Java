package com.aspose.pdf.examples.AsposePdfExamples.Miscellaneous;

import com.aspose.pdf.BuildVersionInfo;

public class GettingProductAndBuildInformation {

    public static void main(String[] args) {
        // Get version information
        System.out.println("Product: " + BuildVersionInfo.Product);
        System.out.println("File Version: " + BuildVersionInfo.FileVersion);
        System.out.println("Assembly Version: " + BuildVersionInfo.AssemblyVersion);
    }
}
