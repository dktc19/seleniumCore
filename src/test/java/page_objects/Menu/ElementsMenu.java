package page_objects.Menu;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.PageBase;

public class ElementsMenu extends PageBase {
    WebDriverWait wait = new WebDriverWait(driver, 30, 1000);

    public Query headerEl = new Query().defaultLocator(By.xpath("//div[@id='navbarSupportedContent']/ul[1]/li/a")).usingDriver(driver);
    public Query linkTrangChuEl = new Query().defaultLocator(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/a")).usingDriver(driver);
    public Query linkInternetEl = new Query().defaultLocator(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[2]/a")).usingDriver(driver);
    public Query linkFptCameraEl = new Query().defaultLocator(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[3]/a")).usingDriver(driver);
    public Query linkFptPlayBoxEl = new Query().defaultLocator(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[4]/a")).usingDriver(driver);
    public Query linkFptCloudEl = new Query().defaultLocator(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[5]/a")).usingDriver(driver);
    public Query timKiemEl = new Query().defaultLocator(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[1]")).usingDriver(driver);
    public Query labelTimKiemEl = new Query().defaultLocator(By.xpath("/html/body/div[1]/div[2]/div[1]/header/nav/div/div[2]/div[1]/label")).usingDriver(driver);
    public Query labelBtnTimKiemEl = new Query().defaultLocator(By.xpath("/html/body/div[1]/div[2]/div[1]/header/nav/div/div[2]/div[2]/button")).usingDriver(driver);
    public Query placeholderTimKiemEl = new Query().defaultLocator(By.id("ordercode")).usingDriver(driver);
    public Query inputTimKiemEl = new Query().defaultLocator(By.id("ordercode")).usingDriver(driver);
    public Query txtDonHangKhongHopLeEl = new Query().defaultLocator(By.xpath("/html/body/div[1]/div[2]/div[1]/header/nav/div/div[2]/div[1]/small")).usingDriver(driver);
    public Query labelRoBotEl = new Query().defaultLocator(By.xpath("/html/body/div[1]/div[2]/div[1]/header/nav/div/div[2]/div[1]/div[2]")).usingDriver(driver);
    public Query dropDownQHEl = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[2]/div/span"))).usingDriver(driver);
    public Query listTTEl = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[1]/div/select/option"))).usingDriver(driver);
    public Query listQHEl = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[2]/div/select/option"))).usingDriver(driver);
    public Query listPXEl = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[3]/div/select/option"))).usingDriver(driver);
    public Query dropdownTinhThanhEl = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[1]/div/span/span[1]/span"))).usingDriver(driver);
    public Query dropdownQuanHuyenEl = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[2]/div/span/span[1]/span"))).usingDriver(driver);
    public Query dropdownPhuongXaEl = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[3]/div/span/span[1]/span"))).usingDriver(driver);
    /***
     * Drop down Phường Xã
     */
    public Query itemInList = new Query().defaultLocator((By.xpath("//span[@class='select2-container select2-container--default select2-container--open']/span[@class='select2-dropdown select2-dropdown--below']/span[@class='select2-results']/ul/li"))).usingDriver(driver);
    public Query textBtnXacNhanEl = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_footer_\"]/div/div/button/span"))).usingDriver(driver);
    public Query locationEl = new Query().defaultLocator((By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[2]/a"))).usingDriver(driver);
    public Query textDCLDEl= new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_title_\"]/span"))).usingDriver(driver);
    public Query textGCEl = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/p"))).usingDriver(driver);
    public Query dropDownTTEl = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[1]/div/span"))).usingDriver(driver);
    public Query btnXEl = new Query().defaultLocator(By.xpath("//*[@id=\"mdLocation-manual___BV_modal_header_\"]/button")).usingDriver(driver);
    public Query txtThongBao = new Query().defaultLocator((By.xpath("//*[@id=\"mdLocation-manual___BV_modal_body_\"]/div[2]/small"))).usingDriver(driver);

}