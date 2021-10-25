package ru.praktikum.scooter;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderPageStep2 {
    //* Когда привезти самокат
    @FindBy(how = How.TAG_NAME,using = "placeholder=\"* Когда привезти самокат\"")
    private String fieldDeliveryDate;

    //* Срок аренды
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div[2]/div[2]/div[2]/div/div[1]")
    private String fieldRentalPeriod;

    //* CheckBox Color Scooter Black
    @FindBy(how = How.ID,using = "id=\"black\"")
    private String fieldColorScooterBlack;

    //* CheckBox Color Scooter Gray
    @FindBy(how = How.ID,using = "id=\"grey\"")
    private String fieldColorScooterGray;

    // placeholder="Комментарий для курьера"
    @FindBy(how = How.TAG_NAME,using = "placeholder=\"Комментарий для курьера\"")
    private String fieldCommentsForCourier;

    // Button Back
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div[2]/div[3]/button[1]")
    private String buttonBack;

    // Button Order
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[3]/button[2]")
    private String buttonOrder;

    // Button confirm order NO
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[1]")
    private String buttonConfirmOrderNo;

    // Button confirm order Yes
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]")
    private String buttonConfirmOrderYes;
}
