package com.demoqa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TestAutomationPractice {

    @Test
    void firstTest(){
        open("https://demoqa.com/text-box");
        System.out.println("Проверяем наличие Text Box");
        $x("//div[contains(text(),'Text Box')]").shouldBe(Condition.visible);
        System.out.println("Тест выполнен успешно");
    }
}
