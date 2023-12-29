I/ Cách đặt tên: 

1. Package names (tên gói): 
	Viết thường, có khoảng trắng và khoảng trắng được thay bằng ký tự _ . VD: com.example.deep_space
2. Class names (tên lớp):
	Viết chữ in toàn bộ chữ cái đầu tiên, không khoảng trắng. VD: HashTest, HashIntegrationTest
3. Method names & Parameter names (tên phương thức và biến):
	Viết thường chữ cái đầu tiên của chữ đầu tiên, các chữ cái đầu tiêu của các chữ còn lại viết chữ in . VD : sendMessage, stop
4. Constant names (tên hằng số):
	Viết toàn bộ bằng chữ in,có khoảng trắng và khoảng trắng được thay bằng ký tự _ . VD: CONSTANT_CASE
5. Page object name:
	Viết theo kiểu Method names, đối với website phải chứa path của trang ở cuối.
6. Class & Function test cases,Page Objects:
	- Class Name: Viết tắt theo sheet name trên test case. VD Chọn gói dịch vụ -> CGDV.java
	- Function Name: Viết theo Testcase ID trên test case VD: TC_1.1 -> TC_1_1
	- Test Description: Viết theo cột Nội Dung Test(Test Title) trên test case 
	
II/ Cách ghi chú vào phương thức:

    /**
     * Description: <Mô tả ngắn>
	 * Author: <email FPT>
	 * Create Date: <Ngày tạo>
	 *
     * @param <tham số truyền vào>
     * @param <tham số truyền vào>
     * @return <kết quả trả về>
     */

VD:
    /**
     * Description: Truyền vào element để lấy một list element, click vào element có text trùng với text truyền đã truyền vào
	 * Author: minhlh5
	 * Create Date: 23/06/2021
	 *
     * @param driver
     * @param element
     * @param text
     * @return action on element
     */
