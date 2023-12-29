package page_objects.Menu;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import page_objects.PageBase;

import java.util.ArrayList;
import java.util.List;

import static net.fpt.utils.WebElementActionUtil.chooseList;
import static org.assertj.core.api.Assertions.assertThat;
import static constants.Common.*;

public class ActionsMenu extends ElementsMenu {
    static final Logger logger = LoggerFactory.getLogger(PageBase.class);

    /* Get list HyperLink trên thanh menu */
    public List getListHyperlink(){
        List<String> result = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(headerEl.by()));
        List<WebElement> elementList = headerEl.findWebElements();
        for (int i = 0; i < elementList.size(); i++) {
            result.add(elementList.get(i).getText().trim());
        }
        return result;
    }
    /* Get  HyperLink trang chủ  */
    public String linkTrangChuFPT(){
        WebElement clickLinkTrangChu = wait.until(ExpectedConditions.elementToBeClickable(linkTrangChuEl.by()));
        clickLinkTrangChu.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getCurrentUrl();
    }
    /* Get  HyperLink trang Internet  */
    public String linkInternet(){
        WebElement clickInternet = wait.until(ExpectedConditions.elementToBeClickable(linkInternetEl.by()));
        clickInternet.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getCurrentUrl();
    }
    /* Get  HyperLink trang Camera */
    public String linkFptCamera(){
        WebElement clickFptCamera = wait.until(ExpectedConditions.elementToBeClickable(linkFptCameraEl.by()));
        clickFptCamera.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getCurrentUrl();
    }
    /* Get  HyperLink trang FPTplaybox */

    public String linkFptPlayBox(){
        WebElement clickFptPlayBox = wait.until(ExpectedConditions.visibilityOfElementLocated(linkFptPlayBoxEl.by()));
        clickFptPlayBox.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getCurrentUrl();
    }
    /* Get  HyperLink trang FPT Cloud */

    public String linkFptCloud(){
        WebElement clickFptCloud = wait.until(ExpectedConditions.visibilityOfElementLocated(linkFptCloudEl.by()));
        clickFptCloud.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getCurrentUrl();
    }
    /* Get Text các phần từ tại POPUP tìm kiếm */
    public List checkTextPopUpTimKiem(){
        clickIconTimKiem();
        WebElement label = wait.until(ExpectedConditions.elementToBeClickable(labelTimKiemEl.by()));
        List<String> result = new ArrayList<>();
        result.add(label.getText());
        WebElement txtBtnTimKiem = wait.until(ExpectedConditions.elementToBeClickable(labelBtnTimKiemEl.by()));
        result.add(txtBtnTimKiem.getText());
        WebElement placehoder = wait.until(ExpectedConditions.elementToBeClickable(placeholderTimKiemEl.by()));
        result.add(placehoder.getAttribute("placeholder"));
        return  result;
    }
    /* Check hiển thị Input tìm kiếm  */
    public Boolean checkInputTimKiem(){
        Boolean trangthai = null;
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(inputTimKiemEl.by()));
        if(input.isDisplayed()){
            trangthai = true;
        }
        else trangthai =false;
        return trangthai;
    }
    /* Truyền txt vào input tìm kiếm */
    public String senKeyTXTTimKiem(String key){
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(inputTimKiemEl.by()));
        input.sendKeys(key);
        return input.getAttribute("value");
    }
    /* Xóa txt input tìm kiếm */
    public String deleteTXTTimKiem(String key){
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(inputTimKiemEl.by()));
        input.clear();
        return input.getAttribute("value");
    }
    /* Kiểm tra sau khi xóa text tại input tim kiếm */
    public Boolean clearTxtTimKiem(String key) throws InterruptedException {
        Boolean trangthai = null;
        //Thread.sleep(2000);
        deleteTXTTimKiem(key);
        String getText = deleteTXTTimKiem(key);
        if(getText.equals(""))
        {
            trangthai =true;
        }else  trangthai =false;
        return  trangthai;
    }
    /* Nhập kí tự vào input tìm kiếm đơn hàng */
    public Boolean nhapKiTuInput(String input){
        Boolean trangthai = null;
        WebElement inputTK = wait.until(ExpectedConditions.elementToBeClickable(inputTimKiemEl.by()));
        inputTK.sendKeys(input);
        String getTextInput = inputTK.getAttribute("value");
      if(getTextInput.equals(input))
      {
          trangthai = true;
      }
      else  trangthai =false;
        return trangthai;
    }
    /* Hàm xử lý gettext đơn hàng không hợp lệ  */
    public String getTextDHKHL(String input){
        WebElement inputTK = wait.until(ExpectedConditions.elementToBeClickable(inputTimKiemEl.by()));
        inputTK.sendKeys(input);
        WebElement clickBtnTK = wait.until(ExpectedConditions.elementToBeClickable(labelBtnTimKiemEl.by()));
        clickBtnTK.click();
        WebElement txtDonHangNotFound = wait.until(ExpectedConditions.elementToBeClickable(txtDonHangKhongHopLeEl.by()));
        return  txtDonHangNotFound.getText();
    }
    public void clickIconTimKiem(){
        WebElement iconTimKiem =  wait.until(ExpectedConditions.elementToBeClickable(timKiemEl.by()));
        iconTimKiem.click();
    }
    /* Hàm xử lý xuất hiện google capcha */
    public Boolean displayGoogleCapcha(String Key) throws InterruptedException {
        WebElement inputTK = wait.until(ExpectedConditions.elementToBeClickable(inputTimKiemEl.by()));
        WebElement clickBtnTK = wait.until(ExpectedConditions.elementToBeClickable(labelBtnTimKiemEl.by()));
        for ( int i=0;i<3;i++){
            inputTK.sendKeys(Key);
            clickBtnTK.click();
            inputTK.clear();
        }
        WebElement getDisplayGoogleCapcha = wait.until(ExpectedConditions.elementToBeClickable(labelRoBotEl.by()));
        if(getDisplayGoogleCapcha.isDisplayed()){
            return true;
        }else  return false;

    }
    /* Hàm xử lý click Tìm kiếm đơn hàng */
    public  void clickShowPopUpDonHang(){
        WebElement clickBtnTK = wait.until(ExpectedConditions.elementToBeClickable(labelBtnTimKiemEl.by()));
        clickBtnTK.click();
    }
    /* Hàm xử lý tìm kiếm đơn hàng thành công */
    public String checkTimKiemDonHangThanhCong(String key){
        clickIconTimKiem();
        senKeyTXTTimKiem(key);
        clickShowPopUpDonHang();
        return driver.getCurrentUrl();
    }
    public void clickDropDownQH() {
        WebElement clickQH = wait.until(ExpectedConditions.elementToBeClickable(dropDownQHEl.by()));
        clickQH.click();
    }

    public ActionsMenu waitLoadingLocation() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(listTTEl.by())));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(listTTEl.by())));
        return this;
    }
    public ActionsMenu waitLoadingLocationTT() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listTTEl.by()));
        return this;
    }

    public ActionsMenu waitLoadingLocationQH() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(listTTEl.by(),0));
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listQHEl.by()));
        return this;
    }

    public ActionsMenu waitLoadingWardQH() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(listPXEl.by(),0));
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listPXEl.by()));
        return this;
    }

    /* Chọn location tỉnh thành lắp đặt để vào trang home  */
    public ActionsMenu chooseProvinceLocation(String input) {
        WebElement dropdownTT = wait.until(ExpectedConditions.elementToBeClickable(dropdownTinhThanhEl.by()));
        dropdownTT.click();
        chooseList(itemInList, input);
        return this;
    }

    /***
     Chọn location quận huyện lắp đặt để vào trang home
     */
    public ActionsMenu chooseProvinceLocationQH(String input) {
        WebElement dropdownTT = wait.until(ExpectedConditions.elementToBeClickable(dropdownQuanHuyenEl.by()));
        dropdownTT.click();
        chooseList(itemInList, input);
        return this;
    }

    /***
    Chọn location phường xã lắp đặt để vào trang home
     */
    public ActionsMenu chooseWardsLocationQH(String input) {
        WebElement dropdownTT = wait.until(ExpectedConditions.elementToBeClickable(dropdownPhuongXaEl.by()));
        dropdownTT.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chooseList(itemInList, input);
        return this;
    }
    /* Click vào Btn Xác Nhận  */
    public ActionsMenu clickButtonApproveLocation() {
        WebElement btnXacNhan = wait.until(ExpectedConditions.elementToBeClickable(textBtnXacNhanEl.by()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnXacNhan.click();
        return this;
    }

    /* Click hiển thị POPUP */
    public void clickHienThiPOPUP() throws InterruptedException {
        WebElement clickPopUp = wait.until(ExpectedConditions.elementToBeClickable(locationEl.by()));
        clickPopUp.click();
    }

    public String getTextCurrentLocation() throws InterruptedException {
        WebElement stringText = wait.until(ExpectedConditions.presenceOfElementLocated(locationEl.by()));
        return stringText.getText();
    }

    /* Get Text địa chỉ lắp đặt */
    public String getTextDCLD() {
        WebElement stringTextDCLD = wait.until(ExpectedConditions.elementToBeClickable(textDCLDEl.by()));
        return stringTextDCLD.getText();
    }

    /* Get Text ghi chú của POPUP chọn location */
    public String getTextGC() {
        WebElement stringTextGC = wait.until(ExpectedConditions.elementToBeClickable(textGCEl.by()));
        return stringTextGC.getText();
    }

    /* Get Text Button Xác nhận */
    public String textBtnXacNhan() {
        WebElement btnXacNhan = wait.until(ExpectedConditions.elementToBeClickable(textBtnXacNhanEl.by()));
        return btnXacNhan.getText();
    }
    /* Check trạng thái hiển thị dropdownlist Tỉnh Thành , true là hiển thị, false là không hiển thị */
    public Boolean displayDropdownlistTT() {
        Boolean trangthai = null;
        WebElement dropdownTT = wait.until(ExpectedConditions.elementToBeClickable(dropdownTinhThanhEl.by()));
        if (dropdownTT.isDisplayed()) {
            trangthai = true;
        } else trangthai = false;
        return trangthai;
    }

    /* Check trạng thái hiển thị dropdownlist Tỉnh Thành , true là hiển thị, false là không hiển thị */
    public Boolean displayDropdownlisQH() {
        Boolean trangthai = null;
        WebElement dropdownTT = wait.until(ExpectedConditions.elementToBeClickable(dropdownQuanHuyenEl.by()));
        if (dropdownTT.isDisplayed()) {
            trangthai = true;
        } else trangthai = false;
        return trangthai;
    }
    /* Check get List Dropdown Quận Huyện */
    public List getListTT() throws InterruptedException {
        List<String> result = new ArrayList<>();
        Thread.sleep(2000);
        WebElement hienthiTT = wait.until(ExpectedConditions.elementToBeClickable(dropdownTinhThanhEl.by()));
        hienthiTT.click();
        WebElement clickTT = wait.until(ExpectedConditions.elementToBeClickable(dropDownTTEl.by()));
        clickTT.click();
        List<WebElement> elementList = listTTEl.findWebElements();
        for (int i = 0; i < elementList.size(); i++) {
            result.add(elementList.get(i).getText().trim());
        }
        return result;

    }
    /* Check get List Dropdown Quận Huyện */
    public List getListQH() throws InterruptedException {
        List<String> result = new ArrayList<>();
        Thread.sleep(2000);
        clickDropDownQH();
        WebElement stringTextGC = wait.until(ExpectedConditions.elementToBeClickable(textGCEl.by()));
        stringTextGC.click();
        List<WebElement> elementList = listQHEl.findWebElements();
        for (int i = 0; i < elementList.size(); i++) {
            result.add(elementList.get(i).getText().trim());
        }
        return result;
    }

    /* Check đã tắt POPUP hay chưa */
    public Boolean checkTatPOPUP() throws InterruptedException {
        Boolean trangthai = null;
        WebElement clickTatPopUp = wait.until(ExpectedConditions.elementToBeClickable(textBtnXacNhanEl.by()));
        clickTatPopUp.click();
        ActionsMenu actionMenu = new ActionsMenu();
        String getURL = actionMenu.linkInternet();
        if (getURL != "") {
            trangthai = true;
        } else trangthai = false;
        return trangthai;
    }
    /* Check thông báo chưa chọn quận huyện */
    public String getTextThongChuaChonQH() {
        WebElement stringTextThongBao = wait.until(ExpectedConditions.elementToBeClickable(txtThongBao.by()));
        return stringTextThongBao.getText();
    }

    /**Author: HaoBH
     * Function: check whether the element is displayed
     * @param element
     * @return true/false
     * */
    public boolean checkElementDisplayed(Query element){
        logger.info("checkElementDisplayed");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element.by()));
            if (element.findWebElement().isDisplayed())
                return true;
        }
        catch (NoSuchElementException e){

        }
        catch (TimeoutException e){

        }
        return false;
    }

    public boolean checkIsDisplayPopupLocation(){
        return checkElementDisplayed(textBtnXacNhanEl);
    }

    public void skipToPopupLocation(){
        logger.info("skipToPopupLocation");
        if(checkIsDisplayPopupLocation()){
            ActionsMenu menuShop = new ActionsMenu();
            menuShop.waitLoadingLocation().
                    clickButtonApproveLocation();
        }
    }
    public void openPopuplocationIfItNotPresent() throws InterruptedException {
        logger.info("openPopuplocationIfItNotPresent");
        Boolean checkPopUp = checkIsDisplayPopupLocation();
        if(checkPopUp==false){
            ActionsMenu menuShop = new ActionsMenu();
            menuShop.clickHienThiPOPUP();
        }
    }

    public void verifyTextOnLocationPopup() throws InterruptedException {
        assertThat(getTextDCLD()).as("So sánh text địa chỉ lắp đặt").isEqualTo(DCLD);
        assertThat(getTextGC()).as("So sánh text địa chỉ lắp đặt").isEqualTo(ghiChu);
        assertThat(textBtnXacNhan()).as("So sánh text Btn Xác nhận").isEqualTo(textbtnXN);
        assertThat(displayDropdownlistTT()).as("Hiển thị dropdownlist Tỉnh Thành").isEqualTo(true);
        assertThat(displayDropdownlisQH()).as("Hiển thị dropdownlist Quận Huyện").isEqualTo(true);
        assertThat(getListTT()).as("Check dropdownlist Tỉnh Thành ").isEqualTo(getListTT);
        assertThat(getListQH()).as("Check dropdownlist Quận Huyện ").isEqualTo(getList1QH);
    }

    @Test()
    public void verifyErrorMessageLocationPopup(){
        assertThat(getTextThongChuaChonQH()).as("Check hiển thị text thông báo lỗi QH").isEqualTo(textTBQH);
    }

    @Test()
    public void verifySelectLocationPopup() throws InterruptedException {
        assertThat(getTextCurrentLocation()).as("Kiểm tra chọn địa chỉ lắp đặt").isEqualTo("Hà Nội2");
    }
    @Test()
    public void verifyCloseLocationPopup() throws InterruptedException {
        assertThat(checkTatPOPUP()).as("Check tat POPUP").isEqualTo(true);
    }

    @Test()
    public void verifyHeader() throws InterruptedException {
        assertThat(getListHyperlink()).containsExactlyInAnyOrder("Trang chủ", "Internet", "FPT Camera", "FPT Playbox", "FPT Cloud").as("Không hiện đủ header");
        assertThat(linkTrangChuFPT()).as("So sánh đường link ").isEqualTo(urlTrangChu);
        assertThat(linkInternet()).as("So sánh đường link Internet").isEqualTo(urlInternet);
        assertThat(linkFptCamera()).as("So sánh link FPT Camera").isEqualTo(urlFPTCamera);
        assertThat(linkFptPlayBox()).as("So sánh link FPT PlayBox").isEqualTo(urlFPTPlayBox);
        assertThat(linkFptCloud()).as("So sánh link FPT Cloud").isEqualTo(urlFPTCLOUD);
        assertThat(checkTextPopUpTimKiem()).as("So sánh các text của POPUP").isEqualTo(listTextTimKiem);
        assertThat(checkInputTimKiem()).as("Check hiển thị input tìm kiếm").isEqualTo(true);
        assertThat(nhapKiTuInput("ABCDEFGH")).as("Check có cho phép nhập kí tự không").isEqualTo(true);
        assertThat(clearTxtTimKiem("ABCDEFGH")).as("Check xóa text thành công").isEqualTo(true);
        assertThat(getTextDHKHL("ABCDEFGH")).as("Check thông báo đơn hàng không hợp lệ").isEqualTo(txtDonHangNotFound);
        assertThat(displayGoogleCapcha("khoatest")).as("Hiển thị google Capcha").isEqualTo(true);
    }
}
