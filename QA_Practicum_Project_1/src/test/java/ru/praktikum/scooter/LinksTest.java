package ru.praktikum.scooter;

import com.codeborne.selenide.Configuration;

import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class LinksTest {
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
    public void openScooterSite() {
        // Open url
        MainPage scooterMainPage =
                open("https://qa-scooter.praktikum-services.ru/",
                        MainPage.class);

        scooterMainPage.closeCookies();
        scooterMainPage.clickFooterButtonOrder();
        if (scooterMainPage.clickLinkScooterSite()) {
            System.out.println("Страница https://qa-scooter.praktikum-services.ru/ открыта [Ok]");
        } else {
            System.out.println("Страница https://qa-scooter.praktikum-services.ru/ НЕ открыта [Fail]");
        }
    }

    @Test
    public void openYandexSite() {

        // Open url
        MainPage scooterMainPage =
                open("https://qa-scooter.praktikum-services.ru/",
                        MainPage.class);

        scooterMainPage.closeCookies();
        scooterMainPage.clickFooterButtonOrder();
        if (scooterMainPage.clickLinkYandexSite()) {
            System.out.println("Страница https://yandex.ru/ открыта в новом окне [Ok]");
        } else {
            System.out.println("Страница https://yandex.ru/ НЕ открыта в новом окне [Fail]");
        }
    }
}
