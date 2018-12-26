package test.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import test.resources.generic.WebLibrary;

/* ######################################################################################################
 * Class Name: UserLib
 * Description: Contains the methods which are used for the common functionalities of the application
 * Author: Testing Masters
 * Date Created: 14-Feb-2016
 * ######################################################################################################
 */
public class UserLibrary extends WebLibrary 
{
	/*
	 * ######################################################################################################
	 *  Method Name: Login
	 *  Description: To Login to a HRM Application,Based on UID,Password
	 *  Input Parameters:URL,UID,Password
	 *  Output: True/False 
	 *  Author: Veerendra 
	 *  Date Created:21-Aug-2016
	 * ######################################################################################################
	 */
	public static boolean Login(String URL, String UID, String Password) 
	{
		boolean loginstatus = true;
		boolean status;

		status = OpenUrl(URL);
		if (status)
			LogEventWithScreeshot("info", "Application is Up and Running");
		else
			LogEventWithScreeshot("fail", "Unable to Launch HRM Application");

		status = SetText("//input[@id='txtUsername']", UID);
		if (status)
			LogEventWithScreeshot("info", "Entered UserName");
		else
			LogEventWithScreeshot("fail", "Unable to Enter UserName");

		status = SetText("//input[@id='txtPassword']", Password);
		if (status)
			LogEventWithScreeshot("info", "Entered Password");
		else
			LogEventWithScreeshot("fail", "Unable to Enter Password");

		status = ClickElement("//input[@name='Submit']");
		if (status)
			LogEventWithScreeshot("info", "Clicked on Login");
		else
			LogEvent("fail", "Unable to Click on login");

		wait(2);
		status = Exist("//a[contains(text(),'Welcome')]");
		if (status)
			LogEventWithScreeshot("pass", "Login is sucessful");
		else {
			LogEventWithScreeshot("fail", "Login is not sucessful");
			loginstatus = false;
		}

		return loginstatus;
	}
//=========================================================
	public static boolean Logout() 
	{
		Boolean status;
		ClickElement("//a[contains(text(),'Welcome')]");
		status = ClickElement("//a[text()='Logout']");
		if (status)
			LogEventWithScreeshot("info", "Clicked on Logout");
		else
			LogEventWithScreeshot("fail", "Unable to clickon Clicked on Logout");

		status = Exist("//input[@id='txtUsername']");
		if (status)
			LogEventWithScreeshot("pass", "Logout is successful");
		else
			LogEventWithScreeshot("fail", "Logout is Not successful");
		return status;
	}
//=========================================================
/* ######################################################################################################
 * Method Name: 
 * Description: 
 * Author: Kumar
 * Date Created: 28-Nov-2017
 * ######################################################################################################
 */

public static void NavigateMyLeave()
{	
	
	 boolean stepstatus = SelectMenuOption("//*[@id='menu_leave_viewLeaveModule']", "//*[@id='menu_leave_viewMyLeaveList']");
	if(stepstatus)
	{
		LogEventWithScreeshot("pass", "My Leave page displayed");
	}
	else
	{
		LogEventWithScreeshot("fail", "My Leave page not displayed");
	}	
	
}
//==================================================================

public static boolean SelectLeaveStatus(String Leavestatus)
{	
	boolean stepstatus = true;
	boolean retval;	
	//Unchecl All
	retval = ClickElement("//*[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']");
	if(retval==false)
	{
		stepstatus = false;
	}
	
	switch(Leavestatus.toLowerCase())
	{
	case "taken" :
		retval = ClickElement("//*[@id='leaveList_chkSearchFilter_3']");
		if(retval==false)
		{
			stepstatus = false;
		}
		break;
		
	case "cancelled" :
		retval = ClickElement("//*[@id='leaveList_chkSearchFilter_0']");
		if(retval==false)
		{
			stepstatus = false;
		}
		break;
		
	case "pending" :
		retval = ClickElement("//*[@id='leaveList_chkSearchFilter_1']");
		if(retval==false)
		{
			stepstatus = false;
		}
		break;
		
	case "rejected" :
		retval = ClickElement("//*[@id='leaveList_chkSearchFilter_-1']");
		if(retval==false)
		{
			stepstatus = false;
		}
		break;
		
	case "scheduled" :
		retval = ClickElement("//*[@id='leaveList_chkSearchFilter_2']");
		if(retval==false)
		{
			stepstatus = false;
		}
		break;
		
  default:			
			stepstatus = false;
			break;
	}	
	
	return stepstatus;
}

//=========================================================


/* ######################################################################################################
 * Method Name: 
 * Description: 
 * Author: Kumar
 * Date Created: 28-Nov-2017
 * ######################################################################################################
 */
public static void NavigateApplyeave()
{	
	
	 boolean stepstatus = SelectMenuOption("//*[@id='menu_leave_viewLeaveModule']", "//*[@id='menu_leave_applyLeave']");
	if(stepstatus)
	{
		LogEventWithScreeshot("pass", "Apply Leave page displayed");
	}
	else
	{
		LogEventWithScreeshot("fail", "Apply Leave page not displayed");
	}	
	
}

//==================================================================


/* ######################################################################################################
 * Method Name: SelectDateRange
 * Description: Select from date and to date
 * Author: Neeraja
 * Date Created: 28-Nov-2017
 * ######################################################################################################
 */
public static void SelectDateRange(String xpath1, String xpath2)

{	
	SetTextAndEscape(xpath1,FromDate);
	SetTextAndEscape(xpath1,ToDate );
		
}


/* ######################################################################################################
 * Method Name: SelectDateRange
 * Description: Select from date and to date
 * Author: Neeraja
 * Date Created: 28-Nov-2017
 * ######################################################################################################
 */
public static void searchLeaveDetails()

{	
	int rowCount = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr")).size();
	
	
	for (int iRow=1; iRow<rowCount;iRow++)
	{
		String A = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+iRow+"]/td[1]")).getText();
		
		if(FromDate.contentEquals(A))
		{
			System.out.println(A);
			break;
	    }
		
	}
		
}
}
		