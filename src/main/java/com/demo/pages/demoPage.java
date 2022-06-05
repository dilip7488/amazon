package com.demo.pages;



import java.awt.List;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.MatchResult;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.demo.automation.framework.TestSession;
import com.demo.automation.framework.pagefactory.MobileWebViewPage;
import com.demo.utils.InitData;
import com.demo.utils.PropFileHandler;
//import com.deque.axe.AXE;
//import com.deque.axe.AXE;

public class demoPage extends MobileWebViewPage {
	@Rule
	public TestName testName = new TestName();

	private static final URL scriptUrl = demoPage.class.getResource("/axe.min.js");
	public static String platformName = InitData.platformName;

	public demoPage(TestSession session) throws Exception {

		super(session, "Applications/demo");

	}
	/**
	 * This method is for to click on login button of main page of Naukri.com
	 * @throws InterruptedException
	 */
	public void clickonLogin() throws InterruptedException {
		session.driver.findElement(By.xpath("//*[contains(@class,'Login')]")).click();
		Thread.sleep(3000);
	}
	/**
	 * This method is To Enter the email ID in email id field.
	 * @throws InterruptedException
	 */
	public void enteremailId() throws InterruptedException {
		session.driver.findElement(By.xpath("//*[contains(@placeholder,'Enter your active Email ID / Username')]")).sendKeys("abc20@gmail.com");
		Thread.sleep(3000);
	}
	/**
	 * This method is to enter Password in password field.
	 * @throws InterruptedException
	 */
	public void enterPassword() throws InterruptedException {
		session.driver.findElement(By.xpath("//*[contains(@type,'password')]")).sendKeys("12345");
		Thread.sleep(3000);
	}
	/**
	 * This method is to click on login button after entering email ID & Password.
	 * @throws InterruptedException
	 */
	public void clickonLoginButton() throws InterruptedException {
		session.driver.findElement(By.xpath("//*[contains(@class,'btn-primary loginButton')]")).click();
		Thread.sleep(3000);
	}
	/**
	 * Verify the Home page is visible
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public void isHomePageVisible() throws InterruptedException {
//
//		// WebDriverWait wait = new WebDriverWait(session.driver, 60);
//		// return
//		// wait.until(ExpectedConditions.visibilityOf(element("homePage"))).isDisplayed();
//
//		// Actions action = new Actions(session.driver);
//		// action.moveToElement(session.driver.findElement(By.xpath("(//*[text()='Help &
//		// Support'])[1]"))).perform();
//		// Thread.sleep(1000);
//		// session.driver.findElement(By.xpath("(//*[text()='Contact
//		// Us'])[1]")).click();
//		// Thread.sleep(1000);
//		// Select sel = new
//		// Select(session.driver.findElement(By.name("c_account_type")));
//		// sel.selectByValue("Not a virgin mobile customer");
//		// Thread.sleep(1000);
//		// session.driver.findElement(By.id("c_name")).sendKeys("John Doe");
//		// Thread.sleep(1000);
//		// session.driver.findElement(By.id("c_email")).sendKeys("johndoe@testmail.com");
//		// Thread.sleep(1000);
//		//
//		// session.driver.findElement(By.id("l_mobile")).sendKeys("7676565656");
//		// Thread.sleep(1000);
//		// session.driver.findElement(By.id("c_subject")).sendKeys("New Mobile
//		// Connection test");
//		// Thread.sleep(1000);
//		//
//		// session.driver.findElement(By.id("c_message")).sendKeys("New Mobile
//		// Connection Required");
//		// Thread.sleep(1000);
//		//
//		// session.driver.findElements(By.className("recaptcha-checkbox
//		// goog-inline-block recaptcha-checkbox-unchecked
//		// rc-anchor-checkbox")).get(0).click();
//		//
//		//
//		// session.driver.findElement(By.id("c_submit")).click();
//		//
//		// Thread.sleep(2000);
//	//	JavascriptExecutor executor = (JavascriptExecutor) session.driver;
//		// executor.executeScript("arguments[0].scrollIntoView();",
//		// elements("arrowRightOnTestBatchList").get(elements("arrowRightOnTestBatchList").size()
//		// - 1));
////		executor.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');",
////				session.driver.findElement(By.xpath("//*[text()='Join Now']")));
////
////		session.driver.findElement(By.xpath("//*[text()='Join Now']")).click();
////		Thread.sleep(10000);
////		executor.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');",
////				session.driver.findElements(By.xpath("//*[@class='number-pieces has-type']")).get(2));
////
////		session.driver.findElements(By.xpath("//*[@class='number-pieces has-type']")).get(2).click();
////		Thread.sleep(6000);
////
////		executor.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');",
////				session.driver.findElement(By.xpath("//button[text()='BOOK IT NOW']")));
////
////		session.driver.findElement(By.xpath("//button[text()='BOOK IT NOW']")).click();
////		Thread.sleep(10000);
////
////		executor.executeScript("arguments[0].scrollIntoView();",
////				session.driver.findElement(By.xpath("//button[text()='Get this plan']")));
////
////		Thread.sleep(1000);
////
////		executor.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');",
////				session.driver.findElement(By.xpath("//button[text()='Get this plan']")));
////
////		executor.executeScript("arguments[0].click();",
////				session.driver.findElement(By.xpath("//button[text()='Get this plan']")));
//
//		// session.driver.findElement(By.xpath("//button[text()='Get this
//		// plan']")).click();
//
//		// Thread.sleep(10000);
//		// session.driver.findElement(By.xpath("//button[text()='Continue']")).click();
//
//		Thread.sleep(10000);
//
//		Select sel = new Select(session.driver.findElement(By.name("idtype")));
//		sel.selectByValue("I");
//		Thread.sleep(1000);
//
//		session.driver.findElement(By.id("id_number")).sendKeys("2000000008");
//
//		Thread.sleep(1000);
//
//		Select nation = new Select(session.driver.findElement(By.name("Nationality")));
//		nation.selectByValue("111");
//		Thread.sleep(1000);
//		Select city = new Select(session.driver.findElement(By.name("city")));
//		city.selectByValue("3");
//		Thread.sleep(1000);
//
//		executor.executeScript("arguments[0].scrollIntoView();",
//				session.driver.findElement(By.xpath("//*[@class='btn btn-primary']")));
//
//		Thread.sleep(1000);
//
//		executor.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');",
//				session.driver.findElement(By.xpath("//*[@class='btn btn-primary']")));
//
//		executor.executeScript("arguments[0].click();",
//				session.driver.findElement(By.xpath("//*[@class='btn btn-primary']")));
//
//		// session.driver.findElement(By.xpath("//*[@class='btn
//		// btn-primary']")).click();
//		Thread.sleep(6000);


	}

	/**
	 * Verify the Url
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean isUrlCorrect() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("url****" + session.driver.getCurrentUrl());
		return session.driver.getCurrentUrl().contains(PropFileHandler.readProperty("url"));

	}

	/**
	 * Select any category
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void selectCategory() throws InterruptedException {
//		String x1 = "//*[text()=' ";
//		String x2 = PropFileHandler.readProperty("category");
//		String x3 = " ']";
//		String xpath = x1 + x2 + x3;
//		WebElement category = session.driver.findElement(By.xpath(xpath));
//		JavascriptExecutor js = (JavascriptExecutor) session.driver;
//		js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');", category);
//		Thread.sleep(2000);
//		category.click();
	//	PropFileHandler.writeToFile("PageSource", session.driver.getPageSource());
		
//		final String HTML = session.driver.getPageSource();
//		Document document = Jsoup.parse(HTML);
//		Element table = document.select("table").first();
//		String arrayName = table.select("th").first().text();
//		JSONObject jsonObj = new JSONObject();
//		JSONArray jsonArr = new JSONArray();
//		Elements ttls = table.getElementsByClass("ttl");
//		Elements nfos = table.getElementsByClass("nfo");
//		JSONObject jo = new JSONObject();
//		for (int i = 0, l = ttls.size(); i < l; i++) {
//		    String key = ttls.get(i).text();
//		    String value = nfos.get(i).text();
//		    jo.put(key, value);
//		}
//		jsonArr.put(jo);
//		jsonObj.put(arrayName, jsonArr);
//		System.out.println(jsonObj.toString());
		
//		System.out.println("**********************************Page Source Start**************************************"+session.driver.getPageSource());
//		System.out.println("**********************************Page Source End******************");
		Thread.sleep(25000);
		//PropFileHandler.writeToFile("PageSource1", session.driver.getPageSource());
		session.driver.findElement(By.xpath("//a[text()='Images']")).click();
		
		
		
				

//			String email = PropFileHandler.readProperty("emailID");
//			dashBoardPO.enterEmailAddressInTextfield(email);
//
//			dashBoardPO.tapOnLoginBtn();
//
//			String pswd = PropFileHandler.readProperty("password");
//			 dashBoardPO.enterPasswordInTextfield(pswd);

	
		
		
	}

	/**
	 * Select brand
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void selectBrand() throws InterruptedException {
		String x1 = "//*[text()='";
		String x2 = PropFileHandler.readProperty("brand");
		String x3 = "']/parent::a/child::div";
		String xpath = x1 + x2 + x3;
		WebElement brand = session.driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) session.driver;
		js.executeScript("arguments[0].scrollIntoView();", session.driver.findElement(By.xpath(xpath)));
		js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');", brand);
		Thread.sleep(2000);
		brand.click();

	}

	/**
	 * Verify the options displayed according to the brand
	 * 
	 * @return
	 */
	public boolean areOptionsAccordingToFilterSet() {
		boolean status = false;

		for (int i = 0; i <= elements("optionsDisplayed").size() - 1; i++) {

			if (elements("optionsDisplayed").get(i).getText().contains(PropFileHandler.readProperty("brand"))) {
				System.out.println("Option " + i + " is -->" + elements("optionsDisplayed").get(i).getText());
				status = true;
			} else {
				status = false;
			}
		}
		return status;

	}

