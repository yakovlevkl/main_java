package ru.praktikum.scooter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

class MainPage extends HeaderAndFooterOfPage{
    //Картинка "Самокат
    @FindBy(how = How.CLASS_NAME,using = "Home_Scooter__3YdJy")
    private SelenideElement imageHomeScooter;

    //Новый текст после скролла "Он лёгкий и с мощными колёсами"
    @FindBy(how = How.CLASS_NAME,using = "//*[@id=\"root\"]/div/div/div[2]/div[4]/div[2]/text()")
    private SelenideElement sloganHomeScooter;

    //Блок с характеристиками (Модель Toxic PRO, Максимальная скорость, Проедет без подзарядки, Выдерживает вес)
    @FindBy(how = How.CLASS_NAME,using = "Home_Table__2kPxP")
    private SelenideElement specificationsScooter;

    //Блок для "Как это работает" (Элементы "Кружок с цифрой 1 внутри"
    @FindBy(how = How.CLASS_NAME,using = "")
    private SelenideElement howItsWork;

    //Шаг 1 "Заказываете самокат"
    @FindBy(how = How.CLASS_NAME,using = "")
    private SelenideElement stepOneOrderScooter;

    //Описание Шага 1 "Выбираете, когда и куда привезти"
    @FindBy(how = How.CLASS_NAME,using = "")
    private SelenideElement stepOneDescription;

    //Блок "Вопросы о важном" (каждый вопрос и ответ)
    //Вопрос: Сколько это стоит? И как оплатить?
    //Ответ: "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

    //Вопрос: Хочу сразу несколько самокатов! Так можно?
    //Ответ:"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

    //Вопрос: Как рассчитывается время аренды?
    //Ответ: "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

    //Вопрос: Можно ли заказать самокат прямо на сегодня?
    //Ответ: "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

    //Вопрос: Можно ли продлить заказ или вернуть самокат раньше?
    //Ответ:"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";

    //Вопрос: Вы привозите зарядку вместе с самокатом?
    //Ответ:"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";

    //Вопрос: Можно ли отменить заказ?
    //Ответ:"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

    //Вопрос: Я жизу за МКАДом, привезёте?
    //Ответ: "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    //

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

    // Список вопросов типа -> Question: Сколько это стоит? И как оплатить?
    @FindBy(how = How.CLASS_NAME,using = "accordion__button")
    private ElementsCollection accordionHeadingQuestion;

    // Список ответов типа -> Answer: Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    @FindBy(how = How.CLASS_NAME,using = "accordion__panel")
    private ElementsCollection accordionHeadingAnswer;

    private void clickOnAccordionHeadingQuestion(int number) {
        SelenideElement getQuestion = accordionHeadingQuestion.get(number);
        getQuestion.scrollTo().shouldBe(Condition.visible).click();
    }

    private String getAccordionHeadingAnswer(int number) {
        SelenideElement getAnswer = accordionHeadingAnswer.get(number);
        return getAnswer.shouldBe(Condition.visible).getText();
    }

    String clickQuestionsAboutImportantAndGetAnswer(int number) {
        // Выполняем сразу клик по элементу -> получаем строку
        clickOnAccordionHeadingQuestion(number);
        return getAccordionHeadingAnswer(number);
    }

    void inputNumberOrder(String orderNumber){
        buttonOrderStatus.scrollTo().shouldBe(Condition.visible).click();
        fieldOrderNumber.shouldBe(Condition.visible).setValue(orderNumber);
        buttonGo.scrollTo().shouldBe(Condition.visible).click();

     }

     Boolean trackFound(){
         return imageTrackNotFound.shouldBe(Condition.visible).isDisplayed();
     }

}
