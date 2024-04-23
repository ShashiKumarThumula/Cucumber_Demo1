import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalWait {

    public static WebDriverWait wait;

    public static WebDriver driver;

    static {

        wait = new WebDriverWait(driver, 10);
    }
}