	/**
	 * Select second item from the list
	 * 
	 */
	public void selectItem() {
		elements("optionsDisplayed").get(4).click();
	}

	/**
	 * Click on Add to cart button
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void clickOnAddToCart() throws InterruptedException

	{
		ArrayList<String> tabs2 = new ArrayList<String>(session.driver.getWindowHandles());
		session.driver.switchTo().window(tabs2.get(1));
		element("addToCart").click();
		Thread.sleep(4000);

		JavascriptExecutor executor = (JavascriptExecutor) session.driver;
		executor.executeScript("arguments[0].click();", element("cart"));
		// element("cart").click();
		// session.driver.close();
		// session.driver.switchTo().window(tabs2.get(0));
		
		Select dp = new Select(session.driver.findElement(By.xpath("//*[@id='input-sort']")));
		java.util.List<WebElement> dropDownOption=	dp.getOptions();
		

	}

	/**
	 * Click on cart
	 * 
	 */
	public void clickOncart() {
		element("cart").click();
	}

	// public void testAccessibility() {
	
	/* JSONObject responseJSON = new AXE.Builder(session.driver,
	 scriptUrl).analyze();
	
	 JSONArray violations = responseJSON.getJSONArray("violations");
	
	 if (violations.length() == 0) {
	 Assert.assertTrue("No violations found", true);
	 } else {
	 AXE.writeResults(testName.getMethodName(), responseJSON);
	 Assert.assertTrue(AXE.report(violations), false);
	 }
	 }*/

