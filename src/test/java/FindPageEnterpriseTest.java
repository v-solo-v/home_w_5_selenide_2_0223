import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindPageEnterpriseTest {
    @BeforeAll
    public static void configProperty () {
        Configuration.browserSize = System.getProperty("browserSize","1920x1080");
        Configuration.browser = System.getProperty("browser", "firefox");
        open("https://github.com");
    }
    @Test
    void findEnterprise () {
        $("div.header-menu-wrapper").$(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $("div.enterprise-hero").shouldHave(text("Build like the best"));
    }
}
