package test_cases;

import net.fpt.driver_setting.DriverBase;
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
import page_objects.Menu.ActionsMenu;
import page_objects.Register.ActionsRegister;

import java.net.MalformedURLException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static constants.Common.*;


public class Home extends DriverBase {
    public ActionsMenu menuShop;
    public ActionLandingPage langdingPage;
    public ActionsRegister register;
    private WebDriver driver;

    static final Logger logger = LoggerFactory.getLogger(Home.class);
    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = getDriver();
    }



  @Test(description = "Kiểm tra pop up địa chỉ lắp đặt: TC_1_10")
   public void TC_1_10() throws InterruptedException {
        logger.info("TC_1_10");
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
        menuShop = new ActionsMenu();
        menuShop.openPopuplocationIfItNotPresent();
        menuShop.verifyTextOnLocationPopup();

    }

    @Test(description = "Kiểm tra pop up địa chỉ lắp đặt: TC_1_11",
            dependsOnMethods={"TC_1_10"})
    public void TC_1_11() throws InterruptedException {
        logger.info("TC_1_11");
        menuShop.openPopuplocationIfItNotPresent();
        menuShop.verifyCloseLocationPopup();
    }

    @Test(description = "Kiểm tra pop up địa chỉ lắp đặt: TC_1_12; TC_1_14; TC_1_18",
            dependsOnMethods={"TC_1_10"})
    public void TC_1_12() throws InterruptedException {
        logger.info("TC_1_12");
        menuShop.openPopuplocationIfItNotPresent();
        menuShop.waitLoadingLocation().
                chooseProvinceLocation("Hà Nội").
                chooseProvinceLocationQH("Quận Ba Đình").
                clickButtonApproveLocation().
                verifySelectLocationPopup();
    }

    @Test(description = "Kiểm tra pop up địa chỉ lắp đặt:  TC_1_16;",dependsOnMethods={"TC_1_10"})
    public void TC_1_16() throws InterruptedException {
        logger.info("TC_1_16");
        menuShop.openPopuplocationIfItNotPresent();
        menuShop.waitLoadingLocationTT().
                chooseProvinceLocation("Hà Nội").
                clickButtonApproveLocation().
                verifyErrorMessageLocationPopup();
    }


    @Test(description = "Check trường hợp KH vào bằng link có mã GTBB")
    public void TC_1_21() throws InterruptedException {
        logger.info("TC_1_21");
        langdingPage = new ActionLandingPage();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        langdingPage.goHereWithReferralCode(maGTBBVoucher);
        wait.until(ExpectedConditions.visibilityOfElementLocated(langdingPage.txtNoiDungThongBao.by()));
        Assert.assertEquals(langdingPage.txtNoiDungThongBao.findWebElement().getText(),expectedTextTC1_21);
    }

    @Test(description = "Check header menu" +
            "TC_1_22; TC_1_26; TC_1_27; TC_1_29; TC_1_30; TC_1_31; TC_1_32; TC_1_34; TC_1_35; TC_1_36; TC_1_37; TC_1_38")
    public void Feature_3() throws InterruptedException {
        logger.info("Feature_3");
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
        menuShop = new ActionsMenu();
        menuShop.skipToPopupLocation();
        menuShop.verifyHeader();
    }

    @Test(description = "Check tim kiem don hang thanh cong: ", priority = 36)
    public void Feature_4() {
        logger.info("Feature_4");
        driver.get(url);
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
        menuShop = new ActionsMenu();
        menuShop.skipToPopupLocation();
        assertThat(menuShop.checkTimKiemDonHangThanhCong("SGOD936F437626")).as("Hiển thị google Capcha").isEqualTo(urlDetailDonHang);

    }
