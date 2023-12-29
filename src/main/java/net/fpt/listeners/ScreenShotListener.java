package net.fpt.listeners;

import net.fpt.driver_setting.DriverBase;
import net.fpt.utils.MinIO;
import org.openqa.selenium.*;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.remote.Augmenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;


public class ScreenShotListener extends TestListenerAdapter {
    static final Logger logger = LoggerFactory.getLogger(ScreenShotListener.class);
    public static String screenshotAbsolutePath;
    public static String elementAbsolutePath;

    private boolean createFile(File screenshort){
        boolean filecreate =false;
        if(screenshort.exists()){
            filecreate = true;
        }else {
            File parentDirectory =new File(screenshort.getParent());
            if (parentDirectory.exists() || parentDirectory.mkdir()){
                try{
                    filecreate = screenshort.createNewFile();
                }catch (IOException errorCreatingScreenshot){
                    errorCreatingScreenshot.printStackTrace();
                }
            }
        }
        return filecreate;
    }

    /**
     * method to capture the entire screen of the Browser
     * or Mobile App
     *
     * @param driver- WebDriver
     * @param screenshot - The path and filename to save it to
     */
    private void getScreenShortFile(WebDriver driver,File screenshot){
        try {
            FileOutputStream screenshotStream = new FileOutputStream(screenshot);
            screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            screenshotStream.close();
        }catch (IOException unableToWriteScreenshot){
            logger.error("Unable to write " + screenshot.getAbsolutePath());
            unableToWriteScreenshot.printStackTrace();
        }
    }

    /**
     * method to capture the screen of the Browser
     * or Mobile App
     *
     * @param element - WebElement
     * @param screenshot - The path and filename to save it to
     */
    public static void getElementShortFile(WebElement element ,File screenshot){
        try {
            FileOutputStream screenshotStream = new FileOutputStream(screenshot);
            screenshotStream.write(element.getScreenshotAs(OutputType.BYTES));
            screenshotStream.close();
        }catch (IOException unableToWriteScreenshot){
            logger.error("Unable to write " + screenshot.getAbsolutePath());
            unableToWriteScreenshot.printStackTrace();
        }
    }

    /**
     * method to capture the full screen of the Browser
     *
     * @param driver-
     * @param screenshot - The path and filename to save it to
     */
    private void getFullScreenShortFile(WebDriver driver,File screenshot){
        try {
            Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
            ImageIO.write(fpScreenshot.getImage(),"jpg",screenshot);
        }catch (IOException unableToWriteScreenshot){
            logger.error("Unable to write " + screenshot.getAbsolutePath());
            unableToWriteScreenshot.printStackTrace();
        }
    }


    private void captureScreen(ITestResult failingTest){
        try {
            WebDriver driver = DriverBase.getDriver();
            String screenshotDirectory= System.getProperty("screenshotDirectory","target/screenshots");
            String fileName =  System.currentTimeMillis() + "_" + failingTest.getName() + ".jpg";
            screenshotAbsolutePath = screenshotDirectory + File.separator + fileName;
            failingTest.setAttribute("screenshotAbsolutePath"+failingTest.getName(),screenshotAbsolutePath);
            failingTest.setAttribute("screenshotFileName"+failingTest.getName(),fileName);
            File screenshort= new File(screenshotAbsolutePath);
            if(createFile(screenshort)){
                try {
                    getFullScreenShortFile(driver,screenshort);
                    new MinIO().minFileUploader(fileName,screenshort);
                }catch (ClassCastException weNeedToAugmentOurDriverObject){
                    getFullScreenShortFile(new Augmenter().augment(driver), screenshort);
                    new MinIO().minFileUploader(fileName,screenshort);
                }
                logger.debug("Written screenshot to " +  screenshotAbsolutePath);
            } else {
                logger.error("Unable to create " +  screenshotAbsolutePath);
            }
        } catch (Exception ex) {
            logger.error("Unable to capture screenshot..."+ ex.getCause());
            ex.printStackTrace();
        }
    }

    /**
     * method to take snapshot of WebElement
     * for The Web or Mobile Element to capture
     * @param element - The Web or Mobile Element to capture
     * @return File
     * @throws Exception
     */
    public static File imageSnapshot(WebElement element) throws Exception {
        WrapsDriver wrapsDriver = (WrapsDriver) element;
        File screen = null;
        // capture the WebElement snapshot
        screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver())
                .getScreenshotAs(OutputType.FILE);
        // create Buffered Image instance from captured screenshot
        BufferedImage img = ImageIO.read(screen);
        // get the width/height of the WebElement for the rectangle
        Rectangle rect = element.getRect();
        // get the location of WebElement in a point (x,y)
        Point p = element.getLocation();
        // create image for element using location and size
        BufferedImage dest =
                img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
        // BMP,bmp,jpg,JPG,jpeg,wbmp,png,PNG,JPEG,WBMP,GIF,gif
        ImageIO.write(dest,"png",screen);
        return screen;
    }

    @Override
    public void onTestFailure(ITestResult failingTest){
        captureScreen(failingTest);
    }

    @Override
    public void onTestSuccess(ITestResult successTest){
        //captureScreen(successTest);
    }


}
