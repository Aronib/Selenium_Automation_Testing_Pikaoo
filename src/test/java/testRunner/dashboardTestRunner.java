package testRunner;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.setup;
import pages.dashboard;
import pages.login;

import java.io.IOException;

public class dashboardTestRunner extends setup {
    dashboard objDashboard;
    login objLogin;

    @BeforeTest
    public void dologin() throws Exception{
        driver.get("https://www.pickaboo.com/");
        objLogin = new login(driver);
        objLogin.dologin("rawnak5738@gmail.com", "aroni5738");
    }

    @Test (priority = 1, description = "Cart Icon Test")
    public void cartItemT() throws InterruptedException {
        objDashboard = new dashboard(driver);
        String cartHeader = objDashboard.cartItem();
        Assert.assertTrue(cartHeader.contains("My Cart"));
    }

    @Test (priority = 2, description = "Search Bar")
    public void checkSearchT() throws IOException, InterruptedException {
        objDashboard = new dashboard(driver);
        String searchResult = objDashboard.checkSearch();
        Assert.assertTrue((searchResult.contains("mobile")));
    }

    @Test (priority = 3, description = "Navbar")
    public void sideNavCheckT() throws IOException, InterruptedException {
        objDashboard = new dashboard(driver);
        String sideNavResult = objDashboard.sideNavCheck();
        Assert.assertEquals(sideNavResult, "Smartphones");
    }

    @Test (priority = 4, description = "Fast Delivery")
    public void fastDeliveryT() throws IOException, InterruptedException {
        objDashboard = new dashboard(driver);
        String fastDeliveryResult = objDashboard.fastDeliveryCheck();
        Assert.assertEquals(fastDeliveryResult, "What is Fastpick Express and how it works?");
    }

    @Test (priority = 5, description = "Best Selling Icon")
    public void bestSellingT() throws IOException, InterruptedException {
        objDashboard = new dashboard(driver);
        objDashboard.bestSellingCheck();
        String bestSellingResult = objDashboard.bestSellingCheck();
        Assert.assertEquals(bestSellingResult, "Best Selling Products");
    }

    @Test (priority = 6, description = "Brand Specific Search")
    public void brandSearchT() throws IOException, InterruptedException {
        objDashboard = new dashboard(driver);
        //objDashboard.brandSearch();
        String brandSearchResult = objDashboard.brandSearch();
        Thread.sleep(10);
        Assert.assertEquals(brandSearchResult, "ASUS");
    }

    /* @Test ()
    public void chatIconT() throws IOException, InterruptedException {
        objDashboard = new dashboard(driver);
        //objDashboard.brandSearch();
        String chatIconResult = objDashboard.chatIconTest();
        Thread.sleep(10);
        Assert.assertEquals(chatIconResult, "Leave a Message");
    }*/

}
