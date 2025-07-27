package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Itemspage {

	@FindBy(xpath="//*[@id=\"grid-main-container\"]/div[3]/div/div[1]/div/div/a/div/div/img")
	public WebElement firstitem;
	
	public void clickonfirstitem(){
		firstitem.click();
	}
}
