package test_cases;

import net.fpt.driver_setting.DriverBase;
import net.fpt.utils.TimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.LandingPage.ActionLandingPage;
import page_objects.LandingPageInternet.ActionLandingPageInternet;
import page_objects.Menu.ActionsMenu;
import page_objects.Register.ActionsRegister;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.fpt.utils.WebElementActionUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static constants.Common.*;

public class InternetTruyenHinh extends DriverBase {

    public ActionsMenu menuShop;
    public ActionLandingPage langdingPage;
    public ActionLandingPageInternet langdingPageInternet;
    public ActionsRegister register;
    private WebDriver driver;


    static final Logger logger = LoggerFactory.getLogger(InternetTruyenHinh.class);

//    @BeforeMethod
//    public void setup() throws MalformedURLException {
//        driver = getDriver();
//    }

   @Test(description = "Kiểm tra hiển thị màn hình FPT Internet trong Home Page \n",priority = 1,groups={"landing"})
    public void TC_2_2() throws InterruptedException {
       logger.info("TC_2_2");
       langdingPageInternet = new ActionLandingPageInternet();
       langdingPageInternet.goHere();
       menuShop = new ActionsMenu();
       menuShop.skipToPopupLocation();
       langdingPageInternet.verifylistTopPromotion();
       langdingPageInternet.verifyListTopPromotionInternetOnly();
       langdingPageInternet.verifyListTopPromotionComboInternetTH();
       langdingPageInternet.verifyListElementsTopNewsTH();
    }

    @Test(description = "Kiểm tra hiển thị màn hình FPT Internet trong Home Page \n",
            dependsOnMethods={"TC_2_2"},groups={"landing"})
    public void TC_2_4() throws InterruptedException {
        logger.info("TC_2_4");
        List listTopPromotionLocaltionA= getTextListItems(langdingPageInternet.listTopPromotionEl);
        menuShop.clickHienThiPOPUP();
        menuShop.waitLoadingLocationTT()
                .chooseProvinceLocation("Hà Nội")
                .waitLoadingLocationQH()
                .chooseProvinceLocationQH("Q.Hoàn Kiếm")
                .waitLoadingWardQH()
                .chooseWardsLocationQH("Phường Cửa Đông")
                .clickButtonApproveLocation();
        langdingPageInternet.waitistElementsTopPromotion();
        langdingPageInternet.verifyTopPromotionAfterChangeLocaltion(listTopPromotionLocaltionA);
    }

    @Test(description = "Kiểm tra hiển thị màn hình FPT Internet trong Home Page \n",
            dependsOnMethods={"TC_2_4"},groups={"landing"})
    public void TC_2_8() throws InterruptedException {
        logger.info("TC_2_8");
        //TC_2_8
        langdingPageInternet.verifyListServiceContent();
    }

    @Test(description = "Kiểm tra hiển thị màn hình FPT Internet trong Home Page \n",
            dependsOnMethods={"TC_2_8"},groups={"landing"})
    public void TC_2_11() throws InterruptedException {
        logger.info("TC_2_11");
        //TC_2_11
        langdingPageInternet.verifyLinkTopNews();
    }

    @Test(description = "Kiểm tra hiển thị màn hình FPT Internet trong Home Page \n",
            dependsOnMethods={"TC_2_8"},groups={"landing"})
    public void TC_2_12() throws InterruptedException {
        logger.info("TC_2_12");
        //TC_2_12
        langdingPageInternet.verifyContentTopNews();
    }

    @Test(description = "Kiểm tra trang đăng ký \n",groups={"register"})
    public void TC_2_13_17() throws InterruptedException {
        logger.info("TC_2_13_17");
        langdingPageInternet = new ActionLandingPageInternet();
        langdingPageInternet.goHere();
        menuShop = new ActionsMenu();
        menuShop.skipToPopupLocation();

        //TC_2_13_17
        langdingPageInternet.click1GoiCuocComboBatKy();
        register = new ActionsRegister();
        register.verifyOpenRegsiter();
    }

    @Test(description = "Kiểm tra trang đăng ký \n",
            dependsOnMethods={"TC_2_13_17"},groups={"register"})
    public void TC_2_14() throws InterruptedException {
        logger.info("TC_2_14");
        //TC_2_14
        register.verifyHeader();
    }

    @Test(description = "Kiểm tra trang đăng ký \n",
            dependsOnMethods={"TC_2_14"},groups={"register"})
    public void TC_2_19() throws InterruptedException {
        logger.info("TC_2_19");
        //TC_2_19
        register.verifyRegisterFilter();
    }

    @Test(description = "Kiểm tra trang đăng ký \n",
            dependsOnMethods={"TC_2_19"},groups={"register"})
    public void TC_2_20() throws InterruptedException {
        logger.info("TC_2_20");
        //TC_2_20_1
        register.clickOnContinueButton()
                .verifyErrorInputName();
    }

    @Test(description = "Kiểm tra trang đăng ký \n",
            dependsOnMethods={"TC_2_20"},groups={"register"})
    public void TC_2_21() throws InterruptedException {
        logger.info("TC_2_21");
        //TC_2_21; TC_2_22
        register.verifyInputPhoneNumber();
    }

    @Test(description = "Kiểm tra trang đăng ký \n",
            dependsOnMethods={"TC_2_21"},groups={"register"})
    public void TC_2_24() throws InterruptedException {
        logger.info("TC_2_24");
        //TC_2_24;
        register.refreshRegister()
                .verifyInputBirthday();
    }

    @Test(description = "Kiểm tra trang đăng ký \n",
            dependsOnMethods={"TC_2_24"},groups={"register"})
    public void TC_2_25() throws InterruptedException {
        logger.info("TC_2_25");
        register.verifyInputID();
    }

    @Test(description = "Check nhập và hiển thị Giới Tính",groups={"register"})
    public void TC_2_26()  {
       logger.info("TC_2_26");
       Boolean result = register.checkChonGT("Nữ");
       assertThat(result).as("Check nhập và hiển thị Giới Tính").isEqualTo(true);
    }

