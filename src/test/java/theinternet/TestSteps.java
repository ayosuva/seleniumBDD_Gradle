package theinternet;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestSteps {
    private WebDriver driver;
    static String TestString;

    @Before
    public void setUp() {

            WebDriverManager.chromedriver().setup();


        if (driver == null) {
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless");
            //driver = new ChromeDriver(options);
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver!=null) {
            driver.close();
            driver.quit();
        }
    }

    @Given("A User Navigates to StatusCodes Page")
    public void aUserNavigatesToStatusCodesPage() {
        driver.navigate().to("https://the-internet.herokuapp.com/status_codes");
    }

    @When("A User Clicks on status Code {int}")
    public void aUserClicksOnStatusCodeInput(Integer inputCode) {
        driver.findElement(By.partialLinkText(inputCode.toString())).click();
    }

    @Then("Application displays the message {int}")
    public void applicationDisplaysTheMessageOutputCode(Integer outputCode) {
        String expectedMessage = "This page returned a "+outputCode.toString()+" status code.";
        String actualMessage = driver.findElement(By.cssSelector("h3 + p")).getText();

        assertThat(actualMessage, containsString(expectedMessage));
    }

    @Given ("Navigate to google home page")
    public void Navigate()
    {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://google.com");
        driver.findElement(By.xpath("//div[text()='I agree']")).click();
    }
    @When("A User enters a something")
    public void UserEnters()
    {
        driver.findElement(By.name("q")).sendKeys("Hello");
    }
    @And ("A User clicks on search button")
    public void click()
    {
        driver.findElement(By.name("q")).submit();
    }
    @Then ("Application shows that the search result")
    public void result(){
        driver.findElement(By.id("result-stats")).isDisplayed();
    }

    @And("Application displays the mess {string}")
    public void applicationDisplaysTheMessOutputCode(String text) {
        System.out.println(text);
    }


}
