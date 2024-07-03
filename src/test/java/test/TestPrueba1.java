package test;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestPrueba1 extends TestObject {



        @DataProvider(parallel = false)
        public String[][] revertirCartera() {
            String testCase = "1_revertirCartera";
            String[][] casesMatrix = suiteM.initializeTestObjects(testCase, null, "csv/cartera/lanzar_cartera.csv");

            return casesMatrix;
        }

        @Test(dataProvider = "revertirCartera")
        public void revertirCartera(String testCase, String id) throws Exception {
            UserStory userS = suiteM.createUserStory(testCase, id);
            userS.testActions(() -> {



                return null;

            }).onEnd(() -> {


                return null;
            }).run();
        }
}
