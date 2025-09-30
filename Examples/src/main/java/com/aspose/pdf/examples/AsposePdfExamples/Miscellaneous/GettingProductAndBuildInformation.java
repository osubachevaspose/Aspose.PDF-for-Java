package com.aspose.pdf.examples.AsposePdfExamples.Miscellaneous;

import com.aspose.pdf.BuildVersionInfo;

public class GettingProductAndBuildInformation {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        System.out.println("============================");
        System.out.println("Example gettingProductAndBuildInformation start");
        gettingProductAndBuildInformation();
        System.out.println("Example gettingProductAndBuildInformation end");
    }

    public static void gettingProductAndBuildInformation() {
        // Get version information
        System.out.println("Product: " + BuildVersionInfo.Product);
        System.out.println("File Version: " + BuildVersionInfo.FileVersion);
        System.out.println("Assembly Version: " + BuildVersionInfo.AssemblyVersion);
    }
}
