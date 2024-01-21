package io.cucumber.skeleton;

import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

public class WebStepDefinitions {



    private static WebDriver driver;
    private Scenario scenario;

    @BeforeAll
    public static void setUp() {
        // This property is optional.
        // If not specified, WebDriver searches the path for chromedriver in your environment variables
        // Example path for Linux or Mac:
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        options.addArguments("--disable-extensions");


        driver = new ChromeDriver(options);
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("the user is on {string}" )
    public void userGoToThePage(String page){
        driver.get(page);
    }

    @When("the user signs in with credentials: user={string} and password = {string}")
    public void userInputsCredentials(String user,String password) {
        By byXPath = By.xpath("//input[@id='CustomerEmail']"); //seleccionar elemento en el html o css
        WebElement element = driver.findElement(byXPath); //coger el texto de username
        element.sendKeys(user);
        byXPath = By.xpath("//input[@id='CustomerPassword']"); //seleccionar elemento en el html o css
        element = driver.findElement(byXPath); //coger el texto de username
        element.sendKeys(password);
        element.submit();
        //si ha encontrado algun elemento que tenga un texto como el que le he pasado pñor string
    }
    @Then("the user should be in {string}")
    public void changePage(String page)
    {
        String newLink = driver.getCurrentUrl();
        boolean present = Objects.equals(newLink, page);
        Assertions.assertTrue(present);
    }
    @Then("the user sees message type={string} class={string} text={string}")
    public void invalidUser(String tag, String clase, String text)
    {
        By byXPath = By.xpath("//"+tag+"[@class='"+clase+"']");
        WebElement element= driver.findElement(byXPath);
        boolean present = element.getText().contains(text);
        Assertions.assertTrue(present);
    }

    @When("the user clicks button {string}")
    public void iClickOnButton(String button_text) {
        driver.findElement(By.linkText(button_text)).click();
    }
    @When("the user chooses button {string}")
    public void buttonText(String button)
    {
        By byXPath = By.xpath("//div[contains(text(), '"+button+"')]");
        WebElement element = driver.findElement(byXPath);
        element.click();
    }

    @And("the user inputs her mail {string}")
    public void emailRec(String email) {
        By byXPath = By.xpath("//input[@id='RecoverEmail']");
        WebElement element= driver.findElement(byXPath);
        element.sendKeys(email);
        element.submit();
    }
    @When("the user signs up with credentials: user={string} and password = {string}")
    public void userSignUp(String email, String password)
    {

        By byXPath = By.xpath("//html/body/div[1]/main/div/div[2]/div/div/div/div[2]/input"); //seleccionar elemento en el html o css
        WebElement element = driver.findElement(byXPath); //coger el texto de username
        element.sendKeys(email);
        byXPath = By.xpath("//html/body/div[1]/main/div/div[2]/div/div/div/div[3]/div/input"); //seleccionar elemento en el html o css
        element = driver.findElement(byXPath); //coger el texto de username
        element.sendKeys(password);
        byXPath = By.xpath("/html/body/div[1]/main/div/div[2]/div/div/div/div[5]/button");
        element = driver.findElement(byXPath);
        element.click();
        //element.submit();
    }
    @And("the user checks button {string}")
    public void clicksPolicy(String button)
    {
        By byXPath = By.xpath("//input[@id='"+button+"']"); //seleccionar elemento en el html o css
        WebElement element = driver.findElement(byXPath); //coger el texto de username
        element.click();
    }
    @When("the user selects the {string} button {string} type")
    public void selectsButton(String button, String type)
    {
        By byXPath = By.xpath("//"+type+"[@class='"+button+"']"); //seleccionar elemento en el html o css
        WebElement element = driver.findElement(byXPath); //coger el texto de username
        element.click();
    }

    @And("the user selects option : {string}")
    public void orderBy(String option)
    {
        By byXPath = By.xpath("//*[@id='wrapper']/section/div[2]/div[1]/div/div[4]/ul/li[3]"); //seleccionar elemento en el html o css
        WebElement element = driver.findElement(byXPath); //coger el texto de username
        element.click();
    }
    @Then("the {string} window opens")
    public void openWindow(String window)
    {
        try {
            By byXPath = By.xpath("//div[@class='" + window + "']");
            WebElement element = driver.findElement(byXPath);
            Assertions.assertTrue(true);
        } catch (NoSuchElementException e) {
            Assertions.assertTrue(false);
        }
    }
    @And("the user search {string}")
    public void search(String product)
    {
        By byXPath = By.xpath("//input[@id='search-input']"); //seleccionar elemento en el html o css
        WebElement element = driver.findElement(byXPath); //coger el texto de username
        element.sendKeys(product);
        element.sendKeys(Keys.RETURN);
    }
    @Then("the {string} delete")
    public void deleteDiv(String window)
    {
        try {
            By byXPath = By.xpath("//div[@id='"+window+"']");
            WebElement element = driver.findElement(byXPath);
        } catch (NoSuchElementException e) {
            Assertions.assertTrue(true);
        }

    }
    @And ("the user move mouse on {string} button")
    public void moveMouse(String button)
    {
        Actions action = new Actions(driver);
        By byXPath = By.xpath("/html/body/header/nav/ul/li[7]");
        WebElement element = driver.findElement(byXPath);
        action.moveToElement(element).build().perform();
    }

    @And("the user selects {string} option")
    public void selectOption(String option)
    {
        By byXPath = By.xpath("//*[@id='wrapper']/main/section[1]/div/div/aside/div[1]/form/div[3]/div[2]/label/select");
        Select options = new Select(driver.findElement(byXPath));
        options.selectByVisibleText(option);
    }
    @Then ("the users sees {string} icon")
    public void iconVisible(String icon)
    {
        try {
            By byXPath = By.xpath("//*[@id='wrapper']/main/section[1]/div/div/aside/div[1]/form/div[3]/div[2]/div/span[5]");
            WebElement element = driver.findElement(byXPath);
            Assertions.assertTrue(true);
        } catch (NoSuchElementException e) {
            Assertions.assertTrue(false);
        }
    }
    @When("the user selects {string} size")
    public void selectSize(String size)
    {
        By byXPath = By.xpath("//*[@id='wrapper']/main/section[1]/div/div/aside/div[1]/form/div[3]/div[2]/div/span[4]");
        WebElement element = driver.findElement(byXPath);
        element.click();
    }


    @AfterAll()
    public static void tearDown() {
        driver.quit();
    }

}
