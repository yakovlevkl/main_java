package ru.praktikum.scooter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Objects;

public class OrderPageStepTwo extends OrderPageStepOne {
    //* Когда привезти самокат
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input")
    private SelenideElement fieldDeliveryDate;

    //* Срок аренды
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div[2]/div[2]/div[2]/div/div[1]")
    private SelenideElement fieldRentalPeriod;

    //* Срок аренды список
    @FindBy(how = How.CLASS_NAME,using = "Dropdown-option")
    private ElementsCollection listRentalPeriod;

    //* CheckBox Color Scooter Black //*[@id="root"]/div/div[2]/div[2]/div[3]/label[1]
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/label[1]")
    private SelenideElement fieldColorScooterBlack;

    //* CheckBox Color Scooter Gray
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/label[2]")
    private SelenideElement fieldColorScooterGray;

    // placeholder="Комментарий для курьера"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input")
    SelenideElement fieldCommentsForCourier;

    // Button Back
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div[2]/div[3]/button[1]")
    private SelenideElement buttonBack;

    // Button Order //*[@id="root"]/div/div[2]/div[3]/button[2]
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[3]/button[2]")
    private SelenideElement buttonOrder;

    // Button confirm order NO
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[1]")
    private SelenideElement buttonConfirmOrderNo;

    // Button confirm order Yes
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]")
    private SelenideElement buttonConfirmOrderYes;

    //Форма подтверждения заказа да нет //*[@id="root"]/div/div[2]/div[5]
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[5]")
    private SelenideElement formConfirmOrder;

    void setDeliveryDate(String deliveryDate) {
        fieldDeliveryDate.shouldBe(Condition.visible).click();
        fieldDeliveryDate.setValue(deliveryDate).pressEnter();
    }

    void setRentalPeriod(String rentalPeriod) {
        fieldRentalPeriod.shouldBe(Condition.visible).click();
        SelenideElement element = listRentalPeriod.get(0);
        element.scrollTo().shouldBe(Condition.visible).click();
    }

    void setColorScooter(String scooterColor) {
        if (Objects.equals(scooterColor, "black")) {
            fieldColorScooterBlack.shouldBe(Condition.visible).click();
        } else {
            fieldColorScooterGray.shouldBe(Condition.visible).click();
        }
    }

    void setCommentsForCourier(String commentsForCourier) {
        fieldCommentsForCourier.shouldBe(Condition.visible).setValue(commentsForCourier);
    }

    void clickButtonOrder() {
        buttonOrder.scrollTo().shouldBe(Condition.visible).click();
    }

    void clickButtonConfirmOrderYes() {
        buttonConfirmOrderYes.scrollTo().shouldBe(Condition.visible).click();
    }

    void controlformConfirmOrder() {
        if (formConfirmOrder.isDisplayed()) {
            System.out.println("Окно подтвердления заказа не закрылось [Fail]");
            clickButtonOrder();
        }
    }

    public void orderConfirmationStepTwo(String deliveryDate,
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
        controlformConfirmOrder();
    }
}
