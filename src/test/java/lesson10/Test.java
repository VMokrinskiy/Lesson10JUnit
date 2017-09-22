package lesson10;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test{
    YandexPage yandexPage = new YandexPage();
    WebDriver driver;

    @Before
    public void init(){
        driver = new ChromeDriver();
        PageFactory.initElements(driver, yandexPage);
        driver.navigate().to("https://www.yandex.ru/");
    }

    @Title("Test2")
    @Description("Log in mail.yandex")
    @org.junit.Test
    public void getToHomePage() throws InterruptedException {
        if (!yandexPage.getUserName().isDisplayed())
            driver.manage().window().maximize();
        yandexPage.getUserName().sendKeys("riddler1391");
        yandexPage.getPassword().sendKeys("123");
        yandexPage.getLogin().click();
        assertFalse(driver.getCurrentUrl().equals("https://mail.yandex.ru/"));
        attachText("Message", "Good Job!");
        Thread.sleep(2000);
    }

    @Title("Test1")
    @Description("search in yandex")
    @org.junit.Test
    public void pressFind() {
        yandexPage.getSearchName().sendKeys("asdasd");
        yandexPage.getButtonSearch().click();
        assertTrue(yandexPage.getSearchMessage().isDisplayed());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Attachment(value = "{0}", type = "text/plain")
    public String attachText(String name, String message) {
        return message;
    }
}
