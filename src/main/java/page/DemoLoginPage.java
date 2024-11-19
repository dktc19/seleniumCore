package page;


import model.DataLogin;
import model.DataTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JsonUtil;

import java.io.File;

public class DemoLoginPage extends BasePage {
  DataLogin dataLogin;
  public DemoLoginPage() {
    super();
    String dataLoginPath =
            String.join(File.separator, "src", "test", "java", "testdata", "dataLogin.json");
    dataLogin = JsonUtil.getInstance().convertFileJsonToObject(dataLoginPath, DataLogin.class);
  }
  @FindBy(id = "email")
  private WebElement inputEmail;
  @FindBy(id = "password")
  private WebElement inputPassword;
  @FindBy(xpath = "//button[contains(text(),'ĐĂNG NHẬP')]")
  private WebElement buttonLogin;
  @FindBy(xpath = "//a[contains(text(),'KHGC System')]")
  public WebElement labelKHGCSystem;
  public void accessToLoginPage() {
    sendKeysForElement(inputEmail, dataLogin.getEmail());
    sendKeysForElement(inputPassword, dataLogin.getPassword());
    click(buttonLogin);
  }
}
