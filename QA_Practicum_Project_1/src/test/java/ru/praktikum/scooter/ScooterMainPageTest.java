package ru.praktikum.scooter;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class ScooterMainPageTest {
    @BeforeEach
    public void setUp(){

    }

    @Test
    public void listInImportantQuestionsSection() {
        // Open url
        MainPage scooterMainPage =
                open("https://qa-scooter.praktikum-services.ru/",
                MainPage.class);
        scooterMainPage.closeCookies();
        // click on first Important questions and get on first Important Answer
        // Argument: Number of question like 0, 1, 2 and etc.
        for (int i=0; i<=7; i++) {
            scooterMainPage.clickQuestionsAboutImportantAndGetAnswer(i);
        }
    }

    @Test
    public void fillPageOfOrder() {
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
    }

    @Test
    public void openYandexSite() {
        // Open url
        MainPage scooterMainPage =
                open("https://qa-scooter.praktikum-services.ru/",
                        MainPage.class);

        scooterMainPage.closeCookies();

        scooterMainPage.clickLinkYandexSite();
    }

    @Test
    public void openScooterSite() {
        // Open url
        MainPage scooterMainPage =
                open("https://qa-scooter.praktikum-services.ru/",
                        MainPage.class);

        scooterMainPage.closeCookies();
        scooterMainPage.clickButtonOrderDown();
        scooterMainPage.clickLinkScooterSite();
    }
    @AfterEach
    public void actionsAfterTest() {

    }
}