	public void loginWithDifferentUsername(String username) {
		session.driver.get("https://" + username + ":105@localhost:44379/");
	}

	public void clickOnTab(String locator) {
		element(locator).click();
	}

	public boolean isUserAbleToAccessAdminTab() {
		

		return elements("adminPage").size() != 0;

	}

	public boolean isUserAbleToAccessReaderTab() {
		

		return elements("readerPage").size() != 0;
		
	}
	public void selectElectronics() {
		element("selectElectronics").click();
		
	}
	public void isElementDisplayed() {
		element("selectElectronics").isDisplayed();
		
	}
	public void selectBrandOneplus() {
		element("brandcategory").click();
		
	}
		public void chooseProduct() {
		element("oneproduct").click();
		
	}
	public void descriptionDisplay() {
		String desp = element("oneproduct").getText();
		System.out.println(desp);
	}
	public void writeProperties() {
		String PDesc =element("oneproduct").getText(); 
		PropFileHandler.writeToFile("Product", PDesc);
		
	}
	public void countProduct() {
		element("prdescription").click();
		element("price").click();
		
	}
	public void writingExcelFile() {
		/*public void writeDataFromExcelSheet(String path,String Sheet,int RowNum,int CellNum,String NewValue) throws Throwable {
			FileInputStream fis=new FileInputStream("./src/main/resources/dataFile/QA.xlsx);
			Workbook wb=WorkbookFactory.create(fis);
			wb.getSheet(amazonproduct).createRow(RowNum).createCell(CellNum).setCellValue(NewValue);
			FileOutputStream fos=new FileOutputStream(path);
			wb.write(fos);
			wb.close();
			*/
		}
	
	public void openingNewTab() {
		// TODO Auto-generated method stub
		
	}
	public void verifyingPropertyData() {
		
		//boolean b=PropFileHandler.readProperty("Product");
		//return boolean;
		
	}
	public void clickingAddCart() {
		//id=submit.add-to-cart
		
	}
	public void selectCart() {
		// 
		
	}
	public void verifyRightProduct() {
		// TODO Auto-generated method stub
		
	}
	
	
		
	}
	
	
	

