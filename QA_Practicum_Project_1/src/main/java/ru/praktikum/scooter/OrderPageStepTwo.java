package ru.praktikum.scooter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


class OrderPageStepTwo extends OrderPageStepOne {
    //* Когда привезти самокат
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input")
    private SelenideElement fieldDeliveryDate;

    //* Срок аренды
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div[2]/div[2]/div[2]/div/div[1]")
    private SelenideElement fieldRentalPeriod;

    //* Срок аренды список
    @FindBy(how = How.CLASS_NAME,using = "Dropdown-option")
    private ElementsCollection listRentalPeriod;

    //* CheckBox Color Scooter Black
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/label[1]")
    private SelenideElement fieldColorScooterBlack;

    //* CheckBox Color Scooter Gray
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/label[2]")
    private SelenideElement fieldColorScooterGray;

    // placeholder="Комментарий для курьера"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input")
    SelenideElement fieldCommentsForCourier;

    // Button Back
    @FindBy(how = How.CLASS_NAME,using = "Button_Inverted__3IF-i")
    private SelenideElement buttonBack;

    // Button Order
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[3]/button[2]")
    private SelenideElement buttonOrder;

    // Button confirm order NO
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[1]")
    private SelenideElement buttonConfirmOrderNo;

    // Button confirm order Yes
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]")
    private SelenideElement buttonConfirmOrderYes;

    //Форма подтверждения заказа да нет
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[5]")
    private SelenideElement formConfirmOrder;

    //Форма оформленного заказа "Заказ оформлен"
    @FindBy(how = How.CLASS_NAME,using = "Order_ModalHeader__3FDaJ")
    private SelenideElement formOrderAccepted;


    void clickButtonBack(){
        buttonBack.scrollTo().shouldBe(Condition.visible).click();
    }

    private void setDeliveryDate(String deliveryDate) {
        fieldDeliveryDate.shouldBe(Condition.visible).click();
        fieldDeliveryDate.setValue(deliveryDate).pressEnter();
    }

    private void setRentalPeriod(String rentalPeriod) {
        fieldRentalPeriod.shouldBe(Condition.visible).click();
        SelenideElement element = listRentalPeriod.get(0);
        element.scrollTo().shouldBe(Condition.visible).click();
    }

    private void setColorScooter(String scooterColor) {
        if (scooterColor.equals("black")) {
            fieldColorScooterBlack.shouldBe(Condition.visible).click();
        } else {
            fieldColorScooterGray.shouldBe(Condition.visible).click();
        }
    }

    private void setCommentsForCourier(String commentsForCourier) {
        fieldCommentsForCourier.shouldBe(Condition.visible).setValue(commentsForCourier);
    }

    private void clickButtonOrder() {
        buttonOrder.scrollTo().shouldBe(Condition.visible).click();
    }

    private void clickButtonConfirmOrderYes() {
        buttonConfirmOrderYes.scrollTo().shouldBe(Condition.visible).click();
    }

    Boolean controlFormConfirmOrder() {
        return buttonConfirmOrderYes.isDisplayed();
    }

    Boolean isOrderAccepted(){
        return formOrderAccepted.getText().contains("Заказ оформлен");
    }

    void orderConfirmationStepTwo(String deliveryDate,
                                  String rentalPeriod,
                                  String scooterColor,
                                  String commentsForCourier)
    {
        setDeliveryDate(deliveryDate);
        setRentalPeriod(rentalPeriod) ;
        setColorScooter(scooterColor);
        setCommentsForCourier(commentsForCourier);
        clickButtonOrder();
        clickButtonConfirmOrderYes();
    }
}
