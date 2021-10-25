package ru.praktikum.scooter;

import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class ScooterMainPageTest {

    String pageSite = "https://qa-scooter.praktikum-services.ru/";

    @Test
    public void listInImportantQuestionsSectionTest() {
        // Open url
        MainPage scooterMainPage = open(pageSite, MainPage.class);

        // click on first Important questions and get on first Important Answer
        scooterMainPage.clickQuestionsAboutImportantAndGetAnswer();
    }

    @Test
    public void orderScooterClickHeaderButtonOrder() {
        // Open url
        HeaderPage scooterHeaderPage = open(pageSite, HeaderPage.class);

        // Click on upper button Order
        scooterHeaderPage.clickButtonOrder1();
    }
}
