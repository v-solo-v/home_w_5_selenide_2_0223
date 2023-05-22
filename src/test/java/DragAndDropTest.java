import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @Test
    void transferTest () {
        Configuration.browserSize = System.getProperty("browserSize","1920x1080");
        Configuration.browser = System.getProperty("browser", "firefox");
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    //Тест не работает
    void transferActionTest () {
        Configuration.browserSize = System.getProperty("browserSize","1920x1080");
        Configuration.browser = System.getProperty("browser", "firefox");
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").shouldHave(text("A"));
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b"));
        $("#column-a").shouldHave(exactText("B"));
    }
}
