package ThriveLeads;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by pc on 11/21/2016.
 */
public class Test {


    public void startDriver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver example = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(example, 30);

        example.manage().window().maximize();
        example.get("http://plugins.thrive-dev.bitstoneint.com/wp-login.php");
        example.findElement(By.xpath(".//*[@id='user_login']")).sendKeys("admin");
        example.findElement(By.xpath(".//*[@id='user_pass']")).sendKeys("asdasd");
        example.findElement(By.xpath(".//*[@id='wp-submit']")).click();
        Thread.sleep(3000);
        example.findElement(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/a/div[3]")).click();
        Thread.sleep(3000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'http://plugins.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tve_ult_dashboard')]")));

        example.findElement(By.xpath("//a[contains(@href,'http://plugins.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tve_ult_dashboard')]")).click();
        Thread.sleep(3000);
        //example.findElement(By.xpath("//h3[@class='tvd-title']")).sendKeys(Keys.END);

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tvd-modal-base']/div[1]/div[1]/div[1]/div[1]/div/img")));
        example.findElement(By.xpath("//i[contains(@class,'tvd-icon-plus tvd-icon-rounded tvd-icon-medium')]")).click();
        Thread.sleep(2000);
        example.findElement(By.xpath("//img[contains(@data-id,'0')]")).click();
        Thread.sleep(3000);
        example.findElement(By.id("tvu-new-campaign-name")).sendKeys("newtest");
        example.findElement(By.xpath(".//*[@id='tvd-modal-base']/div[2]/div[2]/div/div[2]/a")).click();
        Thread.sleep(2000);
        example.findElement(By.xpath(".//*[@id='tvu-campaign-settings']/div[1]/div/div[2]/div/div[2]/a")).click();
        example.findElement(By.xpath("//img[@src='http://plugins.thrive-dev.bitstoneint.com/wp-content/plugins/thrive-ultimatum/admin/img/tvd-absolute-campaign.png']")).click();
        example.findElement(By.xpath(".//*[@id='tvd-modal-base']/div[2]/div/div[2]/a")).click();

        Actions actions = new Actions(example);
        WebElement moveonmenu = example.findElement(By.xpath("//a[contains(.,'Howdy, admin')]"));
        WebElement submenu = example.findElement(By.cssSelector("#wp-admin-bar-logout a"));


        actions.moveToElement(moveonmenu).perform();
        Thread.sleep(3000);

        actions.moveToElement(submenu).perform();
        submenu.click();
    }

}
