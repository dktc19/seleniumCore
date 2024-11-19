package testcase;

import core.DriverManager;
import model.DataTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import page.BasePage;
import utilities.JsonUtil;

import java.io.File;

/**
 * BaseTest class to set up for tests.
 *
 * @author PhucDN7
 * @since 2024-10-09
 */
public class BaseTest extends BasePage {
  DataTest dataTest;
  private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
  public BaseTest() {
    super();
    String dataTestPath =
            String.join(File.separator, "src", "test", "java", "testdata", "dataTest.json");
    dataTest = JsonUtil.getInstance().convertFileJsonToObject(dataTestPath, DataTest.class);
  }
  @BeforeTest
  @Parameters({"platform"})
  public void setUp(String platform) {
    DriverManager.createDriver(platform);
  }
  @BeforeMethod
  public void beforeMethod() {
    DriverManager.getWebDriverThreadLocal().get(dataTest.getUrl());
  }
  @AfterTest(alwaysRun = true)
  public void tearDown() {
    DriverManager.quitDriver();
  }
}
