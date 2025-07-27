package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Departmentpage {
	
	@FindBy(xpath="(//span[text()='Furniture'])[2]")
	public WebElement furniture;
	
	@FindBy(xpath="(//span[text()='Movies & TV'])[1]")
	public WebElement movie;
	
	@FindBy(xpath="(//span[text()='Automotive'])[2]")
	public WebElement automative;
	
	public void selectcheckbox(String checkbox){
		if(checkbox.equalsIgnoreCase("furniture")){
			furniture.click();
		}else if(checkbox.equalsIgnoreCase("movie")){
			movie.click();
		}else if(checkbox.equalsIgnoreCase("automative")){
			automative.click();
		}
	}
}
