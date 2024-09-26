package pages;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends PageObject {
    public LoginPage(UserStory userS) {
        super(userS);
    }

    public LoginPage accederWeb(){
        debugBegin();

        webDriver.go("https://www.sqrups.es/");
        Assert.assertTrue(webDriver.isPresent(By.xpath("//span[contains(text(),'INICIO')]")));

        debugEnd();
        return this;
    }

}
