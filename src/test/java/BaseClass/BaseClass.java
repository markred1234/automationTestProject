package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseClass {

    protected static WebDriver driver;
    protected String appurl = "";
    UIMap datafile;
    String workingDir;
    public String userName;
    public String password;

    @BeforeTest(alwaysRun = true)
    @Parameters({"appurl"})
    public void setUp(String _appurl) throws InterruptedException {

        //Get current working directory and load the data file
        workingDir = System.getProperty("user.dir");
        datafile = new UIMap(workingDir + "/src/test/resources/datafile.properties");
        userName = datafile.getData("userName");
        password = datafile.getData("password");

        //Chrome Options

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        System.out.println("Operating System:" + System.getProperty("os.name"));
        System.setProperty("webdriver.chrome.driver", "WebDrivers/chromedriver.exe");
        System.out.println("******************************************");
        System.out.println("Launching Chrome browser");
        try {
            driver = new ChromeDriver(options);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        driver.manage().window().maximize();

        appurl = _appurl;

        driver.navigate().to(appurl);


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
