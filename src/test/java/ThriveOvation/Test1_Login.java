package ThriveOvation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by pc on 11/15/2016.
 */
public class Test1_Login {

    @Test

    //Library library = new Library();
    public void verifyLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");

        Library library = new Library();
        library.manageWindow();
        library.Login();
        library.closeFirefox();


    }
}

