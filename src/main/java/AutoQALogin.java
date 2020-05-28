import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutoQALogin {
    private WebDriver driver;
    By SignInLink = By.partialLinkText("Sign in");
    By email = By.id("email");
    By password = By.id("passwd");
    By login = By.id("SubmitLogin");

    public AutoQALogin(WebDriver driver) {
        this.driver = driver;
    }

    private void clickSignIn() {
        driver.findElement(SignInLink).click();
    }

    private void setEmail(String yourEmail) {
        driver.findElement(email).sendKeys(yourEmail);
    }

    private void setPassword(String yourPassword) {
        driver.findElement(password).sendKeys(yourPassword);
    }

    private void clickLogin() {
        driver.findElement(login).click();
    }

    public void loginToWebSite(String yourEmail, String yourPassword) {
        this.clickSignIn();
        this.setEmail(yourEmail);
        this.setPassword(yourPassword);
        this.clickLogin();
    }
}
