package net.fpt.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LogTestNGListener extends TestListenerAdapter {
    public static String logFile = null;
    public static final String LOGFILE_PATH = "Logs/";
    static final Logger logger = LoggerFactory.getLogger(LogTestNGListener.class);

    /**
     *
     * onStart - method to log data before any tests start
     *
     * @param testContext
     */
    @Override
    public void onStart(ITestContext testContext) {
        if ( logFile == null ) {
            logFile = LOGFILE_PATH
                    +"TestNG."+ new SimpleDateFormat("MM.dd.yy.HH.mm.ss")
                    .format(new Date())
                    + ".log";
        }

        try {
            log("\nSuite Start Date: " +
                    new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss")
                            .format(new Date()) +
                    ".log");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        super.onStart(testContext);
    }
    /**
     * onFinish - method to log data after all tests are complete
     *
     * @param testContext
     */
    @Override
    public void onFinish(ITestContext testContext) {
        try {
            log("\nTotal Passed = " +
                    getPassedTests().size() +
                    ", Total Failed = " +
                    getFailedTests().size() +
                    ", Total Skipped = " +
                    getSkippedTests().size() +
                    "\n");

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        super.onFinish(testContext);
    }

    public void onTestStart(ITestResult tr) {
        log("\n---------------------------------- Test '"
                + tr.getName()
                + "' ----------------------------------\n");
        log(tr.getStartMillis(),
                "START-> "
                        + tr.getName() + "\n");
        log(" Test Parameters : "

                + "\n");
        super.onTestStart(tr);
    }

    /**
     * onTestFailure method
     *
     * @param tr
     */
    @Override
    public void onTestFailure(ITestResult tr) {
        long time = tr.getEndMillis() - tr.getStartMillis();
        if ( !tr.getThrowable().equals("") ) {
            log(" "+tr.getThrowable().getMessage() + "\n");
        }
        log(" Result : FAILED\n");
        log(" Execution Time : "+ printExecutionTime(tr)  +"\n");
        log(tr.getEndMillis(),
                "END -> "
                        + tr.getInstanceName()
                        + "." + tr.getName());
        log("\n----------------------------------------------------------------------------\n");
        super.onTestFailure(tr);
    }

    /**
     * onTestSuccess method
     *
     * @param tr
     */
    @Override
    public void onTestSuccess(ITestResult tr) {

        log(" Result : PASSED\n");
        log(" Execution Time : "+ printExecutionTime(tr) +"\n");
        log(tr.getEndMillis(),
                "END -> "
                        + tr.getName());


        log("\n----------------------------------------------------------------------------\n");
        super.onTestSuccess(tr);
    }

    /**
     * log - method to log data to standard out or logfile
     *
     * @param dataLine
     */
    public void log(long date, String dataLine) {
        System.out.format("%s%n", String.valueOf(new Date(date)), dataLine);
        if (logFile != null) {
            writeLogFile(logFile, dataLine);
        }
    }

    /**
     * log - overloaded method to log data to standard out or logfile
     *
     * @param dataLine
     */
    public void log(String dataLine) {
        System.out.format("%s%n", dataLine);
        if ( logFile != null ) {
            writeLogFile(logFile, dataLine);
        }
    }
    /**
     * writeFile - method to stuff a row entry into a file
     *
     * @param logFile - the file to write to
     * @param dataLine - the line to write into the file
     * @throws Exception
     */
    public static void writeLogFile(String logFile,
                                 String dataLine)
             {
        DateFormat dateFormat =
                new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        File directory = new File(LOGFILE_PATH);
        File file = new File(logFile);
        try {
            if ( !directory.exists() ) {
                directory.mkdirs();
            }
            else if ( !file.exists() ) {
                file.createNewFile();
            }
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(logFile, true));
            if ( dataLine.contains("START") || dataLine.contains("END") ) {
                writer.append("["
                        + dateFormat.format(date)
                        + "] "
                        + dataLine);
            }
            else {
                writer.append(dataLine);
            }
            writer.newLine();
            writer.close();
        }
        catch(IOException e) {
        // do nothing...
        }
    }
    /**
     * printExecutionTime - method convert timeStamp to format time
     *
     * @param tr - ITestResult
     */
    public String printExecutionTime(ITestResult tr){
        long time = tr.getEndMillis() - tr.getStartMillis();
        long hours = TimeUnit.MILLISECONDS.toHours(time);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time - TimeUnit.HOURS.toMillis(hours));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time - TimeUnit.HOURS.toMillis(hours) - TimeUnit.MINUTES.toMillis(minutes));
        long milliseconds = time - TimeUnit.HOURS.toMillis(hours) - TimeUnit.MINUTES.toMillis(minutes) - TimeUnit.SECONDS.toMillis(seconds);
        return String.format("%02d:%02d:%02d:%d", hours, minutes, seconds, milliseconds);
    }

}
