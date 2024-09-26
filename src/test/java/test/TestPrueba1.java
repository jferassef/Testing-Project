package test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.ActionSteps;


public class TestPrueba1 extends TestObject {

    protected SuiteManager suiteM = new SuiteManager("Login");
    @DataProvider(parallel = false)
    public String[][] pruebaTest1() {
        String testCase = "1_test";
        String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, null);

        return casesMatrix;
    }

    @Test(dataProvider = "pruebaTest1")
    public void prueba(String testCase, String id) throws Exception {
        UserStory userS = suiteM.createUserStory(testCase, id);
        ActionSteps steps = new ActionSteps(userS);

        userS.testActions(() -> {

            steps.accederWebNombre();

            return null;

        }).onEnd(() -> {


            return null;
        }).run();
    }

    @AfterSuite
    public void afterSuite
            () {
        suiteM.createHtmlReport();
    }
}

