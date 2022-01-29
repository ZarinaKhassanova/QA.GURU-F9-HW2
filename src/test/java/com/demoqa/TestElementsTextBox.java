package com.demoqa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 AutomationPractice first test
 */
public class TestElementsTextBox {

    @BeforeAll
    static void settings(){
        System.setProperty("webdriver.chrome.driver","src/tools/chromedriver.exe");
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Manager Autotest");
        $("#userEmail").setValue("test@gmail.com");
        $("#currentAddress").setValue("Kazakhstan");
        $("#permanentAddress").setValue("Almaty");
        //Click button "Submit"
        $("#submit").scrollTo().click();

        //Check result ver.1
        $("#output #name").shouldHave(text("Manager Autotest"));
        $("#output #email").shouldHave(text("test@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Kazakhstan"));
        $("#output #permanentAddress").shouldHave(text("Almaty"));

        //Check result ver.2
        $("#output").shouldHave(text("Manager Autotest"), text("test@gmail.com"), text("Kazakhstan"), text("Almaty"));
    }
}
