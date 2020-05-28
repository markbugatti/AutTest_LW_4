import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    @FindBy(id = "footer")
    WebElement footer;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkImage(String clothName) {
        driver.findElement(By.xpath("//img[@alt='"+ clothName + "']"));
    }

    public void checkEmail() {
        footer.findElement(By.partialLinkText("support@seleniumframework.com"));
    }

    public void checkTel() {
        footer.findElement(By.xpath("//span[contains(text(), '(347) 466-7432')]"));
    }

    public void checkContacts() {
        checkEmail();
        checkTel();
    }
}
