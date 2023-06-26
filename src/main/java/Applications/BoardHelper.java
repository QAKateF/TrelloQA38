package Applications;

import Models.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BoardHelper extends HelperBase {
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void pressCreateButton() {
        click(By.xpath("//p[@class='X7iA6JJNiXCA2r']"));
    }

    public void selectCreateBoard() {
        click(By.xpath("//span[.='Create board']"));
    }

    public void fillBoardName(Board board) {
        type(By.xpath("//input[@aria-invalid='true']"), board.getName());
    }

    public void submitBoardCreation() {
        click(By.xpath("//button[@data-testid='create-board-submit-button']"));
    }

    public int boardCounter() {
        List<WebElement> boardslist = wd.findElements(By.cssSelector(".boards-page-board-section-list-item"));
        return boardslist.size();
    }

    public String getBoardTitle(By locator) {
        wd.findElement(locator).getText();
        return wd.findElement(locator).getText();
    }


    public String getTitle() {
        return wd.findElement(By.cssSelector(".hiRkezEUBG7ve6.uXhW3KBBr1jUsJ")).getText();
    }

    public boolean waitElementPresent(By locator, int timeOut) {
        return new WebDriverWait(wd, 10).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).size() > 0;
    }

    public void backToWorkSpase() {
        click(By.xpath("//p[@class='nNvJhnERHVQb9o']"));
    }

    public void selectFirstBoard() {
        click(By.xpath("//ul[@class='boards-page-board-section-list']//li[1]"));
    }

    public void openMenu() {
        if (!wd.findElement(By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']")).isDisplayed()) {
            pause(3000);
            WebElement el = wd.findElement(By.xpath("//button[@aria-label='Show menu']//span[@class='css-snhnyn']"));
            //click(By.xpath("//button[@aria-label='Show menu']"));
            new Actions(wd).moveToElement(el).click().perform();
            pause(3000);
            WebElement el1 = wd.findElement(By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']"));
            new Actions(wd).moveToElement(el1).click().perform();
        } else {
            pause(3000);
            WebElement el1 = wd.findElement(By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']"));
            new Actions(wd).moveToElement(el1).click().perform();

        }
    }

    public void openMenuMore() {
        click(By.cssSelector(".icon-sm.icon-overflow-menu-horizontal.board-menu-navigation-item-link-icon"));
    }

    public void closeBoard() {
        click(By.cssSelector(".board-menu-navigation-item-link.js-close-board"));
        click(By.cssSelector(".js-confirm.full.nch-button.nch-button--danger"));
        pause(1000);
        click(By.cssSelector(".Bp80TGmc9hQIdE.bxgKMAm3lq5BpA.V_9lMAQOdk_AYt.SEj5vUdI3VvxDc"));
        pause(1000);
        click(By.xpath("//button[@class='a72r81xglmtLCW bxgKMAm3lq5BpA KpU415sFFvOzGZ PnEv2xIWy3eSui SEj5vUdI3VvxDc']"));
    }

    public boolean waitForElementPresent(By locator, int timeOut) {
        return new WebDriverWait(wd, timeOut)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).size() > 0;


    }

    public void fillNameForm(String name) {

        for (int i = 1; i < boardCounter(); i++) {
            String xp = "//ul[@class='boards-page-board-section-list']//li[" + i + "]";
            click(By.xpath(xp));
            waitForElementPresent(By.cssSelector(".hiRkezEUBG7ve6.uXhW3KBBr1jUsJ"), 10);
            WebElement el = wd.findElement(By.cssSelector(".hiRkezEUBG7ve6.uXhW3KBBr1jUsJ"));
            new Actions(wd).moveToElement(el).click(el).sendKeys(name + Keys.ENTER).perform();
            String title = wd.findElement(By.cssSelector(".hiRkezEUBG7ve6.uXhW3KBBr1jUsJ")).getText();
            Assert.assertEquals(name, title);
            click(By.cssSelector(".nNvJhnERHVQb9o"));
            pause(2000);
        }

    }
}