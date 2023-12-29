package constants;

import net.fpt.utils.ReadingJsonUtil;

import java.util.ArrayList;
import java.util.List;

public final class Common {
    public static final String DATA_TEST_FILE_PATH_COMMON = System.getProperty("user.dir")
            + "/src/test/java/test_data_files/Data.json";

    //Phần đọc dữ liệu từ file json
    public static ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

    /* Common */
    public static String url = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"URL_TEST");
    public static String urlGTBB = jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"/URL_TEST_MA_GIOI_THIEU_BAN_BE");
    public static String maGTBBVoucher =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"/MA_GTBB");

    //-----------------------------------------------------------------------------------------
    /* Home */
    public static final String DATA_TEST_FILE_PATH_HOME = System.getProperty("user.dir")
            + "/src/test/java/test_data_files/HomeData.json";
    public static String DCLD = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_HOME,"DCLD");
    public static String ghiChu = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_HOME,"GHICHU");
    public static String textbtnXN = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_HOME,"TEXT_BTNXACNHAN");
    public static List getListTT = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_HOME, "PROVINCE");
    public static List getList1QH = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_HOME, "QUAN_HUYEN_TPHCM");
    public static String textTBQH =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_HOME, "TEXT_THONG_BAO_CHON_QH");

    public static String expectedTextTC1_21 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"NOI_DUNG_THONG_BAO_MA_GTBB_PART1")
                    + maGTBBVoucher
                    + jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"NOI_DUNG_THONG_BAO_MA_GTBB_PART2");
    public static String urlTrangChu =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/LINK_TRANG_CHU");
    public static String urlInternet =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/LINK_INTERNET");
    public static String urlFPTCamera =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/LINK_FPT_CAMERA");
    public static String urlFPTPlayBox =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/LINK_FPTPLAYBOX");
    public static String urlFPTCLOUD =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/LINK_FPTCLOUD");
    public static List<String> listTextTimKiem = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_HOME, "LIST_TEXT_POPUP_TIMKIEM");
    public static String txtDonHangNotFound =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_HOME, "DON_HANG_NOT_FOUND");
    public static String urlDetailDonHang =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/URL_CHI_TIET_DH");
    public static List getListKH =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_HOME, "LIST_TEXT_CHUA_LA_KHFPT");
    public static String getURL_DKOL =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/URL_DKOL");
    public static String getURL_KM =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/URL_KM");
    public static String getURL_TDGD=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_TDGD");
    public static String getURL_TT=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_TT");
    public static String getURL_HiFPT=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_HIFPT");
    public static String getURL_YT=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_YT");
    public static String getURL_IG=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_IG");
    public static String getURL_FB=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_FB");
    public static String getURL_ZL=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_ZL");
    public static ArrayList listFromJSONTC1_98 =
            new ArrayList(jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_HOME, "listVeFPTTelecom"));
    public static ArrayList listFromJSONTC1_104 =
            new ArrayList(jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_HOME
                    , "listKhachHangFPTTelecom"));
    public static String getURL_FPTPlay=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_FPTPLAY");
    public static String getURL_FPTCamera=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_FPTCamera");
    public static String getTEXTCOPY = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_HOME,"TEXT_COPY");

    public static String expectedLinkTC1_99 =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/linkGioiThieuChung");
    public static String expectedLinkTC1_100 =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/linkLienKetThanhVien");
    public static String expectedLinkTC1_101 =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/linkKhachHangDoiTac");
    public static String expectedLinkTC1_102 =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/linkQuanHeCoDong");
    public static String expectedLinkTC1_107 =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/linkThanhToanOnline");
    public static String expectedLinkTC1_108 =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/linkGopYKhachHang");
    public static String expectedLinkTC1_109 =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/linkDieuKhoanBaoHanh");
    public static String expectedLinkTC1_88 =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_REGISTER_PAGE");
    public static String getURL_Foxpay=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_FPTFOXPAY");
    public static String getURL_FPTPlayBox=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_FPTPlayBox");
    public static String getURL_Fshare=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_FSHARE");
    public static String getURL_Fsend=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_FSEND");
    public static String getURL_FPTIhome=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_FPTIHOME");
    public static String getURL_BCT=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_BCT");
    public static String getURL_IPV6=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_IPV6");
    public static String getURL_IMG=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_IMG");
    public static String expectedLinkTC1_103 =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/linkTapDoanFPT");
    public static String getURL_SPDV =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME, "/URL_SPDV");
    public static String getURL_TD=
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_HOME,"/URL_TUYENDUNG");
    public static List getListPrice =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_HOME,"PRICE_SPDV_HANOI");
    public static List check1Block =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_HOME,"BLOCK_DETAIL");
    public static List check1BlockSP =
            jsonUtil.docFileJSON(Common.DATA_TEST_FILE_PATH_HOME,"BLOCK_DETAIL_QUANTAM");


   /* Internet - Truyền Hình*/
    //Phần đọc dữ liệu từ file json
   public static final String DATA_TEST_FILE_PATH_NET_PAYTV = System.getProperty("user.dir")
           + "/src/test/java/test_data_files/RegisterData.json";


    public static String urlHome = jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"/URL_TEST");

    public static List getListTTDK =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON,"MAN_HINH_TTDK");
    public static String getURLDK =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"/URL_DKINTERNET");
    public static List getListTTCN =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON,"LIST_TEXT_TTCN");
    public static List getListLoi =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_NET_PAYTV,"LIST_ERROR_DKDV");
    public static String ERROR_NULL_NAME =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_NET_PAYTV,"ERROR_NULL_NAME");
    public static String ERROR_NULL_PHONE =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_NET_PAYTV,"ERROR_NULL_PHONE");

    public static String getTextSDTSaiDinhDang=
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"ERROR_SAIDINHDANG");
    public static String ERROR_BIRTHDAY=
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_NET_PAYTV,"ERROR_BIRTHDAY");

    public static String ERROR_ID=
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_NET_PAYTV,"ERROR_ID");
    public static String ERROR_STREET=
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_NET_PAYTV,"ERROR_STREET");

    public static String getTextThongBaoTrungKHTN=
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"ERROR_TRUNGKHTN24H");
    public static List getTextKTHT=
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON,"THONGBAO_KIEMTRA_HATANG");
    public static String getTextTBNC=
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"THONGBAO_THUEBAONOCUOC");
    public static String urlChonDichVu =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"/URL_CHON_DICH_VU");
    public static String urlThanhToan =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"/URL_PAYMENT");
    public static List LIST_TEXTTTT =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON,"LIST_TEXT_TTTT");
    public static String TEXTQT =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"TEXTQT");
    public static List LISTTEXTPOPUP =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON,"LISTTEXTPOPUPTTTT");
    public static String URLQR =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"/URL_QR");
    public static String URLTTTN =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"/URLTTTN");
    public static String URLTTQTATM =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"/URLTTQUOCTEATM");
    public static String URLQT =
            jsonUtil.findValueJsonObjectByKeyPathJsonString(DATA_TEST_FILE_PATH_COMMON,"/URLDVQT");
    public static List LISTCTDH =
            jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON,"LISTTTCTDH");

    public static String expectedTextNoiDungXacNhanHuyVoucher =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"NOI_DUNG_XAC_NHAN_HUY_VOUCHER");
    public static String txtThongBaoLoiVoucher_part1 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"MESSAGE_VOUCHER_KHONG_HOP_LE_PART1");
    public static String txtThongBaoLoiVoucher_part2 =
            jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON,"MESSAGE_VOUCHER_KHONG_HOP_LE_PART2");

}
