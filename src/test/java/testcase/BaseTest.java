package testcase;

import core.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * BaseTest class to set up for tests.
 *
 * @author PhucDN7
 * @since 2024-10-09
 */
public class BaseTest {
  private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

  @BeforeTest
  @Parameters({"platform"})
  public void setUp(String platform) {
    DriverManager.createDriver(platform);
  }

  @AfterTest(alwaysRun = true)
  public void tearDown() {
    DriverManager.quitDriver();
  }
}
