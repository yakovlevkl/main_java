package ru.praktikum.scooter;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderPageStep1 {

    // Заказ * Имя
    @FindBy(how = How.TAG_NAME,using = "placeholder=\"* Имя\"")
    private String fieldFirstName;

    // Заказ * Фамилия
    @FindBy(how = How.TAG_NAME,using = "placeholder=\"* Фамилия\"")
    private String fieldSecondName;

    // Заказ * Адрес: куда привезти заказ
    @FindBy(how = How.TAG_NAME,using = "placeholder=\"* Адрес: куда привезти заказ\"")
    private String fieldAddress;

    // Заказ Станция метро
    @FindBy(how = How.TAG_NAME,using = "placeholder=\"* Станция метро\"")
    private String fieldMetroStation;

    // Заказ Телефон: на него позвонит курьер
    @FindBy(how = How.TAG_NAME,using = "placeholder=\"* Телефон: на него позвонит курьер\"")
    private  String fieldPhoneNumber;

    // Button Next
    @FindBy(how = How.CLASS_NAME,using = "class=\"Order_NextButton__1_rCA\"")
    private String buttonNext;


}
