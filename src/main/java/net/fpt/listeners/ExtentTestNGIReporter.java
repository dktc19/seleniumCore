package net.fpt.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import net.fpt.constant.ReportConstants;
import net.fpt.utils.MinIO;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;
import org.testng.xml.XmlSuite;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ExtentTestNGIReporter implements IReporter {
    static final Logger logger = LoggerFactory.getLogger(ExtentTestNGIReporter.class);
    private final String title = getClass().getSimpleName();
    String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date());
    private final String fileName = title + "-" + timeStamp + "-" + Thread.currentThread().getName() + ".html";


    private final String htmlFileAbsolutePath = getOutputFolder() + fileName;
    private ExtentReports extent;
    public final boolean uploadFileEnabled = Boolean.getBoolean("enableUploadFile");

    @Override
    public void generateReport(List<XmlSuite> xmlSuites,
                               List<ISuite> suites,
                               String outputDirectory) {
        CustomizedEmailableIReport.getInstance().fullReportName = fileName;
        init();
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
            for (ISuiteResult r : result.values()) {
                    ITestContext context = r.getTestContext();
                try {
                buildTestNodes(context.getFailedTests(), Status.FAIL);

                buildTestNodes(context.getSkippedTests(), Status.SKIP);

                buildTestNodes(context.getPassedTests(), Status.PASS);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for (String s : Reporter.getOutput()) {
            extent.setTestRunnerOutput(s);
        }
        extent.flush();

        //Publish report to hi-static
        if(uploadFileEnabled){
            try {
                new MinIO().minFileUploader(fileName,new File(htmlFileAbsolutePath),"text/html");
            } catch (Exception e) {
                logger.error(e.toString());
            }
        }
    }

    private void init() {
        logger.info(htmlFileAbsolutePath);
        ExtentHtmlReporter htmlReporter =
                new ExtentHtmlReporter(htmlFileAbsolutePath);
        htmlReporter.config()
                .setDocumentTitle("ExtentReports - Created by TestNG Listener");
        htmlReporter.config()
                .setReportName("ExtentReports - Created by TestNG Listener");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(title);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(title);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
    }

    private void buildTestNodes(IResultMap tests,
                                Status status) throws IOException {
        ExtentTest test;
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                String screenshotAbsolutePath=(String) result.getAttribute("screenshotAbsolutePath"+result.getName());
                String screenshotFileName=(String) result.getAttribute("screenshotFileName"+result.getName());
                test = extent.createTest(
                        "[" + result.getMethod().getRealClass() + "] -  "+ result.getMethod().getMethodName() + " : " + result.getMethod().getDescription());
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
                if (result.getThrowable() != null & screenshotAbsolutePath!= null ) {
                    //test.log(status, result.getThrowable());
                    if(uploadFileEnabled){
                        test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath("https://hi-static.fpt.vn/sys/selenium-core/stag/"+screenshotFileName,screenshotFileName).build());
                    }else {
                        test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromBase64String(getEncodedString(screenshotAbsolutePath)).build());
                    }
                } else {
                    test.log(status,
                            "Test " +
                                    status.toString().toLowerCase() +
                                    "ed");
                }
                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    private String getOutputFolder() {
        return ReportConstants.REPORT_FOLDER;
    }

    public ExtentTestNGIReporter() {
        File folder = new File(getOutputFolder());
        folder.mkdirs();
    }

    public String getEncodedString(String path) throws IOException {
        byte[] fileContent = new byte[0];

        fileContent = FileUtils.readFileToByteArray(new File(path));

        return Base64.getEncoder().encodeToString(fileContent);
    }

}
