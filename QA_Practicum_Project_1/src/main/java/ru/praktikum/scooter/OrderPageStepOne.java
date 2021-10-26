package ru.praktikum.scooter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderPageStepOne extends HeaderAndFoterOfPage {

    // Заказ * Имя
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input")
    private SelenideElement fieldFirstName;

    // Заказ * Фамилия
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input")
    private SelenideElement fieldSecondName;

    // Заказ * Адрес: куда привезти заказ
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input")
    private SelenideElement fieldAddress;

    // Заказ Станция метро
    @FindBy(how = How.CLASS_NAME,using = "select-search__input")
    private SelenideElement fieldMetroStation;

    // Заказ Станция метро список
    @FindBy(how = How.CLASS_NAME,using = "select-search__raw")
    private ElementsCollection listMetroStation;

    // Заказ Телефон: на него позвонит курьер
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input")
    private SelenideElement fieldPhoneNumber;

    // Button Next
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[3]/button")
    private SelenideElement buttonNext;

    public void setBuyerFirstName(String firstName) {
        fieldFirstName.setValue(firstName);
    }

    public void setBuyerSecondName(String secondName) {
        fieldSecondName.setValue(secondName);
    }

    public void setBuyerAddress(String address) {
        fieldAddress.setValue(address);
    }

    public void setMetroStation(String metroStation) {
        fieldMetroStation.shouldBe(Condition.visible).click();
        fieldMetroStation.setValue(metroStation).sendKeys(Keys.DOWN);
        fieldMetroStation.pressEnter();
    }

    public void setPhoneNumber(String phoneNumber) {
        fieldPhoneNumber.setValue(phoneNumber);
    }

    private void clickOnButtonNext() {
        buttonNext.scrollTo().shouldBe(Condition.visible).click();
    }

    public void orderConfirmationStepOne(String firstName,
                                         String secondName,
                                         String address,
                                         String metroStation,
                                         String setPhoneNumber)
    {
        setBuyerFirstName(firstName);
        setBuyerSecondName(secondName);
        setBuyerAddress(address);
        setMetroStation(metroStation);
        setPhoneNumber(setPhoneNumber);
        clickOnButtonNext();
    }
}
