package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.TestBase;

public class Sucessmsgpage extends TestBase{
	
	@FindBy(xpath="//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span")
	public WebElement sucessmsg_main;
	
	@FindBy(xpath="//*[@id=\"attachDisplayAddBaseAlert\"]/div/h4")
	public WebElement sucessmsg_slide;
	
	public void verifysuccessmsg(){
		try{
		String text = sucessmsg_main.getText();
		System.out.println("text="+text);
		st.assertEquals(text, "Added to Cart");
		}catch(Throwable t){
			String text = sucessmsg_slide.getText();
			System.out.println("text="+text);
			st.assertEquals(text, "Added to Cart");
			driver.navigate().refresh();
		}
		st.assertAll();
	}

}
