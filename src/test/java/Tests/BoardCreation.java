package Tests;

import Models.Board;
import Models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {

    @BeforeMethod
    public void preConditions() {
        if (!app.getBoardHelper().isElementPresent(By.cssSelector(".DweEFaF5owOe02.V_PnoJ2AynVwLp.G6CmOLx93OUZez"))) {
            app.getSessionHelper().openLoginForm();
            app.getSessionHelper().fillLoginForm(new User().withEmail("maxmayzel@gmail.com").withPassword("Rfrnec7_*"));
            app.getSessionHelper().submitLogin();
            app.getSessionHelper().pause(3000);
        }
    }

    @Test
    public void boardCreationTest() {

        while (app.getBoardHelper().boardCounter() < 10) {
            int before = app.getBoardHelper().boardCounter();
            String boardName = "qa38_" + (System.currentTimeMillis()/1500)%3600;
            app.getBoardHelper().pressCreateButton();
            app.getBoardHelper().pause(2000);
            app.getBoardHelper().selectCreateBoard();
            app.getBoardHelper().pause(2000);
            app.getBoardHelper().fillBoardName(new Board().withName(boardName));
            app.getBoardHelper().pause(2000);
            app.getBoardHelper().submitBoardCreation();
            app.getBoardHelper().pause(3000);
            app.getBoardHelper().backToWorkSpase();
            app.getBoardHelper().pause(2000);
            int after = app.getBoardHelper().boardCounter();
            Assert.assertEquals(before, after-1);

        }
    }
}