   @Test(description = "Kiểm tra mục Địa chỉ lắp đặt ở màn hình Thông tin đăng ký",groups={"register","register-fill"})
    public void TC_2_27() throws InterruptedException, MalformedURLException {
        logger.info("TC_2_27; TC_2_28");
        langdingPageInternet = new ActionLandingPageInternet();
        langdingPageInternet.goHere();
        menuShop = new ActionsMenu();
        menuShop.openPopuplocationIfItNotPresent();

        register = new ActionsRegister();

        menuShop.waitLoadingLocationTT()
                .chooseProvinceLocation("Hà Nội")
                .waitLoadingLocationQH()
                .chooseProvinceLocationQH("Q.Ba Đình")
                .waitLoadingWardQH()
                .chooseWardsLocationQH("Phường Giảng Võ");
        String tinhThanh = langdingPageInternet.getTextElement(menuShop.dropdownTinhThanhEl);
        String quanHuyen = langdingPageInternet.getTextElement(menuShop.dropdownQuanHuyenEl);
        String phuongXa = langdingPageInternet.getTextElement(menuShop.dropdownPhuongXaEl);
        menuShop.clickButtonApproveLocation();
        //vao register
        langdingPageInternet.click1GoiCuocComboBatKy();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        Assert.assertTrue(checkElementDisplayed(wait , register.titleDiaChiLapDat));
        Assert.assertTrue(checkElementDisplayed(wait , register.closedDropdownTinhThanh));
        Assert.assertTrue(checkElementDisplayed(wait , register.closedDropdownQuanHuyen));
        Assert.assertTrue(checkElementDisplayed(wait , register.closedDropdownPhuongXa));

        //check có tự fill tỉnh thành quận đã chọn ở popup Location
        register.waitForDropdownLoad(register.closedDropdownTinhThanh,tinhThanh)
                .waitForDropdownLoad(register.closedDropdownQuanHuyen,quanHuyen);
        Assert.assertEquals(register.closedDropdownTinhThanh.findWebElement().getText(),tinhThanh);
        Assert.assertEquals(register.closedDropdownQuanHuyen.findWebElement().getText(),quanHuyen);
        //TC_2_28
        Assert.assertEquals(register.closedDropdownPhuongXa.findWebElement().getText(),phuongXa);
        Assert.assertTrue(checkElementDisplayed(wait ,register.closedDropdownPhuongXa));
        Assert.assertTrue(checkElementDisplayed(wait ,register.closedDropdownDuongPho));
        Assert.assertTrue(checkElementDisplayed(wait,register.radioButtonNhaRieng));
        Assert.assertTrue(checkElementDisplayed(wait,register.radioButtonChungCu));
        Assert.assertTrue(checkElementDisplayed(wait,register.txtHouseNumber));
        Assert.assertTrue(checkElementDisplayed(wait,register.btnTiepTuc));

    }
    @Test(description = "Kiểm tra khung search trong Dropdown Tỉnh/thành, quận/huyện, phường/xã, đường/phố", dependsOnMethods={"TC_2_27"},groups={"register","register-fill"})
    public void TC_2_29() throws InterruptedException {
        logger.info("TC_2_29");
        List<String> inputTinhThanh = Stream.of("hà nội", "HA NOI").collect(Collectors.toList());
        Assert.assertTrue(register.checkSearchBoxDropdown(register.closedDropdownTinhThanh
                ,register.searchBoxTinhThanh
                ,register.listItemTinhThanh
                ,inputTinhThanh));

        //tương tự list tỉnh thành
        List<String> inputQuanHuyen = Stream.of("Q.Cầu Giấy", "cau giay").collect(Collectors.toList());
        Assert.assertTrue(register.checkSearchBoxDropdown(register.closedDropdownQuanHuyen
                ,register.searchBoxQuanHuyen
                ,register.listItemQuanHuyen
                ,inputQuanHuyen));

        //tương tự list tỉnh thành
        List<String> inputPhuongXa = Stream.of("phường dịch vọng", "PHUONG dich voNG").collect(Collectors.toList());
        Assert.assertTrue(register.checkSearchBoxDropdown(register.closedDropdownPhuongXa
                ,register.searchBoxPhuongXa
                ,register.listItemPhuongXa
                ,inputPhuongXa));
        //tương tự list tỉnh thành
        List<String> inputDuongPho = Stream.of("dương quảng Hàm", "DuonG Quang Ham").collect(Collectors.toList());
        Assert.assertTrue(register.checkSearchBoxDropdown(register.closedDropdownDuongPho
                ,register.searchBoxDuongPho
                ,register.listItemDuongPho
                ,inputDuongPho));
    }

    @Test(description = "Kiểm tra hiển thị message báo lỗi khi không chọn giá trị ở các dropdown trong mục Địa chỉ lắp đặt", dependsOnMethods={"TC_2_27"},groups={"register","register-fill"})
    public void TC_2_31() throws InterruptedException {
        logger.info("TC_2_31");
        register.refreshRegister()
                .clickOnContinueButton()
                .verifyInputStreet();
    }


