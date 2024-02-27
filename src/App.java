import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

public class App {
    public static Integer count = 0;

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\nombr\\Proyecto Automation\\Proyecto 1\\src\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        options.addArguments("--enable-automation");
        options.addArguments("test-type=browsers");
        options.addArguments("disable-infobars");
        WebDriver driver = new ChromeDriver();

        try {
            // Test 01:Get into Website
            driver.get("https://www.jw.org/es/");
            Thread.sleep(3000);
            //System.out.println("Successfully getting the Home Page");
            Thread.sleep(3000);
            String Title = driver.getTitle();
            //System.out.println(Title);
            Assert.assertEquals(Title, "Sitio oficial de los testigos de Jehová: jw.org | español");
            App.WriteResultAssert();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            // Test 02:Get into Website
            String PageSource = driver.getPageSource();
            int pageSourceLength = PageSource.length();
            //System.out.println(pageSourceLength);
            Assert.assertEquals(pageSourceLength,191125);
            String CurrentUrl = driver.getCurrentUrl();
            //System.out.println(CurrentUrl);
            App.WriteResultAssert();
        } catch (AssertionError ex) {
            App.count++;
            System.out.println("========================================");
            System.out.println("Test #" + App.count + " failed");
            System.out.println("======================================== \n");
            System.out.println(ex);
        }

        try {
            // Test 03:Chrome Maximization
            driver.manage().window().maximize();
            //System.out.println("The chrome window is maximized");
            Thread.sleep(3000);
            WebElement p = driver.findElement(By.cssSelector("input[class=\'siteSearchKeywords\']"));
            p.sendKeys("jesus");
            p.submit();

            Thread.sleep(3000);

            App.WriteResultAssert();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        // driver.quit();

    }

    public static void WriteResultAssert() {
        App.count++;
        System.out.println("========================================");
        System.out.println("Test #" + App.count + " passed successfully!");
        System.out.println("======================================== \n");

    }
}
