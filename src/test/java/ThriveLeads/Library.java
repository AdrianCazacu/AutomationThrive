package ThriveLeads;

import ThriveOvation.GenerateData;
import org.junit.Assert;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

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
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='user_login']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='user_pass']")));

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

    public void GoToThriveLeads() throws InterruptedException {

        driver.findElement(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/a/div[3]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=tvo_admin_dashboard')]")));

        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[contains(@class,'wp-first-item current')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='toplevel_page_tve_dash_section']/ul/li[6]/a")));

        driver.findElement(By.xpath("//a[contains(@href,'http://adrian.thrive-dev.bitstoneint.com/wp-admin/admin.php?page=thrive_leads_dashboard')]")).click();



    }

    //GO TO TU DASHBOARD


    public void GoToThriveUltimatum() throws InterruptedException {



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


    //ADD LEAD ThriveBOXES

    public void addLeadThriveBoxes() throws InterruptedException {

        ThriveLeads.GenerateData genData = new ThriveLeads.GenerateData();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Add New ThriveBox']")));
        driver.findElement(By.xpath("//a[@title='Add New ThriveBox']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Add ThriveBox')]")));

        String boxName = genData.generateRandomString(6);
        driver.findElement(By.xpath("//input[@id='add-new-thrivebox-name']")).sendKeys(boxName);

        driver.findElement(By.xpath("//a[contains(.,'Add ThriveBox')]")).click();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tve-two-step-lightbox-list > li:last-child > div > div:nth-child(6) > span > a.tve-two-step-lightbox-settings.tvd-btn-icon.tvd-btn-icon-blue > span.tvd-on-large-and-down")).click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='tvd-waves-effect tvd-waves-light tvd-btn tvd-btn-gray tve-add-form']")));
        driver.findElement(By.xpath("//button[@class='tvd-waves-effect tvd-waves-light tvd-btn tvd-btn-gray tve-add-form']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='add-new-form-name']")).sendKeys(genData.generateRandomAlphaNumeric(5));
        driver.findElement(By.xpath("//a[@class='tvd-right tvd-waves-effect tvd-waves-light tvd-btn tvd-btn-green tve-add-form tvd-modal-submit']")).click();

        //Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tve-variation-list > tr > td.table-row-actions > div > a.tvd-btn-icon-solid.tvd-btn-icon-solid-blue.tvd-tooltipped > i")));

        driver.findElement(By.xpath("//a[contains(@title,'Edit Design')]")).click();

        Thread.sleep(9000);
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("The number of tabs open are: " + newTab.size());
        driver.switchTo().window(newTab.get(1));

        driver.switchTo().frame(driver.findElement(By.id("tve-editor-frame")));
        driver.findElement(By.xpath("//img[@src='http://adrian.thrive-dev.bitstoneint.com/wp-content/plugins/thrive-leads/editor-templates/screen_filler/thumbnails/three_set_v3.png']")).click();
        driver.findElement(By.xpath(".//*[@id='tve-leads-choose-template']/div")).click();

        driver.switchTo().defaultContent();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#tve_update_content > span.tve_expanded")).click();
        Thread.sleep(3000);
        driver.close();
        Thread.sleep(2000);
        driver.switchTo().window(newTab.get(0));
        driver.findElement(By.cssSelector("#tve-content > div.tl-hide-no-forms > a")).click();
        Thread.sleep(2000);
        String getList = driver.findElement(By.id("tve-two-step-lightbox-list")).getText();



        Assert.assertTrue("Thrive Box NOT created",getList.contains(boxName));


        driver.quit();

    }

    // ADD Lead SHORTCODES

    public void addLeadShortcodes() throws InterruptedException {
        ThriveLeads.GenerateData genData = new ThriveLeads.GenerateData();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Add New Lead Shortcode']")));
        driver.findElement(By.xpath("//a[@title='Add New Lead Shortcode']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tvd-modal-base > div.tvd-modal-footer > div > div:nth-child(2) > a")));


        driver.findElement(By.id("add-new-shortcode-name")).sendKeys(genData.generateRandomAlphaNumeric(6));

        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#tvd-modal-base > div.tvd-modal-footer > div > div:nth-child(2) > a")).click();

        Thread.sleep(3000);

        //Select last Edit button of Shortcode added
        driver.findElement(By.cssSelector("#tve-shortcode-list > li:last-child > div > div:nth-child(7) > span > a.tve-shortcode-settings.tvd-btn-icon.tvd-btn-icon-blue > span.tvd-on-large-and-down")).click();


    }
    public void addLead() throws InterruptedException {

        ThriveLeads.GenerateData genData = new ThriveLeads.GenerateData();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("tve-lead-add")));

        driver.findElement(By.id("tve-lead-add")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-new-group-name")));

        String leadName = genData.generateRandomString(10);
        driver.findElement(By.id("add-new-group-name")).sendKeys(leadName);
        driver.findElement(By.xpath("//a[contains(.,'Add Lead Group')]")).click();


        String leadname = driver.findElement(By.id("tve-group-list")).getText();
        Thread.sleep(1000);



        driver.findElement(By.cssSelector("#tve-group-list > li.collapse-table-list-item.tvd-collapsible.tve-expanded.tvd-active > div.tve-form-types.tvd-collapsible-body > div.tve-form-type-buttons.tve-clearfix > div > div:nth-child(1) > a")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//img[@src='http://adrian.thrive-dev.bitstoneint.com/wp-content/plugins/thrive-leads/admin/img/form_types/lightbox_a.png']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tve-group-list > li.collapse-table-list-item.tvd-collapsible.tve-expanded.tvd-active > div.tve-form-types.tvd-collapsible-body > div.tve-form-types-list.tvd-collection.tvd-collection-no-border > div.tve-form-type-item.tvd-collection-item > div > div.tvd-col.tvd-s3 > span > a.tvd-btn-icon.tvd-btn-icon-green.tve-form-type-add > span.tvd-on-large-and-down")).click();

        Thread.sleep(2000);

        //wait.until(ExpectedConditions.elementToBeClickable(By.className("tvd-waves-effect tvd-waves-light tvd-btn tvd-btn-gray tve-add-form")));
        driver.findElement(By.cssSelector("#tve-content > div.tl-show-no-forms.tvd-margin-top-big > div > div > div > button")).click();
        driver.findElement(By.id("add-new-form-name")).sendKeys(genData.generateRandomAlphaNumeric(5));
        driver.findElement(By.cssSelector("#tvd-modal-base > div.tvd-modal-footer > div > div:nth-child(2) > a")).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tve-variation-list > tr > td.table-row-actions > div > a.tvd-btn-icon-solid.tvd-btn-icon-solid-blue.tvd-tooltipped > i")).click();
        Thread.sleep(9000);



        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("The number of tabs open are: " + newTab.size());
        driver.switchTo().window(newTab.get(1));




        driver.switchTo().frame(driver.findElement(By.id("tve-editor-frame")));
        driver.findElement(By.cssSelector(".tve_landing_page_template:nth-child(3)")).click();







       driver.findElement(By.cssSelector("#tve-leads-choose-template > div")).click();
        driver.switchTo().defaultContent();

        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#tve_cpanel > div > div.tve_cpanel_sec.tve_control_btns > div.tve_btn_success.tve_left")).click();

        driver.close();

        driver.switchTo().window(newTab.get(0));
        driver.findElement(By.cssSelector("#tve-content > div.tl-hide-no-forms > a")).click();
        Thread.sleep(3000);

        String leadsList = driver.findElement(By.cssSelector("#tve-group-list")).getText();

        Thread.sleep(1000);

        Assert.assertTrue("Thrive Lead not created!!",leadsList.contains(leadName));


        String getLeadList = driver.findElement(By.cssSelector("#tve-group-list")).getCssValue("li");
        System.out.println(getLeadList);

        driver.quit();

    }

    public void deleteLead() throws InterruptedException {



        Thread.sleep(1000);

        //String name = driver.findElement(By.cssSelector("#tve-group-list > li:last-child")).getText();

        String name = driver.findElement(By.cssSelector(".collapse-table-list-item:last-child .group-title")).getText();

        System.out.println(name);

        driver.findElement(By.cssSelector(".collapse-table-list-item:last-child .tvd-icon-trash-o")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#tvd-modal-base > div.tvd-modal-footer > div > div:nth-child(2) > a")).click();

        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        String listItems = driver.findElement(By.cssSelector("#tve-group-list")).getText();
//        List<WebElement> lists = driver.findElements(By.cssSelector(".collapse-table-list-item .group-title"));
//
//
//
//        for(WebElement list:lists){
//           String itemsOnList =  list.getText();
//        }

        Assert.assertFalse("Thrive Lead Group NOT Deleted",listItems.contains(name));


//        #tve-lead-group-516 > div > div.tvd-col.tvd-s3 > div > a.tvd-tooltipped.tve-prevent-click.tve-group-delete.tvd-text-gray > span
//
//                #tve-lead-group-516 > div > div.tvd-col.tvd-s3 > div > a.tvd-tooltipped.tve-prevent-click.tve-group-delete.tvd-text-gray > span
//
//        tvd-icon-trash-o
        


        driver.quit();


    }

        public void deleteLeadThriveBox() throws InterruptedException {


                String name = driver.findElement(By.cssSelector("#tve-two-step-lightbox-list > li:last-child > div > div:nth-child(1) > div > div > span > span")).getText();
                driver.findElement(By.cssSelector("#tve-two-step-lightbox-list > li:last-child > div > div:nth-child(6) > span > a.tve-two-step-lightbox-delete.tvd-btn-icon.tvd-btn-icon-red > span.tvd-on-large-and-down")).click();
                Thread.sleep(2000);
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#tvd-modal-base > div.tvd-modal-footer > div > div:nth-child(2) > a"))));
                driver.findElement(By.cssSelector("#tvd-modal-base > div.tvd-modal-footer > div > div:nth-child(2) > a")).click();
                Thread.sleep(2000);
                driver.navigate().refresh();
                Thread.sleep(2000);
                String getList = driver.findElement(By.id("tve-two-step-lightbox-list")).getText();

                Assert.assertFalse("Thrive Box NOT deleted!!!!", getList.contains(name));


            driver.quit();

    }






    }




