package ru.praktikum.scooter;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {

    // Button 'Заказать'
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div[1]/div[1]/div[2]/button[1]")
    private SelenideElement buttonOrder2;

    // Question: Сколько это стоит? И как оплатить?
    @FindBy(how = How.CLASS_NAME,using = "accordion__heading")
    private SelenideElement accordionHeadingQuestion0;

    // Answer: Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    @FindBy(how = How.CLASS_NAME,using = "accordion__panel")
    private SelenideElement accordionHeadingAnswer0;

    // Question: Хочу сразу несколько самокатов! Так можно?
    // Answer: Пока что у нас так: один заказ — один самокат.
    // Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    private final String accordionHeadingQuestion1 = "//*[@id=\"accordion__heading-1\"]";

    // Question: Как рассчитывается время аренды?
    // Answer: Допустим, вы оформляете заказ на 8 мая.
    //      Мы привозим самокат 8 мая в течение дня.
    //      Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру.
    //      Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    private final String accordionHeadingQuestion2 = "//*[@id=\"accordion__heading-2\"]";

    // Question: Можно ли заказать самокат прямо на сегодня?
    // Answer: Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    private final String accordionHeadingQuestion3 = "//*[@id=\"accordion__heading-3\"]";

    // Question: Можно ли продлить заказ или вернуть самокат раньше?
    // Answer: Пока что нет!
    //      Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    private final String accordionHeadingQuestion4 = "//*[@id=\"accordion__heading-4\"]";

    // Question: Вы привозите зарядку вместе с самокатом?
    // Answer: Самокат приезжает к вам с полной зарядкой.
    //      Этого хватает на восемь суток — даже если будете кататься без передышек и во сне.
    //      Зарядка не понадобится.
    private final String accordionHeadingQuestion5 = "//*[@id=\"accordion__heading-5\"]";

    // Question: Можно ли отменить заказ?
    // Answer: Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим.
    //      Все же свои.
    private final String accordionHeadingQuestion6 = "//*[@id=\"accordion__heading-6\"]";

    // Question: Я жизу за МКАДом, привезёте?
    // Answer: Да, обязательно. Всем самокатов! И Москве, и Московской области.
    private final String accordionHeadingQuestion7 = "//*[@id=\"accordion__heading-7\"]";

    public void clickOnAccordionHeadingQuestion0() {
        accordionHeadingQuestion0.scrollTo().click();
    }

    public void getAccordionHeadingAnswer0() {
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                accordionHeadingAnswer0.getText());
    }

    public void clickQuestionsAboutImportantAndGetAnswer() {
        // Выполняем сразу клик по элементу -> получаем строку -> сравниваем с исходной строкой
        clickOnAccordionHeadingQuestion0();
        getAccordionHeadingAnswer0();
    }

    public void clickButtonOrder2() {
        // Клик по кнопке Заказа внизу основной страницы
        buttonOrder2.click();
    }
    
}
