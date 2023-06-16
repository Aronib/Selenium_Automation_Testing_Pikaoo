package testRunner;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.login;
import setup.setup;

import java.io.FileReader;
import java.util.concurrent.TimeUnit;

public class loginTestRunner extends setup{
    login objLogin;

    @BeforeTest
    public void url(){
        driver.get("https://www.pickaboo.com/");
    }

    @Test(priority = 1, description = "Correct Login")
    public void dologin() throws Exception{
        //driver.get("https://www.pickaboo.com/");
        objLogin = new login(driver);
        //JSONParser jasonParser = new JSONParser();
        //Object obj = jasonParser.parse(new FileReader("./src/test/resources/users.json"));
        //JSONObject jsonObject = (JSONObject) obj;

        //String email = (String) jsonObject.get("email");
        //String password = (String) jsonObject.get("password");

        //String user = objLogin.dologin("rawnak5738@gmail.com", "aroni5738");
        //Assert.assertEquals(user, "Test User");

        objLogin.dologin("rawnak5738@gmail.com", "aroni5738");
        Thread.sleep(5000);
        String expectedURL = "https://www.pickaboo.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        //Assert.assertEquals(user, "My Account");
    }

    @Test(priority = 2, description = "Incorrect Login")
    public void dologinWrongEmail() throws Exception{
        //driver.get("https://www.pickaboo.com/");
        objLogin = new login(driver);
        //JSONParser jasonParser = new JSONParser();
        //Object obj = jasonParser.parse(new FileReader("./src/test/resources/users.json"));
        //JSONObject jsonObject = (JSONObject) obj;

        //String email = (String) jsonObject.get("email");
        //String password = (String) jsonObject.get("password");

        //String user = objLogin.dologin("rawnak5738@gmail.com", "aroni5738");
        //Assert.assertEquals(user, "Test User");

        objLogin.doLoginForWrongEmail("rawnak57389@gmail.com", "aroni5738");
        Thread.sleep(5000);
        String expectedURL = "https://www.pickaboo.com/login/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        //Assert.assertEquals(user, "My Account");
    }


}