    /*API trả về không ổn định hiện thông báo khác nhau*/
    @Test(description = "Kiểm tra hiển thị popup khi trùng KHTN <24h", priority = 32)
    public void TC_2_32() throws InterruptedException {
        driver.get(getURLDK);
        register = new ActionsRegister();
        Thread.sleep(3000);
        register.chooseValueInDropdown(
                register.closedDropdownQuanHuyen,register.listItemQuanHuyen,"Quận Bắc Từ Liêm");
        Thread.sleep(3000);
        register.checkChonPhuongXa("Phường Cổ Nhuế 1");
        Thread.sleep(3000);
        register.checkChonDuongPho("An Sinh");
        register.enterFullName("Bui Thi Tuyet")
               .enterPhone("0703716567")
               .enterNgaySinh("10/10/2001")
               .enterID("012345678")
               .chooseSex("Nữ")
               .enterEmail("khoa@gmail.com")
               .chooseHouseNumber("12");
        register.clickOnContinueButton();
        register.waitLoadigStartStop();
        String result  = register.getTextTrungKHTN24h();
        assertThat(result).as("Kiểm tra hiển thị popup khi trùng KHTN <24h").isEqualTo(getTextThongBaoTrungKHTN);
    }
   @Test(description = "Kiểm tra hiển thị popup khi khách hàng ở chung cư", priority = 33)
    public void TC_2_33() throws InterruptedException {
        driver.get(getURLDK);
        register = new ActionsRegister();
        Boolean phuongXa  = register.checkChonPhuongXa("Phường Cổ Nhuế 1");
        Thread.sleep(2000);
        Boolean duongPho = register.checkChonDuongPho("An Sinh");
        register.clearTextPhone();
        register.enterPhone("070"+ TimeUtil.generateRandomString());
        register.clickRadioChungCu();
        register.clickOnContinueButton();
        Thread.sleep(3000);
        String result  = register.getTextKTHT();
        assertThat(result).as("Kiểm tra hiển thị popup khi khách hàng ở chung cư").isIn(getTextKTHT);
    }
    @Test(description = "Kiểm tra hiển thị popup khi không có hạ tầng", priority = 34)
    public void TC_2_34() throws InterruptedException {
        driver.get(getURLDK);
        register = new ActionsRegister();
        Thread.sleep(2000);
        Boolean phuongXa  = register.checkChonPhuongXa("Phường Cổ Nhuế 1");
        Thread.sleep(2000);
        Boolean duongPho = register.checkChonDuongPho("Nơi khác");
        register.clearTextPhone();
        register.enterPhone("070"+ TimeUtil.generateRandomString());
        register.enterTenDuongPho("No Name");
        register.clickOnContinueButton();
        String result  = register.getTextKTHT();
        assertThat(result).as("Kiểm tra hiển thị popup khi không có hạ tầng").isIn(getTextKTHT);
    }
  @Test(description = "Kiểm tra hiển thị popup thue bao nợ cước", priority = 35)
    public void TC_2_35() throws InterruptedException {
        driver.get(getURLDK);
        register = new ActionsRegister();
        Boolean phuongXa  = register.checkChonPhuongXa("Phường Cổ Nhuế 1");
        Thread.sleep(2000);
        Boolean duongPho = register.checkChonDuongPho("An Sinh");
        Thread.sleep(2000);
        register.clearTextPhone();
        register.enterPhone("070"+ TimeUtil.generateRandomString());
        register.clearTextID();
        register.enterID("025531417");
        register.clickRadioNhaRieng();
        register.clickOnContinueButton();
        String result  = register.getTextTBNC();
        assertThat(result).as("Kiểm tra hiển thị popup thuê bao nợ cước").isEqualTo(getTextTBNC);
    }

    @Test(description = "Kiểm tra chuyển hướng khi nhập đầy đủ thông tin ở tất cả các trường ở màn hình Thông tin đăng ký", priority = 38)
    public void TC_2_38() throws InterruptedException {

        driver.get(url);
        register = new ActionsRegister();
        langdingPage = new ActionLandingPage();
        langdingPageInternet = new ActionLandingPageInternet();
        menuShop = new ActionsMenu();
        WebDriverWait wait = new WebDriverWait(driver,15);
        //nếu popup Location hiển thị thì click Xác nhận
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        //Click 1 gói cước
        langdingPageInternet.click1GoiCuoc();
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
                .enterNgaySinh("01/01/1996")
                .enterID("742156649");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        String actualLink = driver.getCurrentUrl();
        Assert.assertEquals(actualLink,urlChonDichVu);
    }

    @Test(description = "Kiểm tra hiển thị màn hình Chọn dịch vụ ", priority = 39)
    public void TC_2_39() throws InterruptedException {
        driver.get(url);
        register = new ActionsRegister();
        langdingPage = new ActionLandingPage();
        langdingPageInternet = new ActionLandingPageInternet();
        menuShop = new ActionsMenu();
        WebDriverWait wait = new WebDriverWait(driver,15);
        //nếu popup Location hiển thị thì click Xác nhận
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        //Click 1 gói cước
        langdingPageInternet.click1GoiCuocComboBatKy();
        //langdingPageInternet.click1GoiCuoc();
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
                .enterNgaySinh("01/01/1996")
                .enterID("742156649");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        //Check hiển thị header
        Assert.assertTrue(checkElementDisplayed(wait,register.headerLogo));
        Assert.assertTrue(checkElementDisplayed(wait,register.headerLinkThongTinDangKy));
        Assert.assertTrue(checkElementDisplayed(wait,register.headerLinkChonDichVu));
        Assert.assertTrue(checkElementDisplayed(wait,register.headerLinkThongTinThanhToan));
        Assert.assertTrue(checkElementDisplayed(wait,register.headerLinkHoanTatDangKy));

        //Check hiển thị mục Thông tin dịch vụ
        Assert.assertTrue(checkElementDisplayed(wait,register.sectionThongTinDichVu));
        //Check hiển thị mục Chọn hình thức trả trước
        Assert.assertTrue(checkElementDisplayed(wait,register.txtChonHinhThucTraCuoc));
        //Check hiển thị mục Mua thêm nhận ưu đãi
        //wait.until(ExpectedConditions.visibilityOfElementLocated(register.txtMuaThemNhanUuDai.by()));
        //Assert.assertTrue(langdingPage.checkElementDisplayed(register.txtMuaThemNhanUuDai));
        //Check hiển thị mục Thời gian lắp đặt
        Assert.assertTrue(checkElementDisplayed(wait,register.txtThoiGianLapDat));

        Assert.assertTrue(checkElementDisplayed(wait,register.btnTiepTuc));
    }

