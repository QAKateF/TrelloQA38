package Applications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text!= null) {
            wd.findElement(locator).click();
            pause(2000);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }
    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }
}