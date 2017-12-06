package ThriveOvation;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.awt.*;

/**
 * Created by pc on 11/15/2016.
 */
public class Library {



    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);


    //VERIFY LOGIN

    public void Login() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\D:\\Automation\\chromedriver_win32\\chromedriver.exe");

        //WebDriver driver = new FirefoxDriver();
        driver.get("http://adrian.thrive-dev.bitstoneint.com/wp-admin/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='user_login']")));

        driver.findElement(By.xpath(".//*[@id='user_login']")).sendKeys("admin");
        driver.findElement(By.xpath(".//*[@id='user_pass']")).sendKeys("Vi7(tWqJr9Uf@mWugX(Q4qR^");
        driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();




        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/a/div[3]")));
        Assert.assertEquals("Dashboard ‹ Adrian Dev Site — WordPress", driver.getTitle());
    }

    //GO TO TO DASHBOARD

    public void GoToThriveOvation() throws InterruptedException {
        driver.findElement(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/a/div[3]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tvo_admin_dashboard')]")));

        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tvo_admin_dashboard')]")).click();
        Thread.sleep(1000);
        //driver.findElement(By.linkText("http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tvo_admin_dashboard")).click();
    }


    //GO TO TL DASHBOARD

    public void GoToThriveLeads() {
        driver.findElement(By.xpath("//a[contains(@class,'wp-first-item current')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/ul/li[6]/a")));

        driver.findElement(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=thrive_leads_dashboard')]")).click();

    }

    //GO TO TU DASHBOARD

    public void GoToThriveUltimatum() {
        driver.findElement(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/a/div[3]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tve_ult_dashboard')]")));

        driver.findElement(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tve_ult_dashboard')]")).click();
    }


    //GO TO THO DASHBOARD

    public void GoToThriveHeadOptimizer() {
        driver.findElement(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/a/div[3]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tho_admin_dashboard')]")));

        //driver.findElement(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/ul/li[5]/a")).click();
        driver.findElement(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tho_admin_dashboard')]")).click();
    }

    //MANAGE BROWSER WINDOW

    public void manageWindow() {
        driver.manage().window().maximize();

    }


    //CLOSE BROWSER
    public void closeFirefox() {

        driver.quit();
    }


    //ADD NEW TESTIMONIAL AND VERIFY
    public void addNewTestimonial() throws InterruptedException {

        GenerateData generateData = new GenerateData();

        driver.findElement(By.xpath("//a[@class='tvo-add-new-testimonial tvd-waves-effect tvd-waves-light tvd-btn tvd-btn-blue tvd-left']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'tvo-title')]")));

        driver.switchTo().activeElement();

        WebElement title = driver.findElement(By.xpath("//input[contains(@id,'tvo-title')]"));
        title.click();
        title.sendKeys("Automated Test - Testimonial 1");
        //driver.findElement(By.xpath("//input[contains(@id,'tvo-title')]")).sendKeys("Automated Test - Testimonial 1");
        Thread.sleep(500);

        WebElement name = driver.findElement(By.id("tvo-author-name"));
        name.click();
        String storename = generateData.generateRandomString(10) + " " + generateData.generateStringWithAllobedSplChars(15,"abcdefghijklmnop");
        name.sendKeys(storename);



        //driver.findElement(By.xpath("//label[contains(@for,'tvo-author-name')]")).sendKeys("Luke Skywalker");
        Thread.sleep(500);

        WebElement email = driver.findElement(By.id("tvo-author-email"));
        email.click();
        email.sendKeys(generateData.generateEmail(20));

        //driver.findElement(By.xpath("//label[contains(@for,'tvo-author-email')]")).sendKeys("luke.skywalker@email.com");
        Thread.sleep(500);

        WebElement role = driver.findElement(By.id("tvo-author-role"));
        role.click();
        role.sendKeys(generateData.generateRandomString(10));



        //driver.findElement(By.xpath("//label[contains(@for,'tvo-author-role')]")).sendKeys("QA Jedi");
        Thread.sleep(500);

        driver.switchTo().frame(driver.findElement(By.id("tvo-testimonial-content-tinymce_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys(generateData.generateRandomAlphaNumeric(60) + Keys.PAGE_DOWN);
        driver.switchTo().defaultContent();


        driver.findElement(By.xpath("//a[contains(@class,'tvo-save-new-testimonial tvd-waves-effect tvd-waves-light tvd-btn tvd-btn-green tvd-right')]")).click();

        driver.switchTo().defaultContent();

        driver.navigate().refresh();
        Thread.sleep(2000);
        String text = driver.findElement(By.id("tvo-testimonials-list")).getText();


        Assert.assertTrue("Testimonial not found",text.contains(storename));


    }


    //LOGOUT FROM WORDPRESS
    public void logout() throws InterruptedException {


        Actions actions = new Actions(driver);
        WebElement moveonmenu = driver.findElement(By.xpath("//a[contains(.,'Howdy, admin')]"));
        WebElement submenu = driver.findElement(By.cssSelector("#wp-admin-bar-logout a"));

        actions.moveToElement(moveonmenu).perform();
        Thread.sleep(3000);

        actions.moveToElement(submenu).perform();
        submenu.click();

        Assert.assertEquals("Adrian Dev Site ‹ Log In",driver.getTitle());
        //Thread.sleep(2000);





                //moveToElement(driver.findElement(By.xpath("//a[contains(@class,'ab-item')]"))).click();

                //moveToElement(driver.findElement(By.xpath("//a[contains(.,'Log Out')]"))).click().perform();


    }




    }




