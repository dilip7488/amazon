package com.demo.automation.framework.mobile.touchaction.drivers;

import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.RemoteTouchScreen;

import io.appium.java_client.android.AndroidDriver;

public class Share2PeopleSauceDriver extends AndroidDriver<WebElement> implements HasTouchScreen {
	private RemoteTouchScreen touch;

	public TouchScreen getTouch() {
		// TODO Auto-generated method stub
		return touch;
	}

	public Share2PeopleSauceDriver(URL remoteAddress, Capabilities caps) {
		super(remoteAddress, caps);
		touch = new RemoteTouchScreen(getExecuteMethod());
	}

}
