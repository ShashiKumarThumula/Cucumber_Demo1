package steps;

import actions.GlobalWait;
import framework.Configuration;
import framework.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Keka_Steps {
    WebDriver driver;


    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        DesiredCapabilities cap = new DesiredCapabilities();
        Driver.add(Configuration.get("browser"), cap);
        driver = Driver.current();
        driver.get(Configuration.get("url"));
        driver.manage().window().maximize();
        GlobalWait.setDriver(driver);
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName() + "_screenshot");
        }
        //driver.quit();
        Thread.sleep(1000);
    }


    public WebDriver getDriver() {
    return driver;
    }
}
