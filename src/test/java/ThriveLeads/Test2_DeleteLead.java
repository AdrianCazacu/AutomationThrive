package ThriveLeads;

import org.junit.Test;

/**
 * Created by pc on 11/17/2016.
 */
public class Test2_DeleteLead {
    @Test

    public void deleteLead() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");


        ThriveLeads.Library library = new ThriveLeads.Library();
        library.manageWindow();
        library.Login();
        library.GoToThriveLeads();
        Thread.sleep(2000);
        library.deleteLead();




    }
}
