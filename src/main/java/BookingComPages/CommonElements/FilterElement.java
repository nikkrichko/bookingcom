package BookingComPages.CommonElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilterElement {

    private WebDriver webDriver;

    @FindBy(id = "ss")
    private WebElement cityField;

    @FindBy(className = "search_hl_name")
    private WebElement firstAutoComplete;

    @FindBy(id = "")
    private WebElement dayFromList;

    @FindBy(id = "")
    private List<WebElement> monthFromList;

    @FindBy(id = "")
    private WebElement dayUntilList;

    @FindBy(id = "")
    private List<WebElement> monthUntilList;

    @FindBy( className = "b-button__text")
    private WebElement submitSearchButton;

    public FilterElement(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void setCityField(String cityName){
        cityField.sendKeys(cityName);
    }

    public void setFirstAutoComplete(){
        firstAutoComplete.click();
    }

    public void submitSearch(){
        submitSearchButton.click();
    }
}
