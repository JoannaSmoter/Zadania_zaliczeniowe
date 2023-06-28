package pl.codeslab.myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Address {
    private static WebDriver driver;

    @FindBy(id = "field-alias")
    WebElement newAliasInput;

    @FindBy(id = "field-address1")
    WebElement newAddressInput;

    @FindBy(id = "field-postcode")
    WebElement newPoscodeInput;

    @FindBy(id = "field-id_country")
    WebElement newCountryInput;

    @FindBy(id = "field-phone")
    WebElement newphoneInput;

    public Address(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
