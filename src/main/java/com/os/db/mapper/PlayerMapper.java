package com.os.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.os.db.domain.Player;
import com.os.db.domain.Tag;

public interface PlayerMapper {

  void addPlayer(Player player);
  
  Player getByName(String name);
  
  void saveTag(Tag tag);
  Tag getTagByName(String name);
  
  void savePlayerTag(@Param(value="playerId")int playerId,
		  			 @Param(value="tagId")int tagId, 
		  			 @Param(value="reportIp")String reportIp);
  
  int getPlayerTag(@Param(value="playerId")int playerId, @Param(value="tagId")int tagId);
  
  void updatePlayerTagCount(@Param(value="playerId")int playerId, @Param(value="tagId")int tagId);
  
  List<Tag> getTagsByPlayerId(@Param(value="playerId")int playerId);
}
