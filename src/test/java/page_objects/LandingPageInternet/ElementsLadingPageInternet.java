package page_objects.LandingPageInternet;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.PageBase;

public class ElementsLadingPageInternet extends PageBase {
    WebDriverWait wait = new WebDriverWait(driver, 15, 1000);
    /**
     * Danh sách gói cước trên đầu trang
    * */
    public Query listTopPromotionEl = new Query().defaultLocator(By.cssSelector(".owl-stage-outer span.name")).usingDriver(driver);
    /**
     * Danh sách gói cước combo net + tv bên dưới title
     * */
    public Query listTopPromotionComboInternetTHEl = new Query().defaultLocator(By.cssSelector("section.sec-plb.mb-3:nth-last-child(3) .name")).usingDriver(driver);
    /**
     * Danh sách gói cước tv bên dưới title
     * */
    public Query listTopPromotionInternetOnlyEl = new Query().defaultLocator(By.cssSelector("section.sec-plb.mb-3:nth-last-child(2) .name")).usingDriver(driver);
    /**
     * Danh sách tin tức bên dưới trang
     * */
    public Query listTopNewsEl = new Query().defaultLocator(By.cssSelector("*[class$='slider slider-features owl-carousel owl-theme owl-loaded owl-drag'] > div > div> div")).usingDriver(driver);

    public Query txtTenGoiCuoc_blockGoiCuoc = new Query().defaultLocator(By.xpath("((//div[contains(@class,'item item-hot')])[1]//span)[1]")).usingDriver(driver);
    public Query blockGoiCuoc = new Query().defaultLocator(By.xpath("//span[contains(text(),'Internet - Super100')]")).usingDriver(driver);
    public Query listImagesInternetTHInternetOnly = new Query().defaultLocator(By.xpath("//div[@id='box1gb']//div[@class='image-box']/img")).usingDriver(driver);
    public Query listGroupContentInternetTHInternetOnly = new Query().defaultLocator(By.xpath("//ul[@class='list-service']")).usingDriver(driver);
    public Query listTopLinkNewsEl = new Query().defaultLocator(By.xpath("//div[@class='slider slider-features owl-carousel owl-theme owl-loaded owl-drag']//div[@class='owl-stage-outer']/div/div")).usingDriver(driver);
    public Query sectionNewsEl = new Query().defaultLocator(By.xpath("//section[@class='sec-features mb-3']")).usingDriver(driver);

}