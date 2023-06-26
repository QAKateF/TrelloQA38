package Applications;

import Models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']"));
    }

    public void fillLoginForm(User user) {
        type(By.xpath("//input[@id='user']"), user.getEmail());
        click(By.xpath("//input[@value='Continue']"));
        pause(3000);
        type(By.xpath("//input[@id='password']"), user.getPassword());
    }

    public void submitLogin() {
        click(By.xpath("//span[text()='Log in']"));
        pause(3000);
    }

    public void clickOnAvatar() {
        click(By.cssSelector(".DweEFaF5owOe02.V_PnoJ2AynVwLp.G6CmOLx93OUZez"));
    }

    public void clickOnLogOut() {
        click(By.xpath("(//span[normalize-space()='Log out'])[1]"));
    }

    public void clickConfirm() {
        click(By.xpath("//button[@id='logout-submit']"));
    }
}
