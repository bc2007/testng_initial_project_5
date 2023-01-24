package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TechGlobalFrontendTestingPage extends TechGlobalHomePage{

    public TechGlobalFrontendTestingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[class='CardGrids_CardGrids__qDdyI']>div")
    public List<WebElement> cards;

    public void getFrontendTestingPage(){
        headerDropdown.click();
        headerDropdownOptions.get(0).click();
    }

    public void clickOnCard(int index){
        cards.get(index).click();
    }

    public void clickOnCard(String cardName){
        for (WebElement card : cards) {
            if(card.getText().equals(cardName)){
                card.click();
                break;
            }
        }
    }


}
