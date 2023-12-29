# Các lệnh thực thi:
  - mvn verify : Chạy các testcase được khai báo trong testNG.xml.
  - mvn clean verify : Xóa mục target và chạy testcase.
  - mvn verify -D[biến]=tham số : Thay đổi các biến mặc định trong file pom.xml |  VD: -Dbrowser=chrome Thay đổi trình duyệt chạy testcase
  - mvn clean verify -e : Hiện thông tin chi tiết lỗi.
  - mvn verify -Dmaven.failsafe.debug : debug trên maven (hướng dẫn cách thêm debug trên IntelliJ https://www.jetbrains.com/help/idea/tutorial-remote-debug.html )
  - mvn verify -Dhttps.proxyHost=proxy.hcm.fpt.vn  -Dhttps.proxyPort=80   -Dhttp.proxyHost=proxy.hcm.fpt.vn  -Dhttp.proxyPort=80 -Dhttp.nonProxyHosts="seleniumhub.fpt.net|upload-static.fpt.net|systemmailapi.fpt.vn": Chạy với proxy
# Ghi Chú:
    Xuất báo cáo Tiếng Việt, thêm biến Environment: JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

# Chú ý:
    Mọi người vui lòng theo hướng dẫn trong Guideline.md.
    Mọi người vui lòng chỉ push code lên nhánh develop.
    Mọi trục trặc hoặc có vấn đề gì mọi người liên hệ anh Minh hoặc Nhân.
# AutoTest_ISC
Date: 20/01/2021
