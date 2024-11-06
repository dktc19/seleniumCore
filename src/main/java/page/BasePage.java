package page;

import constants.GlobalConfig;
import core.DriverManager;
import exception.TestContextException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * BasePage class to represent the base page for all page objects.
 *
 * @author PhucDN7
 * @since 2024-10-09
 */
public abstract class BasePage {
  protected WebDriver driver;
  protected WebDriverWait wait;
  private static final Logger LOGGER = LogManager.getLogger(BasePage.class);

  /** Constructor to initialize the BasePage with a driver. */
  protected BasePage() {
    this.driver = DriverManager.getWebDriverThreadLocal();
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConfig.WAIT_TIMEOUT_30_SECONDS));
    PageFactory.initElements(driver, this);
  }

  /**
   * Waits for the visibility of a web element.
   *
   * @param element the web element to wait for
   */
  public WebElement waitForVisibility(WebElement element) {
    LOGGER.info("Waiting for visibility of {}", element);
    return wait.until(ExpectedConditions.visibilityOf(element));
  }

  public void waitForInvisibility(WebElement element) {
    LOGGER.info("Waiting for {} disappear", element);
    wait.until(ExpectedConditions.invisibilityOf(element));
  }

  public void waitForVisibilityOfAllElements(List<WebElement> elements) {
    LOGGER.info("Waiting for visibility of all elements");
    wait.until(ExpectedConditions.visibilityOfAllElements(elements));
  }

  /**
   * Waits for an element to be clickable.
   *
   * @param element the element to wait for clickable
   */
  public WebElement waitForClickable(WebElement element) {
    LOGGER.info("Waiting for clickable of {}", element);
    return wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  /**
   * Waits for the URL to be the expected URL.
   *
   * @param expectedUrl url to wait for
   */
  public void waitForURL(String expectedUrl) {
    LOGGER.info("Waiting for URL to be {}", expectedUrl);
    wait.until(ExpectedConditions.urlToBe(expectedUrl));
  }

  /**
   * Clicks on a web element.
   *
   * @param element the web element to click
   */
  public void click(WebElement element) {
    if (waitForClickable(element) != null) {
      element.click();
      LOGGER.info("Click on {} successfully", element);
    } else {
      LOGGER.error("Failed to click on {} due to element non-clickable", element);
    }
  }

  /**
   * Checks if an element is displayed.
   *
   * @param element the element to check displayed
   * @return true if the element is displayed, false otherwise
   */
  public boolean isElementDisplayed(WebElement element) {
    try {
      // Wait for the element to be visible
      LOGGER.info("Checking if {} is displayed", element);
      wait.until(ExpectedConditions.visibilityOf(element));
      return element.isDisplayed();
    } catch (Exception e) {
      LOGGER.error("{} is not displayed", element);
      return false;
    }
  }

  /**
   * Send keys for an element.
   *
   * @param element the element to send keys
   * @param text the text to send
   */
  public void sendKeysForElement(WebElement element, String text) {
    if (waitForVisibility(element) != null) {
      element.clear();
      element.sendKeys(text);
      LOGGER.info("Sent keys to {} successfully", element);
    } else {
      LOGGER.error("Failed to send keys to {} due to element invisible", element);
    }
  }

  /**
   * Get Text Element
   *
   * @param element the element to get text
   * @return the text of the element
   */
  public String getTextElement(WebElement element) {
    if (waitForVisibility(element) != null) {
      return element.getText();
    }
    LOGGER.error("{} is not visible for GetText action", element);
    return null;
  }

  /**
   * Get Attribute Element
   *
   * @param element the element to get attribute
   * @param attribute the attribute to get
   * @return the attribute value of the element
   */
  public String getAttributeElement(WebElement element, String attribute) {
    if (waitForVisibility(element) != null) {
      LOGGER.info("Get attribute {} of {}", attribute, element);
      return element.getAttribute(attribute);
    }
    LOGGER.error("Failed to get attribute {} of {} due to element invisible", attribute, element);
    return null;
  }

  /**
   * Sleeps for a specified number of milliseconds.
   *
   * @param seconds the number of milliseconds to sleep
   */
  public static void sleepInSeconds(long seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      // Preserve interrupt status
      Thread.currentThread().interrupt();
      throw new TestContextException("Error in waiting...");
    }
  }

  /**
   * Sleeps for a specified number of milliseconds.
   *
   * @param minutes the number of milliseconds to sleep
   */
  public static void sleepInMinutes(long minutes) {
    try {
      Thread.sleep(minutes * 60 * 1000);
    } catch (InterruptedException e) {
      // Preserve interrupt status
      Thread.currentThread().interrupt();
      throw new TestContextException("Error in waiting...");
    }
  }

  public String getNumberFromText(String text) {
    return text.replaceAll("\\D", "");
  }

  public String getCurrentURL() {
    return driver.getCurrentUrl();
  }

  public boolean isElementNotPresent(WebElement element) {
    try {
      LOGGER.info("Checking if {} is not present", element);
      wait.until(ExpectedConditions.invisibilityOf(element));
      return true;
    } catch (Exception e) {
      LOGGER.error("{} is present", element);
      return false;
    }
  }

  public void scrollIntoView(WebElement element) {
    LOGGER.info("Scrolling into view of {}", element);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }

  public String getURLCurrentPage() {
    return driver.getCurrentUrl();
  }

  public void waitPageLoadComplete(String url) {
    LOGGER.info("Waiting for page to load with URL containing: {}", url);
    wait.until(
        (ExpectedCondition<Boolean>)
            webDriver -> {
              String currentUrl = driver.getCurrentUrl().toLowerCase();
              String readyState =
                  (String)
                      ((JavascriptExecutor) driver).executeScript("return document.readyState");
              return currentUrl.contains(url.toLowerCase()) && "complete".equals(readyState);
            });
    LOGGER.info("Page load complete: {}", driver.getCurrentUrl());
  }

  public void switchToFrame(WebElement elementFrame) {
    wait.until(
        ExpectedConditions.presenceOfElementLocated(
            By.xpath("//iframe[@id='Cardinal-CCA-IFrame']")));
    driver.switchTo().frame(elementFrame);
  }

  public void clickToElementByJS(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    jsExecutor.executeScript("arguments[0].click();", element);
  }

  public WebElement getDynamicElement(String locator, String... dynamicValue) {
    try {
      return wait.until(
          ExpectedConditions.visibilityOfElementLocated(
              By.xpath(String.format(locator, (Object[]) dynamicValue))));
    } catch (TimeoutException e) {
      return null;
    }
  }

  /**
   * Check the element is displayed with timeout
   *
   * @param element the element to check displayed
   * @param timeOut the time-out to wait for the element
   * @return true if the element is displayed, false otherwise
   */
  public boolean isElementDisplayedWithTimeout(WebElement element, long timeOut) {
    try {
      WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
      webDriverWait.until(ExpectedConditions.visibilityOf(element));
      return element.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  public boolean customWaitForElementVisible(
      WebElement element, int secondTimeOut, int sleepMilliSeconds) {
    WebDriverWait webDriverWait =
        new WebDriverWait(
            driver, Duration.ofSeconds(secondTimeOut), Duration.ofMillis(sleepMilliSeconds));
    try {
      webDriverWait.until(ExpectedConditions.visibilityOf(element));
      return element.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }
}
