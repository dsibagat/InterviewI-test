package tests.webTests;

import config.ConfigHelper;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AdminPanelTest extends TestBase {
    @Test
    public void login() {
        step("Открываем страницу авторизации", () ->
                open("/admin/login"));

        step("Вводим логин", () ->
                $("#UserLogin_username").val(ConfigHelper.getUsername()));

        step("Вводим пароль", () -> {
            $("#UserLogin_password").val(ConfigHelper.getPassword());
        });

        step("Нажимаем на кнопку Sign in", () ->
                $("[value='Sign in']").click());

        step("Проверяем что пользователь авторизован", () -> {
            $(".nav-right").shouldHave(text(ConfigHelper.getUsername()));
        });

        step("Кликаем по правому сайд бару Users", () ->
                $(".main-side-menu .fa-user").click());

        step("Кликаем по Players в выпадающем меню", () ->
                $(byText("Players")).click());

        step("Выполняем сортировку и проверяем что она сработала", () -> {
            String value = $(".odd").getText();
            $(byText("Username")).click();
            $(".grid-view-loading").shouldNot(visible);
            String value1 = $(".odd").getText();
            assert !value.equals(value1);
        });
    }
}

