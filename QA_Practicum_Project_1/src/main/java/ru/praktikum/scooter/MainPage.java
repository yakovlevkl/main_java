package ru.praktikum.scooter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage extends OrderPageStepTwo {

    // Button 'Заказать'
    @FindBy(how = How.XPATH,using = "/html/body/div/div/div[1]/div[1]/div[2]/button[1]")
    private SelenideElement buttonOrderDown;

    // Список вопросов типа -> Question: Сколько это стоит? И как оплатить?
    @FindBy(how = How.CLASS_NAME,using = "accordion__button")
    private ElementsCollection accordionHeadingQuestion;

    // Список ответов типа -> Answer: Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    @FindBy(how = How.CLASS_NAME,using = "accordion__panel")
    private ElementsCollection accordionHeadingAnswer;

    private String stringForComparison(int number){
        String stringCompare = null;
        if (number == 0) {
            stringCompare = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        } else if (number == 1) {
            stringCompare = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        } else if (number == 2) {
            stringCompare = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        } else if (number == 3) {
            stringCompare = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        } else if (number == 4) {
            stringCompare = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        } else if (number == 5) {
            stringCompare = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        } else if (number == 6) {
            stringCompare = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        } else if (number == 7) {
            stringCompare = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        }
        return stringCompare;
    }

    private void clickOnAccordionHeadingQuestion(int number) {
        SelenideElement getQuestion = accordionHeadingQuestion.get(number);
        getQuestion.scrollTo().shouldBe(Condition.visible).click();
    }

    private void getAccordionHeadingAnswerAndCompare(int number) {
        SelenideElement getAnswer = accordionHeadingAnswer.get(number);
        assertEquals(stringForComparison(number), getAnswer.shouldBe(Condition.visible).getText());
    }

    void clickQuestionsAboutImportantAndGetAnswer(int number) {
        // Выполняем сразу клик по элементу -> получаем строку -> сравниваем с исходной строкой
        clickOnAccordionHeadingQuestion(number);
        getAccordionHeadingAnswerAndCompare(number);
    }

    public void clickButtonOrderDown() {
        // Клик по кнопке Заказа внизу основной страницы
        buttonOrderDown.scrollTo().shouldBe(Condition.visible).click();
    }
    
}
