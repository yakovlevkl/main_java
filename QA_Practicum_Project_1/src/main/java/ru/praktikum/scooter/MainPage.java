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
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[4]/div[1]")
    private SelenideElement howItsWork;

    //Шаг 1
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[1]/div[1]")
    private SelenideElement stepOne;

    //Шаг 1 "Заказываете самокат"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[1]/div[2]/div[1]")
    private SelenideElement stepOneOrderScooter;

    //Описание Шага 1 "Выбираете, когда и куда привезти"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[1]/div[2]/div[2]")
    private SelenideElement stepOneDescription;

    //Шаг 2
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[2]/div[1]")
    private SelenideElement stepTwo;

    //Шаг 2 "Курьер привозит самокат"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[2]/div[2]/div[1]")
    private SelenideElement stepTwoDeliveryScooter;

    //Описание Шага 2 "А вы — оплачиваете аренду"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[2]/div[2]/div[2]")
    private SelenideElement stepTwoDescription;

    //Шаг 3
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[3]/div[1]")
    private SelenideElement stepThree;

    //Шаг 3 "Катаетесь"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[3]/div[2]/div[1]")
    private SelenideElement stepThreeEnjoy;

    //Описание Шага 3 "Сколько часов аренды осталось — видно на сайте"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[3]/div[2]/div[2]")
    private SelenideElement stepThreeDescription;

    //Шаг 4
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[4]/div[1]")
    private SelenideElement stepFour;

    //Шаг 4 "Курьер забирает самокат"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[4]/div[2]/div[1]")
    private SelenideElement stepFourReturnScooter;

    //Описание Шага 4 "Когда аренда заканчивается"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[4]/div[2]/div[2]")
    private SelenideElement stepFourDescription;

    //Блок "Вопросы о важном"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[5]/div[1]")
    private SelenideElement questionsAboutImportant;

    //Вопрос: Сколько это стоит? И как оплатить?
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__heading-0\"]")
    private SelenideElement questionsAboutPay;

    //Ответ: "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__panel-0\"]/p")
    private SelenideElement answerAboutPay;

    //Вопрос: Хочу сразу несколько самокатов! Так можно?
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__heading-1\"]")
    private SelenideElement questionsAboutFewScooters;

    //Ответ:"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__panel-1\"]/p")
    private SelenideElement answerAboutFewScooters;

    //Вопрос: Как рассчитывается время аренды?
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__heading-2\"]")
    private SelenideElement questionsAboutRentalTime;

    //Ответ: "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__panel-2\"]/p")
    private SelenideElement answerAboutRentalTime;

    //Вопрос: Можно ли заказать самокат прямо на сегодня?
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__heading-3\"]")
    private SelenideElement questionsOrderScooterNow;

    //Ответ: "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__panel-3\"]/p")
    private SelenideElement answerOrderScooterNow;

    //Вопрос: Можно ли продлить заказ или вернуть самокат раньше?
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__heading-4\"]")
    private SelenideElement questionsAboutExtendOrder;

    //Ответ:"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__panel-4\"]/p")
    private SelenideElement answerAboutExtendOrder;

    //Вопрос: Вы привозите зарядку вместе с самокатом?
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__heading-5\"]")
    private SelenideElement questionsChargingScooter;

    //Ответ:"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__panel-5\"]/p")
    private SelenideElement answerAbouChargingScooter;

    //Вопрос: Можно ли отменить заказ?
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__heading-6\"]")
    private SelenideElement questionsAboutCancelOrder;

    //Ответ:"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__panel-6\"]/p")
    private SelenideElement answerAboutCancelOrder;

    //Вопрос: Я жизу за МКАДом, привезёте?
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__heading-7\"]")
    private SelenideElement questionsAboutBeyondMkad;

    //Ответ: "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    @FindBy(how = How.XPATH,using = "//*[@id=\"accordion__panel-7\"]/p")
    private SelenideElement answerAboutBeyondMkad;
    //

    // Список вопросов типа -> Question: Сколько это стоит? И как оплатить?
    @FindBy(how = How.CLASS_NAME,using = "accordion__button")
    private ElementsCollection listQestionsAboutScooterOrder;

    // Список ответов типа -> Answer: Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    @FindBy(how = How.CLASS_NAME,using = "accordion__panel")
    private ElementsCollection listAnswersAboutScooterOrder;

    private void clickOnAccordionHeadingQuestion(int number) {
        SelenideElement getQuestion = listQestionsAboutScooterOrder.get(number);
        getQuestion.scrollTo().shouldBe(Condition.visible).click();
    }

    private String getAccordionHeadingAnswer(int number) {
        SelenideElement getAnswer = listAnswersAboutScooterOrder.get(number);
        return getAnswer.shouldBe(Condition.visible).getText();
    }

    String clickQuestionsAboutImportantAndGetAnswer(int number) {
        // Выполняем сразу клик по элементу -> получаем строку
        clickOnAccordionHeadingQuestion(number);
        return getAccordionHeadingAnswer(number);
    }
}
