package ru.praktikum.scooter;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

public class CreatingOrderTest {
    @Before
    public void setUp() {
        // chrome, edge
        String typeBrowser = "chrome";
        Configuration.browser = typeBrowser;
        Configuration.startMaximized = true;
        System.out.println("Тестирование запущено на боаузере: " + typeBrowser);
    }

    @Test
    public void fillPageOfOrderFirstBuyer() {
        // Open url
        OrderPageStepTwo scooterOrderPageStep =
                open("https://qa-scooter.praktikum-services.ru/",
                        OrderPageStepTwo.class);

        // Click on upper button Order
        scooterOrderPageStep.closeCookies();
        // Click on upper button Order
        scooterOrderPageStep.clickHeaderButtonOrder();
        //fill in the first page of the order
        scooterOrderPageStep.orderConfirmationStepOne(
                "Петр",
                "Петров",
                "Свободы,55",
                "Шоссе Энтузиастов",
                "+79999999998");

        //fill in the first page of the order
        scooterOrderPageStep.orderConfirmationStepTwo(
                "01.11.2021",
                "пятеро суток",
                "gray",
                "При встрече сплясать лезгинку");

        if (scooterOrderPageStep.controlformConfirmOrder()) {
            System.out.println("Окно подтверждения заказа НЕ закрылось [Fail]");
        } else {
            System.out.println("Окно подтверждения заказа закрылось  [Ok]");
        }
    }

    @Test
    public void fillPageOfOrderSecondBuyer() {
        // Open url
        OrderPageStepTwo scooterOrderPageStep =
                open("https://qa-scooter.praktikum-services.ru/",
                         OrderPageStepTwo.class);

        // Click on upper button Order
        scooterOrderPageStep.closeCookies();
        // Click on upper button Order
        scooterOrderPageStep.clickFooterButtonOrder();
        //fill in the first page of the order
        scooterOrderPageStep.orderConfirmationStepOne(
                "Иван",
                "Иванов",
                "Ленина,1-55",
                "Бульвар Рокоссовского",
                "89222222228");

        //fill in the first page of the order
        scooterOrderPageStep.orderConfirmationStepTwo(
                "12.12.2021",
                "сутки",
                "black",
                "Разговаривать без акцента");

        if (scooterOrderPageStep.controlformConfirmOrder()) {
            System.out.println("Окно подтверждения заказа НЕ закрылось [Fail]");
        } else {
            System.out.println("Окно подтверждения заказа закрылось  [Ok]");
        }
    }
}
