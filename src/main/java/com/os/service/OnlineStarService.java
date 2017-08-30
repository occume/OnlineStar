package com.os.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.conroller.OnlineStarController;
import com.os.mapper.OnlineStarMapper;
import com.os.mapper.OnlineStarWorkMapper;
import com.os.model.OnlineStar;
import com.os.model.OnlineStarExample;
import com.os.model.OnlineStarLabel;
import com.os.model.OnlineStarRecommend;
import com.os.model.OnlineStarWork;
import com.os.model.OnlineStarWorkExample;

@Service
public class OnlineStarService {
	
	private static final Logger LOG = LoggerFactory.getLogger(OnlineStarService.class);

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
		addLabels(os);
		return osMapper.insert(os);
	}
	
	public int update(OnlineStar os){
		addLabels(os);
		return osMapper.updateByPrimaryKeySelective(os);
	}
	
	public void addLabels(OnlineStar os){
		if(os.getLabelList() != null){
			for(OnlineStarLabel label: os.getLabelList()){
				label.setOsId(os.getId());
				List<OnlineStarLabel> list = osMapper.selectLabelByName(label);
				if(list.size() > 0){
					LOG.info("Exist label, {}, {}", os.getId(), label.getName());
				}
				else{
					osMapper.insertLabel(label);
				}
			}
		}
	}
	
	public void addLabels(List<OnlineStarLabel> labelList){
		if(labelList != null){
			for(OnlineStarLabel label: labelList){
				osMapper.insertLabel(label);
			}
		}
	}
	
	public OnlineStar getByAuthId(long authId){
		OnlineStarExample example = new OnlineStarExample();
		example.createCriteria().andAuthIdEqualTo(authId);
		List<OnlineStar> list = osMapper.selectByExample(example);
		OnlineStar os = list.size() > 0 ? list.get(0) : null;
		if(os != null){
			os.setLabelList(osMapper.selectLabelByOsId(os.getId()));
		}
		return os;
	}
	
	public OnlineStar getByOsId(long osId){
		OnlineStarExample example = new OnlineStarExample();
		example.createCriteria().andIdEqualTo(osId);
		List<OnlineStar> list = osMapper.selectByExample(example);
		OnlineStar os = list.size() > 0 ? list.get(0) : null;
		if(os != null){
			os.setLabelList(osMapper.selectLabelByOsId(os.getId()));
		}
		return os;
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
