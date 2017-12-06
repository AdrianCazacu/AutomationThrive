package ThriveLeads;

import org.junit.*;

/**
 * Created by pc on 11/24/2016.
 */
public class Test3_AddLeadThriveBox {

    @org.junit.Test

    public void addLeadThriveBox() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");

        ThriveLeads.Library library = new ThriveLeads.Library();
        library.manageWindow();
        library.Login();
        Thread.sleep(2000);
        library.GoToThriveLeads();
        library.addLeadThriveBoxes();

    }
}
