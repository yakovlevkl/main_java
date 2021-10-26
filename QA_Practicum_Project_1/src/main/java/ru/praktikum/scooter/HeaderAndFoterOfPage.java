package ru.praktikum.scooter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderAndFoterOfPage {
    // link https://yandex.ru/
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[1]/div[1]/a[1]")
    private SelenideElement linkYandexSite;

    // Код кнопки поиска на сайте Яндекса
    @FindBy(how = How.XPATH,using = "/html/body/div[1]/div[3]/div[3]/div/div[3]/dhtaq/div/div/div[1]/div[1]/a/div")
    private SelenideElement pageYandexSite;

    // link //*[@id="root"]/div/div[1]/div[1]/a[2]
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[1]/div[1]/a[2]")
    private SelenideElement linkScooterSite;

    //Scooter Самокат на пару дней
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[2]/div[4]")
    private SelenideElement mainPageScooterSite;

    // Button 'Заказать'
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div[1]/div[1]/div[2]/button[1]")
    private SelenideElement buttonHeaderOrder;

    // Button 'Статус заказа'
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div[1]/div[1]/div[2]/button[2]")
    private SelenideElement orderStatus;

    // Поле Номер заказа
    @FindBy(how = How.TAG_NAME,using = "placeholder=\"Введите номер заказа\"")
    private SelenideElement orderNumber;

    // Button GO
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div[1]/div[3]/button")
    private SelenideElement buttonGo;

    // Button Coockie
    @FindBy(how = How.ID,using = "rcc-confirm-button")
    private SelenideElement closeCoockiesInfo;

    public void closeCookies(){
        if (closeCoockiesInfo.isDisplayed()) {
            closeCoockiesInfo.shouldBe(Condition.visible).click();
        }
    }

    public void clickHeaderButtonOrder() {
        // Клик по кнопке Заказа вверху основной страницы
        buttonHeaderOrder.click();
    }

    public void clickLinkYandexSite(){
        linkYandexSite.shouldBe(Condition.visible).click();
        pageYandexSite.click();
    }

    public void clickLinkScooterSite(){
        linkScooterSite.shouldBe(Condition.visible).click();
        mainPageScooterSite.shouldBe(Condition.visible).click();
    }
}
