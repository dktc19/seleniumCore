package page_objects.LandingPage;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.PageBase;

public class ElementsLadingPage extends PageBase {
        WebDriverWait wait = new WebDriverWait(driver, 30, 1000);

        public Query topServices = new Query().defaultLocator(By.xpath("//div[@class='owl-stage']/div/div/span[1]")).usingDriver(driver);

        public Query super100 = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]")).usingDriver(driver);

        public Query btnX = new Query().defaultLocator(By.xpath("//div[@id='mdLocation-manual___BV_modal_content_']//button[@aria-label='Close']")).usingDriver(driver);

        //Các elements phần Footer
        public Query txtVeFPTTelecom = new Query().defaultLocator(By.xpath("//span[text()='Về FPT Telecom']")).usingDriver(driver);
        public Query txtKhachHangFPTTelecom = new Query().defaultLocator(By.xpath("//span[text()='Khách hàng FPT Telecom']")).usingDriver(driver);
        public Query txtChuaLaKhachHang = new Query().defaultLocator(By.xpath("//span[text()='Chưa là khách hàng']")).usingDriver(driver);
        public Query imgTuyenDung = new Query().defaultLocator(By.xpath("//img[@src='https://fpt.vn/storage/upload/images/banners/associated/fptjobs_new.png']")).usingDriver(driver);
        public Query btnHiFPT = new Query().defaultLocator(By.xpath("//a[@href='https://fpt.vn/hifpt.php']")).usingDriver(driver);
        public Query btnYoutube = new Query().defaultLocator(By.xpath("//a[@href='https://www.youtube.com/user/likefpt']")).usingDriver(driver);
        public Query btnInstagram = new Query().defaultLocator(By.xpath("//a[@href='https://www.instagram.com/fpt.telecom/']")).usingDriver(driver);
        public Query btnFacebook= new Query().defaultLocator(By.xpath("//a[@href='https://www.facebook.com/FptTelecom/']")).usingDriver(driver);
        public Query btnZalo= new Query().defaultLocator(By.xpath("//a[@href='http://zalo.me/fpttelecom']")).usingDriver(driver);
        public Query txtLienKetSanPhamDichVu= new Query().defaultLocator(By.xpath("(//span[text()='Liên kết sản phẩm dịch vụ'])[2]")).usingDriver(driver);
        public Query txtGiayChungNhan= new Query().defaultLocator(By.xpath("//p[text()[normalize-space()='Giấy chứng nhận ĐKKD số 0101778163 do Sở Kế hoạch Đầu tư Thành phố Hà Nội cấp ngày 28/07/2005']]")).usingDriver(driver);
        public Query imgBoCongThuong = new Query().defaultLocator(By.xpath("//img[@src='/shop/htmlv4/assets/images/ft-bct.png']")).usingDriver(driver);
        //public Query imgIPV6 = new Query().defaultLocator(By.xpath("//img[@src='//staging.net.fpt.vn/shop/htmlv4/assets/images/ft-ipv6.png']")).usingDriver(driver);
        public Query txtCopyRight= new Query().defaultLocator(By.xpath("//p[text()='© 2018 Bản quyền thuộc FPT Telecom']")).usingDriver(driver);

        public Query listItemVeFPTTelecom = new Query().defaultLocator(By.xpath("//span[text()='Về FPT Telecom']/parent::*/parent::*//ul/li")).usingDriver(driver);
        public Query txtLinkGioiThieuChung= new Query().defaultLocator(By.xpath("//span[text()='Về FPT Telecom']/parent::*/parent::*//ul/li//a[text()[normalize-space()='Giới thiệu chung']]")).usingDriver(driver);
        public Query txtLinkLienKetThanhVien= new Query().defaultLocator(By.xpath("//span[text()='Về FPT Telecom']/parent::*/parent::*//ul/li//a[text()[normalize-space()='Liên kết - Thành viên']]")).usingDriver(driver);
        public Query txtLinkKhachHangDoiTac= new Query().defaultLocator(By.xpath("//span[text()='Về FPT Telecom']/parent::*/parent::*//ul/li//a[text()[normalize-space()='Khách hàng - Đối tác']]")).usingDriver(driver);
        public Query txtLinkQuanHeCoDong= new Query().defaultLocator(By.xpath("//span[text()='Về FPT Telecom']/parent::*/parent::*//ul/li//a[text()[normalize-space()='Quan hệ cổ đông']]")).usingDriver(driver);
        public Query txtLinkTapDoanFPT= new Query().defaultLocator(By.xpath("//span[text()='Về FPT Telecom']/parent::*/parent::*//ul/li//a[text()[normalize-space()='Tập đoàn FPT']]")).usingDriver(driver);
        public Query listItemKhachHangFPTTelecom = new Query().defaultLocator(By.xpath("//span[text()='Khách hàng FPT Telecom']/parent::*/parent::*//ul/li")).usingDriver(driver);
        public Query txtLinkThanhToanOnline = new Query().defaultLocator(By.xpath("//a[text()='Thanh toán Online']")).usingDriver(driver);

        public Query txtLinkGopYKhachHang = new Query().defaultLocator(By.linkText("Góp ý khách hàng")).usingDriver(driver);

        public Query txtLinkDieuKhoanBaoHanh = new Query().defaultLocator(By.xpath("//a[text()='Điều khoản - Bảo hành']")).usingDriver(driver);

    //popup Thông báo đã áp dụng Mã GTBB
    public Query txtNoiDungThongBao = new Query().defaultLocator((By.xpath("//div[@id='__BVID__109___BV_modal_content_']//p"))).usingDriver(driver);

        public Query footerEl = new Query().defaultLocator(By.xpath("/html/body/footer[2]")).usingDriver(driver);
        public Query listTextChualaKHFPTEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[1]/div[3]/ul/li"))).usingDriver(driver);
        public Query linkDKOLEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[1]/div[3]/ul/li[1]/a"))).usingDriver(driver);
        public Query linkSPDVEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[1]/div[3]/ul/li[2]/a"))).usingDriver(driver);
        public Query linkKMEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[1]/div[3]/ul/li[3]/a"))).usingDriver(driver);
        public Query linkTTGDEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[1]/div[3]/ul/li[4]/a"))).usingDriver(driver);
        public Query linkTTEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[1]/div[3]/ul/li[5]/a"))).usingDriver(driver);
        public Query linkTDEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[1]/div[4]/a"))).usingDriver(driver);
        public Query linkHifPTEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[1]/div[4]/div[2]/a[1]"))).usingDriver(driver);
        public Query linkYoutubeEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[1]/div[4]/div[2]/a[2]"))).usingDriver(driver);
        public Query linkIGEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[1]/div[4]/div[2]/a[3]"))).usingDriver(driver);
        public Query linkFBEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[1]/div[4]/div[2]/a[4]"))).usingDriver(driver);
        public Query linkZLEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[1]/div[4]/div[2]/a[5]"))).usingDriver(driver);
        public Query linkFPTInternetEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[2]/div[1]/div/div/div/div[1]/div/div[6]/a"))).usingDriver(driver);
        public Query linkFPTPlayEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]"))).usingDriver(driver);
        public Query linkFPTCameraEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]"))).usingDriver(driver);
        public Query linkFPTFoxPayEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[2]/div[1]/div/div/div/div[1]/div/div[9]/a/img"))).usingDriver(driver);
        public Query linkFPTPlayBoxEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[2]/div[1]/div/div/div/div[1]/div/div[10]/a/img"))).usingDriver(driver);
        public Query linkFshareEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[2]/div[1]/div/div/div/div[1]/div/div[11]/a/img"))).usingDriver(driver);
        public Query linkFsendEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[2]/div[1]/div/div/div/div[1]/div/div[12]/a/img"))).usingDriver(driver);
        public Query linkFPTIhomeEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[2]/div[1]/div/div/div/div[1]/div/div[8]/a/img"))).usingDriver(driver);
        public Query iconLeftEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[2]/div[1]/div/div/div/div[2]/button[2]"))).usingDriver(driver);
        public Query imgBoCongThuongEl = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid footer-black w1136']/div/div[2]/div[2]/div/div/a[1]"))).usingDriver(driver);
        public Query txtCopyRightEl = new Query().defaultLocator((By.xpath("//html[1]/body[1]/div[1]/div[2]/main[1]/div[2]/div[1]/footer[2]/div[1]/div[1]/p[1]"))).usingDriver(driver);
        public Query imgFPT = new Query().defaultLocator((By.xpath("//footer[@class='container-fluid bottom-footer']/div/div/a"))).usingDriver(driver);
        public Query btnLendauTrang = new Query().defaultLocator((By.xpath("//*[@id=\"myBtn\"]"))).usingDriver(driver);
        public Query txtTrangChu = new Query().defaultLocator((By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/a"))).usingDriver(driver);
        public Query imgIPV6_URL = new Query().defaultLocator(By.xpath("//img[@src='/shop/htmlv4/assets/images/ft-ipv6.png']")).usingDriver(driver);
        public Query sliderhomeUDEL = new Query().defaultLocator(By.xpath("/html/body/div[1]/div[2]/main/div/section[3]/div/div")).usingDriver(driver);
        //public Query priceSuper80UDEL = new Query().defaultLocator(By.xpath("(//span[text()='215.000đ'])[1]")).usingDriver(driver);
        public Query priceSuper100UDEL = new Query().defaultLocator(By.xpath("//span[text()='245.000đ']")).usingDriver(driver);
        public Query priceSuper150UDEL = new Query().defaultLocator(By.xpath("(//span[text()='320.000đ'])[1]")).usingDriver(driver);
        public Query priceSuper250UDEL = new Query().defaultLocator(By.xpath("(//span[text()='760.000đ'])[1]")).usingDriver(driver);
        public Query priceFPTTrongNhaUDEL = new Query().defaultLocator(By.xpath("(//span[text()='1.000.000đ'])[1]")).usingDriver(driver);
        public Query priceFPTNgoaiTroiUDEL = new Query().defaultLocator(By.xpath("(//span[text()='1.200.000đ'])[1]")).usingDriver(driver);
        public Query priceLuuTru1NgayUDEL = new Query().defaultLocator(By.xpath("(//span[text()='22.000đ'])[1]")).usingDriver(driver);
        public Query priceLuuTru2NgayUDEL = new Query().defaultLocator(By.xpath("(//span[text()='33.000đ'])[1]")).usingDriver(driver);
        public Query tenGoiCuocEl = new Query().defaultLocator(By.xpath("//span[text()='Internet - Super100']")).usingDriver(driver);
        public Query motaDichVuEl = new Query().defaultLocator(By.xpath("(//span[@class='mt-3 mb-3'])[1]")).usingDriver(driver);
        public Query thangEl = new Query().defaultLocator(By.xpath("(//span[@class='clo-gray'])[1]")).usingDriver(driver);
        public Query giamGiaEl = new Query().defaultLocator(By.xpath("(//del[@class='clo-gray'])[1]")).usingDriver(driver);
        public Query giamGiaPhanTramEl = new Query().defaultLocator(By.xpath("//div[text()='-44%']")).usingDriver(driver);
        public Query dataDuocQuanTamNhieuNhatEl = new Query().defaultLocator(By.className("row")).usingDriver(driver);
        public Query tenSPQuanTamNhieuNhatEl = new Query().defaultLocator(By.xpath("//p[text()='Internet - Super150']")).usingDriver(driver);
        public Query iconSPQuanTamNhieuNhatSPEl = new Query().defaultLocator(By.xpath("(//img[@class='mr-3'])[2]")).usingDriver(driver);
        public Query motaSPQuanTamNhieuNhatSPEl = new Query().defaultLocator(By.xpath("(//span[contains(@class,'text-14 clo-black76')])[3]")).usingDriver(driver);
        public Query priceSPQuanTamNhieuNhatSPEl = new Query().defaultLocator(By.xpath("(//span[text()='320.000đ'])[2]")).usingDriver(driver);
        public Query giamGiaSPQuanTamNhieuNhatSPEl = new Query().defaultLocator(By.xpath("//del[text()=' 540.000đ']")).usingDriver(driver);


        public Query sliderTinNoiBat= new Query().defaultLocator(By.xpath("//div[contains(@class,'slider slider-features')]/parent::*/parent::*/parent::*")).usingDriver(driver);
        public Query itemSliderTinNoiBat= new Query().defaultLocator(By.xpath("//div[contains(@class,'slider slider-features')]/parent::*/parent::*/parent::*//h3//a")).usingDriver(driver);
        public Query imgFPTPlayBox= new Query().defaultLocator(By.xpath("//div[contains(@class,'slider slider-features')]/parent::*/parent::*/parent::*//div[@class='owl-item active']//img[@alt='FPT Play Box Nâng tầm giải trí']")).usingDriver(driver);
        public Query titleFPTPlayBox= new Query().defaultLocator(By.xpath("(//a[text()='FPT Play Box'])[2]")).usingDriver(driver);
        public Query describeFPTPlayBox= new Query().defaultLocator(By.xpath("//div[contains(@class,'slider slider-features')]/parent::*/parent::*/parent::*//div[@class='owl-item active']//p[contains(text(),'Nâng tầm giải trí')]")).usingDriver(driver);
        public Query goiCuocInternetSuper80= new Query().defaultLocator(By.xpath("//p[text()='Internet - Super80']")).usingDriver(driver);
        public Query txtThongTinCaNhan= new Query().defaultLocator(By.xpath("//span[text()='Thông tin cá nhân']")).usingDriver(driver);
        public Query itemInDuocQuanTamNhieuNhat= new Query().defaultLocator(By.xpath("//div[contains(@class,'row box-info')]//img")).usingDriver(driver);


}