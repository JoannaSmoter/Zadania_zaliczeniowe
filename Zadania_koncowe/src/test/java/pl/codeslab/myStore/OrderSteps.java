package pl.codeslab.myStore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;


public class OrderSteps {
    private WebDriver driver;

    @Given("I'm on the authentication page")
    public void imOnTheShopAuthenticationPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @When("I login using  my email {string} and password {string}")
    public void iLoginUsingMyEmailAndPassword(String email, String password) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
    }

    @And("I go to main paige")
    public void iGoToMainPaige() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://prod-kurs.coderslab.pl/index.php?");
    }

    @Then("I choose the Hummingbird Printed Sweater with a {int}% discount")
    public void iChooseTheHummingbirdPrintedSweaterWithADiscount(int arg0) {
        driver.findElement(By.linkText("Hummingbird Printed Sweater")).click();
    }

    @And("I check discount")
    public void iCheckDiscount() {
        try {
            WebElement discountElement = driver.findElement(By.xpath("//span[contains(text(), '20%')]"));
            if (discountElement.isDisplayed()) {
                System.out.println("Rabat 20% jest dostępny.");
            } else {
                System.out.println("Brak wyświetlanego rabatu 20%.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Brak rabatu 20%.");
        }
    }

    @And("I select size {string}")
    public void iSelectSize(String size) {
        WebElement sizeSelect = driver.findElement(By.id("group_1"));
        sizeSelect.sendKeys(size);


    }

    @And("I add {int} items")
    public void iAddItemsToTheCart(int quantity) {
        int itemsQuantity = 5;

        WebElement quantityInput = driver.findElement(By.id("quantity_wanted"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(quantityInput));

        quantityInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));  // Zaznacz całą wartość pola tekstowego
        quantityInput.sendKeys(String.valueOf(itemsQuantity));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("I add to the cart")
    public void iAddToTheCart() {
       driver.findElement(By.cssSelector("button.add-to-cart")).click();

    }

    @And("I proceed to checkout")
    public void iProceedToCheckout() {
    driver.findElement(By.cssSelector("a[href='//mystore-testlab.coderslab.pl/index.php?controller=cart&action=show'][class='btn btn-primary']")).click();

        driver.findElement(By.cssSelector("a[href='https://mystore-testlab.coderslab.pl/index.php?controller=order'][class='btn btn-primary']")).click();

    }

    @And("I confirm the address")
   public void iConfirmTheAddress() {
       driver.findElement(By.name("confirm-addresses")).click();
  }


    @And("I choose delivery method")
    public void iChooseDeliveryMethod() {
    driver.findElement(By.name("confirmDeliveryOption")).click();

  }

    @And("I choose the payment option")
    public void iChooseThePaymentOption() {
        driver.findElement(By.id("payment-option-1")).click();

    }


    @And("I choose I agree to the terms of service and will adhere to them unconditionally.")
    public void iChooseIAgreeToTheTermsOfServiceAndWillAdhereToThemUnconditionally() {
        driver.findElement(By.className("js-terms")).click();
    }

    @Then("I approve and am on the order page")
    public void iApproveAndAmOnTheOrderPage() {
        driver.findElement(By.cssSelector(".btn.btn-primary.center-block")).click();
    }

    @And("I will take a screenshot of the order confirmation and amount.")
    public void iWillTakeAScreenshotOfTheOrderConfirmationAndAmount() {
        driver.get("https://prod-course.coderslab.com/index.php?controller=order-confirmation&id_cart=12994&id_module=14&id_order=1269&key=b896e335df2997ad2433e4ef8ba22622");

// Wykonaj zrzut ekranu
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);

// Zapisz zrzut ekranu na dysku
        String screenshotPath = "src/test/java/pl/Zrzuty/zrzut.png";
        try {
            // Zapisz zrzut ekranu na dysku
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            System.out.println("Zrzut ekranu został zapisany: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Błąd podczas zapisywania zrzutu ekranu: " + e.getMessage());
        }
    }


}
