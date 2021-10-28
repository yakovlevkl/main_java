package ru.praktikum.scooter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

class OrderPageStepOne extends MainPage {

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

    // Visible Error Values
    @FindBy(how = How.CLASS_NAME,using = "Input_ErrorMessage__3HvIb")
    private ElementsCollection errorValues;

    // Visible Error Value Metro          Order_MetroError__1BtZb
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div[2]")
    private SelenideElement errorValueMetro;

    String getErrorValues(int number){
        return errorValues.get(number).getText();
    }

    private void setBuyerFirstName(String firstName) {
        if (!firstName.equals("")) {
            fieldFirstName.setValue(firstName);
        }
    }

    private void setBuyerSecondName(String secondName) {
        if (!secondName.equals("")) {fieldSecondName.setValue(secondName);}
    }

    private void setBuyerAddress(String address) {
        if (!address.equals("")) {fieldAddress.setValue(address);}
    }

    private void setMetroStation(String metroStation) {
        if (!metroStation.equals("")) {
            fieldMetroStation.shouldBe(Condition.visible).click();
            fieldMetroStation.setValue(metroStation).sendKeys(Keys.DOWN);
            fieldMetroStation.pressEnter();
        }
    }

    private void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.equals("")) {fieldPhoneNumber.setValue(phoneNumber);}
    }

    private void clickOnButtonNext() {
        buttonNext.scrollTo().shouldBe(Condition.visible).click();
    }

    void orderConfirmationStepOne(String firstName,
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

    ElementsCollection errorOnOrderForm(){
        return errorValues;
    }

    SelenideElement errorOnOrderFormValueMetro(){
        return errorValueMetro;
    }

}
