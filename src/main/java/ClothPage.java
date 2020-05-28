import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClothPage {
    private WebDriver driver;

    public ClothPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSendToAFriend() {
        driver.findElement(By.partialLinkText("Send to a friend")).click();
    }

    public void NameOfYourFriendLabelExists() {
        driver.findElement(By.xpath("//label[@for='friend_name']"));
    }

    public void SendButtonExists() {
        driver.findElement(By.id("sendEmail"));
    }

    public void clickAddToCart() {
        driver.findElement(By.name("Submit")).click();
    }

    public void goToCart() {
        driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
    }

    public void closeSendPage() {
         driver.findElement(By.xpath("//a[@title='Close']")).click();
    }
}
