package page_objects.Register;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.PageBase;

public class ElementsRegister extends PageBase {
    public Query nameEl = new Query().defaultLocator(By.id("name")).usingDriver(driver);
    public Query phoneEl = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]")).usingDriver(driver);
    public Query dateOfBirthEl = new Query().defaultLocator(By.id("birthday")).usingDriver(driver);
    public Query selectdateOfBirtAfterSend = new Query().defaultLocator(By.xpath("//div[@aria-selected='true']")).usingDriver(driver);
    public Query cmndEl = new Query().defaultLocator(By.xpath("//input[@placeholder='000 000 000 000']")).usingDriver(driver);
    //public Query cmndEl = new Query().defaultLocator(By.xpath("//label[text()[normalize-space()='Số cmnd/cccd']]//parent::div//input")).usingDriver(driver);
    public Query sexListEl = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/span[1]/span[1]/span[1]/span[1]")).usingDriver(driver);
    public Query emailEl = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/input[1]")).usingDriver(driver);
    public Query dropdownliststateListEl = new Query().defaultLocator(By.xpath("//div[@data-select2-id='122']/div[@class='wrapper']/main[@class='main-container payment-flow container-payment']/div[@class='container-fluid banner-pm pb-5']/section[@class='mt-4 mb-4 sec-payment']/div[@class='container w-736 sec-plb-inside rd-t mt-4 rd-b box-sdow']/div[@class='row box-info']/div[@class='col-12']/div[@class='pdx09 py-4']/div[@class='form-infomation']/div[1]/div[1]/select[1]/option")).usingDriver(driver);
    public Query dropdownlistDistrictListEL= new Query().defaultLocator(By.xpath("//div[@data-select2-id='122']/div[@class='wrapper']/main[@class='main-container payment-flow container-payment']/div[@class='container-fluid banner-pm pb-5']/section[@class='mt-4 mb-4 sec-payment']/div[@class='container w-736 sec-plb-inside rd-t mt-4 rd-b box-sdow']/div[@class='row box-info']/div[@class='col-12']/div[@class='pdx09 py-4']/div[@class='form-infomation']/div[2]/div[1]/select[1]/option")).usingDriver(driver);
    public Query dropdownlistWard= new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/span[1]/span[1]/span[1]")).usingDriver(driver);
    public Query listItemWard= new Query().defaultLocator(By.xpath("//span[@class='select2-container select2-container--default select2-container--open']//span[@class='select2-results']/ul/li")).usingDriver(driver);
    public Query dropdownlistStreet = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/span[1]/span[1]/span[1]/span[1]")).usingDriver(driver);
    public Query listItemStreet = new Query().defaultLocator(By.xpath("//span[@class='select2-dropdown select2-dropdown--above']//span[@class='select2-results']/ul/li")).usingDriver(driver);
    public Query houseNumber = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[6]/input[1]")).usingDriver(driver);
    public Query loading = new Query().defaultLocator(By.xpath("//div[@aria-label='Loading']")).usingDriver(driver);
    public Query ngaySinhEl = new Query().defaultLocator(By.id("birthday")).usingDriver(driver);

    // Top step register
    public Query txtDKDV = new Query().defaultLocator(By.linkText("Thông tin đăng ký")).usingDriver(driver);
    public Query txtChonDV = new Query().defaultLocator(By.linkText("Chọn dịch vụ")).usingDriver(driver);
    public Query txtTTTT = new Query().defaultLocator(By.linkText("Thông tin thanh toán")).usingDriver(driver);
    public Query txtHTDK = new Query().defaultLocator(By.linkText("Hoàn tất đăng ký")).usingDriver(driver);

    public Query txtHovaTen = new Query().defaultLocator(By.xpath("//label[@for='name']")).usingDriver(driver);
    public Query txtSDT = new Query().defaultLocator(By.xpath("(//label[@for='phone'])[1]")).usingDriver(driver);
    public Query txtNgaySinh = new Query().defaultLocator(By.xpath("//label[contains(text(),'Ngày sinh')]")).usingDriver(driver);
    public Query txtSoCMND = new Query().defaultLocator(By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/label[1]")).usingDriver(driver);
    public Query txtgioiTinh = new Query().defaultLocator(By.xpath("//label[text()='Giới tính']")).usingDriver(driver);
    public Query txtDiachiEmail = new Query().defaultLocator(By.xpath("//label[text()='Địa chỉ email']")).usingDriver(driver);
    public Query txtVuiLongNhapName = new Query().defaultLocator(By.xpath("//small[text()='Vui lòng nhập họ và tên.']")).usingDriver(driver);
    public Query txtVuiLongNhapSDT = new Query().defaultLocator(By.xpath("//small[text()='Vui lòng nhập họ và tên.']")).usingDriver(driver);
    public Query txtVuiLongNhapNgaySinh = new Query().defaultLocator(By.xpath("//small[text()='Vui lòng nhập ngày sinh.']")).usingDriver(driver);
    public Query txtVuiLongCMND = new Query().defaultLocator(By.xpath("//small[text()='Vui lòng nhập số CMND/CCCD.']")).usingDriver(driver);
    public Query txtVuiLongChonPhuongXa = new Query().defaultLocator(By.xpath("//small[text()[normalize-space()='Vui lòng chọn phường/xã.']]")).usingDriver(driver);
    public Query txtVuiLongChonDuongPho = new Query().defaultLocator(By.xpath("//small[text()[normalize-space()='Vui lòng chọn đường/phố.']]")).usingDriver(driver);
    public Query txtVuiLongChonSoNha = new Query().defaultLocator(By.xpath("//small[text()[normalize-space()='Vui lòng nhập địa chỉ/số nhà.']]")).usingDriver(driver);
    public Query txtThongTinCaNhan = new Query().defaultLocator(By.xpath("//span[text()='Thông tin cá nhân']")).usingDriver(driver);
    public Query txtDiaChiLapDat = new Query().defaultLocator(By.xpath("//span[text()='Địa chỉ lắp đặt']")).usingDriver(driver);
    public Query btnTiepTuc = new Query().defaultLocator(By.xpath("(//button[contains(@class,'btn btn-custom')])[1]")).usingDriver(driver);
    public Query txtSaiDangSoDT = new Query().defaultLocator(By.xpath("//small[text()='Số điện thoại của bạn không đúng định dạng!']")).usingDriver(driver);
    public Query txtSaiDangNgaysinh = new Query().defaultLocator(By.xpath("//small[text()='Ngày sinh của bạn không đúng định dạng!']")).usingDriver(driver);
    public Query dropdownGioiTinh = new Query().defaultLocator(By.xpath("/html/body/span/span/span[2]/ul/li")).usingDriver(driver);
    public Query inputGT = new Query().defaultLocator(By.xpath("(//span[@id='select2--container'])[1]")).usingDriver(driver);
    public Query inputPhuongXa = new Query().defaultLocator(By.xpath("(//span[@id='select2--container'])[4]")).usingDriver(driver);
    public Query inputDuongPho = new Query().defaultLocator(By.xpath("(//span[@id='select2--container'])[5]")).usingDriver(driver);
    public Query dropdownPhuongXaDP = new Query().defaultLocator(By.xpath("/html/body/span/span/span[2]/ul/li")).usingDriver(driver);
    public Query txtHouseNumber = new Query().defaultLocator(By.id("address")).usingDriver(driver);
    public Query txtHinhThucTraCuoc = new Query().defaultLocator(By.xpath("//span[text()='Chọn hình thức trả cước']")).usingDriver(driver);
    public Query txtPopupTrungKHTN = new Query().defaultLocator(By.xpath("//p[text()='Số điện thoại của Quý Khách đã được sử dụng để đăng ký dịch vụ của FPT Telecom thời gian gần đây. Vui lòng quay lại sau 24 tiếng hoặc đăng ký qua tổng đài 19006600']")).usingDriver(driver);
    public Query radioBtnChungCu = new Query().defaultLocator(By.id("send[2]")).usingDriver(driver);
    public Query radioBtnNhaRieng = new Query().defaultLocator(By.id("send[1]")).usingDriver(driver);
    public Query txtPopupKTHT = new Query().defaultLocator(By.xpath("//span[contains(text(),'Thông báo')]/following::p")).usingDriver(driver);
    public Query txtNhapTenDuongPho = new Query().defaultLocator(By.id("address_user")).usingDriver(driver);
    public Query txtThongBaoNoCuoc = new Query().defaultLocator(By.xpath("//p[text()='Thông tin Quý khách đăng ký thuộc hợp đồng SGH552808 chưa hoàn tất thủ tục thanh toán cước trước đó. Vui lòng liên hệ tổng đài 1900 6600 để được hỗ trợ. Xin cảm ơn!']")).usingDriver(driver);

    public Query listErrorNullInput = new Query().defaultLocator(By.xpath("//small[@class='form-text text-12 clo-red']")).usingDriver(driver);

    WebDriverWait wait = new WebDriverWait(driver, 15, 2000);

    //Chọn dịch vụ
    public Query buttonIncrease = new Query().defaultLocator(By.xpath("//a[@class='btn-tool btn-increase']")).usingDriver(driver);
    public Query textQuantityBox = new Query().defaultLocator(By.xpath("//span[@class='quantity']")).usingDriver(driver);
    public Query buttonDecrease = new Query().defaultLocator(By.xpath("//a[@class='btn-tool btn-decrease']")).usingDriver(driver);
    public Query buttonInfoFsafe = new Query().defaultLocator(By.xpath("//i[@class='ico-grey']")).usingDriver(driver);
    public Query popUpInfoFsafe = new Query().defaultLocator(By.xpath("//div[@class='modal-dialog modal-md']")).usingDriver(driver);
    public Query buttonClosePopUpInfoFsafe = new Query().defaultLocator(By.xpath("//div[contains(@style,'display: block;')]//following::button")).usingDriver(driver);
    public Query textTitleSetupTime = new Query().defaultLocator(By.xpath("//span[contains(text(),'Thời gian lắp đặt')]")).usingDriver(driver);
    public Query dateSetupTime = new Query().defaultLocator(By.xpath("//label[contains(text(),'Ngày')]//following::input[1]")).usingDriver(driver);
    public Query TextErrorDateSetup = new Query().defaultLocator(By.xpath("//small[@class='form-text text-12 clo-red error-message']")).usingDriver(driver);
    public Query dropDownListTimeSetup = new Query().defaultLocator(By.id("select2--container")).usingDriver(driver);
    public Query listTimeSetup = new Query().defaultLocator(By.xpath("//span[@class='select2-container select2-container--default select2-container--open']//span[@class='select2-results']/ul/li")).usingDriver(driver);

    //tab Thông tin đăng ký - mục Địa chỉ lắp đặt
    public Query closedDropdownTinhThanh = new Query().defaultLocator(By.xpath("(//span[@id='select2--container'])[2]")).usingDriver(driver);
    public Query searchBoxTinhThanh = new Query().defaultLocator(By.xpath("//input[@role='searchbox']")).usingDriver(driver);
    public Query listItemTinhThanh = new Query().defaultLocator(By.xpath("//ul[@role='listbox']//li")).usingDriver(driver);

    public Query closedDropdownQuanHuyen = new Query().defaultLocator(By.xpath("(//span[@id='select2--container'])[3]")).usingDriver(driver);
    public Query searchBoxQuanHuyen = new Query().defaultLocator(By.xpath("//input[@role='searchbox']")).usingDriver(driver);
    public Query listItemQuanHuyen= new Query().defaultLocator(By.xpath("//ul[@role='listbox']//li")).usingDriver(driver);

    public Query closedDropdownPhuongXa = new Query().defaultLocator(By.xpath("(//span[@id='select2--container'])[4]")).usingDriver(driver);
    public Query searchBoxPhuongXa = new Query().defaultLocator(By.xpath("//input[@role='searchbox']")).usingDriver(driver);
    public Query listItemPhuongXa= new Query().defaultLocator(By.xpath("//ul[@role='listbox']//li")).usingDriver(driver);

    public Query closedDropdownDuongPho = new Query().defaultLocator(By.xpath("(//span[@id='select2--container'])[5]")).usingDriver(driver);
    public Query searchBoxDuongPho = new Query().defaultLocator(By.xpath("//input[@role='searchbox']")).usingDriver(driver);
    public Query listItemDuongPho= new Query().defaultLocator(By.xpath("//ul[@role='listbox']//li")).usingDriver(driver);
    public Query txtBoxNhapTenDuongPho= new Query().defaultLocator(By.xpath("//input[@id='address_user']")).usingDriver(driver);

    public Query radioButtonNhaRieng= new Query().defaultLocator(By.xpath("//input[@value='nhà riêng']")).usingDriver(driver);
    public Query radioButtonChungCu= new Query().defaultLocator(By.xpath("//input[@value='chung cư']")).usingDriver(driver);

    //public Query txtBoxDiaChiSoNha= new Query().defaultLocator(By.xpath("//input[@id='address']")).usingDriver(driver);

    public Query titleDiaChiLapDat = new Query().defaultLocator(By.xpath("//span[text()[normalize-space()='Địa chỉ lắp đặt']]")).usingDriver(driver);
    //Các elements tab Chọn dịch vụ
    public Query headerLogo= new Query().defaultLocator(By.xpath("//a[@href='/shop/']")).usingDriver(driver);
    public Query headerLinkThongTinDangKy= new Query().defaultLocator(By.xpath("//a[text()[normalize-space()='Thông tin đăng ký']]")).usingDriver(driver);
    public Query headerLinkChonDichVu= new Query().defaultLocator(By.xpath("(//a[text()[normalize-space()='Chọn dịch vụ']])[1]")).usingDriver(driver);
    public Query headerLinkThongTinThanhToan= new Query().defaultLocator(By.xpath("//a[text()[normalize-space()='Thông tin thanh toán']]")).usingDriver(driver);
    public Query headerLinkHoanTatDangKy= new Query().defaultLocator(By.xpath("//a[text()[normalize-space()='Hoàn tất đăng ký']]")).usingDriver(driver);

    public Query sectionThongTinDichVu= new Query().defaultLocator(By.xpath("(//div[contains(@class,'container-fluid banner-pm')]//section)[2]")).usingDriver(driver);
    public Query txtTenGoiCuoc_ChonDichVu= new Query().defaultLocator(By.xpath("(//div[contains(@class,'container-fluid banner-pm')]//section)[2]//h4//span")).usingDriver(driver);
    public Query txtTinhThanh_ChonDichVu= new Query().defaultLocator(By.xpath("//section//a[@href='/shop/internet/register']")).usingDriver(driver);
    public Query txtMoTa= new Query().defaultLocator(By.xpath("//section//div[@class='info']")).usingDriver(driver);

    public Query txtChonHinhThucTraCuoc = new Query().defaultLocator(By.xpath("//span[text()[normalize-space()='Chọn hình thức trả cước']]")).usingDriver(driver);
    public Query txtTenGoiTraCuoc= new Query().defaultLocator(By.xpath("(//label[@for='payment[0]']//span)[1]")).usingDriver(driver);
    public Query txtPhiLapDat = new Query().defaultLocator(By.xpath("(//label[@for='payment[0]']//span)[2]")).usingDriver(driver);

    public Query txtMuaThemNhanUuDai= new Query().defaultLocator(By.xpath("//span[text()[normalize-space()='Mua thêm nhận ưu đãi']]")).usingDriver(driver);
    public Query itemGoiDichVuMuaThem= new Query().defaultLocator(By.xpath("//label[@for='use_time[4]']")).usingDriver(driver);
    public Query iconI= new Query().defaultLocator(By.xpath("//label[@for='use_time[4]']//i")).usingDriver(driver);
    public Query txtTenBox_MuaThemNhanUuDai= new Query().defaultLocator(By.xpath("//label[@for='use_time[4]']//i")).usingDriver(driver);
    public Query txtGiaBox_MuaThemNhanUuDai= new Query().defaultLocator(By.xpath("(//span[text()[normalize-space()='Bộ giải mã FPT TV']]//parent::div//span)[2]")).usingDriver(driver);

    public Query txtThoiGianLapDat= new Query().defaultLocator(By.xpath("//span[text()[normalize-space()='Thời gian lắp đặt']]")).usingDriver(driver);
    public Query txtGioLapDat= new Query().defaultLocator(By.xpath("/html/body/div[1]/div[2]/main/div/section[4]/div[1]/div/div/div/div/div/div[2]/div/span")).usingDriver(driver);
    public Query chooseGioLapDat= new Query().defaultLocator(By.xpath("/html/body/span/span/span[2]/ul/li")).usingDriver(driver);

    public Query GioLapDatEl= new Query().defaultLocator(By.id("select2--container")).usingDriver(driver);

    // Xpath Thong tin thanh toan
    public Query txtHoanTatDangKy= new Query().defaultLocator(By.xpath("//span[text()='Hoàn tất đăng ký']")).usingDriver(driver);
    public Query txtThongtinThanhToan= new Query().defaultLocator(By.xpath("//p[text()[normalize-space()='Chọn phương thức thanh toán']]")).usingDriver(driver);
    public Query txtChiTietDonHang = new Query().defaultLocator(By.xpath("//span[text()='Chi tiết đơn hàng']")).usingDriver(driver);
    public Query txtDieuKhoan2 = new Query().defaultLocator(By.xpath("//span[text()='điều khoản của FPT Telecom.']")).usingDriver(driver);
    public Query txtDieuKhoan1 = new Query().defaultLocator(By.xpath("//span[text()='Bằng việc ấn vào nút Thanh toán bạn đã đồng ý với các ']")).usingDriver(driver);
    public Query bnThanhToan = new Query().defaultLocator(By.xpath("(//a[contains(@class,'btn btn-custom')])[2]")).usingDriver(driver);
    public Query displayNameandPhone = new Query().defaultLocator(By.xpath("(//div[@class='d-flex justify-content-between']//p)[1]")).usingDriver(driver);
    public Query displayDiaChi = new Query().defaultLocator(By.xpath("(//div[@class='d-flex justify-content-between']//p)[2]")).usingDriver(driver);
    public Query displayThoiGianLapDat = new Query().defaultLocator(By.xpath("(//div[@class='d-flex justify-content-between']//p)[3]")).usingDriver(driver);
    public Query linkThayDoiDiaChiLapDat = new Query().defaultLocator(By.xpath("(//a[@href='/shop/internet/register'])[2]")).usingDriver(driver);
    public Query linkThayDoiDiaChiTT = new Query().defaultLocator(By.xpath("(//a[@href='/shop/internet/service'])[2]")).usingDriver(driver);
    public Query linkPTTT = new Query().defaultLocator(By.xpath("//a[contains(@class,'big-btn d-flex')]")).usingDriver(driver);
    public Query txtHinhThucTT = new Query().defaultLocator(By.xpath("(//h5[@id='exampleModalLabel'])[4]")).usingDriver(driver);
    public Query txtNoteTT = new Query().defaultLocator(By.xpath("//i[text()='Giảm 50.000đ khi thanh toán qua thẻ quốc tế, thẻ ATM, MoMo, VNPay, Foxpay']")).usingDriver(driver);
    public Query txtTheQuocTe = new Query().defaultLocator(By.xpath("(//p[text()='Thẻ quốc tế'])[2]")).usingDriver(driver);
    public Query txtFoxPay = new Query().defaultLocator(By.xpath("//p[text()='Ví điện tử Foxpay']")).usingDriver(driver);
    public Query txtMoMo = new Query().defaultLocator(By.xpath("(//p[text()='Ví điện tử Momo'])[2]")).usingDriver(driver);
    public Query txtTheVNPAY = new Query().defaultLocator(By.xpath("(//p[text()='Ví điện tử VNPay'])[2]")).usingDriver(driver);
    public Query txtTheATM = new Query().defaultLocator(By.xpath("(//label[@for='baz[2]']//p)[2]")).usingDriver(driver);
    public Query txtTTTN = new Query().defaultLocator(By.xpath("//p[text()='Thanh toán tại nhà ']")).usingDriver(driver);
    public Query radioTheQuocTe = new Query().defaultLocator(By.xpath("(//input[@id='baz[1]'])[2]")).usingDriver(driver);
    public Query radioTheATM = new Query().defaultLocator(By.xpath("(//input[@id='type_payment'])[2]")).usingDriver(driver);
    public Query radioFoxPay = new Query().defaultLocator(By.xpath("(//input[@id='baz[5]'])[2]")).usingDriver(driver);
    public Query radioMoMo = new Query().defaultLocator(By.xpath("(//input[@id='baz[3]'])[2]")).usingDriver(driver);
    public Query radioVNPay = new Query().defaultLocator(By.xpath("(//input[@id='baz[4]'])[2]")).usingDriver(driver);
    public Query radioTTTN= new Query().defaultLocator(By.xpath("(//input[@id='baz[5]'])[3]")).usingDriver(driver);
    public Query iconX= new Query().defaultLocator(By.xpath("(//span[text()='×'])[4]")).usingDriver(driver);
    public Query btnXN = new Query().defaultLocator(By.xpath("(//button[contains(@class,'w-100 btn')])[4]")).usingDriver(driver);
    public Query txtXN = new Query().defaultLocator(By.xpath("(//span[text()='Xác nhận'])[2]")).usingDriver(driver);
    public Query getTextHTTT = new Query().defaultLocator(By.xpath("(//span[@class='clo-black76'])[1]")).usingDriver(driver);
    public Query getTextKH50K = new Query().defaultLocator(By.xpath("//span[text()='DKOL50K']")).usingDriver(driver);
    public Query txtGoiCuoc = new Query().defaultLocator(By.xpath("//p[text()='Combo super 100 (14 tháng)']")).usingDriver(driver);
    public Query txtFsafe = new Query().defaultLocator(By.xpath("//p[text()='F-Safe (2 tháng)']")).usingDriver(driver);
    public Query txtVoucher = new Query().defaultLocator(By.xpath("//p[text()='Voucher']")).usingDriver(driver);
    public Query txtTongTien = new Query().defaultLocator(By.xpath("//p[text()='Tổng tiền']")).usingDriver(driver);
    public Query txtTongTienGoiCuoc = new Query().defaultLocator(By.xpath("//span[text()='3.660.000đ']")).usingDriver(driver);
    public Query txtTienFsafe = new Query().defaultLocator(By.xpath("//span[text()='360.000đ']")).usingDriver(driver);
    public Query txtGiamGia = new Query().defaultLocator(By.xpath("//span[text()='-50.000đ']")).usingDriver(driver);
    public Query txtThanhTien = new Query().defaultLocator(By.xpath("(//span[text()='3.970.000đ'])[1]")).usingDriver(driver);
    public Query txtXemChiTiet = new Query().defaultLocator(By.xpath("(//a[@class='text-bold clo-orange'])[2]")).usingDriver(driver);
    public Query txtHDDDT = new Query().defaultLocator(By.xpath("(//a[@class='text-bold clo-orange'])[3]")).usingDriver(driver);
    public Query txtTiepTuc = new Query().defaultLocator(By.xpath("(//button[contains(@class,'btn btn-custom')])[1]")).usingDriver(driver);
    public Query txtCoTheQuanTam = new Query().defaultLocator(By.xpath("/html/body/div[1]/div[2]/main/div/section[3]/div[1]/div/div/div/h4/span")).usingDriver(driver);
    public Query txtHienThiDanhSach = new Query().defaultLocator(By.xpath(" /html/body/div[1]/div[2]/main/div/section[3]/div[1]/div/div/div/div")).usingDriver(driver);
    public Query txt1GoiCuocQT = new Query().defaultLocator(By.xpath("/html/body/div[1]/div[2]/main/div/section[3]/div[1]/div/div/div/div/div[1]/div/div[1]/a\n")).usingDriver(driver);
    public Query txtBoxVoucher = new Query().defaultLocator(By.xpath("//input[@id='voucher']")).usingDriver(driver);
    public Query btnApDung = new Query().defaultLocator(By.xpath("//a[text()[normalize-space()='Áp dụng']]")).usingDriver(driver);
    public Query popupThongBaoApDungVoucherThanhCong = new Query().defaultLocator(By.xpath("//div[@role='dialog']//div[@tabindex='-1']")).usingDriver(driver);
    public Query btnXPopup = new Query().defaultLocator(By.xpath("//div[@role='dialog']//div[@tabindex='-1']//button[@aria-label='Close']")).usingDriver(driver);
    public Query btnDongY = new Query().defaultLocator(By.xpath("//div[@role='dialog']//div[@tabindex='-1']//span[text()[normalize-space()='Đồng ý']]")).usingDriver(driver);
    public Query txtValueTongTien = new Query().defaultLocator(By.xpath("//p[text()[normalize-space()='Tổng tiền']]//parent::div//span")).usingDriver(driver);
    public Query txtLinkMaGTBBVoucher = new Query().defaultLocator(By.xpath("(//a[@href='javascript:;']//span)[2]")).usingDriver(driver);
    public Query listVoucherSauKhiNhap = new Query().defaultLocator(By.xpath("//div[@class='tag-list d-flex']//a")).usingDriver(driver);
    public Query btnXVoucher = new Query().defaultLocator(By.xpath("//div[@class='tag-list d-flex']//a//span[@class='click-del']")).usingDriver(driver);
    public Query popupXacNhanHuyVoucher = new Query().defaultLocator(By.xpath("//div[@class='modal-content' and @tabindex='-1']")).usingDriver(driver);
    public Query txtNoiDungXacNhanHuyVoucher_popupXacNhanHuyVoucher = new Query().defaultLocator(By.xpath("//div[@class='modal-content' and @tabindex='-1']//div[@class='modal-body']//p")).usingDriver(driver);
    public Query btnKhongHuy_popupXacNhanHuyVoucher = new Query().defaultLocator(By.xpath("//div[@class='modal-content' and @tabindex='-1']//div[@class='modal-body']//span[text()[normalize-space()='Không hủy']]")).usingDriver(driver);
    public Query btnHuy_popupXacNhanHuyVoucher = new Query().defaultLocator(By.xpath("//div[@class='modal-content' and @tabindex='-1']//div[@class='modal-body']//span[text()[normalize-space()='Hủy']]")).usingDriver(driver);
    public Query btnX_popupXacNhanHuyVoucher = new Query().defaultLocator(By.xpath("//div[@class='modal-content' and @tabindex='-1']//button[@aria-label='Close']")).usingDriver(driver);
    public Query txtThongBaoLoiVoucher_popupXacNhanHuyVoucher = new Query().defaultLocator(By.xpath("//div[@class='row']//small")).usingDriver(driver);

}