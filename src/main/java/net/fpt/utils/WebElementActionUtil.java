package net.fpt.utils;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public final class WebElementActionUtil {
    static final Logger logger = LoggerFactory.getLogger(WebElementActionUtil.class);
    /**
     * Mô tả: Truyền vào element để láy một list element, click vào element có text trùng với text truyền đã truyền vào
     * @param element
     * @param choose
     */
    public static void chooseList(Query element, String choose){
        try {
            List<WebElement> elementList = element.findWebElements();
            System.out.println("Number of elements:" + elementList.size());
            for (int i = 0; i < elementList.size(); i++) {
                System.out.println(elementList.get(i).getText());
                if (elementList.get(i).getText().equals(choose)) {
                    logger.info("Found Item: "+ choose);
                    elementList.get(i).click();
                    break;
                }
            }

        }catch(Exception e) {
            logger.error("chooseList "+ element.toString());
        }

    }

    /**
     * Mô tả: Kiểm tra có hiện element trong viewpoint hay không
     * link: https://stackoverflow.com/questions/45243992/verification-of-element-in-viewport-in-selenium
     * @param element
     * @return
     */
    public static Boolean isVisibleInViewport(WebElement element) {
        WebDriver driver = ((RemoteWebElement)element).getWrappedDriver();

        return (Boolean)((JavascriptExecutor)driver).executeScript(
                "var elem = arguments[0],                 " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            "
                , element);
    }

    /**
     * Author: HaoBH
     * Function: get list của các items giống nhau chứa trong cùng 1 layout chung
     *@param query - item trong cùng của layout.
     *             Example: 1 thẻ <ul> chứa nhiều thẻ <li> bên trong thì query là 1 tập hợp các <li>
     *@return List items kiểu String
     * */
    public static List getTextListItems (Query query) {
        ArrayList result = new ArrayList<>();
        List<WebElement> elementList= new ArrayList<>(query.findWebElements());
        for (int i = 0; i < elementList.size(); i++) {
            result.add(elementList.get(i).getText().trim());
            //System.out.println(elementList.get(i).getText().trim());
        }
        return result;
    }

    /**
     * Author: MinhLH5
     * Function: get list của các items giống nhau chứa trong cùng 1 layout chung
     *@param listElement - item trong cùng của layout.
     *             Example: 1 thẻ <ul> chứa nhiều thẻ <li> bên trong thì query là 1 tập hợp các <li>
     *@return List items kiểu String
     * */
    public static List getTextListItems (List<WebElement> listElement) {
        ArrayList result = new ArrayList<>();
        for (WebElement i: listElement) {
            result.add(i.getText().trim());
        }
        return result;
    }

    /**
     * Author: minhlh
     * Function: lấy danh sách element có chứa đường link
     *@param query - item trong cùng của layout.
     *@return List web element
     * */
    public static List<WebElement> getListElementHasLinkInList (Query query) {
        ArrayList result = new ArrayList<>();
        List<WebElement> elementList= new ArrayList<>(query.findWebElements());
        for (int i = 0; i < elementList.size(); i++) {
            try {// fix loop exit because exception null
                String attribute = elementList.get(i).getAttribute("href");
                if (attribute.trim().length() > 0 && attribute.indexOf("#")<0) {
                    logger.debug(">>>>>>>>>>>>>>>>>>>.{} >> {}", attribute, attribute.length());
                    result.add(elementList.get(i));
                }
            } catch (Exception e) {

            }
        }
        return result;
    }

    /**
     * Author: MinhLH5
     * Mô tả: Kiểm tra img có được load
     * @param element
     * @return Boolean
     */
    public static Boolean isLoadingImage(WebElement element) {
        WebDriver driver = ((RemoteWebElement)element).getWrappedDriver();
        return (Boolean) ((JavascriptExecutor)driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
    }

    /**
     * Author: MinhLH5
     * Mô tả: Chờ element chuyển đổi style được định nghĩa
     * @return Boolean
     */
    public static ExpectedCondition<Boolean> waitForLoadingCSSStype(WebElement element, String stypeLoading) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                //System.out.println(element.getAttribute("style"));
                return element.getAttribute("style").equals(stypeLoading);
            }
        };
    }

    /**
     * Author: MinhLH5
     * Mô tả: Chờ element xuất hiện và bắt đầu click
     * @return action
     * @param q // test
     * @param wait //test
     */
    public static void waitAndClickToElement(Query q, WebDriverWait wait){
        WebElement myElement =  wait.until(ExpectedConditions.elementToBeClickable(q.by()));
        myElement.click();
    }


    /**Author: HaoBH
     * Function: check whether the element is displayed
     * @param element
     * @return true/false
     * */
    public static boolean checkElementDisplayed(WebDriverWait wait, Query element){
        logger.info("checkElementDisplayed");

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element.by()));
            if (element.findWebElement().isDisplayed())
                return true;
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }
        catch (TimeoutException e){
            e.printStackTrace();
        }
        return false;
    }
}
