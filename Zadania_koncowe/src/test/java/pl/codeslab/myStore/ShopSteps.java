package pl.codeslab.myStore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;



public class ShopSteps {
    private static WebDriver driver;

    @Given("I'm on the shop authentication page")
    public void imOnTheShopAuthenticationPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @When("I login using email {string} and password {string}")
    public void iLoginUsingEmailAndPassword(String email, String password) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
    }

    @And("I go to Addresses")
    public void iGoTo() {
        driver.findElement(By.linkText("Addresses")).click();

    }

    @Then("I click Create new address button")
    public void iClickButton() {
        driver.findElement(By.cssSelector("a[data-link-action = 'add-address']")).click();

    }

    @When("I enter new data alias {string}, address {string}, city {string}, postal code {string}, country {string}, phone number {string}")
    public void iEnterNewData(String alias, String address, String city, String postalCode, String country, String phoneNumber) {
        driver.findElement(By.name("alias")).sendKeys(alias);
        driver.findElement(By.name("address1")).sendKeys(address);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("postcode")).sendKeys(postalCode);
        driver.findElement(By.name("id_country")).sendKeys(country);
        driver.findElement(By.name("phone")).sendKeys(phoneNumber);

    }
    @And("I click Save")
    public void iClickSave() {
        driver.findElement(By.className("form-control-submit")).click();

    }
    @Then("I verify that the address is correct")
    public void iVerifyThatTheAddressIsCorrect() {
        WebElement addedAddress =driver.findElement(By.className("address-body"));
        String actualAddress = addedAddress.getText(); // pobranie adresu ze strony - jako adres aktualny
        String alias = "Ad1";
        String firstname = "Joanna";
        String lastname= "Smoter";
        String address = "Spokojna";
        String city = "Gaj";
        String postalCode = "35-123";
        String country = "United Kingdom";
        String phoneNumber = "55555555"; //statycznie zdefiniowane wartości - imię i nazwisko nie występowało w kroku w gherkinie.
        String expectedAddress = alias + "\n" +
                firstname  + " "+ lastname + "\n" +
                address + "\n" +
                city + "\n" +
                postalCode + "\n" +
                country + "\n" +
                phoneNumber; // adres połączony poprzez połączenie - taka struktura jest w kodzie strony, są w cudzysłowiach.
        Assertions.assertEquals(expectedAddress, actualAddress); //asercja do porównania oczekiwanego z aktualnym
        System.out.println("Adres jest poprawny");
    }

        @And("I close the browser")
        public void iCloseTheBrowser() {
            driver.quit();
    }

}





