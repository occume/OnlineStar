package org.d3.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.os.model.Follow;
import com.os.model.Player;
import com.os.model.Tag;
import com.os.service.NarraterService;
import com.os.service.PlayerService;

public class PlayerServiceTest {

	public static ApplicationContext ctx;
	public static NarraterService ns;
	public static PlayerService playerService;
	
	static{
		ctx = new ClassPathXmlApplicationContext("/beans.xml");
		ns = ctx.getBean(NarraterService.class);
		playerService = ctx.getBean(PlayerService.class);
	}
	
	public static void main(String...strings){
		getTags();
	}
	
	public static void savePlayer(){
		Player player = new Player("JD");
		playerService.savePlayer(player);
		System.out.println(player.getId());
	}

	public static void saveTag(){
		Tag tag = new Tag("cde");
		playerService.saveTag(tag);
		System.out.println(tag.getId());
	}
	
	public static void savePlayerTag(){
		playerService.savePlayerTagRelation(1, 2, "127.0.0.1");
	}
	
	public static void getTags(){
		List<Tag> tags = playerService.getTagByPlayerId(1);
		System.out.println(tags);
	}
}
