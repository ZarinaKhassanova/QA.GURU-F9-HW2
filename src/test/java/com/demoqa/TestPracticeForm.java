package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static java.util.ResourceBundle.clearCache;

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
        //Открываем браузер
        open("https://demoqa.com/automation-practice-form");
    }

    @AfterAll
    static void clearBrowserCache(){
        clearCache();
    }

    @Test
    void testStudentRegistrationForm(){

        //region Student Registration Form
        //Проверяем, что страница загрузилась
        $(byText("Student Registration Form")).shouldBe(Condition.visible, Duration.ofMillis(3000));
        //Заполняем поле "First Name"
        $("#firstName").setValue("Zarina");
        //Заполняем поле "Last Name"
        $("#lastName").setValue("Khassanova");
        //Заполняем поле "Email"
        $("#userEmail").setValue("test@gmail.com");
        //Выбираем "Gender"
        $(byText("Female")).click();
        //Заполняем поле "Mobile"
        $("#userNumber").setValue("7707012345");
        // Заполняем поле "Date of Birth"
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOptionByValue("1984");
        $$(".react-datepicker__day").find(text("3")).click();
        //Заполняем поле "Subjects"
        $("#subjectsInput").click();
        $("#subjectsInput").sendKeys("c");
        $(byText("Computer Science")).click();
        //Заполняем поле "Hobbies"
        $(byText("Sports")).click();
        //Загружаем картинку в поле "Picture"
        $("#uploadPicture").uploadFile(new File("src/files/octocat3.jpg"));
        //Заполняем поле "Current Address"
        $("#currentAddress").scrollTo();
        $("#currentAddress").sendKeys("Goa, India");
        //Заполняем поля "State and City"
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();
        //Кликаем на кнопку "Submit"
        $("#submit").click();
        //endregion

        //region Check result
        //Проверяем, что форма с таблицей открылась
        $(byText("Thanks for submitting the form")).shouldBe(Condition.visible, Duration.ofMillis(3000));

        //Проверяем данные в таблице
        $(".table-responsive").$(byText("Zarina Khassanova"));
        $(".table-responsive").$(byText("test@gmail.com"));
        $(".table-responsive").$(byText("Female"));
        $(".table-responsive").$(byText("7707012345"));
        $(".table-responsive").$(byText("03 July,1984"));
        $(".table-responsive").$(byText("Computer Science"));
        $(".table-responsive").$(byText("Sports"));
        $(".table-responsive").$(byText("octocat3.jpg"));
        $(".table-responsive").$(byText("Goa, India"));
        $(".table-responsive").$(byText("Haryana Panipat"));

        System.out.println("Accepted fill form");
        //endregion
    }
}
