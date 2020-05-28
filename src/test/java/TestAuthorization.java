import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class TestAuthorization {

    public static WebDriver driver;
    public AutoQALogin autoQALogin;
    public static ChromeOptions chromeOptions;
    public static String baseUrl = "http://automationpractice.com/";

    public String yourEmail = "yourEmail";
    public String yourPassword = "yourPassword";

    @BeforeClass
    public static void setup() throws MalformedURLException {
        chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserVersion", "83");
        chromeOptions.setCapability("platformName", "Windows 10");

        driver = new RemoteWebDriver(new URL("http://localhost:9515"), chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void testLoginWorksCorrect() {
        autoQALogin = new AutoQALogin(driver);
        autoQALogin.loginToWebSite(yourEmail, yourPassword);
    }

    @Test
    public void test1WomenPage() {
        autoQALogin = new AutoQALogin(driver);
        autoQALogin.loginToWebSite(yourEmail, yourPassword);

        WomenPage womenPage = new WomenPage(driver);
        womenPage.clickWomenLink();
        int goodsCount = womenPage.countGoods();
        int yellowGoodsCount = womenPage.countYellowGoods();
        womenPage.switchListView();
        boolean exist = womenPage.checkDescriptionExistance();

        Assert.assertEquals(7, goodsCount);
        Assert.assertEquals(3, yellowGoodsCount);
        Assert.assertTrue(exist);
    }

    @Test
    public void test2WomanPage() {
        /* Authorization */
        autoQALogin = new AutoQALogin(driver);
        autoQALogin.loginToWebSite(yourEmail, yourPassword);
        /* Go on Women page */
        WomenPage womenPage = new WomenPage(driver);
        womenPage.clickWomenLink();
        womenPage.clickCloth("Faded Short Sleeve T-shirts");

        /* Testing page for concrete cloth */
        ClothPage clothPage = new ClothPage(driver);
        clothPage.clickSendToAFriend();
        clothPage.NameOfYourFriendLabelExists();
        clothPage.SendButtonExists();
    }

    @Test
    public void test3WomanPage() {
        /* Authorization */
        autoQALogin = new AutoQALogin(driver);
        autoQALogin.loginToWebSite(yourEmail, yourPassword);
        /* Go on Women page */
        WomenPage womenPage = new WomenPage(driver);
        womenPage.clickWomenLink();
        womenPage.clickCloth("Faded Short Sleeve T-shirts");

        /* Testing page for concrete cloth */
        ClothPage clothPage = new ClothPage(driver);
        /* add and go to cart */
        clothPage.clickAddToCart();
        clothPage.goToCart();


        /* check email and tel number on the footer */
        CartPage cartPage = new CartPage(driver);
        cartPage.checkContacts();
    }

    @AfterClass
    public static void quit() {
        driver.quit();
    }

}