/*
    @Test(description = "Check information on footer: khách hàng của FPT Telecom; Check phần Về FPT Telecom; Chưa là khách hàng" +
            "TC_1_98; TC_1_104;TC_1.110; TC_1_113; TC_1_114; TC_1_115; TC_1_116; TC_1_117; TC_1_118; TC_1_119;" +
            " TC_1_120; TC_1_121; TC_1_124; TC_1_125; TC_1_126; TC_1_137; TC_1_139")
    public void Feature_5() throws InterruptedException{
        logger.info("Feature_5");
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
        menuShop = new ActionsMenu();
        menuShop.skipToPopupLocation();
        langdingPage.verifyFooterInformation();
    }

    @Test(description = "Check click Giới thiệu chung ở phần Về FPT Telecom: " +
            "TC_1.99")
    public void Feature_6() {
        logger.info("Feature_6");
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
        menuShop = new ActionsMenu();
        menuShop.skipToPopupLocation();
        langdingPage.clickElement(langdingPage.txtLinkGioiThieuChung);
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.urlContains(expectedLinkTC1_99));
        Assert.assertEquals(driver.getCurrentUrl(), expectedLinkTC1_99);
    }

    @Test(description = "Check click Liên kết - Thành viên ở phần Về FPT Telecom: TC_1_100 ", priority = 100)
    public void Feature_7() throws MalformedURLException {
        logger.info("Feature_7");
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
        menuShop = new ActionsMenu();
        menuShop.skipToPopupLocation();
        langdingPage.clickElement(langdingPage.txtLinkLienKetThanhVien);
        driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.urlContains(expectedLinkTC1_100));
        String actualLink = driver.getCurrentUrl();
        Assert.assertEquals(actualLink, expectedLinkTC1_100);
    }

    @Test(description = "Check click Khách hàng - Đối tác ở phần Về FPT Telecom: TC_1_101", priority = 101)
    public void Feature_8() throws MalformedURLException {
        logger.info("Feature_8");
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
        menuShop = new ActionsMenu();
        menuShop.skipToPopupLocation();
        langdingPage.clickElement(langdingPage.txtLinkKhachHangDoiTac);
        driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.urlContains(expectedLinkTC1_101));
        String actualLink = driver.getCurrentUrl();
        Assert.assertEquals(actualLink, expectedLinkTC1_101);
    }

    @Test(description = "Check click Quan hệ cổ đông ở phần Về FPT Telecom: TC_1_102")
    public void Feature_9() throws MalformedURLException {
        logger.info("Feature_9");
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
        menuShop = new ActionsMenu();
        menuShop.skipToPopupLocation();
        langdingPage.clickElement(langdingPage.txtLinkQuanHeCoDong);
        driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.urlContains(expectedLinkTC1_102));
        String actualLink = driver.getCurrentUrl();
        Assert.assertEquals(actualLink, expectedLinkTC1_102);
    }

    @Test(description = "Check click Tập đoàn FPT ở phần Về FPT Telecom: TC_1_103")
    public void Feature_10() throws MalformedURLException {
        logger.info("Feature_10");
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
        menuShop = new ActionsMenu();
        menuShop.skipToPopupLocation();
        langdingPage.clickElement(langdingPage.txtLinkTapDoanFPT);
        driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.urlContains(expectedLinkTC1_103));
        String actualLink = driver.getCurrentUrl();
        Assert.assertEquals(actualLink, expectedLinkTC1_103);
    }

    @Test(description = "Check click Thanh toán online ở phần Khách hàng FPT Telelcom: TC_1_107")
    public void Feature_11() throws MalformedURLException {
        logger.info("Feature_11");
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
        menuShop = new ActionsMenu();
        menuShop.skipToPopupLocation();
        langdingPage.clickElement(langdingPage.txtLinkThanhToanOnline);
        driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.urlContains(expectedLinkTC1_107));
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedLinkTC1_107);
    }
    @Test(description = "Check click Góp ý khách hàng ở phần Khách hàng FPT Telelcom: TC_1_108")
    public void Feature_12() throws MalformedURLException {
        logger.info("Feature_12");
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
        menuShop = new ActionsMenu();
        menuShop.skipToPopupLocation();
        langdingPage.clickElement(langdingPage.txtLinkGopYKhachHang);
        driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.urlContains(expectedLinkTC1_108));
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedLinkTC1_108);
    }

    @Test(description = "Check click Điều khoản – Bảo hành ở phần Khách hàng FPT Telelcom: TC_1_109")
    public void Feature_13() throws MalformedURLException {
        logger.info("Feature_13");
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
        menuShop = new ActionsMenu();
        menuShop.skipToPopupLocation();
        langdingPage.clickElement(langdingPage.txtLinkDieuKhoanBaoHanh);
        driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.urlContains(expectedLinkTC1_109));
        Assert.assertEquals(driver.getCurrentUrl(),expectedLinkTC1_109);
    }
    @Test(description = "Check giao diện trang chủ: TC_1_72; TC_1_76; TC_1_77; TC_1_87; TC_1_156; TC_1_157; TC_1_184; TC_1_189; TC_1_163; TC_1_157  ")
    public void Feature_14() throws InterruptedException {
        logger.info("Feature_14");
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
        menuShop = new ActionsMenu();
        menuShop.skipToPopupLocation();
        assertThat(langdingPage.getListItems(langdingPage.itemSliderTinNoiBat)).
                as("Check hiển thị danh sách các tin tức có tình trạng enable").isNotNull();
        assertThat(langdingPage.checkElementDisplayed(langdingPage.imgFPTPlayBox)).
                as("Check thông tin hiển thị hình ảnh trên 1 tin tức nổi bật").isTrue();
        assertThat(langdingPage.checkElementDisplayed(langdingPage.titleFPTPlayBox)).
                as("Check thông tin hiển thị tiêu đề trên 1 tin tức nổi bật").isTrue();
        assertThat(langdingPage.checkElementDisplayed(langdingPage.describeFPTPlayBox)).
                as("Check thông tin hiển thị trên mô tả 1 tin tức nổi bật").isTrue();

        List<WebElement> listOfElements_SG= langdingPage.itemInDuocQuanTamNhieuNhat.findWebElements();
        menuShop.openPopuplocationIfItNotPresent();
        menuShop.waitLoadingLocationTT()
                .chooseProvinceLocation("Bình Dương")
                .waitLoadingLocationQH()
                .chooseProvinceLocationQH("Huyện Bàu Bàng")
                .clickButtonApproveLocation();
        WebDriverWait wait = new WebDriverWait(driver,60);
        try {
            Thread.sleep(4000); // sau khi nhấn xong hiện trang cũ trước khi load lại toàn bộ trang
        }catch (Exception e){

        }
        wait.until(ExpectedConditions.textToBePresentInElementLocated(menuShop.locationEl.by(),"Bình Dương"));
        List<WebElement> listOfElements_AG= langdingPage.itemInDuocQuanTamNhieuNhat.findWebElements();
        assertThat(listOfElements_SG.size()).
                as("Check thay đổi danh sách hiển thị và giá SP/DV khi thay đổi Location").
                isNotEqualTo(listOfElements_AG.size());

        assertThat(langdingPage.checkDisplayUuDaiMoiNhat()).as("Check Hiển thị Ưu đãi mới nhất ").isEqualTo(true);

        //TC_1_157: viết lại dùng API check gói sản phẩn dịch vụ trước khi so sánh
        //assertThat(langdingPage.getPriceSPDV()).as("Check gia gia san pham dich vu").isEqualTo(getListPrice);

        //TC_1_163: viết lại dùng API check gói sản phẩn dịch vụ trước khi so sánh
        //assertThat(langdingPage.checkBlockUuDai()).as("Check 1 block uu dai").isEqualTo(check1Block);

        assertThat(langdingPage.checkDisplayDuocQuanTamNhieuNhat()).as("Check data hien thi quan tam nhieu nhat").isEqualTo(true);

        //TC_1_189: viết lại dùng API check gói sản phẩn dịch vụ trước khi so sánh
        //assertThat(langdingPage.checkDisplaySPQuanTamNhieuNhat()).as("Check block quan tam nhieu nhat").isEqualTo(check1BlockSP);
    }
    @Test(description = "Check tin tức nổi bật có gắn link: TC_1_76")
    public void Feature_15() throws MalformedURLException {
        logger.info("Feature_15");
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
        menuShop = new ActionsMenu();
        menuShop.skipToPopupLocation();
        langdingPage.clickRandomNewsHasLink();
        driver = getDriver();
        langdingPage.clickRandomNewsHasLink();
        try {
            Thread.sleep(3000);
        }catch (Exception e){

        }
        Assert.assertNotEquals(driver.getCurrentUrl(),url);
    }


    @Test(description = "Check click vào 1 SP/DV: TC_1_88")
    public void Feature_16() throws MalformedURLException {
        logger.info("Feature_16");
        langdingPage = new ActionLandingPage();
        langdingPage.goHere();
        menuShop = new ActionsMenu();
        menuShop.skipToPopupLocation();
        langdingPage.clickElementWhenItIsDisplay(menuShop.locationEl);
        menuShop.waitLoadingLocationTT()
                .chooseProvinceLocation("Hồ Chí Minh")
                .waitLoadingLocationQH()
                .chooseProvinceLocationQH("Quận 1")
                .clickButtonApproveLocation();
        langdingPage.clickElement(langdingPage.goiCuocInternetSuper80);
        driver = getDriver();
        //khi click gói cước sẽ ra 1 link A, sau đó n giây mới navigate tới url Trang Đăng ký, nên phải wait
        WebDriverWait wait= new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(langdingPage.txtThongTinCaNhan.by()));
        String actualLink = driver.getCurrentUrl();
        Assert.assertEquals(actualLink,expectedLinkTC1_88);
    }

        @Test(description = "Check mo link FOXPAY: TC_1_127")
        public void Feature_17 () throws InterruptedException {
            logger.info("Feature_17");
            langdingPage = new ActionLandingPage();
            langdingPage.goHere();
            menuShop = new ActionsMenu();
            menuShop.skipToPopupLocation();
            String getLinkFoxPay = langdingPage.clickLinkFoxPay();
            assertThat(getLinkFoxPay).as("Check mo link FoxPay").isEqualTo(getURL_Foxpay);
        }
        @Test(description = "Check mo link FPT Play Box: TC_1_128")
        public void Feature_18 () throws InterruptedException {
            logger.info("Feature_18");
            langdingPage = new ActionLandingPage();
            langdingPage.goHere();
            menuShop = new ActionsMenu();
            menuShop.skipToPopupLocation();
            String getLinkFPTPlayBox = langdingPage.clickLinkFptPlayBox();
            assertThat(getLinkFPTPlayBox).as("Check mo link FPT PlayBox").isEqualTo(getURL_FPTPlayBox);
        }
        @Test(description = "Check mo link Fshare:TC_1_129")
        public void Feature_19 () throws InterruptedException {
            logger.info("Feature_19");
            langdingPage = new ActionLandingPage();
            langdingPage.goHere();
            menuShop = new ActionsMenu();
            menuShop.skipToPopupLocation();
            String getLinkFshare = langdingPage.clicklinkFshare();
            assertThat(getLinkFshare).as("Check mo link Fshare").isEqualTo(getURL_Fshare);
        }
        @Test(description = "Check mo link Fsend: TC_1_131")
        public void Feature_20 () throws InterruptedException {
            logger.info("Feature_20");
            langdingPage = new ActionLandingPage();
            langdingPage.goHere();
            menuShop = new ActionsMenu();
            menuShop.skipToPopupLocation();
            String getLinkFsend = langdingPage.clickLinkFsend();
            assertThat(getLinkFsend).as("Check mo link Fsend").isEqualTo(getURL_Fsend);
        }
        @Test(description = "Check mo link Ihome: TC_1_132")
        public void Feature_21 () throws InterruptedException {
            logger.info("Feature_21");
            langdingPage = new ActionLandingPage();
            langdingPage.goHere();
            menuShop = new ActionsMenu();
            menuShop.skipToPopupLocation();
            String getLinkIhome = langdingPage.clickLinkFPTIhome();
            assertThat(getLinkIhome).as("Check mo link Ihome").isEqualTo(getURL_FPTIhome);
        }
        @Test(description = "Check mo link Bo Cong Thuong: TC_1_135")
        public void Feature_22 () throws InterruptedException {
            logger.info("Feature_22");
            langdingPage = new ActionLandingPage();
            langdingPage.goHere();
            menuShop = new ActionsMenu();
            menuShop.skipToPopupLocation();
            String getlinkBCT = langdingPage.clicklinkBCT();
            assertThat(getlinkBCT).as("Check mo link Bo Cong Thuong").isEqualTo(getURL_BCT);
        }

        @Test(description = "Check mo link IPV6: TC_1_136")
        public void Feature_23() throws InterruptedException {
            logger.info("TC_Home_23");
            langdingPage = new ActionLandingPage();
            langdingPage.goHere();
            menuShop = new ActionsMenu();
            menuShop.skipToPopupLocation();
            String getlinkIPV6= langdingPage.clicklinkIPV6();
            assertThat(getlinkIPV6).as("Check mo link IPV6").isEqualTo(getURL_IPV6);
        }

        @Test(description = "Check Link IMG Logo FPT: TC_1_138 ")
        public void Feature_24() {
            logger.info("Feature_24");
            langdingPage = new ActionLandingPage();
            langdingPage.goHere();
            menuShop = new ActionsMenu();
            menuShop.skipToPopupLocation();
            String getURLFPT= langdingPage.getLinkLogo();
            assertThat(getURLFPT).as("Check Link IMG Logo FPT").isEqualTo(getURL_IMG);
        }
*/

}



