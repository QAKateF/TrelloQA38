package Tests;

import Models.User;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModification extends TestBase{
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
    public void boardNameModifTest(){
        int i = (int) ((System.currentTimeMillis() / 1500) % 3600);
        String boardName = "hhh_" + i;
        app.getBoardHelper().pause(2000);
        app.getBoardHelper().fillNameForm(boardName);
    }




}