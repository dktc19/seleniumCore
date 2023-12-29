package net.fpt.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import net.fpt.constant.ReportConstants;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import static net.fpt.listeners.ScreenShotListener.screenshotAbsolutePath;

public class HtmlReports {

    private static ExtentReports extent;

    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();

    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private final String fileName = getClass().getSimpleName();
    String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date());

    private final String htmlFilePath = getOutputFolder() + fileName +"-"+ timeStamp +"-"+ Thread.currentThread().getName() + ".html";

    @BeforeClass
    public void startReport() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(htmlFilePath);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);

    }


    @BeforeMethod
    public synchronized void beforeMethod(Method method) {



    }



    @AfterMethod
    public synchronized void getResult(ITestResult result) throws IOException {

        //System.out.println(Charset.defaultCharset().displayName());

        ExtentTest child = parentTest.get().createNode(result.getName() +" : "+  result.getMethod().getDescription());

        test.set(child);

        if (result.getStatus() == ITestResult.FAILURE) {
            //test.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + ReportConstants.REPORT_FAILED, ExtentColor.RED));
            // Convert Image File to Base64 String
            byte[] fileContent = FileUtils.readFileToByteArray(new File(screenshotAbsolutePath));
            String encodedString = Base64.getEncoder().encodeToString(fileContent);
            test.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromBase64String(encodedString).build());
            //test.get().info(result.getMethod().getDescription());
            //test.get().addScreenCaptureFromPath(screenshotAbsolutePath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.get().log(Status.PASS, MarkupHelper.createLabel(result.getName() + ReportConstants.REPORT_PASSED, ExtentColor.GREEN));
        } else {
            test.get().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + ReportConstants.REPORT_SKIPPED, ExtentColor.ORANGE));
            test.get().skip(result.getThrowable());
        }

    }

    @AfterClass
    public void endReport() {
        extent.flush();
    }

    private String getOutputFolder() {
        return ReportConstants.REPORT_FOLDER;
    }

    public HtmlReports() {
        File folder = new File(getOutputFolder());
        folder.mkdirs();
    }
}
