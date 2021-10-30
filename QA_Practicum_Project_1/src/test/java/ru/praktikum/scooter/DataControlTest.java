package ru.praktikum.scooter;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class DataControlTest {
    @Before
    public void setUp() {
        // chrome, edge
        String typeBrowser = "firefox";
        System.setProperty("selenide.browser", typeBrowser);
        Configuration.browser = typeBrowser;
        Configuration.startMaximized = true;
        System.out.println("Тестирование запущено на браузере: " + typeBrowser);
    }

    @Test
    public void listInImportantQuestionsSection() {
        // Open url
        MainPage scooterMainPage =
                open("https://qa-scooter.praktikum-services.ru/",
                        MainPage.class);
        scooterMainPage.closeCookies();

        // Argument: stringCompare -- expected line in the response
        // Argument: NumberQuestion -- number question on web page scooter

        Map<Integer, String> questionAnswers = new HashMap<Integer, String>();

        String stringCompare;
        int numberQuestion;

        questionAnswers.put(0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        questionAnswers.put(1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
        questionAnswers.put(2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
        questionAnswers.put(3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
        questionAnswers.put(4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
        questionAnswers.put(5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
        questionAnswers.put(6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
        questionAnswers.put(7, "Да, обязательно. Всем самокатов! И Москве, и Московской области.");

        for (int i=0; i<=questionAnswers.size() - 1; i++) {
            String answer = scooterMainPage.clickQuestionsAboutImportantAndGetAnswer(i);
            if (!questionAnswers.get(i).equals(answer)) {
                System.out.println("Есть не соответсвие, контролируем значение: " + questionAnswers.get(i));
                System.out.println("  Есть не соответсвие, полученное значение: " + answer);
            } else {
                System.out.println("Ошибок нет [Ok]");
            }
        }
    }

    @Test
    public void listErrorsOnOrderForm() {
        // Open url
        OrderPageStepTwo scooterMainPage =
                open("https://qa-scooter.praktikum-services.ru/",
                        OrderPageStepTwo.class);

        scooterMainPage.closeCookies();
        scooterMainPage.clickFooterButtonOrder();

        scooterMainPage.orderConfirmationStepOne(
                "Иван",
                "иванов",
                "кирова 123",
                "",
                "");

        for (int i=scooterMainPage.errorOnOrderForm().size() - 1 ; i>=0; i --) {
            if (!scooterMainPage.errorOnOrderForm().get(i).getText().equals("")) {
                System.out.println("Обнаружена ОШИБКА: " + scooterMainPage.errorOnOrderForm().get(i).getText());
            }
        }
        if (scooterMainPage.errorOnOrderFormValueMetro().isDisplayed()) {
            if (!scooterMainPage.errorOnOrderFormValueMetro().getText().equals("")) {
                System.out.println("Обнаружена ОШИБКА: " + scooterMainPage.errorOnOrderFormValueMetro().getText());
            } else {
                System.out.println("Ошибок в полях ввода нет [Ok]");
            }
        }
    }

    @Test
    public void checkStatusOrder() {
        // Open url
        MainPage scooterMainPage =
                open("https://qa-scooter.praktikum-services.ru/",
                        MainPage.class);

        scooterMainPage.closeCookies();
        // orderNumber -- произвольный номер заказа
        String orderNumber = "1";
        scooterMainPage.inputNumberOrder(orderNumber);
        if (scooterMainPage.isTrackFound()){
            System.out.println("Внимание! Заказ с номером: " + orderNumber + " не найден [Fail]");
        } else {
            System.out.println("Заказ с номером: " + orderNumber + " найден [Ok]");
        }
    }
}
