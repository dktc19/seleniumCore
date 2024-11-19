package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.DemoLoginPage;

public class DemoTestCase extends BaseTest {
  @Test(description = "Login KHGC HRM")
  protected void loginKHGCHRM() {
    DemoLoginPage demoLoginPage = new DemoLoginPage();
    demoLoginPage.accessToLoginPage();
    Assert.assertTrue(isElementDisplayed(demoLoginPage.labelKHGCSystem));
  }
}