  @Test(description = "Kiểm tra hiển thị mục Thông tin dịch vụ ở màn hình Chọn dịch vụ", priority = 40)
    public void TC_2_40() throws InterruptedException {
        driver.get(url);
        register = new ActionsRegister();
        langdingPage = new ActionLandingPage();
        langdingPageInternet = new ActionLandingPageInternet();
        //lấy tên gói cước ở Landing page Internet
        String expectedTenGoiCuoc = langdingPageInternet.blockGoiCuoc.findWebElement().getText();
        menuShop = new ActionsMenu();
        WebDriverWait wait = new WebDriverWait(driver,30);
        //nếu popup Location hiển thị thì click Xác nhận
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        //lấy tên gói cước ở Landing page Internet
        langdingPageInternet.click1GoiCuoc();
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
                .enterNgaySinh("01/01/1996")
                .enterID("742156649");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        //Check Tên gói: theo gói dịch vụ khách hàng đã chọn
        String actualTenGoiCuoc = register.txtTenGoiCuoc_ChonDichVu.findWebElement().getText();
        Assert.assertTrue(actualTenGoiCuoc.contains(expectedTenGoiCuoc));
    }
   @Test(description = "Kiểm tra hiển thị mục Thông tin dịch vụ ở màn hình Chọn dịch vụ", priority = 41)
    public void TC_2_41() throws InterruptedException {
        driver.get(url);
        register = new ActionsRegister();
        langdingPage = new ActionLandingPage();
        langdingPageInternet = new ActionLandingPageInternet();
        menuShop = new ActionsMenu();
        WebDriverWait wait = new WebDriverWait(driver,30);

        //nếu popup Location hiển thị thì click Xác nhận
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        //Click 1 gói cước
        langdingPageInternet.click1GoiCuoc();
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
                .enterNgaySinh("01/01/1996")
                .enterID("742156649");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        Assert.assertTrue(checkElementDisplayed(wait,register.txtTenGoiTraCuoc));
        Assert.assertTrue(checkElementDisplayed(wait,register.txtPhiLapDat));
    }
    @Test(description = "Kiểm tra hiển thị mục Mua thêm để nhận ưu đãi ở màn hình Chọn dịch vụ", priority = 43)
    public void TC_2_43() throws InterruptedException {
        driver.get(url);
        register = new ActionsRegister();
        langdingPage = new ActionLandingPage();
        langdingPageInternet = new ActionLandingPageInternet();
        menuShop = new ActionsMenu();
        WebDriverWait wait = new WebDriverWait(driver,30);

        //nếu popup Location hiển thị thì click Xác nhận
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        //Click 1 gói cước
        langdingPageInternet.click1GoiCuoc();
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
                .enterNgaySinh("01/01/1996")
                .enterID("742156649");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        wait.until(ExpectedConditions.presenceOfElementLocated(register.itemGoiDichVuMuaThem.by()));
        Assert.assertTrue(checkElementDisplayed(wait, register.itemGoiDichVuMuaThem));

    }
    @Test(description = "Kiểm tra hiển thị mục Mua thêm để nhận ưu đãi khi tất cả dịch vụ mua thêm đều không có CLKM", priority = 44)
    public void TC_2_44() throws InterruptedException {
        driver.get(url);
        langdingPage = new ActionLandingPage();
        langdingPageInternet = new ActionLandingPageInternet();
        menuShop = new ActionsMenu();
        WebDriverWait wait = new WebDriverWait(driver,30);

        //nếu popup Location hiển thị thì click Xác nhận
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        //Click 1 gói combo, comboName là gói combo không có bán thêm Box
        register = langdingPageInternet.clickCombo("Super250");
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
                .enterNgaySinh("01/01/1996")
                .enterID("742156649");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        //Check Ẩn tiêu đề "Mua thêm để nhận ưu đãi"
        Assert.assertFalse(checkElementDisplayed(wait, register.txtMuaThemNhanUuDai));
    }
    @Test(description = "Kiểm tra hiển thị mục Mua thêm để nhận ưu đãi ở màn hình Chọn dịch vụ", priority = 45)
    public void TC_2_45() throws InterruptedException {
        driver.get(url);
        langdingPage = new ActionLandingPage();
        langdingPageInternet = new ActionLandingPageInternet();
        menuShop = new ActionsMenu();
        WebDriverWait wait = new WebDriverWait(driver,30);

        //nếu popup Location hiển thị thì click Xác nhận
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        //Click 1 gói combo, comboName là gói combo có bán thêm Box
        register = langdingPageInternet.clickCombo("Super80");
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
                .enterNgaySinh("01/01/1996")
                .enterID("742156649");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        wait.until(ExpectedConditions.presenceOfElementLocated(register.itemGoiDichVuMuaThem.by()));
        Assert.assertTrue(checkElementDisplayed(wait, register.iconI));
        Assert.assertTrue(checkElementDisplayed(wait, register.txtTenBox_MuaThemNhanUuDai));
        Assert.assertTrue(checkElementDisplayed(wait, register.txtGiaBox_MuaThemNhanUuDai));
        Assert.assertTrue(checkElementDisplayed(wait, register.buttonIncrease));
        Assert.assertTrue(checkElementDisplayed(wait, register.buttonDecrease));
        Assert.assertTrue(checkElementDisplayed(wait, register.textQuantityBox));
    }

