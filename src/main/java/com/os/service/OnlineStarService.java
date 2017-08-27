package com.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.mapper.OnlineStarMapper;
import com.os.mapper.OnlineStarWorkMapper;
import com.os.model.OnlineStar;
import com.os.model.OnlineStarExample;
import com.os.model.OnlineStarRecommend;
import com.os.model.OnlineStarWork;
import com.os.model.OnlineStarWorkExample;

@Service
public class OnlineStarService {

	@Autowired
	private OnlineStarMapper osMapper;
	@Autowired
	private OnlineStarWorkMapper workMapper;
	
	public int save(OnlineStarWork work){
		return workMapper.insert(work);
	}
	
	public List<OnlineStarWork> getWorkList(long osId, int typeId){
		OnlineStarWorkExample example = new OnlineStarWorkExample();
		OnlineStarWorkExample.Criteria criteria = example.createCriteria();
		criteria.andOsIdEqualTo(osId);
		if(typeId > 0)
			criteria.andTypeIdEqualTo(typeId);
		return workMapper.selectByExample(example);
	}
	
	public int save(OnlineStar os){
		return osMapper.insert(os);
	}
	
	public int update(OnlineStar os){
		return osMapper.updateByPrimaryKeySelective(os);
	}
	
	public OnlineStar getByAuthId(long authId){
		OnlineStarExample example = new OnlineStarExample();
		example.createCriteria().andAuthIdEqualTo(authId);
		List<OnlineStar> list = osMapper.selectByExample(example);
		return list.size() > 0 ? list.get(0) : null;
	}
	
	public OnlineStar getByOsId(long osId){
		OnlineStarExample example = new OnlineStarExample();
		example.createCriteria().andIdEqualTo(osId);
		List<OnlineStar> list = osMapper.selectByExample(example);
		return list.size() > 0 ? list.get(0) : null;
	}
	
	public List<OnlineStarRecommend> popularList(){
		return osMapper.selectPopular();
	}
	
	public List<OnlineStarRecommend> freshList(){
		return osMapper.selectFresh();
	}
	
	public List<OnlineStarWork> popularWorkList(){
		return workMapper.selectPopularWorks();
	}
	
	public List<OnlineStarWork> freshWorkList(){
		return workMapper.selectFreshWorks();
	}
}
