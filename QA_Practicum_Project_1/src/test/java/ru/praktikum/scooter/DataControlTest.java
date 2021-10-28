package ru.praktikum.scooter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

public class DataControlTest {
    @Before
    public void setUp() {
        // chrome, edge
        String typeBrowser = "chrome";
        Configuration.browser = typeBrowser;
        Configuration.startMaximized = true;
        System.out.println("Тестирование запущено на боаузере: " + typeBrowser);
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

        String stringCompare;
        int numberQuestion;

        numberQuestion = 0;
        stringCompare = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

        //int numberQuestion = 1;
        //stringCompare = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

        //int numberQuestion = 2;
        //stringCompare = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

        //int numberQuestion = 3;
        //stringCompare = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

        //int numberQuestion = 4;
        //stringCompare = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";

        //int numberQuestion = 5;
        //stringCompare = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";

        //int numberQuestion = 6;
        //stringCompare = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

        //int numberQuestion = 7;
        //stringCompare = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


        String answer = scooterMainPage.clickQuestionsAboutImportantAndGetAnswer(numberQuestion);

        if (!stringCompare.equals(answer)) {
            System.out.println("Есть не соответсвие:" + answer);
        } else {
            System.out.println("Ошибок нет [Ok]");
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
        if (scooterMainPage.trackFound()){
            System.out.println("Внимание! Заказ с номером: " + orderNumber + " не найден [Fail]");
        } else {
            System.out.println("Заказ с номером: " + orderNumber + " найден [Ok]");
        }
    }
}
