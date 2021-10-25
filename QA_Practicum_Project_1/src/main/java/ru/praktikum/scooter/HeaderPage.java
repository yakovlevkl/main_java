package ru.praktikum.scooter;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderPage {
    // link https://yandex.ru/
    @FindBy(how = How.LINK_TEXT,using = "https://yandex.ru/")
    private String linkYandexSite;

    // link https://qa-scooter.praktikum-services.ru/
    @FindBy(how = How.LINK_TEXT,using = "https://qa-scooter.praktikum-services.ru/")
    private String linkScooterSite;

    // Button 'Заказать'
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div[1]/div[1]/div[2]/button[1]")
    private SelenideElement buttonOrder1;

    // Button 'Статус заказа'
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div[1]/div[1]/div[2]/button[2]")
    private String orderStatus;

    // Поле Номер заказа
    @FindBy(how = How.TAG_NAME,using = "placeholder=\"Введите номер заказа\"")
    private String orderNumber;

    // Button GO
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div[1]/div[3]/button")
    private String buttonGo;

    public void clickButtonOrder1() {
        // Клик по кнопке Заказа вверху основной страницы
        buttonOrder1.click();
    }
}
