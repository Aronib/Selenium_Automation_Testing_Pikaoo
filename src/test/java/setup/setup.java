package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.utils;

import javax.rmi.CORBA.Util;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class setup {
    public WebDriver driver;

    @BeforeTest
    public void setUp() throws IOException {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed");
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void screenShots(ITestResult result)throws IOException{
        if (ITestResult.FAILURE == result.getStatus()){
            try {
                utils utils = new utils(driver);
                utils.takeScreenShots();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    @AfterTest
    public void logout(){
        driver.close();
    }

}
