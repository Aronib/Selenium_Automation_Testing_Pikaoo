package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver drive;
    @FindBy(xpath = "//body[1]/div[2]/section[1]/div[2]/div[1]/div[3]/div[1]/div[1]/a[1]")
    WebElement linkLogin;
    @FindBy(xpath = "//body/div[@id='__next']/main[1]/div[1]/div[2]/div[1]/div[2]/div[1]/center[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]")
    WebElement textEmail;
    @FindBy(xpath = "//body/div[@id='__next']/main[1]/div[1]/div[2]/div[1]/div[2]/div[1]/center[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
    WebElement textPass;
    @FindBy(xpath = "//body/div[@id='__next']/main[1]/div[1]/div[2]/div[1]/div[2]/div[1]/center[1]/div[1]/form[1]/div[1]/div[3]/button[1]")
    WebElement submitBut;

    @FindBy(xpath = "//body/div[@id='__next']/section[4]/div[3]/div[2]/div[2]/div[1]/center[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]")
    WebElement modalLoginTextEmail;

    @FindBy(xpath = "//body/div[@id='__next']/section[4]/div[3]/div[2]/div[2]/div[1]/center[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
    WebElement modalLoginPassword;

    @FindBy(xpath = "//body/div[@id='__next']/section[4]/div[3]/div[2]/div[2]/div[1]/center[1]/div[1]/form[1]/div[1]/div[3]/button[1]")
    WebElement modalLoginSubmitBtn;

    @FindBy(xpath = "//body/div[@id='__next']/section[1]/div[2]/div[1]/div[3]/div[1]/div[1]/*[1]")
    WebElement svg;
    @FindBy(xpath = "//body[1]/div[2]/section[1]/div[2]/div[1]/div[3]/div[2]/p[1]")
    WebElement myAccount;

    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    WebElement logOutBtn;

    public login(WebDriver driver){
        this.drive = driver;
        PageFactory.initElements(driver, this);
    }

    public void dologin (String email, String password) throws InterruptedException {
        linkLogin.click();
        Thread.sleep(10);
        textEmail.sendKeys(email);
        textPass.sendKeys(password);
        submitBut.click();
        Thread.sleep(5000);
        myAccount.click();
        logOutBtn.click();
        //Thread.sleep(10);

        //String rt = rtext.getText();


        //24mins

        //return rt;
    }

    public void doLoginForWrongEmail (String email, String password) throws InterruptedException {
        linkLogin.click();
        textEmail.sendKeys(email);
        textPass.sendKeys(password);
        submitBut.click();
        Thread.sleep(2000);
        // actualURL = driver.getCurrentUrl();



        //29mins vid 11

    }

}