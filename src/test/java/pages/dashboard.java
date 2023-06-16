package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class dashboard {
    WebDriver driver;
    @FindBy(xpath = "//body[1]/div[2]/section[1]/div[2]/div[1]/div[3]/div[3]/p[1]")
    WebElement cartIcon;
    @FindBy(xpath = "//h2[contains(text(),'My Cart (0)')]")
    WebElement cartLblText; //problemo
    @FindBy(xpath = "//body[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]")
    WebElement contShopping;
    @FindBy(xpath = "//body/div[@id='__next']/section[1]/div[2]/div[1]/div[2]/form[1]/input[1]")
    WebElement searchBar;

    @FindBy(xpath = "//body/div[@id='__next']/section[1]/div[2]/div[1]/div[2]/form[1]/button[1]")
    WebElement searchBtn;

    @FindBy(xpath = "//h1[contains(text(),'Search Result for \"mobile\"')]")
    WebElement searchLbl;

    @FindBy(xpath = "//body/div[@id='__next']/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")
    WebElement sideNavElement; // list of elements in side navbar

    @FindBy(xpath = "//h1[contains(text(),'Smartphones')]")
    WebElement sNvLabelCheck; //Assert side navbar elements.

    @FindBy(xpath = "//body/div[@id='__next']/main[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/img[1]")
    WebElement fastDelivery; //round icon blue

    @FindBy(xpath = "//span[contains(text(),'What is Fastpick Express and how it works?')]")
    WebElement fastDeliveryLbl;

    @FindBy(xpath = "//body[1]/div[2]/main[1]/div[1]/section[4]/div[1]/div[1]/div[2]/a[1]/div[1]/a[1]")
    WebElement bestSellingBtn; //first section view all products // xpath problem

    @FindBy(xpath = "//h1[contains(text(),'Best Selling Products')]")
    WebElement getBestSellingLbl;

    @FindBy(xpath = "//a[contains(text(),'Asus')]")
    WebElement brandAsusBtn; // at the bottom section

    @FindBy(xpath = "//h1[contains(text(),'ASUS')]")
    WebElement getBrandAsusLbl;

    @FindBy(xpath = "//div[@id='reve-chat-widget-header']")
    WebElement chatWithicon;

    @FindBy(xpath = "//body[1]/div[9]/div[1]/div[1]/div[1]/p[1]")
    WebElement chatAssert;

    @FindBy(xpath = "//body[1]/div[8]/div[1]/div[1]")
    WebElement chatClose;

    @FindBy(xpath = "//body/div[@id='__next']/section[1]/div[2]/div[1]/div[1]/a[1]/img[1]")
    WebElement pikabooLogoBackbtn;
    public WebDriverWait wait;

    public dashboard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String cartItem() throws InterruptedException {
        cartIcon.click();
        wait = new WebDriverWait(driver, 30);
        String cartHeaderCheck = cartLblText.getText();
        wait = new WebDriverWait(driver, 30);
        pikabooLogoBackbtn.click();
        Thread.sleep(10);
        return cartHeaderCheck;
    }
    
    public String checkSearch() throws IOException, InterruptedException {
        searchBar.sendKeys("mobile");
        //wait = new WebDriverWait(driver, 20);
        Thread.sleep(10);
        searchBtn.click();
        String searchHeaderCheck = searchLbl.getText();
        pikabooLogoBackbtn.click();
        return  searchHeaderCheck;
    }

    public String sideNavCheck()throws IOException{
        sideNavElement.click();
        String sideNavLCheck = sNvLabelCheck.getText();
        pikabooLogoBackbtn.click();
        return sideNavLCheck;
    }

    public String fastDeliveryCheck()throws IOException{
        fastDelivery.click();
        String fastDeliveryLable = fastDeliveryLbl.getText();
        pikabooLogoBackbtn.click();
        return fastDeliveryLable;
    }

    public String bestSellingCheck()throws IOException{
        //to perform Scroll on application using Selenium
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(1136,536)", "");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", bestSellingBtn);
        bestSellingBtn.click();
        //driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[1]/section[4]/div[1]/div[1]/div[2]/a[1]/div[1]/a[1]")).click();
        String bestSellingLblCheck = getBestSellingLbl.getText();
        pikabooLogoBackbtn.click();
        return bestSellingLblCheck;
    }

    public String brandSearch()throws IOException{
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandAsusBtn);
        brandAsusBtn.click();
        //driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/section[10]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]")).click();
        String brandAsusLblCheck = getBrandAsusLbl.getText();
        pikabooLogoBackbtn.click();
        return brandAsusLblCheck;
    }

    public String chatIconTest() throws IOException, InterruptedException {
        chatWithicon.click();
        //wait = new WebDriverWait(driver, 10);
        //boolean status = wait.until(ExpectedCondition.elementToBeClickable(By.xpath("div.animated.slideInUp.modern-theme-body.right.body-maximized:nth-child(12) div.chat-main.online-no-social-login.three-fields:nth-child(1) div.chat-form-info div.form-row.chat-online-form-name:nth-child(5) > label:nth-child(1)"))).getText();
        //WebElement chatLblCheck = ;
        Thread.sleep(10);
        String result = chatAssert.getText();
        chatClose.click();
        return result;
    }

}
