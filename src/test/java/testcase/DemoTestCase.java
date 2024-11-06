package testcase;

import org.testng.annotations.Test;
import page.DemoLoginPage;

public class DemoTestCase extends BaseTest {
  @Test(description = "Login DKOL v3")
  protected void loginDKOL() {
    DemoLoginPage demoLoginPage = new DemoLoginPage();
    demoLoginPage.accessToLoginPage();
  }
}
