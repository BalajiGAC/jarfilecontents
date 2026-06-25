package com.flowanalyzer;
 
import com.flowanalyzer.extractor.JarExtractor;
import com.flowanalyzer.analyzer.ProjectAnalyzer;
import com.flowanalyzer.model.AnalysisResult;
import com.flowanalyzer.report.HtmlReportGenerator;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
 
        if (args.length == 0) {
            throw new RuntimeException(
                    "Please provide Mule JAR path");
        }
 
        String jarFile = args[0];
 
        System.out.println("Extracting JAR...");
 
        JarExtractor extractor =
                new JarExtractor();
 
        extractor.extract(
                jarFile,
                "output/extracted");
 
        System.out.println("Analyzing project...");
 
        ProjectAnalyzer analyzer =
                new ProjectAnalyzer();
 
        AnalysisResult result =
                analyzer.analyze(
                        "output/extracted");
 
        System.out.println("Generating report...");
 
        HtmlReportGenerator report =
                new HtmlReportGenerator();
 
        report.generate(result);
 
        System.out.println(
                "Analysis Complete");
 
        System.out.println(
                "Report generated at output/report.html");
    }
}