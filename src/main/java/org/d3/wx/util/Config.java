package org.d3.wx.util;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {

	private static final Logger log = LoggerFactory.getLogger(Config.class);
	private static List<String> tags;
	
	static{
		loadTags();
	}
	
	public static List<String> getPlayerTags(){
		return tags;
	}

	private static void loadTags() {
		try {
			URL tagsURL = Config.class.getClassLoader().getResource("tag.txt");
			String path = tagsURL.getPath().substring(1);
			tags = Files.readAllLines(Paths.get(path), Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Load player tags error: {}", e.getMessage());
		}
	}
}
