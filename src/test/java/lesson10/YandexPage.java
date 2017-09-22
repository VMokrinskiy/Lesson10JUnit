package lesson10;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexPage {
    @FindBy(xpath = "//input[@name='login']")
    private WebElement userName;

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement password;

    @FindBy(xpath = "//button[contains(@class,'auth__button')]")
    private WebElement login;

    @FindBy(xpath = "(//span[@class=\"input__box\"]/input)[3]")
    private WebElement searchName;

    @FindBy(xpath = "//button[@class='button suggest2-form__button button_theme_websearch button_size_ws-head i-bem button_js_inited']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//div[@class=\"misspell__message\"]")
    private WebElement searchMessage;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getButtonSearch() {
        return buttonSearch;
    }

    public WebElement getSearchName() {
        return searchName;
    }

    public WebElement getLogin(){
        return login;
    }

    public WebElement getSearchMessage() {
        return searchMessage;
    }

}
