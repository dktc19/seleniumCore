package page_objects.Register;

import com.lazerycode.selenium.util.Query;
import constants.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page_objects.LandingPage.ActionLandingPage;
import page_objects.LandingPageInternet.ActionLandingPageInternet;
import page_objects.Menu.ActionsMenu;
import net.fpt.utils.ReadingJsonUtil;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static constants.Common.*;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static net.fpt.utils.WebElementActionUtil.*;
import static org.assertj.core.api.Assertions.assertThat;


public class ActionsRegister extends ElementsRegister {

    private String tinhThanh_ThongTinDangKy="";

    public ActionsRegister enterFullName(String fullname){
        nameEl.findWebElement().sendKeys(fullname);
        return this;
    }

    public ActionsRegister enterPhone(String phoneNumber){
        phoneEl.findWebElement().sendKeys(phoneNumber);
        return this;
    }

    public ActionsRegister enterDayOfBirth(String date){
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateOfBirthEl.by()));
        dateOfBirthEl.findWebElement().sendKeys(date);
        return this;
    }
    // Ham Nhap Ngay Sinh khong click
    public ActionsRegister enterNgaySinh(String date){
        ngaySinhEl.findWebElement().sendKeys(date);
        return this;
    }
    public ActionsRegister enterTenDuongPho(String date){
        txtNhapTenDuongPho.findWebElement().sendKeys(date);
        return this;
    }

    public ActionsRegister enterID(String date){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cmndEl.by()));
        cmndEl.findWebElement().sendKeys(date);
        return this;
    }

    public ActionsRegister enterHouseNumber(String imput){
        houseNumber.findWebElement().sendKeys(imput);
        return this;
    }

    public ActionsRegister enterEmail(String phoneNumber){
        emailEl.findWebElement().sendKeys(phoneNumber);
        return this;
    }

    public ActionsRegister chooseState(String state){
        chooseList(dropdownliststateListEl,state);
        return this;
    }

    public ActionsRegister chooseSex(String sex){
        chooseList(sexListEl,sex);
        return this;
    }

    public ActionsRegister chooseHouseNumber(String number){
        txtHouseNumber.findWebElement().clear();
        txtHouseNumber.findWebElement().sendKeys(number);
        return this;
    }
    /* Hàm getText 1 Element */
    public String getTextElement(Query q){
        WebElement myElement =  wait.until(ExpectedConditions.visibilityOfElementLocated(q.by()));
        return  myElement.getText();
    }

    /* Hàm click vao 1 Element */
    public void clickElement(Query q){
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(q.by()));
        myElement.click();
    }

    /* Hàm click nút tiếp tục trong trang đăng ký*/
    public ActionsRegister clickOnContinueButton(){
        waitAndClickToElement(btnTiepTuc,wait);
        return this;
    }

    /* Hàm getText Thong Tin Dang Ky */
    public List getTextThongTinDangKy()  {
        List<String> result = new ArrayList<>();
        result.add(getTextElement(txtThongTinCaNhan));
        result.add(getTextElement(txtDiaChiLapDat));
        result.add(getTextElement(btnTiepTuc));
        result.add(getTextElement(txtDKDV));
        result.add(getTextElement(txtChonDV));
        result.add(getTextElement(txtTTTT));
        result.add(getTextElement(txtHTDK));
        return result;
    }

    public String  getLinkMenuDKDV() {
        waitAndClickToElement(txtDKDV,wait);
        return driver.getCurrentUrl();
    }
    public String  getLinktxtChonDV() {
        waitAndClickToElement(txtChonDV,wait);
        return driver.getCurrentUrl();
    }
    public String  getLinktxtHTDK() {
        waitAndClickToElement(txtTTTT,wait);
        return driver.getCurrentUrl();
    }
    public String  getLinktxtTTTT() {
        waitAndClickToElement(txtHTDK,wait);
        return driver.getCurrentUrl();
    }
    /* Hàm getText Thong Tin Ca Nhan */
    public List getTextThongTinCaNhan()  {
        List<String> result = new ArrayList<>();
        result.add(getTextElement(txtHovaTen));
        result.add(getTextElement(txtSDT));
        result.add(getTextElement(txtNgaySinh));
        result.add(getTextElement(txtSoCMND));
        result.add(getTextElement(txtgioiTinh));
        result.add(getTextElement(txtDiachiEmail));
        return result;
    }
    /* Hàm getText Thong Tin Loi */
    public List getTextLoi()  {
        return getTextListItems(listErrorNullInput);
    }

    public ActionsRegister clearInputName() throws InterruptedException {
        WebElement sendkeyName = wait.until(ExpectedConditions.elementToBeClickable(nameEl.by()));
        sendkeyName.clear();
        return this;
    }

