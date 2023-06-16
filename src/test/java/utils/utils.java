package utils;

import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.Pageable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class utils {
    WebDriver driver;
    public String password;
    public String email;
    /*{
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }*/

    public utils(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void takeScreenShots() throws IOException {
        File screenShots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-YYYY-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
        File destFile = new File(fileWithPath);
        FileUtils.copyFile(screenShots,destFile);

    }

    /*public void readJSON() throws IOException{
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(new FileReader("./src/test/resources/user"));
        JSONObject userObject = (JSONObject) object;
        
        setEmail((String)userObject.get("email"));
        setPassword((String)userObject.get("password"));
    }*/



}