package page_objects.LandingPageInternet;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page_objects.Register.ActionsRegister;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static constants.Common.getURLDK;
import static net.fpt.driver_setting.DriverBase.getDriver;
import static net.fpt.utils.WebElementActionUtil.getTextListItems;
import static net.fpt.utils.WebElementActionUtil.isLoadingImage;
import static org.assertj.core.api.Assertions.assertThat;
import static constants.Common.urlInternet;

public class ActionLandingPageInternet extends ElementsLadingPageInternet {
    static final Logger logger = LoggerFactory.getLogger(ActionLandingPageInternet.class);

    public ActionLandingPageInternet waitListElementsTopPromotion() {
        wait.until(ExpectedConditions.elementToBeClickable(listTopPromotionEl.by()));
        return this;
    }

    public ActionLandingPageInternet waitListElementsTopPromotionComboInternetTH() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listTopPromotionComboInternetTHEl.by()));
        return this;
    }

    public ActionLandingPageInternet waitElementsTopPromotionInternetOnlyTH() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listTopPromotionInternetOnlyEl.by()));
        return this;
    }

    public List getListElementsTopNewsTH() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listTopNewsEl.by()));
        return listTopNewsEl.findWebElements();
    }

    public WebElement getListElementsLinkTopNewsTH() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sectionNewsEl.by()));
        return sectionNewsEl.findWebElement();
    }

    public ActionLandingPageInternet waitistElementsTopPromotion(){
        wait.until(ExpectedConditions.elementToBeClickable(listTopPromotionEl.by()));
        return this;
    }

    /* Hàm getText  */
    public String getTextElement(Query q){
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(q.by()));
        return  myElement.getText();
    }
    /* Hàm click vao Block ra trang dang ki */
    public void clickElement(Query q){
        logger.info("clickElement");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(q.by()));
        myElement.click();
    }
    /* Hàm click vao Block ra trang dang ki */
    public ActionsRegister click1GoiCuoc() {
        logger.info("click1GoiCuoc");
        clickElement(blockGoiCuoc);
        return new ActionsRegister();
    }

    /* Hàm click vao Block ra trang dang ki comobo */
    public ActionsRegister click1GoiCuocComboBatKy() {
        logger.info("click1GoiCuocComboBatKy");
        Random ran = new Random();
        wait.until(ExpectedConditions.elementToBeClickable(listTopPromotionEl.by()));
        List<WebElement> listElement= listTopPromotionEl.findWebElements();
        listElement.get(ran.nextInt(listElement.size())).click();
        return new ActionsRegister();
    }
    /* Hàm click vao Block Combo ra trang dang ki combo */
    public ActionsRegister clickCombo(String comboName) {
        logger.info("clickCombo");
        wait.until(ExpectedConditions.elementToBeClickable(listTopPromotionComboInternetTHEl.by()));
        List<WebElement> listElement= listTopPromotionComboInternetTHEl.findWebElements();
        for (WebElement e:listElement){
            if (e.getText().trim().contains(comboName)) {
                e.click();
                break;
            }
        }
        return new ActionsRegister();
    }

    /*#######################################################*/
    public void goHere() throws InterruptedException {
        logger.info("goHere");
        try {
            driver = getDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get(urlInternet);
    }

    /*kiểm tra gia diện ưu đãi*/
    public void verifylistTopPromotion(){
        waitListElementsTopPromotion();
        assertThat(getTextListItems(listTopPromotionEl)).as("Hiển thị list ưu đãi nhiều nhất").isNotEmpty();
    }

    /* */
    public void verifyListTopPromotionInternetOnly(){
        waitElementsTopPromotionInternetOnlyTH();
        List listTopPromotionInternetOnly = getTextListItems(listTopPromotionInternetOnlyEl);
        assertThat(listTopPromotionInternetOnly).as("Hiển thị list ưu đãi Internet Only").isNotEmpty();
    }

    /* */
    public void verifyListTopPromotionComboInternetTH(){
        waitListElementsTopPromotionComboInternetTH();
        assertThat(getTextListItems(listTopPromotionComboInternetTHEl)).as("Hiển thị list ưu đãi Combo Internet- Truyền Hình").isNotEmpty();
    }

    /* */
    public void verifyListElementsTopNewsTH(){
        assertThat(getListElementsTopNewsTH()).as("Không hiển thị list tin tức nỗi bật").isNotEmpty();
    }

    /* */
    public void verifyTopPromotionAfterChangeLocaltion(List location){
        assertThat(getTextListItems(listTopPromotionEl)).as("Thay đổi danh sách hiển thị và giá gói Internet - Truyền hình khi thay đổi location").doesNotContainSequence(location);
    }

    /* */
    public void verifyListServiceContent(){

        List<WebElement> elementImg= new ArrayList<>(listImagesInternetTHInternetOnly.findWebElements());
        for (WebElement i : elementImg) {
            Boolean imageLoaded1 = isLoadingImage(i);
            assertThat(imageLoaded1).as("Hiện hình ảnh dịch vụ").isTrue();
        }

        List<WebElement> elementGroupContent= new ArrayList<>(listGroupContentInternetTHInternetOnly.findWebElements());
        for (WebElement i : elementGroupContent) {
            List<WebElement>  c = i.findElements(By.xpath("./child::*"));
            List items = null;
            for (WebElement f : c) {
                items = getTextListItems(c);
            }
            assertThat(items).as("Hiển thị list (content) Thông tin dịch vụ Internet – truyền hình").isNotEmpty();
        }
    }

    public void verifyLinkTopNews(){
        WebElement element = sectionNewsEl.findWebElement();
        List<WebElement> listLinkNews = element.findElements(By.tagName("a"));
        for (WebElement i : listLinkNews) {
            String url = i.getAttribute("href");
            assertThat(url).as("Kiểm tra có hyperlink Tin tức nổi bật").isNotEmpty();
        }
    }

    public void verifyContentTopNews() {

        WebElement element = sectionNewsEl.findWebElement();
        List<WebElement> imgLinkNews = element.findElements(By.tagName("img"));
        for (WebElement i : imgLinkNews) {
            Boolean imageLoaded1 = isLoadingImage(i);
            assertThat(imageLoaded1).as("Hiện hình ảnh trang tin tức nổi bật").isTrue();;
        }

        List titleLinkNews = getTextListItems(element.findElements(By.tagName("h3")));
        assertThat(titleLinkNews).as("Hiện tiêu đề trang tin tức nổi bật").isNotEmpty();;

        List descrptionLinkNews = getTextListItems(element.findElements(By.tagName("p")));
        assertThat(descrptionLinkNews).as("Hiện nội dung trang tin tức nổi bật").isNotEmpty();;
    }





}