    @Test(description = "Kiểm tra số lượng tối đa được mua ở box bán thêm", priority = 46)
    public void TC_2_46() throws InterruptedException {
        driver.get(url);
        langdingPageInternet = new ActionLandingPageInternet();
        //register = langdingPageInternet.click1GoiCuocComboBatKy();
        register = langdingPageInternet.clickCombo("Super80");
        register.enterFullName("Lê Văn A")
                //random dùng api đển check số dt trước khi dùng
                .enterPhone("070"+ TimeUtil.generateRandomString())
                .enterNgaySinh("04/12/1987")
                .enterID("320214575")
                .chooseValueInDropdown(register.closedDropdownTinhThanh,register.listItemTinhThanh,"hồ chí minh")
                .chooseValueInDropdown(register.closedDropdownQuanHuyen,register.listItemQuanHuyen,"Quận 1")
                .choosePhuongXaLapDat("Phường Bến Nghé")
                .chooseDuongPhoLapDat("Bùi Thị Xuân")
                .enterHouseNumber("123")
                .clickOnContinueButton();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        register.clickIncrease();
        assertThat(register.getQuantityBox()).as("Kiểm tra số lượng tăng 1").isEqualTo(1);
        register.clickIncrease();
        assertThat(register.getQuantityBox()).as("Kiểm tra số lượng tăng 2").isEqualTo(2);
        register.clickIncrease();
        assertThat(register.getQuantityBox()).as("Kiểm tra số tối đa là 2").isEqualTo(2);
        register.clickDecrease();
        assertThat(register.getQuantityBox()).as("Kiểm tra số lượng xuống 1").isEqualTo(1);
    }

    @Test(description = "Kiểm tra hiển thị popup giới thiệu dịch vụ F-safe", priority = 47)
    public void TC_2_47()  {
        register.clickInfoFsafe();
        assertThat(register.popUpInfoFsafe.findWebElement().isDisplayed()).as("Kiểm tra hiện thông tin về Fsafe").isTrue();
        register.clickCloseInfoFsafe();
    }

    @Test(description = "Kiểm tra hiển thị mục Thời gian lắp đặt ở màn hình Chọn dịch vụ", priority = 48)
    public void TC_2_48()  {
        assertThat(register.textTitleSetupTime.findWebElement().isDisplayed()).as("Tiêu đề : Thời gian lắp đặt").isTrue();
        assertThat(register.getDateSetupTime()).as("Date picker [Ngày ]:  dd/mm/yyyy").isEqualTo(TimeUtil.getDateStringPlusDays("dd/MM/yyyy",1));
        List textTitleSetupTime = getTextListItems(register.listTimeSetup);
        assertThat(textTitleSetupTime).as("Dropdown [Giờ]: Hiển thị khung giờ lắp đặt khả dụng").isEmpty();
    }

    @Test(description = "Kiểm tra Date picker [Ngày]", priority = 49)
    public void TC_2_49()  throws InterruptedException{
        register.enterTimeSetupTime(TimeUtil.getDateStringMinusDays("dd/MM/yyyy",1));
        Thread.sleep(5000);
        assertThat(register.TextErrorDateSetup.findWebElement().isDisplayed()).as("Hiển thị bảng thời gian. Disable các ngày < hiện tại").isTrue();
        register.enterTimeSetupTime(TimeUtil.getDateStringPlusDays("dd/MM/yyyy",1));
    }

    @Test(description = "Kiểm tra Date picker [Ngày]", priority = 50)
    public void TC_2_50()  {
        List textTitleSetupTime = getTextListItems(register.listTimeSetup);
        textTitleSetupTime.forEach(System.out::println);
        assertThat(textTitleSetupTime).as("Hiển thị thêm khung giờ T+ 1 nếu API trả về có năng lực triển khai").isEqualTo(register.getTimeZoneAbilityForAPI());
    }

