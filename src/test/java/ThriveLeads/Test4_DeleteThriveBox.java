package ThriveLeads;

/**
 * Created by pc on 11/24/2016.
 */
public class Test4_DeleteThriveBox {

    @org.junit.Test

    public void deleteLeadThriveBox() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");

        ThriveLeads.Library library = new ThriveLeads.Library();
        library.manageWindow();
        library.Login();
        Thread.sleep(2000);
        library.GoToThriveLeads();
        library.deleteLeadThriveBox();

    }
}
