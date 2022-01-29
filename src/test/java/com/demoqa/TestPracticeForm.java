package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

/**
 AutomationPractice second test
 */
public class TestPracticeForm {

    @BeforeAll
    static void settings() {
        System.setProperty("webdriver.chrome.driver","src/tools/chromedriver.exe");
        Configuration.startMaximized = true;
    }

    @BeforeEach
    void openBrowser() {
        open("https://demoqa.com/text-box");
    }

    @Test
    void testStudentRegistrationForm(){

        System.out.println("Заполняем Student Registration Form");
        $x("//div[contains(text(),'Text Box')]").shouldBe(Condition.visible);
        System.out.println("Тест выполнен успешно");
    }
}