   @Test(description = "Kiểm tra URL trang thông tin thanh toán", priority = 52)
    public void TC_2_52() throws InterruptedException {
        driver.get(url);
        register = new ActionsRegister();
        langdingPage = new ActionLandingPage();
        langdingPageInternet.clickCombo("Super80"); //langdingPageInternet.click1GoiCuoc();
        WebDriverWait wait = new WebDriverWait(driver,30);
        register.checkChonGT("Nữ");
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
                .enterNgaySinh("01/01/1996")
                .enterID("742156649");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        Thread.sleep(5000);
        register.enterTimeSetupTime(TimeUtil.getDateStringPlusDays("dd/MM/yyyy",1));
        //register.waitLoadigStartStop();
        //register.displayGioLapDat("08:00 - 10:00");
        Thread.sleep(3000);
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlThanhToan));
        assertThat(driver.getCurrentUrl()).isEqualTo(urlThanhToan);
    }
   @Test(description = "Kiểm tra bố cục màn hình Thông tin thanh toán", priority = 53)
    public void TC_2_53_74_75_77_78() throws InterruptedException {
        driver.get(urlThanhToan);
        register = new ActionsRegister();
        Thread.sleep(4000);
        List result = register.getTextHoanTatDK();
        Boolean result2 = register.checkDisplayThongTinThanhToan();
        List result3 = register.getTextListChiTietDonHang();
        assertThat(result).isEqualTo(LIST_TEXTTTT);
        assertThat(result2).isEqualTo(true);
        assertThat(result3).isEqualTo(LISTCTDH);

    }
    @Test(description = "Kiểm tra button Thay đổi địa chỉ lặp đặt ở màn hình Thông tin thanh toán", priority = 54)
    public void TC_2_54() throws InterruptedException {
        register = new ActionsRegister();
        Thread.sleep(5000);
       String url = register.checkClickLinkThayDoiDiaChiLapDat();
       assertThat(url).isEqualTo(getURLDK);
    }
    @Test(description = "Kiểm tra button Thay đổi thời gian lắp đặt ở màn hình Thông tin thanh toán", priority = 55)
    public void TC_2_55() throws InterruptedException {
        driver.get(urlThanhToan);
        register = new ActionsRegister();
        Thread.sleep(5000);
        String url = register.checkClickLinkThayDoiThongTinTT();
        assertThat(url).isEqualTo(urlChonDichVu);
    }
    @Test(description = "Kiểm tra popup Hình thức thanh toán", priority = 56)
    public void TC_2_56() throws InterruptedException {
        driver.get(urlThanhToan);
        register = new ActionsRegister();
        Thread.sleep(3000);
        register.clickPOPUPHTTT();
        Thread.sleep(3000);
       List result = register.getListPOPUPHTTT();
       Boolean result2 = register.checkRadioButton();
        assertThat(result).isEqualTo(LISTTEXTPOPUP);
        assertThat(result2).isEqualTo(true);
    }
    @Test(description = "Kiểm tra hoạt động nút Xác nhận", priority = 57)
    public void TC_2_57() throws InterruptedException {
        register = new ActionsRegister();
        Thread.sleep(3000);
       String hinhThucTT = register.clickBtnXNPOPUPHTTT();
       assertThat(hinhThucTT).isEqualTo("Ví điện tử Foxpay");
    }
    @Test(description = "Kiểm tra button [X]", priority = 58)
    public void TC_2_58() throws InterruptedException {
        register = new ActionsRegister();
        Thread.sleep(3000);
        register.clickPOPUPHTTT();
        Thread.sleep(3000);
        String hinhThucTT = register.clickIconXPOPUPHTTT();
        assertThat(hinhThucTT).isEqualTo("Ví điện tử Foxpay");
    }

    @Test(description = "Kiểm tra xử lý khi click Thanh toán với phương thức =  Ví điện tử Momo", priority = 59)
    public void TC_2_59() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,15);
        register = new ActionsRegister();
        Thread.sleep(3000);
        register.clickPOPUPHTTT();
        Thread.sleep(3000);
        register.clickChooseHTTTMOMO();
        Thread.sleep(3000);
         register.clickbtnTT();
        wait.until(ExpectedConditions.urlToBe(URLQR));
        String result1 = driver.getCurrentUrl();
        assertThat(result1).isEqualTo(URLQR);
    }
    @Test(description = "Kiểm tra xử lý khi click Thanh toán với phương thức =  Ví điện tử VNPay", priority = 60)
    public void TC_2_60() throws InterruptedException {
        driver.get(urlThanhToan);
        WebDriverWait wait = new WebDriverWait(driver,15);
        register = new ActionsRegister();
        Thread.sleep(3000);
        register.clickPOPUPHTTT();
        Thread.sleep(3000);
        register.clickChooseHTTTVNPAY();
        Thread.sleep(3000);
        register.clickbtnTT();
        wait.until(ExpectedConditions.urlToBe(URLQR));
        String result1 = driver.getCurrentUrl();
        assertThat(result1).isEqualTo(URLQR);
   }
    @Test(description = "Kiểm tra xử lý khi click Thanh toán với phương thức =  Thanh toán tại nhà", priority = 65)
    public void TC_2_63_85_86_90() throws InterruptedException {
        driver.get(urlThanhToan);
        WebDriverWait wait = new WebDriverWait(driver,15);
        register = new ActionsRegister();
        Thread.sleep(3000);
        register.clickPOPUPHTTT();
        Thread.sleep(3000);
        register.clickChooseHTTTN();
        Thread.sleep(3000);
        register.clickbtnTT();
        wait.until(ExpectedConditions.urlToBe(URLTTTN));
        String result1 = driver.getCurrentUrl();
        Boolean result2 = register.getLinkHTTDK();
        String getTextQT = register.getTextSPQT();
        Boolean hienThiDS = register.checkDisplayDSQT();
        String getUrlQT = register.getURLQT();
        Thread.sleep(3000);
        String geturl = register.getLinkTrangChu();
        Thread.sleep(3000);
        assertThat(result2).isEqualTo(true);
        assertThat(result1).isEqualTo(URLTTTN);
        assertThat(geturl).isEqualTo(urlHome);
        assertThat(getTextQT).isEqualTo(TEXTQT);
        assertThat(hienThiDS).isEqualTo(true);
        assertThat(getUrlQT).isEqualTo(URLQT);

    }
    @Test(description = "Kiểm tra xử lý khi click Thanh toán với phương thức =  thẻ quốc tế", priority = 63)
    public void TC_2_64() throws InterruptedException {
        driver.get(urlThanhToan);
        WebDriverWait wait = new WebDriverWait(driver,15);
        register = new ActionsRegister();
        Thread.sleep(3000);
        register.clickPOPUPHTTT();
        Thread.sleep(3000);
        register.clickChooseHTTTTQT();
        Thread.sleep(3000);
        register.clickbtnTT();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.urlToBe(URLTTQTATM));
        String result1 = driver.getCurrentUrl();
        assertThat(result1).isEqualTo(URLTTQTATM);
    }
    @Test(description = "Kiểm tra xử lý khi click Thanh toán với phương thức =  ATM", priority = 64)
    public void TC_2_65() throws InterruptedException {
        driver.get(urlThanhToan);
        WebDriverWait wait = new WebDriverWait(driver,15);
        register = new ActionsRegister();
        Thread.sleep(3000);
        register.clickPOPUPHTTT();
        Thread.sleep(3000);
        register.clickChooseHTTTTATM();
        Thread.sleep(3000);
        register.clickbtnTT();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.urlToBe(URLTTQTATM));
        String result1 = driver.getCurrentUrl();
        assertThat(result1).isEqualTo(URLTTQTATM);
    }
    @Test(description = "Kiểm tra URL trang thông tin thanh toán", priority = 66)
    public void TC_2_66() throws InterruptedException {
        driver.get(url);
        register = new ActionsRegister();
        langdingPage = new ActionLandingPage();
        langdingPageInternet = new ActionLandingPageInternet();
        menuShop = new ActionsMenu();
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        langdingPageInternet.click1GoiCuoc();
        WebDriverWait wait = new WebDriverWait(driver,60);
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
//                .enterDayOfBirth("01/01/1996")  //hàm có vấn đề, tạm thời không dùng
                .enterID("742156649");
        driver.findElement(By.xpath("//input[@id='birthday']")).sendKeys("01/01/1996");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        Thread.sleep(3000);
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlThanhToan));
        Thread.sleep(3000);
        String valueTongTienTruocVoucher = register.getTextElement(register.txtValueTongTien).trim();
        register.txtBoxVoucher.findWebElement().sendKeys(maGTBBVoucher);
        register.clickElement(register.btnApDung);
        Assert.assertTrue(checkElementDisplayed(wait, register.popupThongBaoApDungVoucherThanhCong));
        Assert.assertTrue(checkElementDisplayed(wait, register.btnXPopup));
        Assert.assertTrue(checkElementDisplayed(wait, register.btnDongY));
        register.clickElement(register.btnDongY);
        String valueTongTienSauVoucher = register.getTextElement(register.txtValueTongTien).trim();
        Assert.assertNotEquals(valueTongTienTruocVoucher,valueTongTienSauVoucher);

        //Assert.assertTrue(langdingPage.checkElementDisplayed(register.txtLinkMaGTBBVoucher));
        //Xác nhận rằng có hiển thị voucher sau khi nhập
        List listVoucher =  langdingPage.getListItems(register.listVoucherSauKhiNhap);
        Assert.assertTrue(register.checkEnteredVoucherDisplayed(listVoucher,maGTBBVoucher));
    }
    @Test(description = "Kiểm tra button [X] trong popup ", priority = 67)
    public void TC_2_67() throws InterruptedException {
        driver.get(url);
        register = new ActionsRegister();
        langdingPage = new ActionLandingPage();
        langdingPageInternet = new ActionLandingPageInternet();
        menuShop = new ActionsMenu();
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        langdingPageInternet.click1GoiCuoc();
        WebDriverWait wait = new WebDriverWait(driver,60);
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
//                .enterDayOfBirth("01/01/1996")  //hàm có vấn đề, tạm thời không dùng
                .enterID("742156649");
        driver.findElement(By.xpath("//input[@id='birthday']")).sendKeys("01/01/1996");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        Thread.sleep(3000);
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlThanhToan));
        Thread.sleep(3000);
        register.txtBoxVoucher.findWebElement().sendKeys(maGTBBVoucher);
        register.clickElement(register.btnApDung);
        Assert.assertTrue(checkElementDisplayed(wait,register.popupThongBaoApDungVoucherThanhCong));
        register.clickElement(register.btnXPopup);
        Assert.assertFalse(checkElementDisplayed(wait,register.popupThongBaoApDungVoucherThanhCong));

    }
    @Test(description = "Kiểm tra button [Đồng ý] trong popup ", priority = 68)
    public void TC_2_68() throws InterruptedException {
        driver.get(url);
        register = new ActionsRegister();
        langdingPage = new ActionLandingPage();
        langdingPageInternet = new ActionLandingPageInternet();
        menuShop = new ActionsMenu();
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        langdingPageInternet.click1GoiCuoc();
        WebDriverWait wait = new WebDriverWait(driver,60);
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
//                .enterDayOfBirth("01/01/1996")  //hàm có vấn đề, tạm thời không dùng
                .enterID("742156649");
        driver.findElement(By.xpath("//input[@id='birthday']")).sendKeys("01/01/1996");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        Thread.sleep(3000);
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlThanhToan));
        Thread.sleep(3000);
        //
        register.txtBoxVoucher.findWebElement().sendKeys(maGTBBVoucher);
        register.clickElement(register.btnApDung);
        Assert.assertTrue(checkElementDisplayed(wait,register.popupThongBaoApDungVoucherThanhCong));
        register.clickElement(register.btnDongY);
        Assert.assertFalse(checkElementDisplayed(wait,register.popupThongBaoApDungVoucherThanhCong));
    }

    @Test(description = "Kiểm tra popup thông tin của Voucher/mã giới thiệu khi click vào voucher đã nhập", priority = 69)
    public void TC_2_69() throws InterruptedException {
        driver.get(url);
        register = new ActionsRegister();
        langdingPage = new ActionLandingPage();
        langdingPageInternet = new ActionLandingPageInternet();
        menuShop = new ActionsMenu();
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        langdingPageInternet.click1GoiCuoc();
        WebDriverWait wait = new WebDriverWait(driver,60);
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
//                .enterDayOfBirth("01/01/1996")  //hàm có vấn đề, tạm thời không dùng
                .enterID("742156649");
        driver.findElement(By.xpath("//input[@id='birthday']")).sendKeys("01/01/1996");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        Thread.sleep(3000);
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlThanhToan));
        Thread.sleep(3000);
        register.txtBoxVoucher.findWebElement().sendKeys(maGTBBVoucher);
        register.clickElement(register.btnApDung);
        register.clickElement(register.btnDongY);
        register.clickElement(register.txtLinkMaGTBBVoucher);
        Assert.assertTrue(checkElementDisplayed(wait,register.popupThongBaoApDungVoucherThanhCong));
    }
    @Test(description = "Kiểm tra xử lý button [X] bên phải Voucher/mã giới thiệu", priority = 70)
    public void TC_2_70() throws InterruptedException {
        driver.get(url);
        register = new ActionsRegister();
        langdingPage = new ActionLandingPage();
        langdingPageInternet = new ActionLandingPageInternet();
        menuShop = new ActionsMenu();
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        langdingPageInternet.click1GoiCuoc();
        WebDriverWait wait = new WebDriverWait(driver,60);
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
                .enterID("742156649");
        driver.findElement(By.xpath("//input[@id='birthday']")).sendKeys("01/01/1996");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        Thread.sleep(3000);
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlThanhToan));
        Thread.sleep(3000);
        register.txtBoxVoucher.findWebElement().sendKeys(maGTBBVoucher);
        register.clickElement(register.btnApDung);
        register.clickElement(register.btnDongY);
        register.clickElement(register.btnXVoucher);
        Assert.assertTrue(checkElementDisplayed(wait,register.popupXacNhanHuyVoucher));
        String actualTextNoiDungXacNhanHuyVoucher =
                register.txtNoiDungXacNhanHuyVoucher_popupXacNhanHuyVoucher.findWebElement().getText().trim();
        Assert.assertTrue(actualTextNoiDungXacNhanHuyVoucher.equals(expectedTextNoiDungXacNhanHuyVoucher));
        Assert.assertTrue(checkElementDisplayed(wait,register.btnKhongHuy_popupXacNhanHuyVoucher));
        Assert.assertTrue(checkElementDisplayed(wait,register.btnHuy_popupXacNhanHuyVoucher));
        Assert.assertTrue(checkElementDisplayed(wait,register.btnX_popupXacNhanHuyVoucher));
    }
    @Test(description = "Kiểm tra button [Không hủy]", priority = 71)
    public void TC_2_71() throws InterruptedException {
        driver.get(url);
        register = new ActionsRegister();
        langdingPage = new ActionLandingPage();
        langdingPageInternet = new ActionLandingPageInternet();
        menuShop = new ActionsMenu();
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        langdingPageInternet.click1GoiCuoc();
        WebDriverWait wait = new WebDriverWait(driver,60);
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
//                .enterDayOfBirth("01/01/1996")  //hàm có vấn đề, tạm thời không dùng
                .enterID("742156649");
        driver.findElement(By.xpath("//input[@id='birthday']")).sendKeys("01/01/1996");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        Thread.sleep(3000);
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlThanhToan));
        Thread.sleep(3000);
        register.txtBoxVoucher.findWebElement().sendKeys(maGTBBVoucher);
        register.clickElement(register.btnApDung);
        register.clickElement(register.btnDongY);

        List listVoucher =  langdingPage.getListItems(register.listVoucherSauKhiNhap);


        register.clickElement(register.btnXVoucher);
        Assert.assertTrue(checkElementDisplayed(wait,register.popupXacNhanHuyVoucher));
        register.clickElement(register.btnKhongHuy_popupXacNhanHuyVoucher);
        Assert.assertFalse(checkElementDisplayed(wait,register.popupXacNhanHuyVoucher));
        Assert.assertTrue(register.checkEnteredVoucherDisplayed(listVoucher,maGTBBVoucher));
    }
    @Test(description = "Kiểm tra button [Hủy]", priority = 72)
    public void TC_2_72() throws InterruptedException {
        driver.get(url);
        register = new ActionsRegister();
        langdingPage = new ActionLandingPage();
        langdingPageInternet = new ActionLandingPageInternet();
        menuShop = new ActionsMenu();
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        langdingPageInternet.click1GoiCuoc();
        WebDriverWait wait = new WebDriverWait(driver,60);
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
//                .enterDayOfBirth("01/01/1996")  //hàm có vấn đề, tạm thời không dùng
                .enterID("742156649");
        driver.findElement(By.xpath("//input[@id='birthday']")).sendKeys("01/01/1996");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        Thread.sleep(3000);
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlThanhToan));
        Thread.sleep(3000);
        register.txtBoxVoucher.findWebElement().sendKeys(maGTBBVoucher);
        register.clickElement(register.btnApDung);
        register.clickElement(register.btnDongY);

        register.clickElement(register.btnXVoucher);
        Assert.assertTrue(checkElementDisplayed(wait,register.popupXacNhanHuyVoucher));
        register.clickElement(register.btnHuy_popupXacNhanHuyVoucher);
        Assert.assertFalse(checkElementDisplayed(wait,register.popupXacNhanHuyVoucher));
        List listVoucher =  langdingPage.getListItems(register.listVoucherSauKhiNhap);
        Assert.assertFalse(register.checkEnteredVoucherDisplayed(listVoucher,maGTBBVoucher));
    }
    @Test(description = "Kiểm thông báo khi áp dụng voucher không thành công", priority = 73)
    public void TC_2_73() throws InterruptedException {
        driver.get(url);
        register = new ActionsRegister();
        langdingPage = new ActionLandingPage();
        langdingPageInternet = new ActionLandingPageInternet();
        menuShop = new ActionsMenu();
        langdingPage.clickElementWhenItIsDisplay(menuShop.textBtnXacNhanEl);
        langdingPageInternet.click1GoiCuoc();
        WebDriverWait wait = new WebDriverWait(driver,60);
        register.enterFullName("Nguyễn Văn An")
                .enterPhone("032" + TimeUtil.generateRandomString())
//                .enterDayOfBirth("01/01/1996")  //hàm có vấn đề, tạm thời không dùng
                .enterID("742156649");
        driver.findElement(By.xpath("//input[@id='birthday']")).sendKeys("01/01/1996");
        register.chooseValueInDropdown(register.closedDropdownTinhThanh
                ,register.listItemTinhThanh
                ,"Hồ Chí Minh");
        register.chooseValueInDropdown(register.closedDropdownQuanHuyen
                ,register.listItemQuanHuyen
                ,"Quận 1");
        register.chooseValueInDropdown(register.closedDropdownPhuongXa
                ,register.listItemPhuongXa
                ,"Phường Bến Nghé");
        register.chooseValueInDropdown(register.closedDropdownDuongPho
                ,register.listItemDuongPho
                ,"Tôn Thất Đạm");
        register.chooseHouseNumber("10");
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlChonDichVu));
        Thread.sleep(3000);
        register.clickOnContinueButton();
        wait.until(ExpectedConditions.urlToBe(urlThanhToan));
        Thread.sleep(3000);
        String maVoucherKhongHopLe = "MÃ VOUCHER KHÔNG HỢP LỆ ABC!!!";
        register.txtBoxVoucher.findWebElement().sendKeys(maVoucherKhongHopLe);
        register.clickElement(register.btnApDung);
        Assert.assertTrue(checkElementDisplayed(wait,register.txtThongBaoLoiVoucher_popupXacNhanHuyVoucher));
        String expectedMessage= txtThongBaoLoiVoucher_part1 + maVoucherKhongHopLe + txtThongBaoLoiVoucher_part2;
        String actualMessage= register.txtThongBaoLoiVoucher_popupXacNhanHuyVoucher.findWebElement().getText();
        Assert.assertTrue(actualMessage.equals(expectedMessage));
    }
}
