package com.demo.automation.framework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.yaml.snakeyaml.Yaml;

import com.demo.automation.framework.mobile.touchaction.drivers.Share2PeopleSauceDriver;
import com.demo.utils.InitData;
import com.demo.utils.PropFileHandler;
import com.epam.healenium.SelfHealingDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigurationRegistory {

	Map<String, Object> registry;
	private static String OS = System.getProperty("os.name").toLowerCase();

	// public static String url;
	@SuppressWarnings("unchecked")
	public ConfigurationRegistory() {
		registry = (Map<String, Object>) new Yaml()
				.load(getClass().getClassLoader().getResourceAsStream("configurationRegistry.yaml"));
	}

	public WebDriver getDriver(Map<String, Object> config) throws MalformedURLException {
		Map<String, Object> options = new HashMap<String, Object>();
		return getDriver(config, options);
	}

	public WebDriver getDriver(Map<String, Object> config, Map<String, Object> options) throws MalformedURLException {
		String projectPath = System.getProperty("user.dir");
		String driverPathChrome = null;
		String driverPathFF = null;
		String driverPathEdge = null;
		String testConfiguration = null;
		String apkPath = null;
		System.out.println(OS);

		if (isWindows()) {
			System.out.println("This is Windows");
			driverPathChrome = projectPath + "" + "/src/main/resources/drivers/window/chromedriver.exe";
			driverPathFF = projectPath + "" + "/src/main/resources/drivers/firefox/geckodriver.exe";
			driverPathEdge = projectPath + "" + "/src/main/resources/drivers/edge/msedgedriver.exe";
		} else if (isMac()) {
			System.out.println("This is Mac");
			driverPathChrome = projectPath + "" + "/src/main/resources/drivers/mac/chromedriver";
		} else if (isUnix()) {
			System.out.println("This is Unix or Linux");
			driverPathChrome = projectPath + "" + "/src/main/resources/drivers/linux/chromedriver";
		} else {
			System.out.println("Your OS is not supported!!");
		}

		System.out.println("The driver path is " + driverPathChrome);

		if (options.containsKey("TEST_CONFIGURATION")) {
			testConfiguration = options.get("TEST_CONFIGURATION").toString();
		}

		TestSession.logger.info("Launching Test Configuration: " + testConfiguration + " ...");
		System.out.println("Launching Test on Configuration: " + testConfiguration + " ...");

		Map<String, String> configRegistory = (Map<String, String>) registry.get(testConfiguration);
		WebDriver delegate = null;
		WebDriver driver = null;
		
		
		
		
		String appPath = apkPath;
		System.out.println(configRegistory);

		// url=configRegistory.get("server");

		ChromeOptions chromeOptions;
		switch (InitData.platformName) {
//		case ("mac"):
//			// TODO need to check if chromedriver exists
//			System.setProperty("webdriver.chrome.driver", driverPathChrome);
//			chromeOptions = new ChromeOptions();
//			chromeOptions.addArguments("test-type");
//			chromeOptions.addArguments("start-maximized");
//			chromeOptions.addArguments("--incognito");
//			chromeOptions.addArguments("--disable-web-security");
//			chromeOptions.addArguments("--allow-running-insecure-content");
//			driver = new ChromeDriver(chromeOptions);
//			break;

		case ("chrome"):
			System.out.println("In Chrome configuration");
			Map<String, Object> prefs1 = new HashMap<String, Object>();
		prefs1.put("profile.default_content_setting_values.notifications", 2);
		prefs1.put("credentials_enable_service", false);
		prefs1.put("profile.password_manager_enabled", false);
		chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("test-type");
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("--incognito");
		chromeOptions.addArguments("--disable-web-security");
		chromeOptions.addArguments("--allow-running-insecure-content");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(360, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get(PropFileHandler.readProperty("url"));

			break;

		case ("firefox"):
			System.out.println("In firefox configuration");
			System.setProperty("webdriver.gecko.driver", driverPathFF);
			driver = new FirefoxDriver();
			driver.get(PropFileHandler.readProperty("url"));
			break;

		case ("edge"):
			System.out.println("In edge configuration");
			System.setProperty("webdriver.edge.driver", driverPathEdge);
			driver = new EdgeDriver();
			driver.get(PropFileHandler.readProperty("url"));
			break;

		case "android":
			System.out.println("In the Android configuration");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			appPath = projectPath + "" + "/src/main/resources/apk/appName.apk";
			capabilities.setCapability("app", appPath);
			capabilities.setCapability("appPackage", "sa.virginmobile.vm");
			capabilities.setCapability("appActivity", "sa.virginmobile.vm.ui.splash.SplashActivity");
			capabilities.setCapability("newCommandTimeout", 60000);
			capabilities.setCapability("udid", registry.get("deviceId"));
			capabilities.setCapability("deviceName", "Android");
			capabilities.setCapability("unicodeKeyboard", true);
			// capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
			capabilities.setCapability("noReset", "false");
			capabilities.setCapability("fullReset", "true");
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			break;

		case "iPhone":
			System.out.println("In the iPhone configuration");
			appPath = projectPath + "" + "/src/main/resources/apk/appName.app";
			DesiredCapabilities capabilitiess = new DesiredCapabilities();
			capabilitiess.setCapability("platformVersion", "12.2");
			capabilitiess.setCapability("deviceName", "iPhone 8 Plus");
			capabilitiess.setCapability("automationName", "XCUITest");
			capabilitiess.setCapability("platformName", "iOS");
			capabilitiess.setCapability("waitForQuiescence", false);
			System.out.println("App current path is:" + appPath);
			capabilitiess.setCapability("app", appPath);
			// capabilitiess.setCapability(MobileCapabilityType.NO_RESET, false);
			// capabilitiess.setCapability(MobileCapabilityType.FULL_RESET, true);
			capabilitiess.setCapability("clearSystemFiles", true);
			capabilitiess.setCapability("showXcodeLog", true);
			capabilitiess.setCapability("unicodeKeyboard", true);
			capabilitiess.setCapability("waitForAppScript", "$.delay(5000);$.acceptAlert(); true;");
			@SuppressWarnings("rawtypes")
			IOSDriver iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiess);
			driver = iosDriver;
			break;

		case "sauceAndroid":
			System.out.println("In the sauce android configuration");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("appiumVersion", "1.15.0");
			caps.setCapability("deviceName", "Google Pixel 3 XL GoogleAPI Emulator");
			caps.setCapability("deviceOrientation", "portrait");
			caps.setCapability("platformVersion", "11.0");
			caps.setCapability("platformName", "Android");
			caps.setCapability("app", "sauce-storage:VM_preprod_v2.20.apk");
			caps.setCapability("idleTimeout", 180);
			caps.setCapability("maxDuration", 10800);
			caps.setCapability("noReset", false);
			caps.setCapability("unicodeKeyboard", true);

			driver = new Share2PeopleSauceDriver(new URL(
					"https://nimitj:ac328e21-3e2a-442f-9f38-eb93e177633e@ondemand.us-west-1.saucelabs.com:443/wd/hub"),
					caps);
			// driver = new Share2PeopleSauceDriver(new URL(sauceURL), caps);
			break;

		case "sauceiOS":
			System.out.println("In the sauce iOS configuration");
			DesiredCapabilities capp = new DesiredCapabilities();
			capp.setCapability("appiumVersion", "1.16.0");
			capp.setCapability("deviceName", "iPhone 8 Plus Simulator");
			capp.setCapability("deviceOrientation", "portrait");
			capp.setCapability("platformVersion", "13.2");
			capp.setCapability("platformName", "iOS");
			capp.setCapability("browserName", "");

			capp.setCapability("app", "storage:filename=virginmobile.zip");// VM_2.25.ipa for UI upload
			// capp.setCapability("app", "sauce-storage:VM_2.24.V3.ipa");//VM_2.25.ipa for
			// curl command upload
			capp.setCapability("idleTimeout", 180);
			capp.setCapability("maxDuration", 10800);
			// capabilities.setCapability("fullReset", false);
			capp.setCapability("noReset", false);
			IOSDriver iosDriver1 = new IOSDriver(new URL(
					"https://nimitj:ac328e21-3e2a-442f-9f38-eb93e177633e@ondemand.eu-central-1.saucelabs.com:443/wd/hub"),
					capp);
			// IOSDriver iosDriver1 = new IOSDriver(new URL(sauceURL), capp);
			driver = iosDriver1;
			break;

		}

		return driver;
	}

	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

	}

}
