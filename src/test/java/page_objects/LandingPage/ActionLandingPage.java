package page_objects.LandingPage;


import com.lazerycode.selenium.util.Query;
import org.assertj.core.api.AssertionsForClassTypes;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.fpt.utils.WebElementActionUtil.getListElementHasLinkInList;
import static org.assertj.core.api.Assertions.assertThat;
import static constants.Common.*;

public class ActionLandingPage extends ElementsLadingPage {
    static final Logger logger = LoggerFactory.getLogger(ActionLandingPage.class);

    /* Check list text chưa là khách hàng của net.fpt */
    public List getListTextChuaLaKHFPT() {
        logger.info("getListTextChuaLaKHFPT");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listTextChualaKHFPTEl.by()));
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollFooter);
        List<String> result = new ArrayList<>();
        List<WebElement> elementList = listTextChualaKHFPTEl.findWebElements();
        for (int i = 0; i < elementList.size(); i++) {
            result.add(elementList.get(i).getText().trim());
        }
        return result;
    }
    /* Check link đăng kí online */
    public String clickLinkDKOL() throws InterruptedException {
        logger.info("clickLinkDKOL");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(linkDKOLEl.by()));
        String getHyperLinkSPDV =  myElement.getAttribute("href");
        return getHyperLinkSPDV;
    }
    /* Get URL hien tai */
    public String swithTabURL() throws InterruptedException {
        logger.info("swithTabURL");
        Thread.sleep(2000);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        String getLink= driver.switchTo().window(tabs2.get(1)).getCurrentUrl();
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        return  getLink;
    }
    /* Check link sản phẩm dịch vụ */
    public String clickLinkSPDV() throws InterruptedException {
        logger.info("clickLinkSPDV");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(linkSPDVEl.by()));
       String getHyperLinkSPDV =  myElement.getAttribute("href");
        return getHyperLinkSPDV;
    }
    /* Check link sản phẩm Khuyến Mại */
    public String clickLinkKM() throws InterruptedException {
        logger.info("clickLinkKM");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(linkKMEl.by()));
        String getHyperLink =  myElement.getAttribute("href");
        return getHyperLink;
    }
    /* Check link Tìm điểm giao dịch */
    public String clickLinkTTGD() throws InterruptedException {
        logger.info("clickLinkTTGD");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(linkTTGDEl.by()));
        String getHyperLink =  myElement.getAttribute("href");
        return getHyperLink;
    }
    /* Check link Tin Tức*/
    public String clickLinkTT() throws InterruptedException {
        logger.info("clickLinkTT");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(linkTTEl.by()));
        String getHyperLink =  myElement.getAttribute("href");
        return getHyperLink;
    }
    /* Check link Tuyển Dụng*/
    public String clickLinkTD() throws InterruptedException {
        logger.info("clickLinkTD");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(linkTDEl.by()));
        String getHyperLink =  myElement.getAttribute("href");
        return getHyperLink;
    }
    /* Check link HiFPT*/
    public String clickLinkHiFPT() throws InterruptedException {
        logger.info("clickLinkHiFPT");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(linkHifPTEl.by()));
        String getHyperLink =  myElement.getAttribute("href");
        return getHyperLink;
    }
    /* Check link Youtube*/
    public String clickLinkYoutube() throws InterruptedException {
        logger.info("clickLinkYoutube");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(linkYoutubeEl.by()));
        String getHyperLink =  myElement.getAttribute("href");
        return getHyperLink;
    }
    /* Check link IG*/
    public String clickLinkIG() throws InterruptedException {
        logger.info("clickLinkIG");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(linkIGEl.by()));
        String getHyperLink =  myElement.getAttribute("href");
        return getHyperLink;
    }
    /* Check link Facebook*/
    public String clickLinkFB() throws InterruptedException {
        logger.info("clickLinkFB");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(linkFBEl.by()));
        String getHyperLink =  myElement.getAttribute("href");
        return getHyperLink;
    }
    /* Check link Zalo*/
    public String clickLinkZalo() throws InterruptedException {
        logger.info("clickLinkZalo");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(linkZLEl.by()));
        String getHyperLink =  myElement.getAttribute("href");
        return getHyperLink;
    }
    /* Check link FPT Internet*/
    public String clickLinkFPTInternet() throws InterruptedException {
        logger.info("clickLinkFPTInternet");
        clickElement(linkFPTInternetEl);
        Thread.sleep(2000);
        return swithTabURL();
    }
    /* Check link FPT Play*/
    public String clickLinkFPTPlay() throws InterruptedException {
        logger.info("clickLinkFPTPlay");
        clickElement(linkFPTPlayEl);
        Thread.sleep(2000);
        return swithTabURL();
    }
    /* Hàm click vào 1 phần tử */
    public void clickElement(Query q){
        logger.info("clickElement");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(q.by()));
        myElement.click();
    }
    /* Hàm getText  */
    public String getTextElement(Query q){
        logger.info("getTextElement");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(q.by()));
        return  myElement.getText();
    }
    /* Check link FPT Camera*/
    public String clickLinkFPTCamera() throws InterruptedException {
        logger.info("clickLinkFPTCamera");
        clickElement(linkFPTCameraEl);
        Thread.sleep(2000);
        return swithTabURL();
    }
    /* Check link FPT Ihome*/
    public String clickLinkFPTIhome() throws InterruptedException {
        logger.info("clickLinkFPTIhome");
        clickElement(iconLeftEl);
        clickElement(linkFPTIhomeEl);
        Thread.sleep(2000);
        return swithTabURL();
    }
    /* Check link Foxpay*/
    public String clickLinkFoxPay() throws InterruptedException {
        logger.info("clickLinkFoxPay");
        clickElement(iconLeftEl);
        clickElement(linkFPTFoxPayEl);
        Thread.sleep(2000);
        return swithTabURL();
    }
    /* Check link link FPT PlayBox*/
    public String clickLinkFptPlayBox() throws InterruptedException {
        logger.info("clickLinkFptPlayBox");
        clickElement(linkFPTPlayBoxEl);
        Thread.sleep(2000);
        return swithTabURL();
    }
    /* Check link link Fsend*/
    public String clickLinkFsend() throws InterruptedException {
        logger.info("clickLinkFsend");
        clickElement(iconLeftEl);
        Thread.sleep(2000);
        clickElement(linkFsendEl);
        Thread.sleep(2000);
        return swithTabURL();
    }
    /* Check link link linkFshare*/
    public String clicklinkFshare() throws InterruptedException {
        logger.info("clicklinkFshare");
        clickElement(iconLeftEl);
        Thread.sleep(2000);
        clickElement(linkFshareEl);
        Thread.sleep(2000);
        return swithTabURL();
    }
    /* Check click link Bo cong thuong*/
    public String clicklinkBCT() throws InterruptedException {
        logger.info("clicklinkBCT");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(imgBoCongThuongEl.by()));
        String getHyperLink =  myElement.getAttribute("href");
        return getHyperLink;
    }
    /* Check click link IPV6 */
    public String clicklinkIPV6() throws InterruptedException {
        logger.info("clicklinkIPV6");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(imgIPV6_URL.by()));
        String getHyperLink =  myElement.getAttribute("href");
        return getHyperLink;
    }
    /* Check get Text phần CopyRight */
    public String getTextPhanCopyRight()  {
        logger.info("getTextPhanCopyRight");
        WebElement txtCP = wait.until(ExpectedConditions.elementToBeClickable(txtCopyRightEl.by()));
        return txtCP.getText();
    }
    /* Check click Link Logo */
    public String getLinkLogo()  {
        logger.info("getLinkLogo");
        clickElement(imgFPT);
        return driver.getCurrentUrl();
    }
    /* Check click button lên đầu trang */
    public Boolean checkClickBtn()  {
        logger.info("checkClickBtn");
        WebDriverWait wait = new WebDriverWait(driver,60);
        WebElement scrollFooter = wait.until(ExpectedConditions.visibilityOfElementLocated(txtCopyRightEl.by()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollFooter);
        clickElement(btnLendauTrang);
        if(getTextElement(txtTrangChu).equals("Trang chủ")){
            return true;
        }else  return false;
    }
    /* Check hiển thị danh sách Ưu đãi mới nhất*/
    public Boolean checkDisplayUuDaiMoiNhat()  {
        logger.info("checkDisplayUuDaiMoiNhat");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(sliderhomeUDEL.by()));
        if(myElement.isDisplayed()){
            return true;
        }else
            return false;
    }
    /* Check get price sp/dv */
    public List  getPriceSPDV()  {
        logger.info("getPriceSPDV");
        List<String> result = new ArrayList<>();
        result.add(getTextElement(priceSuper100UDEL));
        result.add(getTextElement(priceSuper150UDEL));
        result.add(getTextElement(priceSuper250UDEL));
        result.add(getTextElement(priceFPTTrongNhaUDEL));
        result.add(getTextElement(priceFPTNgoaiTroiUDEL));
        result.add(getTextElement(priceLuuTru1NgayUDEL));
        result.add(getTextElement(priceLuuTru2NgayUDEL));
        return result;
    }
    /* Check 1 block ưu đãi hiển thị */
    public List  checkBlockUuDai()  {
        logger.info("checkBlockUuDai");
        List<String> result = new ArrayList<>();
        result.add(getTextElement(tenGoiCuocEl));
        result.add(getTextElement(motaDichVuEl));
        result.add(getTextElement(thangEl));
        result.add(getTextElement(giamGiaEl));
        result.add(getTextElement(giamGiaPhanTramEl));
        return result;
    }
    /* Check hiển thị danh sách Ưu đãi mới nhất*/
    public Boolean checkDisplayDuocQuanTamNhieuNhat()  {
        logger.info("checkDisplayDuocQuanTamNhieuNhat");
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(dataDuocQuanTamNhieuNhatEl.by()));
        if(myElement.isDisplayed()){
            return true;
        }else
            return false;
    }
    /* Check hiển thị 1 block san pham duoc quan tam nhieu nhat*/
    public List checkDisplaySPQuanTamNhieuNhat() {
        logger.info("checkDisplaySPQuanTamNhieuNhat");
        List<Object> result = new ArrayList<>();
        WebElement myElement = wait.until(ExpectedConditions.elementToBeClickable(iconSPQuanTamNhieuNhatSPEl.by()));
        String hienthiicon = "";
        if(myElement.isDisplayed())
        {
            hienthiicon =  "true";
        }
        result.add(getTextElement(tenSPQuanTamNhieuNhatEl));
        result.add(getTextElement(motaSPQuanTamNhieuNhatSPEl));
        result.add(getTextElement(priceSPQuanTamNhieuNhatSPEl));
        result.add(getTextElement(giamGiaSPQuanTamNhieuNhatSPEl));
        result.add(hienthiicon);
        return result;
    }
        /**
         * Author: HaoBH
         * Function: get list của các items giống nhau chứa trong cùng 1 layout chung
        *@param query - item trong cùng của layout.
         *             Example: 1 thẻ <ul> chứa nhiều thẻ <li> bên trong thì query là 1 tập hợp các <li>
        *@return List items kiểu String
        * */
    public List getListItems (Query query) { //import com.lazerycode.selenium.util.Query;
        logger.info("getListItems");
        ArrayList result = new ArrayList<>();
        List<WebElement> elementList= new ArrayList<>(query.findWebElements());
        for (int i = 0; i < elementList.size(); i++) {
            result.add(elementList.get(i).getText().trim());
            //System.out.println(elementList.get(i).getText().trim());
        }
        return result;
    }
    /**
     * Author: HaoBH
     * Function: click the item when it's displayed, if it's not displayed, don't click
     * @param element - element needs to check
     * */
    public void clickElementWhenItIsDisplay(Query element){
        logger.info("clickElementWhenItIsDisplay");
        //thêm wait sẽ bị lỗi -> không thêm
        try {
            if (element.findWebElement().isDisplayed()) {
                element.findWebElement().click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }



    /* Hàm click tin tức bất ký nếu tồn tại link */
    public void clickRandomNewsHasLink() {
        logger.info("clickRandomNewsHasLink");
        Random ran = new Random();
        wait.until(ExpectedConditions.presenceOfElementLocated(itemSliderTinNoiBat.by()));
        List<WebElement> listElement= getListElementHasLinkInList(itemSliderTinNoiBat);
        WebElement element = listElement.get(ran.nextInt(listElement.size()));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    /*#######################################################*/
    /*Vào LandingPage */
    public void goHere() {
        logger.info("goHere");
        driver.get(url);
    }

    /*Vào LandingPage với mã Giới thiệu bạn bè*/
    public void goHereWithReferralCode(String code) {
        logger.info("goHere");
        driver.get(urlGTBB+code);
    }

    public void verifyFooterInformation() throws InterruptedException {
        //Chưa là khách hàng
        assertThat(getListTextChuaLaKHFPT()).
                as("Check list Check Chưa là khách hàng của FPT Telecom").
                isEqualTo(getListKH);
        assertThat(clickLinkDKOL())
                .as("Check click Đăng ký online ở phần “Chưa là khách hàng của FPT Telecom”").
                isEqualTo(getURL_DKOL);
        assertThat(clickLinkKM()).
                as("Check click Khuyến mãi ở phần “Chưa là khách hàng của FPT Telecom”").
                isEqualTo(getURL_KM);
        assertThat(clickLinkTTGD()).
                as("Check mo link tim diem giao dich").
                isEqualTo(getURL_TDGD);
        assertThat(clickLinkTT()).
                as("Check mo link tin tuc").
                isEqualTo(getURL_TT);
        //social menu
        assertThat(clickLinkHiFPT()).
                as("Check click icon Hi FPT").
                isEqualTo(getURL_HiFPT);
        assertThat(clickLinkYoutube()).
                as("Check click icon Youtube").
                isEqualTo(getURL_YT);
        assertThat(clickLinkIG()).
                as("Check click icon Instagram").
                isEqualTo(getURL_IG);
        assertThat(clickLinkFB()).
                as("Check click icon Facebook").
                isEqualTo(getURL_FB);
        assertThat(clickLinkZalo()).
                as("Check click icon Zalo").
                isEqualTo(getURL_ZL);
        //Check phần Về FPT Telecom
        assertThat(getListItems(listItemVeFPTTelecom)).
                as("Check phần Về FPT Telelcom").
                isEqualTo(listFromJSONTC1_98);
        //Khách hàng FPT Telecom
        assertThat(getListItems(listItemKhachHangFPTTelecom)).
                as("Check Khách hàng FPT Telecom").
                isEqualTo(listFromJSONTC1_104);

        //FPT services
        /*assertThat(linkFPTInternetEl.findWebElement().getAttribute("href")).
                as("Check link FPT Internet").
                isEqualTo(getURL_SPDV);*/
        clickElement(iconLeftEl);
        clickElement(iconLeftEl);
        assertThat(linkFPTPlayEl.findWebElement().getAttribute("href")).
                as("Check mo link FPT Play").
                isEqualTo(getURL_FPTPlay);

        assertThat(linkFPTCameraEl.findWebElement().getAttribute("href")).
                as("Check mo link FPT Camera").
                isEqualTo(getURL_FPTCamera);

        AssertionsForClassTypes.assertThat(getTextPhanCopyRight()).
                as("Check get Text Copy Right").
                isEqualTo(getTEXTCOPY);

        assertThat(checkClickBtn()).
                as("Check Link IMG Logo FPT").
                isEqualTo(true);


    }


}
