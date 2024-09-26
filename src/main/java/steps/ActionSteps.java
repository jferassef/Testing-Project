package steps;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.InteractionObject;
import pages.LoginPage;

public class ActionSteps extends InteractionObject {
    public ActionSteps(UserStory userStory) {
        super(userStory);
    }
    public void accederWebNombre() {
        debugBegin();
        new LoginPage(userS).accederWeb();
        debugEnd();
    }

}
