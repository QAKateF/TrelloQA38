package Tests;

import Models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletion extends TestBase {

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
    public void deletionBoardTest() {
        while (app.getBoardHelper().boardCounter() > 1) {
            int before = app.getBoardHelper().boardCounter();
            app.getBoardHelper().selectFirstBoard();
            app.getBoardHelper().pause(3000);
            app.getBoardHelper().openMenu();
            app.getBoardHelper().pause(3000);
            //app.getBoardHelper().openMenuMore();
            app.getBoardHelper().pause(2000);
            app.getBoardHelper().closeBoard();
            app.getBoardHelper().pause(2000);
            int after = app.getBoardHelper().boardCounter();
            app.getBoardHelper().pause(2000);
            Assert.assertEquals(before - 1, after);
        }
    }

    @Test
    public void deletionSeparatelyBoardTest() {
        // while (app.getBoardHelper().boardCounter() > 1) {
        int before = app.getBoardHelper().boardCounter();
        app.getBoardHelper().selectFirstBoard();
        app.getBoardHelper().pause(5000);
        app.getBoardHelper().openMenu();
        app.getBoardHelper().pause(2000);
        //  app.getBoardHelper().openMenuMore();
        app.getBoardHelper().pause(2000);
        app.getBoardHelper().closeBoard();
        app.getBoardHelper().pause(2000);
        int after = app.getBoardHelper().boardCounter();
        app.getBoardHelper().pause(2000);
        Assert.assertEquals(before - 1, after);
    }


}
