package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 AutomationPractice second test
 */
public class TestPracticeForm {

    @BeforeAll
    static void settings() {
        System.setProperty("webdriver.chrome.driver","src/tools/chromedriver.exe");
        Configuration.browserSize = "1440x900";
    }

    @BeforeEach
    void openBrowser() {
        //Открываем браузер
        open("https://demoqa.com/automation-practice-form");
    }

    @AfterEach
    void closeBrowser(){
        //После каждого теста закрываем веб-дайвер
        closeWebDriver();
    }

    @Test
    void testStudentRegistrationForm(){

        //region Student Registration Form
        //Проверяем, что страница загрузилась
        $(byText("Student Registration Form")).shouldBe(Condition.visible);
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
        $(byText("Thanks for submitting the form")).shouldBe(Condition.visible);

        //Проверяем данные в таблице
        $(".table-responsive").shouldHave(
                text("Zarina Khassanova"),
                text("test@gmail.com"),
                text("Female"),
                text("7707012345"),
                text("03 July,1984"),
                text("Computer Science"),
                text("Sports"),
                text("octocat3.jpg"),
                text("Goa, India"),
                text("Haryana Panipat"));
        System.out.println("Form accepted!");
        //endregion
    }
}
