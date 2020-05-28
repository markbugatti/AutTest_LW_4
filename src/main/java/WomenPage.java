import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WomenPage {
    private WebDriver driver;

    By goodDescription = By.xpath("//p[@class='product-desc']");
//    By clothesElement = By.xpath("//ul[contains(@class, 'product_list')]/li[contains(@class, 'ajax_block_product')]");
    By clothesElement = By.xpath("//li[contains(@class, 'ajax_block_product')]");

    @FindBy(xpath = "//div[@id='block_top_menu']//a[contains(text(), 'Women')]")
    private WebElement WomenLink;

    @FindBy(xpath = "//ul[contains(@class, 'product_list')]")
    private WebElement ClothesList;

    @FindBy(xpath = "//a[contains(@style, '#F1C40F')]")
    private List<WebElement> YellowClothes;

    @FindBy(xpath = "//a[@rel='nofollow'][@href='#'][@title='List']")
    private WebElement listSwitch;


    public WomenPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickWomenLink() {
        WomenLink.click();
    }

    public int countGoods() {
        List<WebElement> ulChildren = ClothesList.findElements(clothesElement);
        return ulChildren.size();
    }

    public int countYellowGoods() {
        return YellowClothes.size();
    }

    public void switchListView() {
        listSwitch.click();
    }

    public boolean checkDescriptionExistance() {
        List<WebElement> list =  ClothesList.findElements(goodDescription);
        if(list.size() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void clickCloth(String clothName) {
        ClothesList.findElement(By.partialLinkText(clothName)).click();
    }


}