//    public Boolean checkNhapInputSDT(int sendkey){
//        WebElement sendkeyName = wait.until(ExpectedConditions.elementToBeClickable(phoneEl.by()));
//        sendkeyName.sendKeys(sendkey);
//        String result =  sendkeyName.getAttribute("value");
//        if(result.equals(sendkey)){
//            return true;
//        }else
//            return false;
//    }


    /* Chọn location Phường/Xã lắp đặt để vào trang home  */
    public ActionsRegister choosePhuongXaLapDat(String input) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement dropdownTT = wait.until(ExpectedConditions.elementToBeClickable(dropdownlistWard.by()));
        dropdownTT.click();
        chooseList(listItemWard, input);
        return this;
    }

    /* Chọn location Phường/Xã lắp đặt để vào trang home  */
    public ActionsRegister chooseDuongPhoLapDat(String input) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement dropdownTT = wait.until(ExpectedConditions.elementToBeClickable(dropdownlistStreet.by()));
        dropdownTT.click();
        chooseList(listItemStreet, input);
        return this;
    }

    /* chờ đến khi hết loading  */
    public ActionsRegister waitLoadigStartStop() {
        wait.until(waitForLoadingCSSStype(loading.findWebElement(),""));
        wait.until(waitForLoadingCSSStype(loading.findWebElement(),"display: none;"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    /* chờ đến khi hết loading  */
    public ActionsRegister waitGoToURL(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
        wait.until(waitForLoadingCSSStype(loading.findWebElement(),"display: none;"));
        return this;
    }

/*    *//* Click tiếp tuc *//*
    public ActionsRegister clickNext() {
        btnTiepTuc.findWebElement().click();
        return this;
    }*/

    /* Click + */
    public ActionsRegister clickIncrease() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonIncrease.by()));
        buttonIncrease.findWebElement().click();
        return this;
    }

    /* Click - */
    public ActionsRegister clickDecrease() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonDecrease.by()));
        buttonDecrease.findWebElement().click();
        return this;
    }
    public int getQuantityBox() {
        return Integer.parseInt(textQuantityBox.findWebElement().getText());
    }

    public ActionsRegister clickInfoFsafe() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonInfoFsafe.by()));
        buttonInfoFsafe.findWebElement().click();
        return this;
    }

    public ActionsRegister clickCloseInfoFsafe() {
        buttonClosePopUpInfoFsafe.findWebElement().click();
        return this;
    }

    public String getDateSetupTime() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(dateSetupTime.by()));
        return element.getAttribute("value");
    }

    public ActionsRegister enterTimeSetupTime(String date) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dateSetupTime.by()));
        element.click();
        element.clear();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.sendKeys(date);
        wait.until(ExpectedConditions.elementToBeClickable(selectdateOfBirtAfterSend.by()));
        selectdateOfBirtAfterSend.findWebElement().click();
        return this;
    }

    public Boolean checkNhapInputSDT(String sendkey){
        WebElement sendkeyName = wait.until(ExpectedConditions.elementToBeClickable(phoneEl.by()));
        sendkeyName.sendKeys(sendkey);
        String result =  sendkeyName.getAttribute("value");
        if(result.equals(sendkey)){
            return true;
        }else
            return false;
    }
    public String checkNhapInputSDTSaiDinhDang(String sendkey) {
        WebElement sendkeyName = wait.until(ExpectedConditions.elementToBeClickable(phoneEl.by()));
        sendkeyName.sendKeys(sendkey);
        clickOnContinueButton();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(txtSaiDangSoDT.by()));
        return element.getText();
    }
    public String checkNhapInputSaiNgaySinh(String sendkey) {
        WebElement sendkeyName = wait.until(ExpectedConditions.elementToBeClickable(dateOfBirthEl.by()));
        sendkeyName.sendKeys(sendkey);
        clickOnContinueButton();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(txtSaiDangNgaysinh.by()));
        return element.getText();
    }
    public Boolean checkNhapInputCMND(String sendkey) {
        WebElement sendkeyName = wait.until(ExpectedConditions.elementToBeClickable(cmndEl.by()));
        sendkeyName.sendKeys(sendkey);
        clickOnContinueButton();
        String result =  sendkeyName.getAttribute("value");
        if(result.equals(sendkey)){
            return true;
        }else
            return false;
    }
    public Boolean checkChonGT(String input) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(inputGT.by()));
        element.click();
        chooseList(dropdownGioiTinh, input);
        Boolean trangthai = null;
        try {
            if (element.getText().equals(input)) {
                trangthai = true;
            }
            else trangthai = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trangthai;
    }
    public Boolean checkChonPhuongXa(String input) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(inputPhuongXa.by()));
        element.click();
        chooseList(dropdownPhuongXaDP, input);
        Boolean trangthai = null;
        try {
            if (element.getText().equals(input)) {
                trangthai = true;
            }
            else trangthai = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trangthai;
    }
    public Boolean checkChonDuongPho(String input) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(inputDuongPho.by()));
        element.click();
        chooseList(dropdownPhuongXaDP, input);
        Boolean trangthai = null;
        try {
            if (element.getText().equals(input)) {
                trangthai = true;
            }
            else trangthai = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trangthai;
    }

    public ActionsRegister clickRadioChungCu() {
        clickElement(radioBtnChungCu);
        return this;
    }
    public String getTextTrungKHTN24h() {
        String result = getTextElement(txtPopupTrungKHTN);
         return result;
    }
    public String getTextKTHT() {
        String result = getTextElement(txtPopupKTHT);
        return result;
    }
    public void clearTextPhone(){
        phoneEl.findWebElement().clear();
    }
    public void clearTextID(){
        cmndEl.findWebElement().clear();
    }
    public String getTextTBNC() {
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        String result = getTextElement(txtThongBaoNoCuoc);
        return result;
    }
    public ActionsRegister clickRadioNhaRieng() {
        clickElement(radioBtnNhaRieng);
        return this;
    }
    public ActionsRegister displayGioLapDat(String input) {
        clickElement(txtGioLapDat);
        chooseList(chooseGioLapDat,input);
        return this ;
    }

    public ActionsRegister refreshRegister() {
        driver.navigate().refresh();
        return this ;
    }

    public List getTextHoanTatDK(){
        List result = new ArrayList();
        result.add(getTextElement(txtHoanTatDangKy));
        result.add(getTextElement(txtThongtinThanhToan));
        result.add(getTextElement(txtChiTietDonHang));
        result.add(getTextElement(txtDieuKhoan2));
        result.add(getTextElement(txtDieuKhoan1));
        result.add(getTextElement(getTextKH50K));
        return result;
    }
    public Boolean checkDisplayThongTinThanhToan(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(bnThanhToan.by()));
        if (element.isDisplayed()){
            return true;
        }else return false;
    }
    public String checkClickLinkThayDoiDiaChiLapDat(){
        clickElement(linkThayDoiDiaChiLapDat);
       return driver.getCurrentUrl();
    }
    public String checkClickLinkThayDoiThongTinTT(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        clickElement(linkThayDoiDiaChiTT);
        return driver.getCurrentUrl();
    }
    public void clickPOPUPHTTT() throws InterruptedException {
        Thread.sleep(2000);
        clickElement(linkPTTT);
    }
    public List getListPOPUPHTTT(){
        List result = new ArrayList();

        result.add(getTextElement(txtHinhThucTT));
        result.add(getTextElement(txtNoteTT));
        result.add(getTextElement(txtTheQuocTe));
        result.add(getTextElement(txtTheATM));
        result.add(getTextElement(txtFoxPay));
        result.add(getTextElement(txtMoMo));
        result.add(getTextElement(txtTheVNPAY));
        result.add(getTextElement(txtTTTN));
        return result;
    }
    public Boolean checkRadioButton(){
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(radioTheQuocTe.by()));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(radioTheATM.by()));
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(radioFoxPay.by()));
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(radioMoMo.by()));
        WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(radioTTTN.by()));
        WebElement element6 = wait.until(ExpectedConditions.elementToBeClickable(iconX.by()));
        WebElement element7 = wait.until(ExpectedConditions.elementToBeClickable(btnXN.by()));
        WebElement element8 = wait.until(ExpectedConditions.elementToBeClickable(radioVNPay.by()));

        if(element1.isDisplayed() && element2.isDisplayed() && element3.isDisplayed() && element4.isDisplayed() &&element5.isDisplayed() && element6.isDisplayed() && element7.isDisplayed() && element8.isDisplayed()) {
            return  true;
        } else return false;
    }
    public String clickBtnXNPOPUPHTTT(){
        clickElement(radioFoxPay);
        clickElement(btnXN);
        return getTextElement(getTextHTTT);
    }
    public void clickChooseHTTTMOMO() throws InterruptedException {
        Thread.sleep(2000);
        clickElement(radioMoMo);
        Thread.sleep(2000);
        clickElement(btnXN);

    }
    public void clickChooseHTTTVNPAY() throws InterruptedException {
        Thread.sleep(2000);
        clickElement(radioVNPay);
        Thread.sleep(2000);
        clickElement(btnXN);

    }
    public void clickChooseHTTTTQT() throws InterruptedException {
        Thread.sleep(2000);
        clickElement(radioTheQuocTe);
        Thread.sleep(2000);
        clickElement(btnXN);
    }
    public void clickChooseHTTTTATM() throws InterruptedException {
        Thread.sleep(2000);
        clickElement(radioTheATM);
        Thread.sleep(2000);
        clickElement(btnXN);
    }
    public void clickChooseHTTTN() throws InterruptedException {
        Thread.sleep(2000);
        clickElement(radioTTTN);
        Thread.sleep(2000);
        clickElement(btnXN);
    }

    public String clickbtnTT() throws InterruptedException {
        Thread.sleep(2000);
        clickElement(bnThanhToan);
        Thread.sleep(2000);
        return driver.getCurrentUrl();
    }
    public String clickIconXPOPUPHTTT(){
        clickElement(iconX);
        return getTextElement(getTextHTTT);
    }
    public void displayGioLapDat(){
        WebElement element =  wait.until(ExpectedConditions.elementToBeClickable(GioLapDatEl.by()));
        if (element.getText().equals("08:00 - 10:00"))
        {
            System.out.println("OK");
        }
    }
    public List getTextListChiTietDonHang() {
        List result = new ArrayList();
        result.add(getTextElement(txtGoiCuoc));
        result.add(getTextElement(txtFsafe));
        result.add(getTextElement(txtVoucher));
        result.add(getTextElement(txtTongTien));
        result.add(getTextElement(txtTongTienGoiCuoc));
        result.add(getTextElement(txtTienFsafe));
        result.add(getTextElement(txtGiamGia));
        result.add(getTextElement(txtThanhTien));

        return result;
    }
    public Boolean getLinkHTTDK(){
        WebElement  element1 =  wait.until(ExpectedConditions.elementToBeClickable(txtXemChiTiet.by()));
        WebElement  element2 =  wait.until(ExpectedConditions.elementToBeClickable(txtHDDDT.by()));
        String getLink1 = element1.getAttribute("href");
       String getLink2 = element2.getAttribute("href");
        if(getLink1.equals("") && getLink2.equals("")){
            return false;

        }else return true;

    }
    public String getLinkTrangChu(){
    clickElement(txtTiepTuc);
    return driver.getCurrentUrl();

    }
    public String getTextSPQT(){
        return getTextElement(txtCoTheQuanTam);
    }
    public Boolean checkDisplayDSQT(){
        WebElement element =  wait.until(ExpectedConditions.elementToBeClickable(txtHienThiDanhSach.by()));
        if(element.isDisplayed()){
            return true;
        }else  return false;
    }
    public String getURLQT(){
        WebElement element =  wait.until(ExpectedConditions.elementToBeClickable(txt1GoiCuocQT.by()));
        String getUrl = element.getAttribute("href");
        return  getUrl;
    }
    /**Author:HaoBH
     * Chờ tới khi element có text mong muốn*/
    public ActionsRegister waitForDropdownLoad(Query element, String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(element.by(),text));
        return this;
    }
    /**Author: HaoBH
     * Function: chọn 1 giá trị trong list của 1 dropdown, dùng chung cho dropdown Tỉnh thành, Quận Huyện, Phường Xã, Đường Phố
     * @param dropdown dropdown cần click chọn giá trị
     * @param list list giá trị tương ứng với dropdown
     * @param option giá trị muốn chọn trong list
     * */
    public ActionsRegister chooseValueInDropdown(Query dropdown, Query list, String option) throws InterruptedException {
        Thread.sleep(3000);
        dropdown.findWebElement().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(list.by()));
        chooseList(list,option);
        return this;
    }
    /**Author: HaoBH
     * Nhập vào searchBox của dropdown từ khóa có - không dấu -> check xem có match với từ khóa không
     * @return boolean
     * */
    public boolean checkSearchBoxDropdown(Query dropdown,Query searchBox,Query listItem,List<String> input ) throws InterruptedException {
        Thread.sleep(3000);
        String resultInList="";
        dropdown.findWebElement().click();
        int count=0;
        for(int i=0 ; i<input.size() ; i++){
            searchBox.findWebElement().sendKeys(input.get(i));
            wait.until(ExpectedConditions.presenceOfElementLocated(listItem.by()));
            resultInList = (String) getTextListItems(listItem).get(0);
            if(resultInList.equalsIgnoreCase(input.get(0))){
                count++;
                searchBox.findWebElement().clear();
            }
            else searchBox.findWebElement().clear();
        }
        chooseList(listItem,resultInList);
        if (count==input.size())
            return true;
        return false;
    }

    /*Nhập Thông tin đăng ký và click Tiếp tục*/
    public void enterThongTinDangKy() throws InterruptedException {
        ActionLandingPageInternet langdingPageInternet = new ActionLandingPageInternet();
        ActionsMenu menuShop = new ActionsMenu();
        ActionLandingPage langdingPage = new ActionLandingPage();
        ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

        //random 1 số phạm vi từ 100 -> 999, chèn vào 3 số cuối của SĐT
        int ranNum = ThreadLocalRandom.current().nextInt(100,999);;

        //nếu popup Location hiển thị thì click Xác nhận
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        //Click 1 gói cước
        langdingPageInternet.click1GoiCuoc();
        enterFullName("Nguyễn Văn An")
                .enterPhone("0328315" + ranNum)
                .enterDayOfBirth("01/01/1996")
                .enterID("742156649");
        chooseValueInDropdown(closedDropdownTinhThanh,listItemTinhThanh,"Hồ Chí Minh");
        chooseValueInDropdown(closedDropdownQuanHuyen,listItemQuanHuyen,"Quận 1");
        chooseValueInDropdown(closedDropdownPhuongXa,listItemPhuongXa,"Phường Bến Nghé");
        chooseValueInDropdown(closedDropdownDuongPho,listItemDuongPho,"Tôn Thất Đạm");
//        txtBoxDiaChiSoNha.findWebElement().sendKeys("10");
        clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(jsonUtil.findValueJsonObjectByKeyPathJsonString(Common.DATA_TEST_FILE_PATH_COMMON,"/URL_CHON_DICH_VU")));
    }

    public List getTimeZoneAbilityForAPI(){
        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
        SessionStorage sessionStorage = webStorage.getSessionStorage();

        Timestamp timestamp= new Timestamp(System.currentTimeMillis());
        LocalDateTime localDateTime=timestamp.toLocalDateTime();

        System.out.println(localDateTime.toString());
        Map<String,Object> jsonAsMap=new HashMap<>();
        jsonAsMap.put("ordercode",sessionStorage.getItem("ordercode"));
        jsonAsMap.put("date", localDateTime.toString());

        String urlAPI = "http://apionline-stag.fpt.vn/api/v1/order/gettimezoneability";
        System.out.println("??"+ given().contentType(JSON).body(jsonAsMap).when().post(urlAPI).then().assertThat().statusCode(200).extract().path("Data"));

        List<String> data = given().contentType(JSON).body(jsonAsMap).when().post(urlAPI).then().assertThat().statusCode(200).extract().
                path("Data");

        return data;
    }
    /*Hàm check xem mã Voucher đã nhập có hiển thị, nếu có thì trả về true, ngược lại thì false*/
    public boolean checkEnteredVoucherDisplayed(List listVoucher, String maGTBBVoucher ){
        for (int i = 0; i<listVoucher.size();i++){
            if (listVoucher.get(i).equals(maGTBBVoucher)){
                return true;
            }
        }
        return false;
    }

    //---------------------------------------------------------------------------

    /*Kiểm tra thông tin header*/
    public void verifyHeader() {
        assertThat(getLinkMenuDKDV()).as("Kiểm tra click vào Header DKDV").isEqualTo(getURLDK);
        assertThat(getLinktxtChonDV()).as("Kiểm tra click vào Header CDV").isEqualTo(getURLDK+"#");
        assertThat(getLinktxtHTDK()).as("Kiểm tra click vào Header TTTT").isEqualTo(getURLDK+"#");
        assertThat(getLinktxtTTTT()).as("Kiểm tra click vào Header HTDK").isEqualTo(getURLDK+"#");
    }

    /*Kiểm tra thông tin các trường nhập thông tin cá nhân*/
    public void verifyRegisterFilter() {
        assertThat(getTextThongTinCaNhan()).as("Kiểm tra mục Thông tin cá nhân ở màn hình thông tin đăng ký").isEqualTo(getListTTCN);
    }

    public void verifyOpenRegsiter() {
        assertThat(getTextThongTinDangKy()).as("Kiểm tra hiển thị màn hình Thông tin đăng ký").isEqualTo(getListTTDK);
    }

    public void verifyErrorListInputRegsiter() {
        assertThat(getTextLoi()).as("Kiểm tra lỗi khi không nhập vào input").isEqualTo(getListLoi);
    }

    public void verifyErrorInputName() throws InterruptedException {
        assertThat(getTextLoi()).as("Kiểm tra hiển thị lỗi khi nhập và xóa tên khách hàng").contains(ERROR_NULL_NAME);
    }

    public void verifyInputPhoneNumber() throws InterruptedException {
        assertThat(checkNhapInputSDT("0703716061")).as("Kiểm tra nhập kí tự vào input SDT").isEqualTo(true);
        clearTextPhone();
        assertThat(checkNhapInputSDTSaiDinhDang("070371")).as("Kiểm tra nhập kí tự sai so dien thoai").isEqualTo(getTextSDTSaiDinhDang);
        clearTextPhone();
        enterPhone("   ");
        clickOnContinueButton();
        assertThat(getTextLoi()).as("Kiểm tra hiển thị lỗi khi nhập chưa nhập số điện thoại").contains(ERROR_NULL_PHONE);

    }

    public void verifyInputBirthday() throws InterruptedException {
        enterDayOfBirth("11/12/555");
        clickOnContinueButton();
        assertThat(getTextLoi()).as("Check nhập sai định dạng ngày sinh").contains(ERROR_BIRTHDAY);
    }

    public void verifyInputID() throws InterruptedException {
        enterID("123456789");
        assertThat(getTextLoi()).as("Check nhập sai định dạng CMND").contains(ERROR_ID);
    }

    public void verifyInputStreet() throws InterruptedException {
        assertThat(getTextLoi()).as("Check thông báo lỗi khi không chọn đường/phố").contains(ERROR_STREET);
    }


}

