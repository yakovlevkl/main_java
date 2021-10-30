package ru.praktikum.scooter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.switchTo;

class HeaderAndFooterOfPage {
    // link https://yandex.ru/
    @FindBy(how = How.CLASS_NAME,using = "Header_LogoYandex__3TSOI")
    private SelenideElement linkYandexSite;

    // Код кнопки поиска на сайте Яндекса home-logo__link
    @FindBy(how = How.CLASS_NAME,using = "home-logo__default")
    private SelenideElement pageYandexSite;

    // link https://qa-scooter.praktikum-services.ru/
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div[1]/div[1]/a[2]")
    private SelenideElement linkScooterSite;

    //Scooter Самокат на пару дней
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[2]/div[4]")
    private SelenideElement mainPageScooterSite;

    // Button 'Заказать'
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div[1]/div[1]/div[2]/button[1]")
    private SelenideElement buttonHeaderOrder;

    // Button 'Заказать'
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button")
    private SelenideElement buttonOrderFooter;

    //Button Статус заказа Header_Link__1TAG7
    @FindBy(how = How.CLASS_NAME,using = "Header_Link__1TAG7")
    private SelenideElement buttonOrderStatus;

    // Field order number
    @FindBy(how = How.CLASS_NAME,using = "Header_Input__xIoUq")
    private SelenideElement fieldOrderNumber;

    // Button Go!
    @FindBy(how = How.CLASS_NAME,using = "Header_Button__28dPO")
    private SelenideElement buttonGo;

    // Image Такого заказа нет Track_NotFound__6oaoY
    @FindBy(how = How.CLASS_NAME,using = "Track_NotFound__6oaoY")
    private SelenideElement imageTrackNotFound;

    // Button Coockie
    @FindBy(how = How.ID,using = "rcc-confirm-button")
    private SelenideElement buttonCoockiesInfo;

    void closeCookies(){
        if (buttonCoockiesInfo.isDisplayed()) {
            buttonCoockiesInfo.shouldBe(Condition.visible).click();
        }
    }

    void clickHeaderButtonOrder() {
        // Клик по кнопке Заказа вверху основной страницы
        buttonHeaderOrder.click();
    }

    void clickFooterButtonOrder() {
        // Клик по кнопке Заказа внизу основной страницы
        buttonOrderFooter.scrollTo().shouldBe(Condition.visible).click();
    }

    Boolean clickLinkYandexSite(){
        linkYandexSite.shouldBe(Condition.visible).click();
        switchTo().window("Яндекс");
        return pageYandexSite.isDisplayed();
    }

    Boolean clickLinkScooterSite(){
        linkScooterSite.shouldBe(Condition.visible).click();
        return mainPageScooterSite.shouldBe(Condition.visible).isDisplayed();
    }

    void inputNumberOrder(String orderNumber){
        buttonOrderStatus.scrollTo().shouldBe(Condition.visible).click();
        fieldOrderNumber.shouldBe(Condition.visible).setValue(orderNumber);
        buttonGo.scrollTo().shouldBe(Condition.visible).click();
    }

    Boolean isTrackFound(){
        return imageTrackNotFound.shouldBe(Condition.visible).isDisplayed();
    }
}
