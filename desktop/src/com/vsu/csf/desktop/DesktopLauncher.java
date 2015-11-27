package com.vsu.csf.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.vsu.csf.CrawlAround;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1000;
		config.height = 700;
		config.title = "CrawlAround";
		new LwjglApplication(new CrawlAround(), config);
	}
}
