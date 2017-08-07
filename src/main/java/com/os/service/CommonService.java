package com.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.mapper.CommonMapper;
import com.os.mapper.OnlineStarWorkMapper;
import com.os.model.City;
import com.os.model.Group;
import com.os.model.JobType;
import com.os.model.OnlineStarWork;
import com.os.model.Province;

@Service
public class CommonService {
	
	@Autowired
	private CommonMapper commonMapper;
	@Autowired
	private OnlineStarWorkMapper workMapper;
	
	public void saveFile(OnlineStarWork work){
		workMapper.insert(work);
	}
	
	public void saveFiles(List<OnlineStarWork> files){
		for(OnlineStarWork work: files){
			saveFile(work);
		}
	}
	
	public List<JobType> getJobTypeList(){
		return commonMapper.jobTypeList();
	}
	
	public List<Group> getGroupList(){
		return commonMapper.groupList();
	}
	
	public List<City> getCityList(){
		return commonMapper.cityList();
	}
	
	public List<City> getCityList(int provinceId){
		return commonMapper.cityListByProvinceId(provinceId);
	}
	
	public List<Province> getProvinceList(){
		return commonMapper.provinceList();
	}
}
