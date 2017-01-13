package com.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.os.db.domain.Player;
import com.os.db.domain.Tag;
import com.os.db.mapper.PlayerMapper;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerMapper playerMapper;
	
	public void savePlayer(Player player){
		playerMapper.addPlayer(player);
	}
	
	public Player getByName(String name){
		return playerMapper.getByName(name);
	}
	
	public boolean isPlayerExist(String name){
		return playerMapper.getByName(name) != null;
	}

	public void saveTag(Tag tag) {
		playerMapper.saveTag(tag);
	}
	
	public Tag getTagByName(String tagName){
		return playerMapper.getTagByName(tagName);
	};
	
	public boolean isTagExist(String tagName){
		return playerMapper.getTagByName(tagName) != null;
	}
	
	public void savePlayerTagRelation(int playerId, int tagId, String reportIp){
		playerMapper.savePlayerTag(playerId, tagId, reportIp);
	}
	
	public int getPlayerTag(int playerId, int tagId){
		return playerMapper.getPlayerTag(playerId, tagId);
	};

	@Transactional
	public Player upBang(String id, String name, 
			String tags, String newTag, String remoteAddr) {
		
		int playerId;
		int tagId = 0;
		/**
    	 * 如果有自定义标签
    	 */
    	if(!Strings.isNullOrEmpty(newTag)){
    		Tag tag = getTagByName(newTag);
    		if(tag != null){
//    			tagId = tag.getId();
    		}
    		else{
    			tag = new Tag(newTag);
    			saveTag(tag);
    		}
    	}
    	else{
    		tagId = Integer.valueOf(tags);
    	}
    	/**
    	 * save player and player-tag relations
    	 */
    	Player p;
    	if(Integer.valueOf(id) == 0){
    		p = new Player(name);
    		p.setReportIp(remoteAddr);
    		savePlayer(p);
    		playerId = p.getId();
    	}
    	else{
    		playerId = Integer.valueOf(id);
    		p = new Player(playerId, name);
    	}
    	
    	if(getPlayerTag(playerId, tagId) > 0){
    		updatePlayerTagCount(playerId, tagId);
    	}
    	else{
    		savePlayerTagRelation(playerId, tagId, remoteAddr);
    	}
    	
		return p;
	}
	
	public void updatePlayerTagCount(int playerId, int tagId) {
		playerMapper.updatePlayerTagCount(playerId, tagId);
	}

	public List<Tag> getTagByPlayerId(int playerId){
		return playerMapper.getTagsByPlayerId(playerId);
	}
}
