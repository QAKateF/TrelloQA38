package Tests;

import Models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {


    @Test(priority = 1)
    public void positiveLogineTest() {
        app.getSessionHelper().openLoginForm();
        app.getSessionHelper().fillLoginForm(new User().withEmail("maxmayzel@gmail.com").withPassword("Rfrnec7_*"));
        app.getSessionHelper().submitLogin();
        app.getSessionHelper().pause(3000);
        Assert.assertTrue(app.getSessionHelper().
                isElementPresent(By.cssSelector(".DweEFaF5owOe02.V_PnoJ2AynVwLp.G6CmOLx93OUZez")));

    }

    @Test(priority = 3)
    public void negatineLoginwithOutPasswordTest() {
        app.getSessionHelper().openLoginForm();
        app.getSessionHelper().fillLoginForm(new User().withEmail("maxmayzel@gmail.com"));
        app.getSessionHelper().submitLogin();
        Assert.assertTrue(app.getSessionHelper().isElementPresent(By.id("password-error")));
    }

    @Test(priority = 2)
    public void logOutTest() {
        if(app.getSessionHelper().isElementPresent(By.cssSelector(".DweEFaF5owOe02.V_PnoJ2AynVwLp.G6CmOLx93OUZez"))) {
            app.getSessionHelper().clickOnAvatar();
            app.getSessionHelper().pause(3000);
            app.getSessionHelper().clickOnLogOut();
            app.getSessionHelper().pause(3000);
            app.getSessionHelper().clickConfirm();
            app.getSessionHelper().pause(3000);
        }else{
            app.getSessionHelper().openLoginForm();
            app.getSessionHelper().fillLoginForm(new User().withEmail("maxmayzel@gmail.com").withPassword("Rfrnec7_*"));
            app.getSessionHelper().submitLogin();
            app.getSessionHelper().pause(2000);
            app.getSessionHelper().clickOnAvatar();
            app.getSessionHelper().pause(2000);
            app.getSessionHelper().clickOnLogOut();
            app.getSessionHelper().pause(2000);
            app.getSessionHelper().clickConfirm();
        }
    }
}